package com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto;

import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import lombok.Data;

import java.sql.Date;

@Data
public class OutputPersonaTeacher extends OutPutPersonaFatherDto {

    private Integer id_persona;
    private String usuario;
    private String name;
    private String supername;
    private String company_Email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    private OutPutProfesorDto.OutputProfesorNotFull profesorNotFull;

    public OutputPersonaTeacher(Persona persona){
        this.id_persona = persona.getId_persona();
        this.usuario = persona.getUsuario();
        this.name = persona.getName();
        this.supername = persona.getSupername();
        this.company_Email = persona.getCompany_Email();
        this.city = persona.getCity();
        this.active = persona.getActive();
        this.created_date = persona.getCreated_date();
        this.imagen_url = persona.getImagen_url();
        this.termination_date = persona.getTermination_date();
        this.profesorNotFull = new OutPutProfesorDto.OutputProfesorNotFull(persona.getTeacher());
    }
}
