package com.ppandita.app.creditcardprocessing.exception;

import com.ppandita.app.creditcardprocessing.response.ServiceResponse;
import com.ppandita.app.creditcardprocessing.response.ServiceResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:41 PM
 */

@ControllerAdvice
public class BaseExceptionHandler
{

    static final Logger _logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler(InvalidInputException.class)
    public ServiceResponse handleException(InvalidInputException ex)
    {
        _logger.error(ex.getMessage(), ex);
        return ServiceResponseBuilder.buildErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ServiceResponse handleException(ResponseStatusException ex)
    {
        _logger.error(ex.getMessage(), ex);
        return ServiceResponseBuilder.buildErrorResponse(ex.getReason(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex)
    {
        _logger.error(ex.getMessage(), ex);
        return ServiceResponseBuilder.buildErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
