package com.pruebaspring.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaspring.prueba.dao.EstudianteCarreraDao;
import com.pruebaspring.prueba.models.Estudiante;
import com.pruebaspring.prueba.models.EstudianteCarrera;

import dto.InscripcionDTO;
import dto.ReporteCarrera;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="api/estudianteCarrera")
@Tag(name = "EstudianteCarrera", description ="Diferentes operaciones sobre la informacion almacenada y relacionada entre estudiantes y carreras")
public class EstudianteCarreraController {

	@Autowired
    private EstudianteCarreraDao estudianteCarreraDao;

	@Operation(description = "Se obtiene un listado de los estudiantes inscriptos en las diferentes carreras, "
			+ "de no haber algun estudiante inscripto en alguna carrera devuelve vacio.", 
			summary = "Obtener informacion de estudiantes inscriptos en carrera.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(method = RequestMethod.GET)
    public List<EstudianteCarrera> getCarreras(){
    	return estudianteCarreraDao.getEstudianteCarreras();
    }
    
    @Operation(description = "Se matricula un estudiante en una carrera.", 
			summary = "Matricular estudiante en una carrera determinada.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK", content = {@Content(schema = @Schema(implementation = EstudianteCarrera.class))} ),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void matricularEstudiante(@RequestBody InscripcionDTO inscripcion){
    	estudianteCarreraDao.matricularEstudiante(inscripcion);
    }
    
    @Operation(description = "Se obtiene un listado de estudiantes filtrando por una carrera y una ciudad determinada, "
    		+ "de no haber estudiantes que cumplan con los filtros devuelve vacio.", 
			summary = "Obtener estudiantes de una carrera y una ciudad determinada.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(value="/carrera/{carrera}/ciudad/{ciudad}", method = RequestMethod.GET )
    public List<Estudiante> getEstudiantesPorCarreraYCiudad(@PathVariable int carrera, @PathVariable String ciudad) {
    	return estudianteCarreraDao.getEstudiantesPorCarrera(carrera, ciudad);
    }
    
    @Operation(description = "Se obtiene reporte de inscriptos y egresados de todas las carreras, de no existir informacion devuelve vacio.", 
			summary = "Obtener reportes de carreras.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(value="/reportes", method = RequestMethod.GET )
    public List<ReporteCarrera> getReporte() {
    	return estudianteCarreraDao.getReporte();
    }
}
