package com.example.bosonit72.Persona.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

    public Persona() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String usuario;
    private String password;
    private String name;
    private String supername;
    private String company_Email;
    private String city;
    @Column(nullable = false)
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public boolean getActive() {
        return true;
    }
}
