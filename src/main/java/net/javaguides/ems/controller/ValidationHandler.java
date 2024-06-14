package net.javaguides.ems.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> inputErrors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("status", HttpStatus.BAD_REQUEST.name());
        errorMap.put("statusCode" , HttpStatus.BAD_REQUEST.value());
        errorMap.put("timeStamp", LocalDateTime.now());
        errorMap.put("fieldErrors" , inputErrors);
        return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
    }
}

