package com.example.bosonit72.Persona.infraestructure.controler.Exception;

import com.example.bosonit72.Persona.domain.CustomError;
import lombok.Data;

import java.util.Date;
@Data
public class EntityNotFoundException extends Exception{
/*
    public CustomError EntityNotFoundException(){
        return new CustomError(new Date(), 404, "Person do not exist!");
    }
 */
    Date fecha;
    int httpCode;
    public EntityNotFoundException(String message, int httpCode)
    {
        super(message);
        setFecha(new Date());
        setHttpCode(httpCode);
    }
}
