/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author yuya
 */
public class Json {
      //URL先の情報をStringで返却するメソッド
    public  String getResult(String urlString){ 
	String result = "";
	try{
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
                while ((tmp = in.readLine()) != null){
                    result += tmp;
                }
            in.close();
            con.disconnect();
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
    }
    //文字列からJSONの変換
  public static JsonNode getJsonNode(String jsonString){
        JsonNode head = null;
        try{
            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createJsonParser(jsonString);
            ObjectMapper mapper = new ObjectMapper(); 
            head = mapper.readTree(parser);
        }catch(Exception e){
            e.printStackTrace();
        }
        return head;
    }
  
  public static ArrayList<ProductBeans> getItemList(JsonNode head){
      ArrayList<ProductBeans> ary = new ArrayList<ProductBeans>();
      for(int i=0; i<20; i++){
      String num = String.valueOf(i);
      ProductBeans pdb = new ProductBeans();
      
      pdb.setName(head.get("ResultSet").get("0").get("Result").get(num).get("Name").getTextValue());
      pdb.setPrice(head.get("ResultSet").get("0").get("Result").get(num).get("Price").get("_value").getTextValue());
      pdb.setImage(head.get("ResultSet").get("0").get("Result").get(num).get("Image").get("Medium").getTextValue());
      pdb.setCode(head.get("ResultSet").get("0").get("Result").get(num).get("Code").getTextValue());
      ary.add(pdb);
   
      }
      return ary;
      
    }
  
  public static ProductBeans getDataList(JsonNode head){
      ProductBeans pdb = new ProductBeans();
      
      pdb.setName(head.get("ResultSet").get("0").get("Result").get("0").get("Name").getTextValue());
      pdb.setPrice(head.get("ResultSet").get("0").get("Result").get("0").get("Price").get("_value").getTextValue());
      pdb.setImage(head.get("ResultSet").get("0").get("Result").get("0").get("Image").get("Medium").getTextValue());
      pdb.setCode(head.get("ResultSet").get("0").get("Result").get("0").get("Code").getTextValue());
      pdb.setDescription(head.get("ResultSet").get("0").get("Result").get("0").get("Description").getTextValue());
      pdb.setRate(head.get("ResultSet").get("0").get("Result").get("0").get("Review").get("Rate").getTextValue());
      
       return pdb;
  }
 

}

  


    
