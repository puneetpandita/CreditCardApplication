package com.ppandita.app.creditcardprocessing.common;

import com.ppandita.app.creditcardprocessing.exception.InvalidInputException;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:03 PM
 *
 * This is a utility class that is used for validation.
 */

public class InputValidator
{
    /*
    * This method will validate 'CreditCard' object with pre-defined set of rules.
    * If the set of rules are not followed, object will be marked as invalid.
    **/
    public static boolean validateCardObjData(CreditCard cardObj) throws InvalidInputException
    {
        return isValidName(cardObj.getName()) &&
                isValidLimit(cardObj.getCardLimit()) &&
                Luhn10Validator.isValidCardNumber(cardObj.getCardNumber());
    }

    /*
     * This method will validate 'name' for the credit card does not have any asterisk '*' symbol.
     **/
    private static boolean isValidName(String name)
    {
        return !name.contains("*");
    }

    /*
     * This method will validate 'limit' for the credit card does not exceed 50000 for any customer.
     **/
    private static boolean isValidLimit(int limit)
    {
        return limit < 50000;
    }
}
