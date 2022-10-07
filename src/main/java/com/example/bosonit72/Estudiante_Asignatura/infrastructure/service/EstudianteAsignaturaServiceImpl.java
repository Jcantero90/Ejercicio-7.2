package com.example.bosonit72.Estudiante_Asignatura.infrastructure.service;

import com.example.bosonit72.Estudiante_Asignatura.infrastructure.repository.EstudianteAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EstudianteAsignaturaServiceImpl implements EstudianteAsignaturaService {

    @Autowired
    EstudianteAsignaturaRepository estudianteAsignaturaRepository;


}
