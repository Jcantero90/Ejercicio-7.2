package com.example.bosonit72.Persona.infraestructure.controler.service;

import com.example.bosonit72.Persona.domain.CustomError;
import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Persona.infraestructure.controler.Exception.EntityNotFoundException;
import com.example.bosonit72.Persona.infraestructure.controler.Exception.UnprocessableEntityException;
import com.example.bosonit72.Persona.infraestructure.controler.InputPersonaDto.InputPerdonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto.OutputPErsonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp {
    @Autowired
    PersonRepository personRepository;

    public List<Persona> getAllPersonas() {
        return personRepository.findAll();
    }

    public OutputPErsonaDTO addPersona(InputPerdonaDTO persona) throws Exception {
        Persona p1 = persona.turnInputToPersona();
        if ((p1.getUsuario() == null) || (p1.getUsuario().length() > 10)) {
            throw new UnprocessableEntityException("Username vacío o superior a 10 caracteres", 422);
        } else {
            personRepository.save(p1);
        }
        return new OutputPErsonaDTO(p1);
    }

    public void deleteByIdPersona(Integer id) {
        personRepository.deleteById(id);
    }


    public OutputPErsonaDTO updatePersona(Integer id, Persona persona) {
        Optional<Persona> updatePer = personRepository.findById(id);
        Persona p1 = updatePer.get();
        p1.setUsuario(persona.getUsuario());
        p1.setPassword(persona.getPassword());
        p1.setName(persona.getName());
        p1.setSupername(persona.getSupername());
        p1.setCompany_Email(persona.getCompany_Email());
        p1.setCity(persona.getCity());
        p1.setActive(persona.getActive());
        p1.setCreated_date(persona.getCreated_date());
        p1.setImagen_url(persona.getImagen_url());
        p1.setTermination_date(persona.getTermination_date());
        System.out.println(p1);
        personRepository.save(p1);
        return new OutputPErsonaDTO(p1);
    }

    public OutputPErsonaDTO findByIdPerosna(Integer id) throws Exception {
        Optional<Persona> personaOptional = personRepository.findById(id);
        if (personaOptional.isEmpty()) {
            throw new EntityNotFoundException("mensaje de prueba", 404);
        }
        return new OutputPErsonaDTO(personRepository.findPersonaById(id));
    }

    public List<OutputPErsonaDTO> getUsername(String usuario) {
        List<Persona> persona = personRepository.findByUsuario(usuario);
        return persona.stream().map(OutputPErsonaDTO::new).collect(Collectors.toList());
    }
}

