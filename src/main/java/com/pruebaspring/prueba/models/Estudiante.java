package com.pruebaspring.prueba.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @Column(name = "id")
    private int dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private int edad;
    @Column(name = "genero")
    private String genero;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "lu")
    private int libretaUniversitaria;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<EstudianteCarrera> carreras;

    public Estudiante() {
    	super();
    }

    public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad,
			int libretaUniversitaria) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.libretaUniversitaria = libretaUniversitaria;
		this.carreras = new ArrayList<EstudianteCarrera>();
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    public void setLibretaUniversitaria(int libretaUniversitaria) {
        this.libretaUniversitaria = libretaUniversitaria;
    }

    /*public int getDNI() {
        return dni;
    }*/
    
    public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public List<EstudianteCarrera> getCarreras() {
		return carreras;
	}
	
	public void addCarrera(Carrera c) {
        EstudianteCarrera ec1 = new EstudianteCarrera(this, c);
        carreras.add(ec1);
        c.getEstudiantes().add(ec1);
    }

	@Override
	public int hashCode() {
		return Objects.hash(apellido, carreras, ciudad, dni, edad, genero, libretaUniversitaria, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(carreras, other.carreras)
				&& Objects.equals(ciudad, other.ciudad) && dni == other.dni && edad == other.edad
				&& Objects.equals(genero, other.genero) && libretaUniversitaria == other.libretaUniversitaria
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Estudiante [dni=" + dni + ", nombre=" + nombre + "]";
	}
	
	

}
