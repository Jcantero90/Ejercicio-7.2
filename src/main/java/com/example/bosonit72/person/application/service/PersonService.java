package com.example.bosonit72.person.application.service;

import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.person.infraestructure.controler.InputPersonaDto.InputPersonaDTO;
import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import java.util.List;

public interface PersonService {

    public List<OutputPersonaDTO> getUsername(String usuario);
    public OutputPersonaDTO findByIdPersona(Integer id_persona) throws Exception;
    public OutputPersonaDTO updatePersona(Integer id_persona, Persona persona);
    public void deleteByIdPersona(Integer id_persona);
    public OutputPersonaDTO addPersona(InputPersonaDTO persona) throws Exception;
}
