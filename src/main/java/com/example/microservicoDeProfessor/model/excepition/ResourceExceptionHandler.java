package com.example.microservicoDeProfessor.model.excepition;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    public record StandardError(
            Instant timestamp,
            Integer status,
            String error,
            String message,
            String path
    ) {}

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<StandardError> naoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request) {
        StandardError err = new StandardError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}