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
    private static final String SQL_READ_ID = "SELECT ID, ImageFile, Size FROM HmImage WHERE ID=?";
    
    /**
     * Select Object by Id
     */
    
    public String selectById(int Id, boolean ImageFile, boolean Size)  throws SQLException{
       String imagefile = null;
       String size = null;
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement("SELECT ID, ImageFile, Size FROM HmImage WHERE ID=?");
        psCommand.setInt(1, Id);
        ResultSet rs = psCommand.executeQuery();
        while(rs.next()){
            imagefile = rs.getString("ImageFile");
            size = rs.getString("Size");
        }
        if(ImageFile)
            return imagefile;
        else if(Size)
            return size;
        return null;
    }
    
    /**
     * Get list of image
     *
     * @return ArrayList
     * @throws SQLException
     */
    public ArrayList<String> select() throws SQLException {
        ArrayList<String> lstImage = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement("SELECT ID, ImageFile, Size FROM HmImage");
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            String link = rsData.getString("ImageFile");
            lstImage.add(link);

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
    
    /**
     * Update object in database
     *
     * @param hmObject
     * @return 
     * @throws SQLException
     */
    public void update(HmImage hImg) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement("UPDATE HmImage SET ImageFile=?,Size =? where ID=?");
        psCommand.setString(1, hImg.getImageFile());
        psCommand.setInt(2, hImg.getSize());
        psCommand.setInt(3, hImg.getId());
        psCommand.executeUpdate();
        //return getGeneratedKey(psCommand);
    }
}