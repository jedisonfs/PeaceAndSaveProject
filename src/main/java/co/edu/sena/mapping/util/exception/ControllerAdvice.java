package co.edu.sena.mapping.util.exception;

import co.edu.sena.mapping.util.exception.ApiError;
import co.edu.sena.mapping.util.exception.runtime.EmptyInputException;
import co.edu.sena.mapping.util.exception.runtime.EntityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@Order(Ordered.HIGHEST_PRECEDENCE)
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        String error = "Malformed JSON request";

        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<Object> handleEmtpyInput(EmptyInputException emptyInputException, javax.validation.ConstraintViolationException ex) {
        ApiError apiError = new ApiError(BAD_REQUEST, "Input field is Empty, Please look into it!", emptyInputException);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exception) {
        ApiError apiError = new ApiError(NOT_FOUND);// Clase que devuelve el error con description y estado personalizado
        apiError.setMessage(exception.getMessage());
        return buildResponseEntity(apiError);
    }
}
