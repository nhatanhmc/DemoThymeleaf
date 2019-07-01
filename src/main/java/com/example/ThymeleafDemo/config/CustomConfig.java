/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ThymeleafDemo.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.NestedServletException;
import org.thymeleaf.exceptions.TemplateEngineException;

/**
 *
 * @author Admin
 */
@EnableWebMvc
@Configuration
public class CustomConfig extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {

        try {
            fc.doFilter(request, response);
        } catch (NestedServletException nse) {
            if (nse.getCause() instanceof TemplateEngineException) {
                //Do stuff here
            }
            throw nse;
        }

    }
}
