package com.ppandita.app.creditcardprocessing.config;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.jet.JetInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/6/22
 * Time: 9:43 PM
 *
 * This is configuration class that binds the Hazelcast Jet instance to our Credit card Repo
 */

@Configuration
@EnableHazelcastRepositories(basePackages = "com.ppandita.app.creditcardprocessing")
public class HazelcastConfig
{
    @Autowired
    JetInstance jetInstance;

    @Bean
    HazelcastInstance hazelcastInstance() {
        return jetInstance.getHazelcastInstance();
    }
}
