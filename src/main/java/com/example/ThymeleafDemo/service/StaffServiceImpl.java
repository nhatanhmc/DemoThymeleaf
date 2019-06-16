/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ThymeleafDemo.service;

import com.example.ThymeleafDemo.dao.StaffDAO;
import com.example.ThymeleafDemo.dto.StaffDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
@Lazy
public class StaffServiceImpl implements StaffService{
    @Autowired
    @Lazy
    private StaffDAO staffDAO ;
    
    @Override
    public List<StaffDTO> getAllStaff() {
       return staffDAO.getAllStaff();
    }

    @Override
    public String checkLogin(String username, String password) {
       return staffDAO.checkLogin(username, password);
    }
    
}
