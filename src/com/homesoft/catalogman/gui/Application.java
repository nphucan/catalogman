/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.gui;

import com.homesoft.catalogman.dao.HmImageDAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.painter.ImagePainter;

/**
 * @company Home
 * @author phucan
 * @createdDate Mar 14, 2015
 * @modifiedDate
 */
public class Application {

    private static String strAppPath = null;
    private HashMap<Integer, ImageIcon> lstIcon;
    private static HashMap<String, ImagePainter> lstImage;

    /**
     * Return application path
     *
     * @return Absolute path
     */
    public static String getAppPath() {
        if (strAppPath == null) {
            strAppPath = new File("").getAbsolutePath();
        }
        return strAppPath;
    }

    /**
     * Get icon by ID
     *
     * @param id ImageID
     * @return
     */
    public ImageIcon getIcon(int id) {
        if (lstIcon == null) {
            lstIcon = new HashMap<>();
            try {
                HmImageDAO daoImage = new HmImageDAO();
                List<String> lstImgName = daoImage.select();
                String strFilename;
                for (String strName : lstImgName) {
                    strFilename = Application.getAppPath() + "/" + strName;
                    if (Files.exists(Paths.get(strFilename))) {
                        // lstIcon.put(id, null)
                    }
                }
            } catch (Exception ex) {

            }
        }
        return lstIcon.get(id);
    }

    public static ImagePainter getImagePainter(String strName) {
        if (java.beans.Beans.isDesignTime()) {
            return new ImagePainter();
        }
        if (lstImage == null) {
            try {
                lstImage = new HashMap<>();
                ImagePainter ptrNormal
                        = new ImagePainter(
                                ImageIO.read(
                                        Application.class.getClass().getResource("/com/homesoft/catalogman/resources/bg/tweed.png")
                                ));

                ImagePainter ptrDark
                        = new ImagePainter(
                                ImageIO.read(
                                        Application.class.getClass().getResource("/com/homesoft/catalogman/resources/bg/tweed_dark.png")
                                ));
                ptrNormal.setHorizontalRepeat(true);
                ptrNormal.setVerticalRepeat(true);
                ptrDark.setHorizontalRepeat(true);
                ptrDark.setVerticalRepeat(true);
                lstImage.put("background", ptrNormal);
                lstImage.put("background_dark", ptrDark);
            } catch (IOException ex) {
                return new ImagePainter();
            }
        }
        return lstImage.get(strName);
    }
}
