/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ThymeleafDemo.dao;

import com.example.ThymeleafDemo.dto.StaffDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
@Lazy
public class StaffDAOImpl implements StaffDAO {

    @Override
    public List<StaffDTO> getAllStaff() {
        List<StaffDTO> listStaff = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/thymeleafdemo");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.addConnectionProperty("useUnicode", "true");
        dataSource.addConnectionProperty("characterEncoding", "UTF-8");
        try {
            String sql = "SELECT STAFFID, EMAIL,STAFFNAME,STAFFADDRESS,ISADMIN FROM STAFF;";

            con = dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {

                StaffDTO staffDTO = new StaffDTO();
                staffDTO.setStaffId(rs.getInt("STAFFID"));
                staffDTO.setEmail(rs.getString("EMAIL"));
                staffDTO.setIsAdmin(rs.getBoolean("ISADMIN"));
                staffDTO.setStaffName(rs.getString("STAFFNAME"));
                staffDTO.setStaffAddress(rs.getString("STAFFADDRESS"));
                listStaff.add(staffDTO);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listStaff;
    }

    @Override
    public String checkLogin(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/thymeleafdemo");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.addConnectionProperty("useUnicode", "true");
        dataSource.addConnectionProperty("characterEncoding", "UTF-8");
        try {
            String sql = "SELECT EMAIL FROM STAFF WHERE EMAIL = ? AND PASSWORD = ?;";

            con = dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            System.out.println(ps.toString());
           rs = ps.executeQuery();
            if(rs.next()){
                return "SUCCESS";
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "FAIL";
    }

}
