package com.pruebaspring.prueba.dao;

import com.pruebaspring.prueba.models.Estudiante;

import java.util.List;

public interface EstudianteDao {
	
    List<Estudiante> getEstudiantes();
    
    //2.A
    void registrarEstudiante(Estudiante estudiante);
   
    //2.B
    
    //2.C
    List<Estudiante> getEstudiantesOrdenadosPorNombre();
    
    //2.D
    Estudiante getEstudianteByLibreta(int lu);
    
    //2.E
    List<Estudiante> getEstudiantesPorGenero(String genero);
}
