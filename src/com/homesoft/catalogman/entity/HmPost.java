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
public class HmPost {
    
    private int id;
    private String content;
    
    public HmPost(int id, String content) {
        this.id = id;
        this.content = content;
    }
    
    public HmPost(int id) {
        this.id = id;
    }
    
    public HmPost(String content) {
        this.content = content;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}
