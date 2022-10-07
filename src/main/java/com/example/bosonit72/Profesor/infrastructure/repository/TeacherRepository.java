package com.example.bosonit72.Profesor.infrastructure.repository;

import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Profesor.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

 //   Optional<Teacher> findByPerson(Persona person);


}
