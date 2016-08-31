/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;

/**
 * ユーザー情報を持ちまわるJavaBeans
 * @author yuya
 */
public class UserDataDTO {
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String addres;
    private int  total;   
    private Timestamp newDate;
    private int type;


    
    
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    public int getUserID(){
        return userID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;      
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getMail(){
        return mail;
    }
    public void setAddres(String addres){
        this.addres = addres;
    }
    public String getAddres(){
        return addres;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return total;
    }
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    public Timestamp getNewDate(){
        return newDate;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getType(){
        return type;
    }
}
               
    
