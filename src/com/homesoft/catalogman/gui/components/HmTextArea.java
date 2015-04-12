/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.homesoft.catalogman.gui.components;

import javax.swing.JTextArea;

/**
 * @company Home
 * @author phucan
 * @createdDate Mar 4, 2015
 * @modifiedDate 
 */
public class HmTextArea extends JTextArea implements HmInput{

    @Override
    public void setValue(Object objValue) {
        setText(objValue.toString());
    }

    @Override
    public Object getValue() {
        return getText();
    }

}
