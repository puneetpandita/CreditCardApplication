package com.ppandita.app.creditcardprocessing.service;

import com.ppandita.app.creditcardprocessing.common.CreditCard;
import com.ppandita.app.creditcardprocessing.common.InputValidator;
import com.ppandita.app.creditcardprocessing.common.Luhn10Validator;
import com.ppandita.app.creditcardprocessing.exception.InvalidInputException;
import com.ppandita.app.creditcardprocessing.repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:01 PM
 *
 * Service class to handle business logic for defined web services
 */

@Service
public class CCPServiceManager implements CCPServiceManagerIntf
{
    @Autowired
    CreditCardRepo creditCardRepository;

    @PostConstruct
    public void initializeCCPManager()
    {
        // Any init code should go here.
        // Like loading up of any factories or retrieving existing data from a file and pushing it to DB/Cache instance
    }

    /*
    * This service method will save the details of CreditCard as input by the user.
    * First it will validate the details provided and if valid save them in the repo.
    **/
    @Override
    public CreditCard validateAndSaveCard(CreditCard cardObj) throws InvalidInputException
    {
        CreditCard savedCardObj = null;
        if (null != cardObj && InputValidator.validateCardObjData(cardObj))
        {
            savedCardObj = creditCardRepository.save(cardObj);
        }
        else
        {
            throw new InvalidInputException("Credit Card data provided is invalid.");
        }

        return  savedCardObj;
    }

    /*
     * This service method will get the details of CreditCard saved in repo.
     * It will take card number as input and fetch corresponding card object.
     **/
    @Override
    public Optional<CreditCard> getCard(String cardNumber) throws InvalidInputException
    {
        Optional<CreditCard> cardObj = null;
        if (null != cardNumber && Luhn10Validator.isValidCardNumber(cardNumber))
        {
            cardObj = creditCardRepository.findById(cardNumber);
        }
        else
        {
            throw new InvalidInputException("Credit Card Number doesn't follow Luhn Algorithm");
        }
        return cardObj;
    }

    /*
     * This service method will get the details of all CreditCard present in repo.
     **/
    @Override
    public Iterable<CreditCard> getAllCards()
    {
        return creditCardRepository.findAll();
    }
}
