package com.ppandita.app.creditcardprocessing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ppandita.app.creditcardprocessing.common.CreditCard;
import com.ppandita.app.creditcardprocessing.exception.InvalidInputException;
import com.ppandita.app.creditcardprocessing.repository.CreditCardRepo;
import com.ppandita.app.creditcardprocessing.service.CCPServiceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CreditCardProcessingApplicationTests
{
    public CreditCardProcessingApplicationTests()
    {
        //No Args Constructor
    }

    @InjectMocks
    CCPServiceManager serviceManager;

    @Mock
    CreditCardRepo cardRepo;

    private CreditCard cardOne;
    private CreditCard cardTwo;
    private CreditCard cardFail;

    @Before
    public void init()
    {
        //InitMocks() is a secondary way to trigger Mock object instantiation, if Mockito Runner is not used
        //MockitoAnnotations.initMocks(this);

        cardOne = new CreditCard();
        cardOne.setCardNumber("79927398713");
        cardOne.setName("Legolas");
        cardOne.setCardLimit(5000);
        cardOne.setCardBalance(0);

        cardTwo = new CreditCard();
        cardTwo.setCardNumber("4417123456789113");
        cardTwo.setName("Neo");
        cardTwo.setCardLimit(3000);
        cardTwo.setCardBalance(0);

        cardFail = new CreditCard();
        cardFail.setCardNumber("799273987987632313");
        cardFail.setName("Incorrect");
        cardFail.setCardLimit(5000);
        cardFail.setCardBalance(0);
    }

    @Test
    public void getAllCardsTest()
    {
        List<CreditCard> list = new ArrayList<>();
        list.add(cardOne);
        list.add(cardTwo);

        when(cardRepo.findAll()).thenReturn(list);

        //test
        Iterable<CreditCard> cardList = serviceManager.getAllCards();

        assertEquals(2, list.size());
        verify(cardRepo, times(1)).findAll();
    }

    @Test
    public void getCardTest() throws InvalidInputException
    {
        when(cardRepo.findById("79927398713")).thenReturn(Optional.of(cardOne));

        CreditCard card = serviceManager.getCard(cardOne.getCardNumber()).get();

        assertEquals("Legolas", card.getName());
        assertEquals(5000, card.getCardLimit());
    }

    @Test
    public void addCardTest() throws InvalidInputException
    {
        serviceManager.validateAndSaveCard(cardOne);
        serviceManager.validateAndSaveCard(cardTwo);
        //serviceManager.validateAndSaveCard(cardFail);

        verify(cardRepo, times(1)).save(cardOne);
        verify(cardRepo, times(1)).save(cardTwo);
        //verify(cardRepo, times(1)).save(cardFail);

    }

}
