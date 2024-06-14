package net.javaguides.ems.advice;


import net.javaguides.ems.entity.AppError;
import net.javaguides.ems.entity.ErrorDetails;
import net.javaguides.ems.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.ObjectError;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AppError> handleException(ResourceNotFoundException resourceNotFoundException) {
        AppError appError = new AppError(
                UUID.randomUUID().toString(),
                resourceNotFoundException.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(appError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
