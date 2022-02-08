package com.ppandita.app.creditcardprocessing.common;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:33 PM
 *
 * This class acts as POJO that will be used as payload for our app data.
 */

public class CreditCard implements Serializable
{
    @Id
    private String cardNumber;
    private String name;
    private int cardLimit;
    private int cardBalance;

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCardLimit()
    {
        return cardLimit;
    }

    public void setCardLimit(int cardLimit)
    {
        this.cardLimit = cardLimit;
    }

    public int getCardBalance()
    {
        return cardBalance;
    }

    public void setCardBalance(int cardBalance)
    {
        this.cardBalance = cardBalance;
    }
}
