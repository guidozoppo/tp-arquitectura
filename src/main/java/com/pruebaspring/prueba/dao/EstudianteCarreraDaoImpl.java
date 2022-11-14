package com.pruebaspring.prueba.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.pruebaspring.prueba.models.Carrera;
import com.pruebaspring.prueba.models.Estudiante;
import com.pruebaspring.prueba.models.EstudianteCarrera;

import dto.InscripcionDTO;
import dto.ReporteCarrera;

@Repository
@Transactional
public class EstudianteCarreraDaoImpl implements EstudianteCarreraDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstudianteCarrera> getEstudianteCarreras() {
		String query = "FROM EstudianteCarrera";
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void matricularEstudiante(InscripcionDTO inscripcion) {
		
		Estudiante e = entityManager.find(Estudiante.class, inscripcion.getIdEstudiante());
		Carrera c = entityManager.find(Carrera.class, inscripcion.getIdCarrera());
		int antiguedad = inscripcion.getAntiguedad();
		int anioGraduacion = inscripcion.getAnioGraduacion();
		
		EstudianteCarrera ec = new EstudianteCarrera(e, c, antiguedad, anioGraduacion);
		
		entityManager.merge(ec);
		
//		Query query = entityManager.createNativeQuery("INSERT INTO estudiantecarrera (id_carrera, id_estudiante, antiguedad, anio_de_graduacion) "
//				+ "VALUES (:carrera, :estudiante, :antiguedad, :anioDeGraduacion)");
//	
//		entityManager.getTransaction().begin();
//		
//		query.setParameter("carrera", idCarrera);
//		query.setParameter("estudiante", idEstudiante);
//		query.setParameter("antiguedad", 0);
//		query.setParameter("anioDeGraduacion", null);
//		
//		Estudiante e = entityManager.find(Estudiante.class, idEstudiante);
//		Carrera c = entityManager.find(Carrera.class, idCarrera);
//		
//		c.addEstudiante(e);
//		e.addCarrera(c);
//		
//		query.executeUpdate();
//		entityManager.getTransaction().commit();
	}

	@Override
	public List<Estudiante> getEstudiantesPorCarrera(int carrera, String ciudad) {
		
//		Query query = entityManager.createQuery("SELECT e FROM Estudiante e JOIN e.carreras WHERE ciudad = ?1 AND idCarrera = ?2");
//		
//		query.setParameter(1, ciudad);
//		query.setParameter(2, carrera);
//		
//		
//		List<Estudiante> resultado = query.getResultList();
		
		return entityManager.createQuery("SELECT e FROM Estudiante e JOIN e.carreras WHERE ciudad = ?1 AND id_carrera = ?2").setParameter(1, ciudad).setParameter(2, carrera).getResultList();
	}

	@Override
	public List<ReporteCarrera> getReporte() {
		List<Object[]> query = entityManager.createNativeQuery(
				"SELECT nombre, ec.anio_de_graduacion anio, NULL LU, ec.id_estudiante id_estudiante "
				+ "FROM carreras c INNER JOIN estudiante_carrera ec ON c.id_carrera = ec.id_carrera "
				+ "WHERE ec.anio_de_graduacion > 0 "
				+ "UNION ALL "
				+ "SELECT nombre, YEAR(CURDATE()) - ec.antiguedad anio, ec.id_estudiante LU, NULL id_estudiante "
				+ "FROM carreras c INNER JOIN estudiante_carrera ec ON c.id_carrera = ec.id_carrera "
				+ "WHERE ec.anio_de_graduacion = 0 "
				+ "UNION ALL "
				+ "SELECT nombre, (ec.anio_de_graduacion - ec.antiguedad) anio, ec.id_estudiante LU, NULL id_estudiante "
				+ "FROM carreras c INNER JOIN estudiante_carrera ec ON c.id_carrera = ec.id_carrera "
				+ "WHERE ec.anio_de_graduacion > 0 "
				+ "ORDER BY nombre, anio, LU DESC").getResultList();
		

		
		List<ReporteCarrera> reportes = query.stream().map(o -> new ReporteCarrera((String)o[0], (BigInteger)o[1], (Integer)o[2], (Integer)o[3])).collect(Collectors.toList());
		
		return reportes;
	}

}
