/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ThymeleafDemo.service;

import com.example.ThymeleafDemo.dto.StaffDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface StaffService {
    public List<StaffDTO> getAllStaff();
    public String checkLogin(String username, String password);
}
