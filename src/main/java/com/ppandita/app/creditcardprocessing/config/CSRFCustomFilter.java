package com.ppandita.app.creditcardprocessing.config;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: PPandita
 * Date: 2/7/22
 * Time: 7:24 PM
 *
 * This is an HTTP custom filter class used to update HTTP response with CSRF Token
 */

public class CSRFCustomFilter extends OncePerRequestFilter
{

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException
    {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        response.setHeader("CSRF-TOKEN-VALUE", csrfToken.getToken());
        filterChain.doFilter(request, response);
    }
}