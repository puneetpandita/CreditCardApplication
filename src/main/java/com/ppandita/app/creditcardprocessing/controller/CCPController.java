package com.ppandita.app.creditcardprocessing.controller;

import com.ppandita.app.creditcardprocessing.common.APIConstants;
import com.ppandita.app.creditcardprocessing.common.CreditCard;
import com.ppandita.app.creditcardprocessing.exception.InvalidInputException;
import com.ppandita.app.creditcardprocessing.response.ServiceResponse;
import com.ppandita.app.creditcardprocessing.response.ServiceResponseBuilder;
import com.ppandita.app.creditcardprocessing.service.CCPServiceManagerIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;


/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:01 PM
 *
 * This class defines rest end points supported by Credit Card processing application.
 *
 */

@RestController
@RequestMapping(APIConstants.CCP_CONTROLLER)
public class CCPController
{
    @Autowired
    CCPServiceManagerIntf serviceManager;

    /*
    * This method is just a demo call for getting generic details without any authorization.
    * This type of API can be used for web pages where static data is to be displayed.
    * For Eg: Welcome page, Organization banner etc.
    **/
    @GetMapping(APIConstants.PUBLIC)
    public String publicResponse()
    {
        return "Hello World, I am public.";
    }


    /*
     * This API will be used to retrieve and add credit card details to card repository.
     * It will only be executable post Authorization of user vide username/password input.
     **/
    @PostMapping(APIConstants.ADD_CARD)
    public ServiceResponse addCreditCard(@RequestBody CreditCard creditCard) throws Exception
    {
        if (Objects.isNull(creditCard))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Received null data for credit card.");
        }

        CreditCard savedCardObj = serviceManager.validateAndSaveCard(creditCard);

        return ServiceResponseBuilder.buildSuccessResponse(savedCardObj, HttpStatus.CREATED);

    }

    /*
     * This API will be used to retrieve a specific card detail from repo using card number as input.
     * It will return a single 'CreditCard' object as part of response
     * It will only be executable post Authorization of user vide username/password input.
     **/
    @GetMapping(APIConstants.GET_CARD)
    public ServiceResponse getCardDetails(@RequestParam String creditCardNum) throws Exception
    {
        if (Objects.isNull(creditCardNum))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credit card number not received.");
        }

        CreditCard cardObj = serviceManager.getCard(creditCardNum).get();

        return ServiceResponseBuilder.buildSuccessResponse(cardObj, HttpStatus.OK);
    }

    /*
     * This API will be used to retrieve all the card details present in repository.
     * It will return a list of 'CreditCard' object as part of response.
     * It will only be executable post Authorization of user vide username/password input.
     **/
    @GetMapping(APIConstants.GET_ALL_CARDS)
    public ServiceResponse getAllCardsDetails() throws Exception
    {
        Iterable<CreditCard> cardList = serviceManager.getAllCards();

        return ServiceResponseBuilder.buildSuccessResponse(cardList, HttpStatus.OK);
    }
}

