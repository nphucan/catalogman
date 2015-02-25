/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @company Home
 * @author phucan
 * @createdDate Feb 4, 2015
 * @modifiedDate
 */
public abstract class AbstractDAO {

    /**
     * Get generated key after executing command.
     * This method should be call after execute(), executeUpdate()
     *
     * @param psCommand
     * @return generated key
     * @throws SQLException
     */
    protected int getGeneratedKey(PreparedStatement psCommand) throws SQLException {
        int iKey = -1;
        if (psCommand.isClosed()) {
            return iKey;
        }
        ResultSet rsGen = psCommand.getGeneratedKeys();
        if (rsGen != null && rsGen.next()) {
            iKey = rsGen.getInt(1);
        }
        return iKey;
    }
}
