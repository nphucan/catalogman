/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;
import com.homesoft.catalogman.entity.HmTaxonomy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * @company Home
 * @author Bao Nguyen
 * @createdDate Feb 6, 2015
 * @modifiedDate 
 */
public class HmTaxonomyDAO extends AbstractDAO {
    private static final String SQL_CREATE = "INSERT INTO HmTaxonomy(Taxonomy, Parent, Description, OptionNo, SortOrder, ImageID, Deletable) VALUE(?,?,?,?,?,?,?)";
    private static final String SQL_READ = "SELECT ID, Taxonomy, Parent, Description, OptionNo, SortOrder, ImageID, Deletable from HmTaxonomy";
    private static final String SQL_UPDATE = "UPDATE HmTaxonomy SET Taxonomy =?,ParentID=? Description =?, OptionNo =?, SortOrder =?, ImageID =?, Deletable=? where ID=?";
    private static final String SQL_DELETE = "DELETE FROM HmTaxonomy where ID=?";
    private static final String SQL_READ_ID = "SELECT (ID, Taxonomy, Parent, Description, OptionNo, SortOrder, ImageID, Deletable) from HmTaxonomy WHERE ID=?";
    
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
    public ArrayList<HmTaxonomy> select() throws SQLException {
        ArrayList<HmTaxonomy> lstTaxonomy = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_READ);
        ResultSet rsData = psCommand.executeQuery();
        while (rsData.next()) {
            HmTaxonomy hmTax = new HmTaxonomy(
                rsData.getInt(1),
                rsData.getString(2),
                rsData.getInt(3),
                rsData.getString(4),
                rsData.getInt(5),
                rsData.getInt(6),
                rsData.getInt(7),
                rsData.getInt(8));
            lstTaxonomy.add(hmTax);
        }
        return lstTaxonomy;
    }
    
    /**
     * Insert object into database
     *
     * @param HmTax
     * @return Generated identity number
     * @throws SQLException
     */
    public void insert(HmTaxonomy HmTax) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_CREATE);
        psCommand.setString(1, HmTax.getTaxonomy());
        psCommand.setInt(2, HmTax.getParent());
        psCommand.setString(3, HmTax.getDescription());
        psCommand.setInt(4, HmTax.getOptionNo());
        psCommand.setInt(5, HmTax.getSortOrder());
        psCommand.setInt(6, HmTax.getImageId());
        psCommand.setInt(7, HmTax.getDeletable());
        psCommand.executeUpdate();
        //return generated ID of INSERT commnad
        //return getGeneratedKey(psCommand);
    }
    
    /**
     * Delete object out of database
     *
     * @param hmTaxonomyDAO
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
     * @param hmTaxonomyDAO
     * @return 
     * @throws SQLException
     */
    public int update(HmTaxonomy HmTax) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement psCommand = conn.prepareStatement(SQL_UPDATE);
         psCommand.setString(1, HmTax.getTaxonomy());
        psCommand.setInt(2, HmTax.getParent());
        psCommand.setString(3, HmTax.getDescription());
        psCommand.setInt(4, HmTax.getOptionNo());
        psCommand.setInt(5, HmTax.getSortOrder());
        psCommand.setInt(6, HmTax.getImageId());
        psCommand.setInt(7, HmTax.getDeletable());
        psCommand.executeUpdate();
        //return generated ID of INSERT commnad
        return getGeneratedKey(psCommand);
    }
}

