/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homesoft.catalogman.entity;

/**
 * @company Home
 * @author Bao Nguyen
 * @createdDate Feb 6, 2015
 * @modifiedDate
 */
public class HmObjectType {
    
    private int id;
    private String name;
    private String description;
    private int imageId;
    
     public HmObjectType(int id, String name, String desciption, int imageId) {
        this.id = id;
        this.name = name;
        this.description = desciption;
        this.imageId = imageId;
    }
    
    public HmObjectType(int id) {
        this.id = id;
    }
    
    public HmObjectType(String name, String desciption, int imageId) {
        this.name = name;
        this.description = desciption;
        this.imageId = imageId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getImageId() {
        return imageId;
    }
    
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
