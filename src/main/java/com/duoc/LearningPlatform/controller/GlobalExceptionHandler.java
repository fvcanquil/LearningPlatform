package com.duoc.LearningPlatform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para la plataforma de aprendizaje.
 * Centraliza el manejo de errores aplicando buenas prácticas de microservicios.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja el caso en que no se encuentra un curso por su ID.
     * Retorna HTTP 404 Not Found con un mensaje descriptivo.
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NoSuchElementException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Recurso no encontrado");
        error.put("mensaje", ex.getMessage() != null ? ex.getMessage() : "El curso solicitado no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Maneja errores de tipo en parámetros de la URL (ej: /api/cursos/abc en lugar de un número).
     * Retorna HTTP 400 Bad Request.
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Parámetro inválido");
        error.put("mensaje", "El parámetro '" + ex.getName() + "' debe ser un número válido");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Captura cualquier excepción no controlada.
     * Retorna HTTP 500 Internal Server Error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneral(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Error interno del servidor");
        error.put("mensaje", "Ocurrió un error inesperado. Por favor intente nuevamente.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
