/*
 * Class description here
 */
package com.homesoft.catalogman.dao;

import com.homesoft.catalogman.Main;
import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @company Home
 * @author phucan
 * @createdDate Jan 7, 2015
 * @modifiedDate
 */
public class DBConnection {

    public static String DB_CONN_STRING;
    public static String DB_USER;
    public static String DB_PWD;
    private static Connection conn;
    
    public static Connection getConnection() throws SQLException{      
        if(conn==null){
            try {
                Main.readConfiguration();
            } catch (IOException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn=DriverManager.getConnection(DB_CONN_STRING, DB_USER, DB_PWD);            
        }      
        return conn;
    }

    public static void Close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }
}
