package com.pruebaspring.prueba.dao;

import com.pruebaspring.prueba.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EstudianteDaoImp implements EstudianteDao{

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	@Override
    public List<Estudiante> getEstudiantes() {
        String query = "FROM Estudiante";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrarEstudiante(Estudiante estudiante) {
        entityManager.merge(estudiante);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> getEstudiantesOrdenadosPorNombre() {
		String query = "FROM Estudiante e ORDER BY nombre";
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Estudiante getEstudianteByLibreta(int lu) {
		return (Estudiante) entityManager.createQuery("FROM Estudiante e WHERE libretaUniversitaria = ?1").setParameter(1, lu).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> getEstudiantesPorGenero(String genero) {
		return entityManager.createQuery("SELECT e FROM Estudiante e WHERE genero = ?1").setParameter(1, genero).getResultList();
	}
}
