package com.example.bosonit72.Persona.infraestructure.controler.service;

import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Exception.EntityNotFoundException;
import com.example.bosonit72.Exception.UnprocessableEntityException;
import com.example.bosonit72.Persona.infraestructure.controler.InputPersonaDto.InputPersonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Persona> getAllPersonas() {
        return personRepository.findAll();
    }

    public OutputPersonaDTO addPersona(InputPersonaDTO persona) throws Exception {
        Persona p1 = persona.turnInputToPersona();
        if ((p1.getUsuario() == null) || (p1.getUsuario().length() > 10)) {
            throw new UnprocessableEntityException("Username vacío o superior a 10 caracteres");
        } else {
            personRepository.save(p1);
        }
        return new OutputPersonaDTO(p1);
    }

    public void deleteByIdPersona(Integer id) {
        personRepository.deleteById(id);
    }

    public OutputPersonaDTO updatePersona(Integer id, Persona persona) {
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
        return new OutputPersonaDTO(p1);
    }

    public OutputPersonaDTO findByIdPersona(Integer id_persona) throws EntityNotFoundException {
        Persona p1 = personRepository.findById(id_persona).orElseThrow(() -> new EntityNotFoundException("No username found with id: " + id_persona));
        return new OutputPersonaDTO(p1);
    }

    public List<OutputPersonaDTO> getUsername(String usuario) {
        List<Persona> persona = personRepository.findByUsuario(usuario);
        return persona.stream().map(OutputPersonaDTO::new).collect(Collectors.toList());
    }

    public Persona findById(Integer id){
        Optional<Persona> persona = personRepository.findById(id);
        Persona person = persona.get();
        return person;
    }

}

