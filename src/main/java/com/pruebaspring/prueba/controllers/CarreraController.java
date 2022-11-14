package com.pruebaspring.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaspring.prueba.dao.CarreraDao;
import com.pruebaspring.prueba.models.Carrera;

/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;*/
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="api/carreras")
@Tag(name = "Carrera", description ="Diferentes operaciones sobre carrera")
public class CarreraController {

	@Autowired
    private CarreraDao carreraDao;


	@Operation(description = "Se obtiene un listado de todas las carreras, de no haber ninguna carrera devuelve vacio.", 
			summary = "Obtener todas las carreras.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(method = RequestMethod.GET)
    public List<Carrera> getCarreras(){
    	return carreraDao.getCarreras();
    }
    
	@Operation(description = "Se obtiene un listado de las carreras que tienen inscripto al menos un estudiante, de no haber carrera con inscriptos devuelve vacio.", 
			summary = "Obtener carreras con al menos un inscripto.")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Success OK"),
	  @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
    @RequestMapping(value="/ConEstudiantes", method = RequestMethod.GET)
    public List<Carrera> getCarrerasConEstudiantes() {
    	return carreraDao.getCarrerasConEstudiantes();
    }
}
