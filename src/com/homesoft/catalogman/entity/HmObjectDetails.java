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
public class HmObjectDetails {
    
    private int id;
    private int objectId;
    private int fieldNo;
    private String fieldValue;
    
    public HmObjectDetails(int id, int objectId, int fieldNo, String fieldValue) {
        this.id = id;
        this.objectId = objectId;
        this.fieldNo = fieldNo;
        this.fieldValue = fieldValue;
    }
    
    public HmObjectDetails(int id) {
        this.id = id;
    }
    
    public HmObjectDetails(int objectId, int fieldNo, String fieldValue) {
        this.objectId = objectId;
        this.fieldNo = fieldNo;
        this.fieldValue = fieldValue;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getObjectId() {
        return objectId;
    }
    
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
    
    public int getFieldNo() {
        return fieldNo;
    }
    
    public void setFieldNo(int fieldNo) {
        this.fieldNo = fieldNo;
    }
    
    public String getFieldValue() {
        return fieldValue;
    }
    
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
