package com.ppandita.app.creditcardprocessing.response;

import org.springframework.http.HttpStatus;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:43 PM
 */

public class BaseResponse
{
    private boolean successful;

    private Integer code;

    private String message;

    private HttpStatus status;

    Object serviceResponse;

    public BaseResponse(Object serviceResponse)
    {
        super();
        this.serviceResponse = serviceResponse;
    }

    public boolean isSuccessful()
    {
        return successful;
    }

    public void setSuccessful(boolean successful)
    {
        this.successful = successful;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public HttpStatus getStatus()
    {
        return status;
    }

    public void setStatus(HttpStatus status)
    {
        this.status = status;
    }

    public Object getServiceResponse()
    {
        return serviceResponse;
    }

    public void setServiceResponse(Object serviceResponse)
    {
        this.serviceResponse = serviceResponse;
    }

}