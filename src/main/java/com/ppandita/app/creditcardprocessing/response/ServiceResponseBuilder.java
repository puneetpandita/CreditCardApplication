package com.ppandita.app.creditcardprocessing.response;

import org.springframework.http.HttpStatus;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:44 PM
 *
 * This is a response builder class, which controller will used to convert all the responses into a standard formatted response.
 */

public class ServiceResponseBuilder
{
    public static ServiceResponse buildSuccessResponse(Object responseBody, HttpStatus status)
    {
        return build(responseBody, status, true);
    }

    public static ServiceResponse buildErrorResponse(Object error, HttpStatus status)
    {
        return build(error, status, false);
    }

    private static ServiceResponse build(Object response, HttpStatus status, boolean successful)
    {
        BaseResponse baseResponse = new BaseResponse(response);
        baseResponse.setMessage(status.getReasonPhrase());
        baseResponse.setCode(status.value());
        baseResponse.setStatus(status);
        baseResponse.setSuccessful(successful);
        ServiceResponse serviceResponse = new ServiceResponse(baseResponse, status);
        return serviceResponse;
    }
}

