package com.example.bosonit72.Persona.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {

String message;
Date fecha;
int httpCode;

    public CustomError(String message, int httpCode) {
        setMessage(message);
        setFecha(new Date());
        setHttpCode(httpCode);
    }
}
