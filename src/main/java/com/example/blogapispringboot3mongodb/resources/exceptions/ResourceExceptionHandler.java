package com.example.blogapispringboot3mongodb.resources.exceptions;

import com.example.blogapispringboot3mongodb.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exc, HttpServletRequest req) {
        Instant now = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Resource not found";
        String message = exc.getMessage();
        String path = req.getRequestURI();
        StandardError standardError = new StandardError(now, status.value(), error, message, path);
        return ResponseEntity.status(status).body(standardError);
    }
}
