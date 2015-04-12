/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.gui;

import com.homesoft.catalogman.entity.HmObjectMeta;
import com.homesoft.catalogman.entity.HmTaxonomy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @company Home
 * @author phucan
 * @createdDate Feb 3, 2015
 * @modifiedDate
 */
public class Test {

    public static void main(String[] args) {
        //Test Catalog 2
        Test t = new Test();
        t.showDialog();
        //Test Category_06
        //CustomDialog dlg=new CustomDialog(new Category_06() , null, true);
        //dlg.show(null);
    }
    Main_01_2 tree = new Main_01_2();

    public void showDialog() {

        tree.bindTaxonomy(getTaxonomies());
        tree.addButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, tree.getSelectedItem());
            }
        });
        CustomDialog dlg = new CustomDialog(new Catalog_02(), null, true);
        dlg.show(getFieldsMeta());
    }

    private List<HmObjectMeta> getFieldsMeta() {
        List<HmObjectMeta> lstMeta = new ArrayList<>();
        HmObjectMeta m1 = new HmObjectMeta(1, "Name", "Name", "Name", DataType.STRING, 0, 1, 0);
        HmObjectMeta m2 = new HmObjectMeta(1, "Age", "Age", "Age", DataType.INTEGER, 0, 1, 0);
        lstMeta.add(m1);
        lstMeta.add(m2);
        return lstMeta;
    }

    private List<HmTaxonomy> getTaxonomies() {
        List<HmTaxonomy> lstTxm = new ArrayList<>();
        HmTaxonomy t3 = new HmTaxonomy(1, "SáchXH", 1, "", 0, 1, 0, 0);
        HmTaxonomy t4 = new HmTaxonomy(1, "SáchVH", 0, "", 0, 1, 0, 0);
        HmTaxonomy t1 = new HmTaxonomy(1, "Sách", 0, "", 0, 1, 0, 0);
        HmTaxonomy t2 = new HmTaxonomy(1, "SáchKH", 1, "", 0, 1, 0, 0);

        lstTxm.add(t1);
        lstTxm.add(t2);
        lstTxm.add(t3);
        lstTxm.add(t4);

        return lstTxm;
    }
    private void loadEditor(){
        EditorPane editor=new EditorPane();
        editor.setFormData(getFieldsMeta());
        editor.onLoad();
        editor.setAction(new EditorPane.EditorAction() {

            @Override
            public boolean saveData() {
                //TODO: put your code here
                return true;
            }
        });        
    }
}
