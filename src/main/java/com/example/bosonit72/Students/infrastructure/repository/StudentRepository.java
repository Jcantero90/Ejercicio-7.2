package com.example.bosonit72.Students.infrastructure.repository;

import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Students.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);

  // Optional<Student> findByPerson(Persona persona);


}
