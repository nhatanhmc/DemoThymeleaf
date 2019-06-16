/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ThymeleafDemo.controller;

import com.example.ThymeleafDemo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @Autowired
    @Lazy
    private StaffService staffService;
    
    @GetMapping(value = "/")
    public String homePage(){
        return "index";
    };
      @GetMapping(value = "/login")
    public String login(){
        return "index";
    };
    @PostMapping(value = "/check-login")
    public String checkLogin(String email,String password,RedirectAttributes redirectAttrs){
       String result = staffService.checkLogin(email, password);
        switch (result) {
            case "FAIL": {
                redirectAttrs.addFlashAttribute("loginError", true);
                return "redirect:/login";
            }
            case "SUCCESS": {
                return "redirect:/home";
            }
            default:
                redirectAttrs.addFlashAttribute("wrongAccount", true);
                return "redirect:/login";
        }

   }
        @GetMapping(value = "/home")
    public String listStaff(ModelMap map){
           map.addAttribute("listStaff", staffService.getAllStaff());
            System.out.println("abc");
        return "homepage";
    };
}
