package com.ppandita.app.creditcardprocessing.exception;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:04 PM
 *
 * This is a custom exception class that will be invoked for invalid input from user
 */

public class InvalidInputException extends Exception
{
    public InvalidInputException(String message)
    {
        super(message);
    }
}
