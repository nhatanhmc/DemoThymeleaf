/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ThymeleafDemo.dto;

/**
 *
 * @author Admin
 */
public class StaffDTO {
    private int staffId;
    private String email;
    private String password;
    private String staffName;
    private String staffAddress;
    private boolean isAdmin;
    

    public StaffDTO() {
    this.staffId = 0;
    this.staffName = "";
    this.staffAddress ="";
    this.email="";
    this.password="";
    this.isAdmin=false;
    }



    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "StaffDTO{" + "staffId=" + staffId + ", email=" + email + ", password=" + password + ", staffName=" + staffName + ", staffAddress=" + staffAddress + ", isAdmin=" + isAdmin + '}';
    }

 
    
}
