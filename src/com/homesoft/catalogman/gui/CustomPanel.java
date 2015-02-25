/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.gui;

import java.awt.Window;
import javax.swing.JPanel;

/**
 * @company Home
 * @author phucan
 * @createdDate Feb 3, 2015
 * @modifiedDate
 */
public abstract class CustomPanel extends JPanel {

    protected int iSignal = 0;
    Window wParent;

    public int getSignal() {
        return this.iSignal;
    }

    /**
     * Set data for the form
     *
     * @param objData
     */
    public abstract void setFormData(Object objData);

    /**
     * Get data of the form
     *
     * @return Object
     */
    public abstract Object getFormData();

    public abstract void onLoad();

    protected void closeForm() {
        if (wParent != null) {
            wParent.dispose();
        }
    }

}
