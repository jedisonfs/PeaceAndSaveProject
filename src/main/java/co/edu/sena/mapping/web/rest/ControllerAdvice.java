package co.edu.sena.mapping.web.rest;

import co.edu.sena.mapping.web.rest.exception.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmtpyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<>("Input field is Empty, Please look into it!", HttpStatus.BAD_REQUEST);
    }
}
