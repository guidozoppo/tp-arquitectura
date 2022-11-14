package com.pruebaspring.prueba.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="EstudianteCarrera")
public class EstudianteCarrera {
	
	@EmbeddedId
	private EstudianteCarreraID id;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEstudiante")
	@JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCarrera")
    @JoinColumn(name = "idCarrera")
    @JsonBackReference
    private Carrera carrera;
    
    @Column(nullable=true)
    private Integer antiguedad; 
    
    @Column(nullable=true)
    private Integer anioDeGraduacion;
	
    
    
	public EstudianteCarrera(Estudiante estudiante, Carrera carrera, int antiguedad, int anioDeGraduacion) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.antiguedad = antiguedad;
		this.anioDeGraduacion = anioDeGraduacion;
		this.id = new EstudianteCarreraID(estudiante.getDni(), carrera.getIdCarrera());
	}
	
	

	
	public EstudianteCarrera(Estudiante estudiante, Carrera carrera) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.id = new EstudianteCarreraID(estudiante.getDni(), carrera.getIdCarrera());
	}

	public EstudianteCarrera() {
		super();
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public EstudianteCarreraID getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrera, estudiante, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudianteCarrera other = (EstudianteCarrera) obj;
		return Objects.equals(carrera, other.carrera) && Objects.equals(estudiante, other.estudiante)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return " estudiante dni= " + estudiante.getDni() + ", inscripto en " + carrera.getNombre() + "]";
	}



	

	
	
	
	
}

