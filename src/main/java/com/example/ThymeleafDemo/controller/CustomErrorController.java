/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ThymeleafDemo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CustomErrorController implements ErrorController {

  @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "/error/404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "/error/500";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "/error/403";
            }
        }
        return "/error/500";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

       //<editor-fold defaultstate="collapsed" desc="ERROR 403">
    @GetMapping("/403")
    public String error403( ) {
        return "/error/403";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ERROR 404">
    @GetMapping("/404")
    public String error404( ) {
       
        return "/error/404";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ERROR 500">
    @GetMapping("/500")
    public String error500( ) {
        return "/error/500";
    }
    //</editor-fold>

}
