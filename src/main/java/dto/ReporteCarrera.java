package dto;

import java.math.BigInteger;

public class ReporteCarrera {
	
	private String carrera;
	private BigInteger anio;
	private Integer id_estudiante;
	private Integer registro;
	
	public ReporteCarrera() {
		super();
	}
	
	public ReporteCarrera(String carrera, BigInteger anio, Integer id_estudiante, Integer registro) {
		this.carrera = carrera;
		this.anio = anio;
		this.id_estudiante = id_estudiante;
		this.registro = registro;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public BigInteger getAnio() {
		return anio;
	}

	public void setAnio(BigInteger anio) {
		this.anio = anio;
	}

	public Integer getGraduado() {
		return id_estudiante;
	}

	public void setGraduado(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}
	
	@Override
	public String toString() {
		return "ReporteCarrera [carrera=" + carrera + ", anio=" + anio + ", id_estudiante=" + id_estudiante + ", registro="
				+ registro + "]";
	}
	
}