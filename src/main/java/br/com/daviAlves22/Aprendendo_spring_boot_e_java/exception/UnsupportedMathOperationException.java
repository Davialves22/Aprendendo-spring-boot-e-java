package br.com.daviAlves22.Aprendendo_spring_boot_e_java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

    public UnsupportedMathOperationException(String message) {
        super(message);
    }
}