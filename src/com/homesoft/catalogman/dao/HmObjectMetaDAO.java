/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;
import com.homesoft.catalogman.entity.HmObjectMeta;
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
public class HmObjectMetaDAO extends AbstractDAO{
    private static final String SQL_CREATE = "INSERT INTO TABLE HmObjectMeta(ObjectTypeID, FieldName, DisplayName, DisplayText, DataType, SortOrder, GroupID, FieldNo) VALUE(?,?,?,?,?,?,?,?)";
    private static final String SQL_READ = "SELECT (ID, ObjectTypeID, FieldName, DisplayName, DisplayText, DataType, SortOrder, GroupID, FieldNo) from HmObjectMeta";
    private static final String SQL_UPDATE = "UPDATE HmObjectMeta SET ObjectTypeID =?, FieldName =?, DisplayName =?, DisplayText =?, DataType =?, SortOrder =?, GroupID =?, FieldNo =? where ID=?";
    private static final String SQL_DELETE = "DELETE FROM HmObjectMeta where ID=?";
    private static final String SQL_READ_ID = "SELECT (ID, ObjectTypeID, FieldName, DisplayName, DisplayText, DataType, SortOrder, GroupID, FieldNo) from HmObjectMeta WHERE ID=?";
     
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
     * Get list of objectMeta
     *
     * @return ArrayList
     * @throws SQLException
     */
    public ArrayList<HmObjectMeta> select() throws SQLException {
        ArrayList<HmObjectMeta> lstObjectMeta = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ);
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            HmObjectMeta hmObjMt = new HmObjectMeta(
                    rsData.getInt(1),
                    rsData.getInt(2),
                    rsData.getString(3),
                    rsData.getString(4),
                    rsData.getString(5),
                    rsData.getInt(6),
                    rsData.getInt(7),
                    rsData.getInt(8),
                    rsData.getInt(9));
            lstObjectMeta.add(hmObjMt);
        }
        return lstObjectMeta;
    }
    
    /**
     * Insert object into database
     *
     * @param hmObjectMeta
     * @return Generated identity number
     * @throws SQLException
     */
    public int insert(HmObjectMeta HmObjMt) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_CREATE);
        psCommand.setInt(1, HmObjMt.getObjectTypeId());
        psCommand.setString(2, HmObjMt.getFieldName());
        psCommand.setString(3, HmObjMt.getDisplayName());
        psCommand.setString(4, HmObjMt.getDisplayText());
        psCommand.setInt(5, HmObjMt.getDataType());
        psCommand.setInt(6, HmObjMt.getSortOrder());
        psCommand.setInt(7, HmObjMt.getGroupId());
        psCommand.setInt(8, HmObjMt.getFieldNo());
        //return genarated ID of INSERT command
        return getGeneratedKey(psCommand);
    }
    
    /**
     * Delete object out of database
     *
     * @param hmObjectMeta
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
     * @param hmObjectMeta
     * @return 
     * @throws SQLException
     */
    public int update(HmObjectMeta HmObjMt) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_UPDATE);
        psCommand.setInt(1, HmObjMt.getObjectTypeId());
        psCommand.setString(2, HmObjMt.getFieldName());
        psCommand.setString(3, HmObjMt.getDisplayName());
        psCommand.setString(4, HmObjMt.getDisplayText());
        psCommand.setInt(5, HmObjMt.getDataType());
        psCommand.setInt(6, HmObjMt.getSortOrder());
        psCommand.setInt(7, HmObjMt.getGroupId());
        psCommand.setInt(8, HmObjMt.getFieldNo());
        //return genarated ID of INSERT command
        return getGeneratedKey(psCommand);
    }
}

