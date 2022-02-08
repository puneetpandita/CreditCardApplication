package com.ppandita.app.creditcardprocessing.common;

import com.ppandita.app.creditcardprocessing.exception.InvalidInputException;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:04 PM
 *
 * This class validates a given number against Luhn 10 algorithm
 */
public class Luhn10Validator
{
    /*
    * This method simply follows the Luhn or Mod 10 Algorithm to validate a number.
    * If the number does not satisfy the algo, it will be marked as invalid.
     */
    public static boolean isValidCardNumber(String cardNumber) throws InvalidInputException
    {
        int sum = 0;
        boolean isOddDigit = false;

        //Check if cardNum is proper with only digits.
        try
        {
            BigInteger cardNum = new BigInteger(cardNumber);
        }
        catch (NumberFormatException ex)
        {
            throw new InvalidInputException("Credit Card Number is invalid. Please provide a valid number with digits only.");
        }

        //Credit card number should not exceed 19 digits.
        if (cardNumber.length() > 19)
        {
            throw new InvalidInputException("Credit Card Number is invalid. Please provide a valid number with 19 digits or lesser.");
        }

        //Iterate over the digits of number in a reverse order.
        for (int index = cardNumber.length() - 1; index >= 0; --index)
        {
            int n = cardNumber.charAt(index) - '0';

            //Every second digit from the right side, should be doubled in value and
            //if value goes into double digits, add the digits to reach a single digit value.
            // For a number 543210, '5','3' and '1' will be processed.
            if (isOddDigit)
            {
                n *= 2;
                if (n > 9)
                {
                    n = n - 9;
                }
            }

            sum += n;
            isOddDigit = !isOddDigit;
        }

        //If the final sum of all digits is divisible by 10, the number is valid.
        return sum % 10 == 0;

    }
}
