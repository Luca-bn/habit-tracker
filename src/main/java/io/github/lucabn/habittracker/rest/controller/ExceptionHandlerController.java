package io.github.lucabn.habittracker.rest.controller;

import io.github.lucabn.habittracker.dto.ErrorResponseDTO;
import io.github.lucabn.habittracker.exception.InternalErrorException;
import io.github.lucabn.habittracker.exception.InvalidParametersException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

  @ExceptionHandler({
      IllegalArgumentException.class,
      IllegalStateException.class,
      InvalidParametersException.class
  })
  ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
    return createErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({
      Exception.class,
      InternalErrorException.class
  })
  ResponseEntity<Object> handleInternalError(RuntimeException ex, WebRequest request) {
    return createErrorResponse(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<Object> createErrorResponse(RuntimeException ex, WebRequest request,
      HttpStatus status) {
    log.error("following error occurred: ", ex);
    return super.handleExceptionInternal(ex, ErrorResponseDTO.builder().
            errorMessage(ex.getMessage())
            .timestamp(LocalDateTime.now()).build(),
        new HttpHeaders(), status, request);
  }

}
