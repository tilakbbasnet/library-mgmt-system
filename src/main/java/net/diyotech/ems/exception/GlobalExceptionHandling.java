package net.diyotech.ems.exception;

import net.diyotech.ems.model.ValidationError;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationError>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ValidationError> validationErrors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(filedError -> {
            validationErrors.add(new ValidationError(filedError.getField(), filedError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(validationErrors);
    }

    @ExceptionHandler(NullPointerException.class)
    public void handleNullPointerException(NullPointerException exception) {

    }
}
