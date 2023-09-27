package com.lacertech.lacereats.controllers.globalexceptionhandler;

import com.lacertech.lacereats.exceptions.BusinessException;
import com.lacertech.lacereats.exceptions.ExistingAttributeException;
import com.lacertech.lacereats.exceptions.IdNotFoundException;
import com.lacertech.lacereats.exceptions.responseerror.ErrorObject;
import com.lacertech.lacereats.exceptions.responseerror.ErrorResponse;
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

/**
 * This class represents a global exception handler for handling various exceptions
 * that may occur during the execution of HTTP requests.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
  private HttpHeaders headers() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }

  /**
   * Handles MethodArgumentNotValidException and returns an error response with details
   * about invalid fields in the request.
   *
   * @param ex      The MethodArgumentNotValidException.
   * @param headers The HttpHeaders to include in the response.
   * @param status  The HttpStatusCode to include in the response.
   * @param request The WebRequest.
   * @return A ResponseEntity containing an error response with details about invalid fields.
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request
  ) {
    List<ErrorObject> errors = getErrors(ex);
    ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
    return new ResponseEntity<>(errorResponse, headers(), status);
  }

  private ErrorResponse getErrorResponse(
      MethodArgumentNotValidException ex,
      HttpStatusCode status,
      List<ErrorObject> errors
  ) {
    return new ErrorResponse("Request has invalid fields.", status.value(),
              status, ex.getBindingResult().getObjectName(), errors);
  }

  private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
    return ex.getBindingResult().getFieldErrors().stream()
             .map(error -> new ErrorObject(error.getDefaultMessage(),
               error.getField(), error.getRejectedValue()))
             .collect(Collectors.toList());
  }

  private ErrorObject getError(BusinessException ex) {
    return new ErrorObject(ex.getMessage(), ex.getField(), ex);
  }

  /**
   * Handles IllegalArgumentException and returns an error response with details
   * about the invalid argument.
   *
   * @param businessException The IllegalArgumentException.
   * @return A ResponseEntity containing an error message.
   */
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessExceptio) {
    return new ResponseEntity<>(businessExceptio.getMessage(), 
      headers(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  /**
   * Handles IdNotFoundException and returns an error response with details about
   * a non-existent attribute.
   *
   * @param idNotFoundException The IdNotFoundException.
   * @return A ResponseEntity containing an error response with details about 
   *     a non-existent attribute.
   */
  @ExceptionHandler(IdNotFoundException.class)
  public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException idNotFoundException) {
    List<ErrorObject> error = new ArrayList<ErrorObject>() {{
        add(getError(idNotFoundException));
      }};

    ErrorResponse errorResponse = new ErrorResponse(
        "Non-existent attribute.",
        HttpStatus.NOT_FOUND.value(),
        HttpStatusCode.valueOf(404), 
        idNotFoundException.getObjectName(),
        error);

    return new ResponseEntity<>(errorResponse, headers(), HttpStatus.NOT_FOUND);
  }

  /**
   * Handles ExistingAttributeException and returns an error response with details
   * about an existing attribute.
   *
   * @param existingAttributeException The ExistingAttributeException.
   * @return A ResponseEntity containing an error response with details about an existing attribute.
   */
  @ExceptionHandler(ExistingAttributeException.class)
  public ResponseEntity<Object> handleExistingAttributeException(
      ExistingAttributeException existingAttributeException
  ) {
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

  /**
   * Handles unexpected exceptions and returns an error response with a generic message.
   *
   * @param unexpectedException The unexpected exception.
   * @return A ResponseEntity containing a generic error message for unexpected exceptions.
   */
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
    return new ResponseEntity<>("Unexpected server error", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
