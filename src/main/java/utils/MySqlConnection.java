/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Admin
 */
public class MySqlConnection {

    public static volatile BasicDataSource ds = null;

    public MySqlConnection() {
        try {
            if (ds == null) {
                ds = new BasicDataSource();
                ds.setUrl("jdbc:mysql://" + EnvironmentVariable.getDBHost() + ":3306/" + EnvironmentVariable.getDBDatabase() + "?autoReconnect=true&useSSL=false&allowMultiQueries=true");
                ds.setUsername(EnvironmentVariable.getDBUser());
                ds.setPassword(EnvironmentVariable.getDBPass());
                ds.setMaxTotal(150);
                ds.setMinIdle(30);
                ds.setMaxIdle(70);
                ds.setMaxConnLifetimeMillis(3000);
                ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
                ds.setInitialSize(50);
                ds.setRemoveAbandonedOnBorrow(true);
                ds.setAbandonedUsageTracking(false);
                ds.setLogExpiredConnections(false);
                ds.setLifo(false);
                ds.addConnectionProperty("useUnicode", "true");
                ds.addConnectionProperty("characterEncoding", "UTF-8");
                ds.setRemoveAbandonedOnMaintenance(true);
            }
        } catch (Exception e) {
            System.out.println("xxx");
        }

    }

}
