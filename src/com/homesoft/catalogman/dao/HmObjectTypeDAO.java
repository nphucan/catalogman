/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;

import com.homesoft.catalogman.entity.HmObjectType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @company Home
 * @author Bao Nguyen
 * @createdDate Feb 6, 2015
 * @modifiedDate
 */
public class HmObjectTypeDAO extends AbstractDAO {

    private static final String SQL_CREATE = "INSERT INTO TABLE HmObjectType(Name, Description, ImageID) VALUE(?,?,?)";
    private static final String SQL_READ = "SELECT ID, Name, Description, ImageID from HmObjectType";
    private static final String SQL_UPDATE = "UPDATE HmObjectType SET Name =?, Description =?, ImageID =? where ID=?";
    private static final String SQL_DELETE = "DELETE FROM HmObjectType where ID=?";
    private static final String SQL_READ_ID = "SELECT ID, Name, Description, ImageID from HmObjectType WHERE ID=?";

    /**
     * Select object by Id
     */
    public String selectById(int Id, boolean Name, boolean Description, boolean ImageID) throws SQLException {
        String name = null;
        String description = null;
        String imageID = null;
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ_ID);
        psCommand.setInt(1, Id);
        ResultSet rs = psCommand.executeQuery();
        while (rs.next()) {
            name = rs.getString("Name");
            description = rs.getString("Description");
            imageID = rs.getString("ImageID");
        }
        if (Name) {
            return name;
        } else {
            if (Description) {
                return description;
            } else {
                if (ImageID) {
                    return imageID;
                }
            }
            return null;
        }
    }

    /**
     * Get list of object
     *
     * @return ArrayList
     * @throws SQLException
     */
    public ArrayList<HmObjectType> select() throws SQLException {
        ArrayList<HmObjectType> lstObjectType = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ);
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            HmObjectType hmObjT = new HmObjectType(
                    rsData.getInt(1),
                    rsData.getString(2),
                    rsData.getString(3),
                    rsData.getInt(4));
            lstObjectType.add(hmObjT);
        }
        return lstObjectType;
    }

    /**
     * Insert object into database
     *
     * @param HmObjType
     * @return Generated identity number
     * @throws SQLException
     */
    public int insert(HmObjectType HmObjType) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_CREATE);
        psCommand.setString(1, HmObjType.getName());
        psCommand.setString(2, HmObjType.getDescription());
        psCommand.setInt(3, HmObjType.getImageId());
        psCommand.executeUpdate();
        return getGeneratedKey(psCommand);
    }

    /**
     * Delete object out of database
     *
     * @param id
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_DELETE);
        psCommand.setInt(1, id);
        psCommand.executeUpdate();
    }

    /**
     * Update object in database
     *
     * @param HmObjType
     * @return
     * @throws SQLException
     */
    public void update(HmObjectType HmObjType) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_UPDATE);
        psCommand.setString(1, HmObjType.getName());
        psCommand.setString(2, HmObjType.getDescription());
        psCommand.setInt(3, HmObjType.getImageId());
        psCommand.setInt(4, HmObjType.getId());
        psCommand.executeUpdate();
        //return getGeneratedKey(psCommand);
    }
}
