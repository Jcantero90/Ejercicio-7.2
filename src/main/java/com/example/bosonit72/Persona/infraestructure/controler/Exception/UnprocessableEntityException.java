package com.example.bosonit72.Persona.infraestructure.controler.Exception;

import com.example.bosonit72.Persona.domain.CustomError;
import lombok.Data;

import java.util.Date;
@Data
public class UnprocessableEntityException extends Exception{
    Date fecha;
    int httpCode;
    public UnprocessableEntityException(String message, int httpCode)
    {
        super(message);
        setFecha(new Date());
        setHttpCode(httpCode);
    }
}
