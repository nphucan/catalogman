/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.gui;

import com.homesoft.catalogman.dao.HmObjectTypeDAO;
import com.homesoft.catalogman.dao.HmTaxonomyDAO;
import com.homesoft.catalogman.entity.HmObjectType;
import com.homesoft.catalogman.entity.HmTaxonomy;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author phucan
 */
public class CatalogMan extends JFrame {

    JXPanel pnlMain;
    JXPanel pnlSidebar;
    JXPanel pnlSplitter;
    JButton btnCollapse;
    Main_01_2 pnlSidebarContent;
    Main_01_1 pnlMainContent;
    private final int SIDEBAR_WIDTH = 215;
    boolean bToggle = true;

    HmObjectTypeDAO daoObjTpe;
    HmTaxonomyDAO daoTxm;

    /**
     * Creates new form Main
     */
    public CatalogMan() {
        initComponents();
        daoObjTpe = new HmObjectTypeDAO();
        daoTxm = new HmTaxonomyDAO();
        initContainer();
        initToolbar();

        
    }

    private void initContainer() {
        pnlMain = new JXPanel();
        pnlSidebar = new JXPanel();
        pnlSplitter = new JXPanel();
        
        pnlMain.setBackgroundPainter(Application.getImagePainter("background"));
        pnlSidebar.setBackgroundPainter(Application.getImagePainter("background_dark"));
        
        pnlSplitter.setBackgroundPainter(Application.getImagePainter("background_dark"));
        pnlToolbar.setBackgroundPainter(Application.getImagePainter("background"));
        
        pnlSidebarContent = new Main_01_2();
        pnlMainContent = new Main_01_1();
        btnCollapse = new JButton();
        btnCollapse.setSize(15, 80);
        btnCollapse.setMinimumSize(new Dimension(15, 80));
        pnlSidebar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        pnlSplitter.setMinimumSize(new Dimension(15, 300));
        pnlSplitter.setLayout(new GridBagLayout());
        pnlSplitter.add(btnCollapse);

        MigLayout lyt = new MigLayout("", "[][]", "[grow]");
        pnlSidebar.setLayout(lyt);
        lyt.layoutContainer(pnlSidebar);
        pnlSidebar.add(pnlSidebarContent, "dock west, growy");
        pnlSidebar.add(pnlSplitter, "dock west, growy");

        pnlMain.setLayout(new MigLayout());
        pnlMain.add(pnlMainContent, "grow");

        lpnContainer.add(pnlMain, 0);
        lpnContainer.add(pnlSidebar, 1);
        lpnContainer_Resized(null);
        lpnContainer.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e); //To change body of generated methods, choose Tools | Templates.
                lpnContainer_Resized(e);
            }

        });
        btnCollapse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnCollapse_ActionPerformed(e);
            }
        });
        pnlSidebarContent.addButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnCategory_clicked(e);
            }
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                     List<HmObjectType> lstObjType = daoObjTpe.select();
                    List<HmTaxonomy> lstTxm = daoTxm.select();
                    
                    pnlSidebarContent.bindCatalog(lstObjType);
                    pnlSidebarContent.bindTaxonomy(daoTxm.select());

                    //TODO: chỉ định phần tử được chọn mặc định ở đây
                    pnlMainContent.fireTaxonomyChanged(lstObjType.get(0));
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pnlMainContent, ex);
                    System.out.println(ex.getStackTrace());
                }
            }
        });
    }

    /**
     * Khởi tạo thanh công cụ
     */
    private void initToolbar() {
        tbFunction04.setVisible(false);
        tbFunction05.setVisible(false);
        tbFunction06.setVisible(false);
        tbFunction07.setVisible(false);
        // tbFunction10.setVisible(false);
    }

    private void btnCategory_clicked(ActionEvent e) {
        pnlMainContent.fireTaxonomyChanged(pnlSidebarContent.getSelectedItem());
        if (pnlSidebarContent.getSelectedItem() != null) {
            toggleSidebar(false);
        }
    }

    private void lpnContainer_Resized(ComponentEvent e) {
        pnlSidebar.setSize(SIDEBAR_WIDTH, lpnContainer.getHeight());
        pnlMain.setSize(lpnContainer.getWidth(), lpnContainer.getHeight());
        lpnContainer.setLayer(pnlSidebar, 1);
        pnlMain.repaint();
    }

    private void btnCollapse_ActionPerformed(ActionEvent e) {
        this.bToggle = !this.bToggle;
        toggleSidebar(bToggle);        
    }

    /**
     * Mở rộng/thu gọn sidebar
     *
     * @param bOpen Nếu TRUE thì hiện sidebar, ngược lại thì thu gọn
     */
    private void toggleSidebar(boolean bOpen) {
        if (bOpen) {
            pnlSidebar.setLocation(0, 0);
        } else {
            pnlSidebar.setLocation(-198, 0);
        }
        this.bToggle=bOpen;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlToolbar = new org.jdesktop.swingx.JXPanel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        tbFunction01 = new org.jdesktop.swingx.JXButton();
        tbFunction02 = new org.jdesktop.swingx.JXButton();
        tbFunction03 = new org.jdesktop.swingx.JXButton();
        tbFunction04 = new org.jdesktop.swingx.JXButton();
        tbFunction05 = new org.jdesktop.swingx.JXButton();
        tbFunction06 = new org.jdesktop.swingx.JXButton();
        tbFunction07 = new org.jdesktop.swingx.JXButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        tbFunction08 = new org.jdesktop.swingx.JXButton();
        tbFunction09 = new org.jdesktop.swingx.JXButton();
        tbFunction10 = new org.jdesktop.swingx.JXButton();
        jPanel2 = new javax.swing.JPanel();
        lblStatus = new org.jdesktop.swingx.JXLabel();
        lpnContainer = new javax.swing.JLayeredPane();
        jToolBar1 = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalog Manager");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        pnlToolbar.setMinimumSize(new java.awt.Dimension(460, 70));
        pnlToolbar.setOpaque(false);
        pnlToolbar.setPreferredSize(new java.awt.Dimension(824, 70));
        pnlToolbar.setLayout(new java.awt.BorderLayout());

        jXPanel2.setOpaque(false);
        jXPanel2.setPreferredSize(new java.awt.Dimension(500, 100));
        jXPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 5));

        tbFunction01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/homesoft/catalogman/resources/icons/data-add-icon.png"))); // NOI18N
        tbFunction01.setToolTipText("New Item");
        tbFunction01.setFocusable(false);
        tbFunction01.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction01.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction01.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction01ActionPerformed(evt);
            }
        });
        jXPanel2.add(tbFunction01);

        tbFunction02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/homesoft/catalogman/resources/icons/catalog-icon.png"))); // NOI18N
        tbFunction02.setToolTipText("Catalog");
        tbFunction02.setFocusable(false);
        tbFunction02.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction02.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction02.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction02ActionPerformed(evt);
            }
        });
        jXPanel2.add(tbFunction02);

        tbFunction03.setText("F03");
        tbFunction03.setFocusable(false);
        tbFunction03.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction03.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction03.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction03ActionPerformed(evt);
            }
        });
        jXPanel2.add(tbFunction03);

        tbFunction04.setText("F04");
        tbFunction04.setFocusable(false);
        tbFunction04.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction04.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction04.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction04ActionPerformed(evt);
            }
        });
        jXPanel2.add(tbFunction04);

        tbFunction05.setText("F05");
        tbFunction05.setFocusable(false);
        tbFunction05.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction05.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction05.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction05ActionPerformed(evt);
            }
        });
        jXPanel2.add(tbFunction05);

        tbFunction06.setText("F06");
        tbFunction06.setFocusable(false);
        tbFunction06.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction06.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction06.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction06ActionPerformed(evt);
            }
        });
        jXPanel2.add(tbFunction06);

        tbFunction07.setText("F07");
        tbFunction07.setFocusable(false);
        tbFunction07.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction07.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction07.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction07ActionPerformed(evt);
            }
        });
        jXPanel2.add(tbFunction07);

        pnlToolbar.add(jXPanel2, java.awt.BorderLayout.WEST);

        jXPanel3.setOpaque(false);
        jXPanel3.setPreferredSize(new java.awt.Dimension(300, 100));
        jXPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 2, 5));

        tbFunction08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/homesoft/catalogman/resources/icons/help-icon.png"))); // NOI18N
        tbFunction08.setToolTipText("Help");
        tbFunction08.setFocusable(false);
        tbFunction08.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction08.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction08.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction08ActionPerformed(evt);
            }
        });
        jXPanel3.add(tbFunction08);

        tbFunction09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/homesoft/catalogman/resources/icons/page-about-icon.png"))); // NOI18N
        tbFunction09.setToolTipText("About");
        tbFunction09.setFocusable(false);
        tbFunction09.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction09.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction09.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction09ActionPerformed(evt);
            }
        });
        jXPanel3.add(tbFunction09);

        tbFunction10.setText("F10");
        tbFunction10.setToolTipText("Exit");
        tbFunction10.setFocusable(false);
        tbFunction10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbFunction10.setPreferredSize(new java.awt.Dimension(64, 64));
        tbFunction10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbFunction10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFunction10ActionPerformed(evt);
            }
        });
        jXPanel3.add(tbFunction10);

        pnlToolbar.add(jXPanel3, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlToolbar, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(824, 26));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblStatus.setText("Status message here");
        jPanel2.add(lblStatus);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jToolBar1.setRollover(true);
        jToolBar1.setMinimumSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout lpnContainerLayout = new javax.swing.GroupLayout(lpnContainer);
        lpnContainer.setLayout(lpnContainerLayout);
        lpnContainerLayout.setHorizontalGroup(
            lpnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpnContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lpnContainerLayout.setVerticalGroup(
            lpnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpnContainerLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        lpnContainer.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(lpnContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbFunction01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction01ActionPerformed
       pnlMainContent.fireCreateNewItem(pnlSidebarContent.getSelectedItem());
    }//GEN-LAST:event_tbFunction01ActionPerformed

    private void tbFunction02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction02ActionPerformed
        CustomDialog dlgCustom = new CustomDialog(new Catalog_02(), this, true);
        dlgCustom.show(null);
    }//GEN-LAST:event_tbFunction02ActionPerformed

    private void tbFunction03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFunction03ActionPerformed

    private void tbFunction04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction04ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFunction04ActionPerformed

    private void tbFunction05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction05ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFunction05ActionPerformed

    private void tbFunction06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction06ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFunction06ActionPerformed

    private void tbFunction08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction08ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFunction08ActionPerformed

    private void tbFunction09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction09ActionPerformed
        CustomDialog dlgCustom = new CustomDialog(new About_05(), this, true);
        dlgCustom.show(null,CustomDialog.LOCATION_AUTO);
    }//GEN-LAST:event_tbFunction09ActionPerformed

    private void tbFunction10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction10ActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_tbFunction10ActionPerformed

    private void tbFunction07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFunction07ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFunction07ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CatalogMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatalogMan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXLabel lblStatus;
    private javax.swing.JLayeredPane lpnContainer;
    private org.jdesktop.swingx.JXPanel pnlToolbar;
    private org.jdesktop.swingx.JXButton tbFunction01;
    private org.jdesktop.swingx.JXButton tbFunction02;
    private org.jdesktop.swingx.JXButton tbFunction03;
    private org.jdesktop.swingx.JXButton tbFunction04;
    private org.jdesktop.swingx.JXButton tbFunction05;
    private org.jdesktop.swingx.JXButton tbFunction06;
    private org.jdesktop.swingx.JXButton tbFunction07;
    private org.jdesktop.swingx.JXButton tbFunction08;
    private org.jdesktop.swingx.JXButton tbFunction09;
    private org.jdesktop.swingx.JXButton tbFunction10;
    // End of variables declaration//GEN-END:variables
}
