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
public class HmObjectMeta {
    
    private int id;
    private int objectTypeId;
    private String fieldName;
    private String displayName;
    private String displayText;
    private int dataType;
    private int sortOrder;
    private int groupId;
    private int fieldNo;
    
    public HmObjectMeta(int id, int objectTypeId, String fieldName, String displayName, String displayText, int dataType, int sortOrder,int groupId, int fieldNo){
        this.id = id;
        this.objectTypeId = objectTypeId;
        this.fieldName = fieldName;
        this.displayName = displayName;
        this.displayText = displayText;
        this.dataType = dataType;
        this.sortOrder = sortOrder;
        this.groupId = groupId;
        this.fieldNo = fieldNo;
    }
    
    public HmObjectMeta(int id) {
        this.id = id;
    }
    
    public HmObjectMeta(int objectTypeId, String fieldName, String displayName, String displayText, int dataType, int sortOrder,int groupId, int fieldNo){
        this.objectTypeId = objectTypeId;
        this.fieldName = fieldName;
        this.displayName = displayName;
        this.displayText = displayText;
        this.dataType = dataType;
        this.sortOrder = sortOrder;
        this.groupId = groupId;
        this.fieldNo = fieldNo;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getObjectTypeId() {
        return objectTypeId;
    }
    
    public void setObjectTypeId(int objectTypeId) {
        this.objectTypeId = objectTypeId;
    }
    
    public String getFieldName() {
        return fieldName;
    }
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayText() {
        return displayText;
    }
    
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
    
    public int getDataType() {
        return dataType;
    }
    
    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
    
    public int getSortOrder() {
        return sortOrder;
    }
    
    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
    
    public int getGroupId() {
        return groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    public int getFieldNo() {
        return fieldNo;
    }
    
    public void setFieldNo(int fieldNo) {
        this.fieldNo = fieldNo;
    }
}
