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
public class ProductBeans {
    private int price;
    private String description;
    private String name;
    private String image;
    private String code;
    private double rate;

            

public ProductBeans(){
    price = 0;
    description = "";
    name = "";
    image ="";
    code = "";
    rate = 0.0;
    
}

public void setName(String name){
    this.name = name;
}
public  String getName(){
    return name;
}
public void setDescription(String description){
    this.description = description;
}
public String getDescription(){
    return description;
}
public void setPrice(String sprice){
    int price = Integer.parseInt(sprice);
    this.price = price;
}
public int getPrice(){
    return price;
}
public void setImage(String image){
    this.image = image;
}
public String getImage(){
    return image;
}
public void setCode(String code){
    this.code = code;
}
public String getCode(){
    return code;
}
public void setRate(String drate){
    this.rate =  Double.parseDouble(drate);  
}
public double getRate(){
    return rate;
}

}