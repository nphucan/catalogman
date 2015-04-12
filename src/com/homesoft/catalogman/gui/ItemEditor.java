/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.gui;

import com.homesoft.catalogman.entity.HmObjectMeta;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 * @company Home
 * @author phucan
 * @createdDate Mar 2, 2015
 * @modifiedDate
 */
public class ItemEditor extends JPanel {

    //private List<HmObjectMeta> _lstMeta;
    private final HashMap<Integer, List<HmObjectMeta>> _dicMeta;
    private final HashMap<String, JTextField> _dicControls;

    public ItemEditor() {
        this.setLayout(new MigLayout());
        this._dicMeta = new HashMap<>();
        this._dicControls = new HashMap<>();
    }

    /**
     * Load components
     */
    public void loadComponents() {
        // this.setBackground(Color.red);
        Integer[] keys = _dicMeta.keySet().toArray(new Integer[_dicMeta.size()]);
        for (Integer strKey : keys) {
            //TODO: change group text here (read from DB(
            JLabel lblGroup = new JLabel("Group " + strKey.toString());
            lblGroup.setFont(lblGroup.getFont().deriveFont(Font.BOLD));
            this.add(lblGroup, "wrap");
            for (HmObjectMeta ho : _dicMeta.get(strKey)) {
                JLabel lblText = new JLabel(ho.getDisplayName());
                lblText.setFont(lblGroup.getFont().deriveFont(Font.PLAIN));
                JTextField txtField = new JTextField();
                txtField.setName(ho.getFieldName());
                txtField.setMinimumSize(new Dimension(180, 26));
                this.add(lblText, "wrap");
                this.add(txtField, "wrap");
                _dicControls.put(ho.getDisplayName(), txtField);
            }
        }
    }

    /**
     * Set fields definition
     *
     * @param lstMeta
     */
    public void setFieldsMeta(List<HmObjectMeta> lstMeta) {
        //this._lstMeta = lstMeta;
        for (HmObjectMeta hMeta : lstMeta) {
            if (_dicMeta.containsKey(hMeta.getGroupId())) {
                _dicMeta.get(hMeta.getGroupId()).add(hMeta);
            } else {
                List<HmObjectMeta> lstTmp = new ArrayList<>();
                lstTmp.add(hMeta);
                _dicMeta.put(hMeta.getGroupId(), lstTmp);
            }
        }
    }

    /**
     * set value to field
     *
     * @param strField field name
     * @param objValue field value
     */
    public void setValue(String strField, Object objValue) {
        this._dicControls.get(strField).setText(objValue.toString());
    }

    /**
     * Get field value
     * @param strField field name
     * @return Object
     */
    public Object getValue(String strField){
        return _dicControls.get(strField).getText();
    }
    
    /**
     * Get field value
     * @param <T> Data type to get
     * @param strField object value
     * @return strong type value
     */
    public <T extends Object> T getStrongTypeValue(String strField){
        return (T)_dicControls.get(strField);
    }
    /**
     * Determine if editor in editable mode
     *
     * @param editable Set TRUE if allow user to edit
     */
    public void setEditable(boolean editable) {
        for (JTextField txtField : _dicControls.values()) {
            txtField.setEditable(editable);
        }
    }
}
