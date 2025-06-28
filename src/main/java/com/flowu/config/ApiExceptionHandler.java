package com.flowu.config; 

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice // Intercepta exceções de todos os controllers
public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class) // Captura esta exceção específica
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        // Você pode criar um DTO de erro para padronizar as respostas
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // DTO para padronizar o corpo do erro
    public static class ApiError {
        private HttpStatus status;
        private String message;

        public ApiError(HttpStatus httpStatus, String message) {
        }
        // getters e construtor
    }
}