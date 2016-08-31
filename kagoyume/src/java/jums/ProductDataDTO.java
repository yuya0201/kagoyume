/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *
 * @author yuya
 */
public class ProductDataDTO {
    private int userID;
    private int total;
    private int type;
    
    public int getUserID(){return this.userID;}
    public int getTotal(){return this.total;}
    public int getType(){return this.type;}
    
    public void setUserID(int userID){this.userID=userID;}
    public void setTotal(int total){this.total=total;}
    public void setType(int type){this.type=type;}
    
    
}
