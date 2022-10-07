package com.example.bosonit72.Persona.domain;

import com.example.bosonit72.Profesor.domain.Teacher;
import com.example.bosonit72.Students.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;

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

    @JsonIgnore
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Student student;

    @JsonIgnore
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Teacher teacher;


    public boolean getActive() {
        return true;
    }

}
