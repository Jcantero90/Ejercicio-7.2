package com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto;

import com.example.bosonit72.Persona.domain.Persona;
import lombok.Data;

import java.sql.Date;

@Data
public class OutputPErsonaDTO {
    private Integer id;
    private String usuario;
    private String name;
    private String supername;
    private String company_Email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public OutputPErsonaDTO(Persona persona) {
        this.id = persona.getId();
        this.usuario = persona.getUsuario();
        this.name = persona.getName();
        this.supername = persona.getSupername();
        this.company_Email = persona.getCompany_Email();
        this.city = persona.getCity();
        this.active = persona.getActive();
        this.created_date = persona.getCreated_date();
        this.imagen_url = persona.getImagen_url();
        this.termination_date = persona.getTermination_date();
    }
}
