package net.javaguides.ems.advice;


import net.javaguides.ems.entity.AppError;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.UUID;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AppError> handleException(ResourceNotFoundException resourceNotFoundException) {
        AppError appError = new AppError(
                UUID.randomUUID().toString(),
                resourceNotFoundException.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(appError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<AppError> handleException(StudentNotFoundException studentNotFoundException) {
        AppError appError = new AppError(
                UUID.randomUUID().toString(),
                studentNotFoundException.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(appError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
