/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman;

import com.homesoft.catalogman.dao.DBConnection;
import com.homesoft.catalogman.gui.Application;
import com.homesoft.catalogman.gui.CatalogMan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;

/**
 * @company Home
 * @author phucan
 * @createdDate Jan 7, 2015
 * @modifiedDate
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // read configuration data
        try {
            readConfiguration();            
        } catch (IOException ex) {
           //System.out.println(ex.getMessage());
           // System.out.println(ex.getStackTrace());
        }
        // setup look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogMan.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        new CatalogMan().setVisible(true);
    }

    public static void readConfiguration() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(
                Application.getAppPath() + "/config.properties"
        );  // get working direcotry + filename
        PropertyResourceBundle prb = new PropertyResourceBundle(fis);
        DBConnection.DB_CONN_STRING = prb.getString("connectionString");
        DBConnection.DB_USER = prb.getString("user");
        DBConnection.DB_PWD = prb.getString("pwd");
    }
}
