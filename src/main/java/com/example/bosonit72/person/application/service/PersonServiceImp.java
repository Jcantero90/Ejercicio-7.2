package com.example.bosonit72.person.application.service;

import com.example.bosonit72.feingClients.Feing;
import com.example.bosonit72.person.infraestructure.controler.repository.PersonRepository;
import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.exception.EntityNotFoundException;
import com.example.bosonit72.exception.UnprocessableEntityException;
import com.example.bosonit72.person.infraestructure.controler.InputPersonaDto.InputPersonaDTO;
import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutPutPersonaFatherDto;
import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutputPersonaStudent;
import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutputPersonaTeacher;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    PersonRepository personRepository;


    //Feign implemented in Autowired.
    @Autowired
    Feing feing;

    //Test method. Not used.
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

    public Persona findById(Integer id) {
        Optional<Persona> persona = personRepository.findById(id);
        Persona person = persona.get();
        return person;
    }

    public OutPutPersonaFatherDto findByIdFather(Integer id, String type) throws EntityNotFoundException {
        Optional<Persona> personaDto = personRepository.findById(id);
        Persona persona = personaDto.get();

        if(persona==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }

        if (type.equals("full")) {
            if (persona.getStudent() != null) {
                return new OutputPersonaStudent(persona);
            } else if (persona.getTeacher() != null) {
                return new OutputPersonaTeacher(persona);
            }
        }
        return new OutputPersonaDTO(persona);
    }

    //Feign method. We can find Teacher by ID.
    public OutPutProfesorDto getFeing (Integer id){
        return feing.findTeacherFeing(id);
    }

}
