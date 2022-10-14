package com.example.bosonit72.feingClients;


import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutputProfesorNotFull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="teacher-service", url = "http://localhost:8081/profesor")
public interface Feing {
    //La ruta del feing a la que queremos conectarnos. NO ponemos una URL nueva, sino a la ruta ya creada que queremos conectarnos.
    @GetMapping("/findTeacher/{id}")
    OutPutProfesorDto findTeacherFeing(@PathVariable("id") Integer id);

    @GetMapping("/findTeacherNoValues")
    OutPutProfesorDto findNoParams();

}
