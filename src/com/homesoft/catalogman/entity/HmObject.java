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
public class HmObject {
    
    private int id;
    private String name;
    private String desciption;
    private int postId;
    private int taxonomyId;
    private int objectId;
    
    public HmObject(int id, String name, String desciption, int postId, int taxonomyId, int objectId) {
        this.id = id;
        this.name = name;
        this.desciption = desciption;
        this.postId = postId;
        this.taxonomyId = taxonomyId;
        this.objectId = objectId;
    }
    
    public HmObject(int id) {
        this.id = id;
    }
    
    public HmObject(String name, String desciption, int postId, int taxonomyId, int ObjectId) {
        this.name = name;
        this.desciption = desciption;
        this.postId = postId;
        this.taxonomyId = taxonomyId;
        this.objectId = objectId;
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
        return desciption;
    }
    
    public void setDescription(String description) {
        this.desciption = description;
    }
    
    public int getPostId() {
        return postId;
    }
    
    public void setPostId(int postId) {
        this.postId = postId;
    }
    
    public int getTaxonomyId() {
        return taxonomyId;
    }
    
    public void setTaxonomyId(int taxonomyId) {
        this.taxonomyId = taxonomyId;
    }
    
    public int getObjectId() {
        return objectId;
    }
    
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
}
