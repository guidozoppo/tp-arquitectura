package dto;

public class InscripcionDTO {

	private int idEstudiante;
	private int idCarrera;
	private int antiguedad;
	private int anioGraduacion;
	public InscripcionDTO(int idEstudiante, int idCarrera, int antiguedad, int anioGraduacion) {
		super();
		this.idEstudiante = idEstudiante;
		this.idCarrera = idCarrera;
		this.antiguedad = antiguedad;
		this.anioGraduacion = anioGraduacion;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getAnioGraduacion() {
		return anioGraduacion;
	}
	public void setAnioGraduacion(int anioGraduacion) {
		this.anioGraduacion = anioGraduacion;
	}
	
	
	
}
