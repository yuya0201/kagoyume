/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.util.ArrayList;

/**
 *ページで入出力されるユーザー情報を持ちまわるJavaBeans
 * @author yuya
 */
public class UserDataBeans {
    private int userID;
    private String name;
    private String passwaord;
    private String mail;
    private String addres;
    private int  total;
    private int type;

    public UserDataBeans(){
        this.userID = 0;
        this.name ="";
        this.passwaord ="";
        this.mail = "";
        this.addres = "";
        this.total = 0; 
    
          this.userID = userID;
    }
    public void setUserId(int userID){
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
        this.passwaord = password;
    }
    public String getPassword(){
        return passwaord;
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
    public void setType(int type) {
        this.type = type;
    }
    public int getType(){
        return type;
    }

    
      public void UD2DTOMapping(UserDataDTO udd){
          udd.setUserID(this.userID);
          udd.setName(this.name);
          udd.setPassword(this.passwaord);
          udd.setMail(this.mail);
          udd.setAddres(this.addres);
          udd.setTotal(this.total);
    }
      public void DTO2DUDMapping(UserDataDTO udd){
          this.setUserId(udd.getUserID());
          this.setName(udd.getName());
          this.setPassword(udd.getPassword());
          this.setMail(udd.getMail());
          this.setAddres(udd.getAddres());
          this.setTotal(udd.getTotal());
    }
      public void UD2PDDMapping(ProductDataDTO pdd){
        pdd.setUserID(this.getUserID());
        pdd.setType(this.getType());
        pdd.setTotal(this.getTotal());
    }
    
      public void PDD2UDMapping(ProductDataDTO pdd){
        this.setUserId(pdd.getUserID());
        this.setType(pdd.getType());
        this.setTotal(pdd.getTotal());
    }
    
        public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.passwaord.equals("")){
            chkList.add("password");
        }
        if(this.mail.equals("")){
            chkList.add("mail");
        }
        if(this.addres.equals("")){
            chkList.add("addres");
        }
        return chkList;
    }

}

