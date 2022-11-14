package com.pruebaspring.prueba.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "carreras")
public class Carrera {

	@Id
	@Column(name = "id_carrera")
	private int idCarrera;
	
	@ApiModelProperty(notes = "nombre DE LA CARRERA", name = "nombre", required=true, value="test nombre")
	@Column
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="carrera")
	@JsonManagedReference
	@JsonIgnore
	private List<EstudianteCarrera> estudiantes;
	
	public Carrera (int id, String nombre) {
		idCarrera = id;
		this.nombre = nombre;
	}
	
	public Carrera() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public List<EstudianteCarrera> getEstudiantes() {
		return estudiantes;
	}
	
	public void addEstudiante(Estudiante e) {
        EstudianteCarrera ec1 = new EstudianteCarrera(e, this);
        estudiantes.add(ec1);
        e.getCarreras().add(ec1);
    }

	@Override
	public int hashCode() {
		return Objects.hash(estudiantes, idCarrera, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrera other = (Carrera) obj;
		return Objects.equals(estudiantes, other.estudiantes) && idCarrera == other.idCarrera
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", nombre=" + nombre + "]";
	}
	
	

	
}
