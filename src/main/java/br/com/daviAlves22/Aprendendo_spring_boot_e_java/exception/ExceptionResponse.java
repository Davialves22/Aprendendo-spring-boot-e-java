package br.com.daviAlves22.Aprendendo_spring_boot_e_java.exception;

import java.util.Date;

public record ExceptionResponse(Date timestmap, String message, String details) {}