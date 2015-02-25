/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.entity;

/**
 * @company Home
 * @author phucan
 * @createdDate Feb 1, 2015
 * @modifiedDate
 */
public class HmImage {

    int id;
    String imageFile;
    int size;

    public HmImage(int id, String imageFile, int size) {
        this.id = id;
        this.imageFile = imageFile;
        this.size = size;
    }

    public HmImage(int id) {
        this.id = id;
    }

    public HmImage(String imageFile, int size) {
        this.imageFile = imageFile;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
