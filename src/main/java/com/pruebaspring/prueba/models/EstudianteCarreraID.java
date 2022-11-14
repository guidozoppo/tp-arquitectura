package com.pruebaspring.prueba.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@SuppressWarnings("serial")
@Embeddable
public class EstudianteCarreraID implements Serializable{

	@Column(name="idEstudiante")
	private int idEstudiante;
	@Column(name="idCarrera")
	private int idCarrera;
		
	public EstudianteCarreraID() {
		super();
	}

	public EstudianteCarreraID(int idEstudiante, int idCarrera) {
		super();
		this.idEstudiante = idEstudiante;
		this.idCarrera = idCarrera;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCarrera, idEstudiante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudianteCarreraID other = (EstudianteCarreraID) obj;
		return idCarrera == other.idCarrera && idEstudiante == other.idEstudiante;
	}

	@Override
	public String toString() {
		return "EstudianteCarreraID [idEstudiante=" + idEstudiante + ", idCarrera=" + idCarrera + "]";
	}
	
	
	
	
	
	
	
	
}
