/**
 * 
 */

package com.arcelormittal.casestudy.controller;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.arcelormittal.casestudy.controller.GlobalExceptionHandler;
import com.arcelormittal.casestudy.response.DefaultResponse;
import com.arcelormittal.casestudy.response.Response;
import com.arcelormittal.casestudy.response.ResponseStatus;

/**
 * Captures and handles exceptions for all the controllers.
 * 
 * @author Pareek 
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Logger for the exception handler.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(GlobalExceptionHandler.class);

    /**
     * Default constructor.
     */
    public GlobalExceptionHandler() {
        super();
    }

    @ExceptionHandler({ RuntimeException.class })
    public final ResponseEntity<Object> handleExceptionDefault(
            final Exception ex, final WebRequest request) throws Exception {
        final HttpHeaders headers;
        final HttpStatus status;

        LOGGER.error(ex.getMessage(), ex);

        status = HttpStatus.INTERNAL_SERVER_ERROR;
        headers = new HttpHeaders();
        return handleExceptionInternal(ex, null, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(final Exception ex,
            final Object body, final HttpHeaders headers,
            final HttpStatus status, final WebRequest request) {
        final Response<String> response;
        final String message;

        if (ex.getMessage() == null) {
            message = "";
        } else {
            message = ex.getMessage();
        }

        response = new DefaultResponse<>(message, ResponseStatus.FAILURE);

        return super.handleExceptionInternal(ex, response, headers, status,
                request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException ex, final HttpHeaders headers,
            final HttpStatus status, final WebRequest request) {
        final Iterable<String> errors;
        final Response<Iterable<String>> response;

        errors = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getDefaultMessage()).collect(Collectors.toList());

        response = new DefaultResponse<>(errors, ResponseStatus.WARNING);

        return super.handleExceptionInternal(ex, response, headers, status,
                request);
    }

}
