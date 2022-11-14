package com.pruebaspring.prueba.dao;

import java.util.List;

import com.pruebaspring.prueba.models.Carrera;

public interface CarreraDao {

	List<Carrera> getCarreras();
	List<Carrera> getCarrerasConEstudiantes();
}
