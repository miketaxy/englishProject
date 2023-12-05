package org.portfolio.englishproject.handler;


import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
    @ExceptionHandler()
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>("We have some errors: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
