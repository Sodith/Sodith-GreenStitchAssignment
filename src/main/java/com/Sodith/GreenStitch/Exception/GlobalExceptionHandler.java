package com.Sodith.GreenStitch.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(EmployeeAlreadyExists.class)
    public ResponseEntity<ErrorDetails> handleStudentAlreadyExists(EmployeeAlreadyExists ex) {

        String errorMessage = ex.getMessage();
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                errorMessage,
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }
    @ExceptionHandler({EmployeeNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleStudentNotFound(EmployeeNotFoundException ex) {

        String errorMessage = ex.getMessage();
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found11",
                errorMessage,
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenericException(Exception ex) {
        String errorMessage = "Any error Occured check data correctly : " ;
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                errorMessage,
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
