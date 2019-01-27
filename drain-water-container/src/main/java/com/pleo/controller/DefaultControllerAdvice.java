package com.pleo.controller;

import com.pleo.exception.InvalidCellHeightsException;
import com.pleo.model.WaterContainerError;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class DefaultControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCellHeightsException.class)
    public ResponseEntity<WaterContainerError> handleInvalidCellHeightsException(InvalidCellHeightsException ex) {
        log.error("Exception occurred : " + ex);
        WaterContainerError waterContainerError = new WaterContainerError();
        waterContainerError.setMessage(ex.getMessage());
        waterContainerError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(waterContainerError, HttpStatus.BAD_REQUEST);
    }

}
