/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;
import com.homesoft.catalogman.entity.HmObject;
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
public class HmObjectDAO extends AbstractDAO {
    private static final String SQL_CREATE = "INSERT INTO TABLE HmObject(Name, Description, PostID, TaxonomyID, ObjectID) VALUE(?,?,?,?,?)";
    private static final String SQL_READ = "SELECT (ID, Name, Description, PostID, TaxonomyID, ObjectID) from HmObject";
    private static final String SQL_UPDATE = "UPDATE HmObject SET Name =?, Description =?, PostID =?, TaxonomyID =?, ObjectID =? where ID=?";
    private static final String SQL_DELETE = "DELETE FROM HmObject where ID=?";
    private static final String SQL_READ_ID = "SELECT(ID, Name, Description, PostID, TaxonomyID, ObjectID) FROM HmObject WHERE ID=? ";
   
    /**
     * Select object by Id
    */
    public Object selectById(int Id)  throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ_ID);
        psCommand.setInt(1, Id);
        ResultSet rs = psCommand.executeQuery();
        return rs;
    }
    
    
    /**
     * Get list of object
     *
     * @return ArrayList
     * @throws SQLException
     */
    public ArrayList<HmObject> select() throws SQLException {
        ArrayList<HmObject> lstObject = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ);
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            HmObject hmObj = new HmObject(
                    rsData.getInt(1),
                    rsData.getString(2),
                    rsData.getString(3),
                    rsData.getInt(4),
                    rsData.getInt(5),
                    rsData.getInt(6));
            lstObject.add(hmObj);

        }
        return lstObject;
    }
    
    /**
     * Insert object into database
     *
     * @param hmObject
     * @return Generated identity number
     * @throws SQLException
     */
    public int insert(HmObject HmObj) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_CREATE);
        psCommand.setString(1, HmObj.getName());
        psCommand.setString(2, HmObj.getDescription());
        psCommand.setInt(3, HmObj.getPostId());
        psCommand.setInt(4, HmObj.getTaxonomyId());
        psCommand.setInt(5, HmObj.getObjectId());
        psCommand.executeUpdate();
        //return generated ID of INSERT command
        return getGeneratedKey(psCommand);
    }
    
    /**
     * Delete object out of database
     *
     * @param hmObject
     * @return 
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
     * @param hmObject
     * @return 
     * @throws SQLException
     */
    public int update(HmObject HmObj) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_UPDATE);
        psCommand.setString(1, HmObj.getName());
        psCommand.setString(2, HmObj.getDescription());
        psCommand.setInt(3, HmObj.getPostId());
        psCommand.setInt(4, HmObj.getTaxonomyId());
        psCommand.setInt(5, HmObj.getObjectId());
        psCommand.executeUpdate();
        return getGeneratedKey(psCommand);
    }
}

   
