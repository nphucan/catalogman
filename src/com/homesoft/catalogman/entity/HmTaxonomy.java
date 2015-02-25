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
public class HmTaxonomy {
    
    private int id;
    private String taxonomy;
    private int parent;
    private String description;
    private int optionNo;
    private int sortOrder;
    private int imageId;
    private int deletable;
    
    public HmTaxonomy(int id, String taxonomy, int parent, String description, int optionNo, int sortOrder, int imageId, int deletable) {
        this.id = id;
        this.taxonomy = taxonomy;
        this.parent = parent;
        this.description = description;
        this.optionNo = optionNo;
        this.sortOrder = sortOrder;
        this.imageId = imageId;
        this.deletable = deletable;
    }
    
    public HmTaxonomy(int id) {
        this.id = id;
    }
    
    public HmTaxonomy(String taxonomy, int parent, String description, int optionNo, int sortOrder, int imageId, int deletable) {
        this.taxonomy = taxonomy;
        this.parent = parent;
        this.description = description;
        this.optionNo = optionNo;
        this.sortOrder = sortOrder;
        this.imageId = imageId;
        this.deletable = deletable;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTaxonomy() {
        return taxonomy;
    }
    
    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }
    
    public int getParent() {
        return parent;
    }
    
    public void setParent(int parent) {
        this.parent = parent;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getOptionNo() {
        return optionNo;
    }
    
    public void setOptionNo(int optionNo) {
        this.optionNo = optionNo;
    }
    
    public int getSortOrder() {
        return sortOrder;
    }
    
    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
    
    public int getImageId() {
        return imageId;
    }
    
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    
    public int getDeletable() {
        return deletable;
    }
    
    public void setDeletable(int deletable) {
        this.deletable = deletable;
    }
}
