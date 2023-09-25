package com.lacertech.lacereats.controllers.globalexceptionhandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lacertech.lacereats.exceptions.BusinessException;
import com.lacertech.lacereats.exceptions.ExistingAttributeException;
import com.lacertech.lacereats.exceptions.IdNotFoundException;
import com.lacertech.lacereats.exceptions.responseerror.ErrorObject;
import com.lacertech.lacereats.exceptions.responseerror.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    private HttpHeaders headers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, headers(),status);
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatusCode status, List<ErrorObject> errors) {
        return new ErrorResponse("Request has invalid fields.", status.value(),
                status, ex.getBindingResult().getObjectName(), errors);
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    private ErrorObject getError(BusinessException ex) {
        return new ErrorObject(ex.getMessage(), ex.getField(), ex);
    }

   @ExceptionHandler(IllegalArgumentException.class)
   public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessExceptio) {
        return new ResponseEntity<>(businessExceptio.getMessage(), headers(), HttpStatus.UNPROCESSABLE_ENTITY);
   }

   @ExceptionHandler(IdNotFoundException.class)
   public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException idNotFoundException) {
        List<ErrorObject> error = new ArrayList<ErrorObject>() {{
            add(getError(idNotFoundException));
        }};

        ErrorResponse errorResponse = new ErrorResponse("Non-existent attribute.", HttpStatus.NOT_FOUND.value(), HttpStatusCode.valueOf(404),  idNotFoundException.getObjectName(), error);

       return new ResponseEntity<>(errorResponse, headers(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistingAttributeException.class)
   public ResponseEntity<Object> handleExistingAttributeException(ExistingAttributeException existingAttributeException) {
        List<ErrorObject> error = new ArrayList<ErrorObject>() {{
            add(getError(existingAttributeException));
        }};

        ErrorResponse errorResponse = new ErrorResponse(
            "Invalid attribute",
            HttpStatus.CONFLICT.value(),
            HttpStatusCode.valueOf(409), 
            existingAttributeException.getObjectName(),
            error);
        
       return new ResponseEntity<>(errorResponse, headers(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
         return new ResponseEntity<>("Unexpected server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
