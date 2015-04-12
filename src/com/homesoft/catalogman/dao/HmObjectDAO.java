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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * @company Home
 * @author Bao Nguyen
 * @createdDate Feb 6, 2015
 * @modifiedDate 
 */
public class HmObjectDAO extends AbstractDAO {
    private static final String SQL_CREATE = "INSERT INTO TABLE HmObject(Name, Description, PostID, TaxonomyID, ObjectID) VALUE(?,?,?,?,?)";
    private static final String SQL_READ = "SELECT ID, Name, Description, PostID, TaxonomyID, ObjectID from HmObject";
    private static final String SQL_UPDATE = "UPDATE HmObject SET Name =?, Description =?, PostID =?, TaxonomyID =?, ObjectID =? where ID=?";
    private static final String SQL_DELETE = "DELETE FROM HmObject where ID=?";
    private static final String SQL_READ_ID = "SELECT ID, Name, Description, PostID, TaxonomyID, ObjectID FROM HmObject WHERE ID=? ";
   
    /**
     * Select object by Id
    */
    public String selectById(int Id, boolean Name, boolean Description, boolean Icon)  throws SQLException{
        String objectname = null;
        String objectdescription = null;
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement("SELECT ID, Name, Description, PostID, TaxonomyID, ObjectID FROM HmObject WHERE ID=?");
        psCommand.setInt(1, Id);
        ResultSet rs = psCommand.executeQuery();
        while(rs.next()){
            objectname = rs.getString("Name");
            objectdescription = rs.getString("Description");
        }
        if(Name) {
            return objectname;
        }else{
            return objectdescription;
        }
    }
    
    
    /**
     * Get list of object
     *
     * @return ArrayList
     * @throws SQLException
     */
    public ArrayList<HmObject> select() throws SQLException {
        ArrayList<HmObject> lstObject = new ArrayList<HmObject>();
       try{
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement("SELECT * from HmObject");
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            HmObject hmobject = new HmObject(
                    rsData.getInt("Id"),
                    rsData.getString("Name"),
                    rsData.getString("Description"),
                    rsData.getInt("PostId"),
                    rsData.getInt("TaxonomyId"),
                    rsData.getInt("ObjectId"));
            lstObject.add(hmobject);
        }}catch(Exception e) {
            e.printStackTrace();
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

   
