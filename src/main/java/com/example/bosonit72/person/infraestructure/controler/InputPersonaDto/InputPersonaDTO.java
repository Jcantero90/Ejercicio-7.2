package com.example.bosonit72.person.infraestructure.controler.InputPersonaDto;

import com.example.bosonit72.person.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputPersonaDTO {
    private Integer id_persona;

    private String usuario;
    private String password;
    private String name;
    private String supername;
    private String company_Email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public Persona turnInputToPersona() {
        Persona p1 = new Persona();
        p1.setId_persona(this.id_persona);
        p1.setUsuario(this.usuario);
        p1.setPassword(this.password);
        p1.setName(this.name);
        p1.setSupername(this.supername);
        p1.setCompany_Email(this.company_Email);
        p1.setCity(this.city);
        p1.setActive(this.active);
        p1.setCreated_date(this.created_date);
        p1.setImagen_url(this.imagen_url);
        p1.setTermination_date(this.termination_date);
        return p1;
    }
}
