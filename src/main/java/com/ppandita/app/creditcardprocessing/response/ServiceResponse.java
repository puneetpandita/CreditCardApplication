package com.ppandita.app.creditcardprocessing.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:43 PM
 */

public class ServiceResponse extends ResponseEntity<Object>
{
    public ServiceResponse(Object body, HttpStatus status)
    {
        super(body, status);
    }
}