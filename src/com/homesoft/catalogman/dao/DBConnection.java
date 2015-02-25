/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @company Home
 * @author phucan
 * @createdDate Jan 7, 2015
 * @modifiedDate
 */
public class DBConnection {

    public  static String DB_CONN_STRING;
    public static String DB_USER;
    public static String DB_PWD;
    private static Connection conn;
    
    public static Connection getConnection() throws SQLException{      
        if(conn==null){
            conn=DriverManager.getConnection(DB_CONN_STRING, DB_USER, DB_PWD);            
        }      
        return conn;
    }
    
    public static void Close(){
        try{
        conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }
}
