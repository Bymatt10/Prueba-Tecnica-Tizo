package com.bymatt.pruebatecnica.config;

import com.bymatt.pruebatecnica.dto.response.StandardResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

import static com.bymatt.pruebatecnica.dto.response.StandardResponseDto.GenerateHttpResponse;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardResponseDto> handleConflict(MethodArgumentNotValidException ex, WebRequest request) {
        return GenerateHttpResponse(new StandardResponseDto(HttpStatus.BAD_REQUEST.value(), Objects.requireNonNull(ex.getFieldError()).getDefaultMessage(), HttpStatus.BAD_REQUEST));
    }
}
