package com.example.bosonit72.person.domain;

import com.example.bosonit72.subject.domain.Estudiante_Asignatura;
import com.example.bosonit72.teacher.domain.Teacher;
import com.example.bosonit72.student.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persona")
public class Persona implements Serializable {



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
