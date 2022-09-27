package com.example.bosonit72.Persona.infraestructure.controler.service.repository;

import com.example.bosonit72.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByUsuario(String usuario);
    Persona findPersonaById(Integer id);
}
