/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.gui.components;

/**
 * @company Home
 * @author phucan
 * @createdDate Mar 4, 2015
 * @modifiedDate
 */
public interface HmInput {

    void setValue(Object objValue);

    Object getValue();

    void setText(String strText);

    String getText();
}
