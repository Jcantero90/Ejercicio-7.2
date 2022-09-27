package com.example.bosonit72.Persona.infraestructure.controler.Exception;

import com.example.bosonit72.Persona.domain.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
@ResponseBody
public class ExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomError handleEntityNotFoundException(EntityNotFoundException exception){
        return new CustomError(exception.getMessage(), 404);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public CustomError handleUnprocessableEntityException(UnprocessableEntityException exception){
        return new CustomError(exception.getMessage(),422);
    }

}
