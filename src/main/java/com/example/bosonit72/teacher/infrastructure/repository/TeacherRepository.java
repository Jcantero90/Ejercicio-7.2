package com.example.bosonit72.teacher.infrastructure.repository;

import com.example.bosonit72.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

 //   Optional<Teacher> findByPerson(Persona person);


}
