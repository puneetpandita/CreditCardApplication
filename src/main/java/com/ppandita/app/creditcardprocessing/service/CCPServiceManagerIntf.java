package com.ppandita.app.creditcardprocessing.service;

import com.ppandita.app.creditcardprocessing.common.CreditCard;
import com.ppandita.app.creditcardprocessing.exception.InvalidInputException;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:01 PM
 */

public interface CCPServiceManagerIntf
{
    CreditCard validateAndSaveCard(CreditCard cardObj) throws InvalidInputException;

    Optional<CreditCard> getCard(String cardNumber) throws InvalidInputException;

    Iterable<CreditCard> getAllCards();
}
