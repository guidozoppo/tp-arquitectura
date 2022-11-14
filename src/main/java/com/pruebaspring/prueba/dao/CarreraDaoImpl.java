package com.pruebaspring.prueba.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pruebaspring.prueba.models.Carrera;

@Repository
@Transactional
public class CarreraDaoImpl implements CarreraDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Carrera> getCarreras() {
        String query = "FROM Carrera";
        return entityManager.createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrera> getCarrerasConEstudiantes() {
		String query = "SELECT DISTINCT c FROM Carrera c JOIN c.estudiantes e WHERE size(e) > 0 ORDER BY size(e) DESC";
		return entityManager.createQuery(query).getResultList();
	}

}
