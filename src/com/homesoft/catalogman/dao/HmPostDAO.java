/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;
import com.homesoft.catalogman.entity.HmPost;
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
public class HmPostDAO extends AbstractDAO {
    private static final String SQL_CREATE = "INSERT INTO TABLE HmPost(Content) VALUE(?)";
    private static final String SQL_READ = "SELECT (ID, Content) from HmPost";
    private static final String SQL_UPDATE = "UPDATE HmPost SET Content =? where ID=?";
    private static final String SQL_DELETE = "DELETE FROM HmPost where ID=?";
    private static final String SQL_READ_ID = "SELECT (ID, Content) from HmPost WHERE ID=?";
    
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
    public ArrayList<com.homesoft.catalogman.entity.HmPost> select() throws SQLException {
        ArrayList<com.homesoft.catalogman.entity.HmPost> lstPost = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ);
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            com.homesoft.catalogman.entity.HmPost hmP = new com.homesoft.catalogman.entity.HmPost(
                rsData.getInt(1),
                rsData.getString(2));
            lstPost.add(hmP);
        }
        return lstPost;
    }
    
    /**
     * Insert object into database
     *
     * @param hmObject
     * @return Generated identity number
     * @throws SQLException
     */
    public int insert(HmPost HmP) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_CREATE);
        psCommand.setString(1, HmP.getContent());
        psCommand.executeUpdate();
        //return generated ID of INSERT command
        return getGeneratedKey(psCommand);
    }
    
    /**
     * Delete object out of database
     *
     * @param hmPost
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
     * @param hmPost
     * @return 
     * @throws SQLException
     */
    public int update(HmPost HmP) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_UPDATE);
        psCommand.setString(1, HmP.getContent());
        psCommand.executeUpdate();
        //return generated ID of INSERT command
        return getGeneratedKey(psCommand);
    }
}
