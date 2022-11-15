package com.pruebaspring.prueba.controllers;

import com.pruebaspring.prueba.dao.EstudianteDao;
import com.pruebaspring.prueba.models.Estudiante;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/estudiantes")
@Tag(name = "Estudiante", description ="Diferentes operaciones sobre estudiante")
@CrossOrigin(origins = "https://tpearquitectura.herokuapp.com/")
public class EstudianteController {

    @Autowired
    private EstudianteDao estudianteDao;

    @Operation(description = "Se obtiene un listado de todos los estudiantes, de no haber ningun estudiante devuelve vacio.", 
			summary = "Obtener todos los estudiantes.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(method = RequestMethod.GET)
    public List<Estudiante> getEstudiantes(){
        return estudianteDao.getEstudiantes();
    }

    @Operation(description = "Se registra un estudiante.", 
			summary = "Registrar un estudiante.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK", content = {@Content(schema = @Schema(implementation = Estudiante.class))} ),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(method = RequestMethod.POST)
    public void registrarEstudiante(@RequestBody Estudiante estudiante){
        estudianteDao.registrarEstudiante(estudiante);
    }

    @Operation(description = "Se obtiene un listado de los estudiantes ordenado alfabeticamente por sus nombres, de no haber ningun estudiante devuelve vacio.", 
			summary = "Obtener estudiantes ordenados por su nombre.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(value="/orderByName", method = RequestMethod.GET)
    public List<Estudiante> getEstudiantesByName(){
        return estudianteDao.getEstudiantesOrdenadosPorNombre();
    }
    
    @Operation(description = "Se obtiene un determinado estudiante filtrando por su numero de legajo universitario, de no existir estudiante con ese LU devuelve vacio.", 
			summary = "Obtener estudiante por su LU.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(value="/lu/{lu}", method = RequestMethod.GET)
    public Estudiante getEstudiantesByLu(@PathVariable int lu){
        return estudianteDao.getEstudianteByLibreta(lu);
    }
    
    @Operation(description = "Se obtiene un listado de los estudiantes filtrando por genero, de no haber existir estudiantes con dicho genero devuelve vacio.", 
			summary = "Obtener estudiantes por genero.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(value="/genero/{genero}", method = RequestMethod.GET)
    public List<Estudiante> getEstudiantesByLu(@PathVariable String genero){
        return estudianteDao.getEstudiantesPorGenero(genero);
    }


}

