/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;

import com.homesoft.catalogman.entity.HmImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @company Home
 * @author phucan
 * @createdDate Feb 1, 2015
 * @modifiedDate
 */
public class HmImageDAO extends AbstractDAO {

    private static final String SQL_CREATE = "INSERT INTO TABLE HmImage(ImageFile, Size) VALUE(?,?)";
    private static final String SQL_READ = "SELECT (ID, ImageFile, Size) from HmImage";
    private static final String SQL_UPDATE = "UPDATE HmImage SET ImageFile=?,Size =? where ID=?";
    private static final String SQL_DELETE = "DELETE FROM HmImage where ID=?";
    private static final String SQL_READ_ID = "SELECT (ID, ImageFile, Size) FROM HmImage WHERE ID=?";
    
    /**
     * Select Object by Id
     */
    
    public Object selectById(int Id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ_ID);
        psCommand.setInt(1, Id);
        ResultSet rs = psCommand.executeQuery();
        return rs;
    }
    
    /**
     * Get list of image
     *
     * @return ArrayList
     * @throws SQLException
     */
    public ArrayList<HmImage> select() throws SQLException {
        ArrayList<HmImage> lstImage = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ);
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            HmImage hmImg = new HmImage(
                    rsData.getInt(1),
                    rsData.getString(2),
                    rsData.getInt(3));
            lstImage.add(hmImg);

        }
        return lstImage;
    }

    /**
     * Insert object into database
     *
     * @param hImg
     * @return Generated identity number
     * @throws SQLException
     */
    public int insert(HmImage hImg) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_CREATE);
        psCommand.setString(1, hImg.getImageFile());
        psCommand.setInt(2, hImg.getSize());
        psCommand.executeUpdate();
        //return generated ID of INSERT command
        return getGeneratedKey(psCommand);  
    }
}