package com.ppandita.app.creditcardprocessing.repository;

import com.ppandita.app.creditcardprocessing.common.CreditCard;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 8:04 PM
 *
 * This is a basic Repository interface that defines Hazelcast as parent repo binding it to Credit Card bean.
 */
public interface CreditCardRepo extends HazelcastRepository<CreditCard, String>, Serializable
{
}
