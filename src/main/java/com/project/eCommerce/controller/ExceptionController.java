package com.project.eCommerce.controller;

import com.project.eCommerce.CSTMException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionController {
    public ResponseEntity<String> handleCustomNotFoundException(CSTMException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }
}
