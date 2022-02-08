package com.ppandita.app.creditcardprocessing.config;

import com.ppandita.app.creditcardprocessing.common.APIConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    //Below configuration will simply disable CSRF token authorization which is required for all post request.
    // Doing this for ease of execution of the POSTMAN requests
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        super.configure(http);
        http.csrf().disable();

    }

    //A standard POST request should be handled with CSRF token.
    //This config will trigger a custom filter that will return CSRF token as part of GET requests,
    // which can then be used for POST requestss
    /*@Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic();
        http.addFilterAfter(new CSRFCustomFilter(), CsrfFilter.class);

    }*/


    //User this method for standard OAUTH2 implementation of spring secuirty
    /*@Override
    public void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                .antMatcher(APIConstants.CCP_CONTROLLER + "/**").authorizeRequests()
                .antMatchers(APIConstants.CCP_CONTROLLER + APIConstants.PUBLIC).permitAll()
                .anyRequest().authenticated().and().oauth2Login();
    }*/
}
