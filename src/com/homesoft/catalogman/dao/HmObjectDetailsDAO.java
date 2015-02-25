/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;
import com.homesoft.catalogman.entity.HmObjectDetails;
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
public class HmObjectDetailsDAO extends AbstractDAO{
    private static final String SQL_CREATE = "INSERT INTO TABLE HmObjectDetails(ObjectID, FieldNo, FieldValue) VALUE(?,?,?)";
    private static final String SQL_READ = "SELECT (ID, ObjectID, FieldNo, FieldValue) from HmObjectDetails";
    private static final String SQL_UPDATE = "UPDATE HmObjectDetails SET ObjectID =?, FieldNo =?, FieldValue =? where ID=?";
    private static final String SQL_DELETE = "DELETE FROM HmObjectDetails where ID=?";
    private static final String SQL_READ_ID = "SELECT (ID, ObjectID, FieldNo, FieldValue) from HmObjectDetails WHERE ID=?";
   
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
    public ArrayList<HmObjectDetails> select() throws SQLException {
        ArrayList<HmObjectDetails> lstObjectDetails = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ);
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            HmObjectDetails hmObjDetails = new HmObjectDetails(
                    rsData.getInt(1), 
                    rsData.getInt(2),
                    rsData.getInt(3),
                    rsData.getString(4));
            lstObjectDetails.add(hmObjDetails);
        }
        return lstObjectDetails;
    }
    
    /**
     * Insert object into database
     *
     * @param hmObjectDetails
     * @return Generated identity number
     * @throws SQLException
     */
    public int insert(HmObjectDetails HmObjDetails) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_CREATE);
        psCommand.setInt(1, HmObjDetails.getObjectId());
        psCommand.setInt(2, HmObjDetails.getFieldNo());
        psCommand.setString(3, HmObjDetails.getFieldValue());
        psCommand.executeUpdate();
        
        return getGeneratedKey(psCommand);
    }
    
    /**
     * Delete object out of database
     *
     * @param hmObjectDetails
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
     * @param hmObjectDetails
     * @return 
     * @throws SQLException
     */
    public int update(HmObjectDetails HmObjDetails) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_UPDATE);
        psCommand.setInt(1, HmObjDetails.getObjectId());
        psCommand.setInt(2, HmObjDetails.getFieldNo());
        psCommand.setString(3, HmObjDetails.getFieldValue());
        psCommand.executeUpdate();
        
        return getGeneratedKey(psCommand);
    }
}
