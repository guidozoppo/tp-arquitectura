package com.pruebaspring.prueba.dao;
import java.util.List;

import com.pruebaspring.prueba.models.Estudiante;
import com.pruebaspring.prueba.models.EstudianteCarrera;

import dto.InscripcionDTO;
import dto.ReporteCarrera;

public interface EstudianteCarreraDao {

	List<EstudianteCarrera> getEstudianteCarreras();
	void matricularEstudiante(InscripcionDTO inscripcion);
	List<Estudiante> getEstudiantesPorCarrera(int carrera, String ciudad);
	List<ReporteCarrera> getReporte();
}
