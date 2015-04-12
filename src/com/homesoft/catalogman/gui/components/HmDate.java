/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.homesoft.catalogman.gui.components;

import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;

/**
 * @company Home
 * @author phucan
 * @createdDate Mar 4, 2015
 * @modifiedDate 
 */
public class HmDate extends JXDatePicker implements HmInput{

    @Override
    public void setValue(Object objValue) {
        this.setDate((Date)objValue);
    }

    @Override
    public Object getValue() {
        return getDate();
    }

    @Override
    @Deprecated
    public void setText(String strText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override    
    @Deprecated
    public String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
