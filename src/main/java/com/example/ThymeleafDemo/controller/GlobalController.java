/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ThymeleafDemo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Admin
 */
@ControllerAdvice
public class GlobalController {
    
    
    @ExceptionHandler(value = Exception.class)
    public ModelAndView error(HttpServletRequest request, Exception e) throws Exception{
         System.out.println(e);
         ModelAndView mav = new ModelAndView();
         mav.addObject("exception", e);
         mav.addObject("url", request.getRequestURI());
         
         mav.setViewName("error");
         return mav;
    }
}
