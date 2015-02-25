/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.gui;

import java.awt.Frame;
import javax.swing.JDialog;

/**
 * @company Home
 * @author phucan
 * @createdDate Feb 3, 2015
 * @modifiedDate
 */
public class CustomDialog extends JDialog {

    CustomPanel m_pnContent;

    /**
     * Show dialog with specified content
     *
     * @param m_pnContent Panel of form
     * @param owner Parent form
     * @param modal
     */
    public CustomDialog(CustomPanel m_pnContent, Frame owner, boolean modal) {
        super(owner, modal);
        this.m_pnContent = m_pnContent;
        if (this.m_pnContent != null) {
            this.m_pnContent.wParent = this;
        }
    }

    /**
     * Get return data from dialog
     *
     * @return Object
     */
    public Object getFormData() {
        return m_pnContent.getFormData();
    }

    /**
     * Get form signal
     *
     * @return int
     */
    public int getSignal() {
        return m_pnContent.getSignal();
    }

    /**
     * Show dialog and load data
     *
     * @param data Data to process on dialog
     */
    public void show(Object data) {
        m_pnContent.setFormData(data);
        m_pnContent.onLoad();
        this.getContentPane().add(this.m_pnContent);
        this.pack();
        this.setVisible(true);        
    }
   
    
}
