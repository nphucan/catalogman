/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.gui.components;

import javax.swing.JTextField;

/**
 * @company Home
 * @author phucan
 * @createdDate Mar 4, 2015
 * @modifiedDate
 */
public class HmText extends JTextField implements HmInput {

    @Override
    public void setValue(Object objValue) {
        this.setText(objValue.toString());
    }

    @Override
    public Object getValue() {
        return getText();
    }

}
