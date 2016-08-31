/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author yuya
 */
public class UserDataDAO {
      //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
        /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO udd) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;
    try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("INSERT INTO user_t(name,password,mail,address,total,newDate) VALUES(?,?,?,?,?,?)");
            
            st.setString(1,udd.getName());
            st.setString(2,udd.getPassword());
            st.setString(3,udd.getMail());
            st.setString(4,udd.getAddres());
            st.setInt(5,udd.getTotal());
            st.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed"); 
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    /**
     * データの上書き
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void update(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        try{
               con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name=?,password=?,mail=?,addres=? WHERE userID=?");
            st.setString(1,udd.getName());
            st.setString(2,udd.getPassword());
            st.setString(3,udd.getMail());
            st.setString(4,udd.getAddres());
            st.setInt(5,udd.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
     /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, udd.getUserID());
            
            ResultSet lesult = st.executeQuery();
            lesult.next();
            
            UserDataDTO resultUd = new UserDataDTO();
            
            resultUd.setUserID(lesult.getInt("UserID"));
            resultUd.setName(lesult.getString("name"));
            resultUd.setPassword(lesult.getString("password"));
            resultUd.setMail(lesult.getString("mail"));
            resultUd.setAddres(lesult.getString("addres"));

            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
        /**
     * ユーザーIDによる1件のデータの削除処理を行う。
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */    
public void delete(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("DELETE FROM user_t WHERE userID =?");
            st.setInt(1,udd.getUserID());
            st.executeUpdate();
            System.out.println("delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
     /**
     * ログインデータの検索処理を行う。
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
     public  UserDataDTO login(UserDataDTO udd) throws SQLException{
                   Connection con = null;
            PreparedStatement st = null;
    try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("SELCT*FROM user_t WHERE name=? AND password");
            st.setString(1,udd.getName());
            st.setString(2,udd.getPassword());
            
            ResultSet lesult = st.executeQuery();
            
            if(lesult.next()){
                
                udd.setUserID(lesult.getInt("UserID"));
                udd.setName(lesult.getString("name"));
                udd.setPassword(lesult.getString("password"));
                udd.setMail(lesult.getString("mail"));
                udd.setAddres(lesult.getString("addres"));
                udd.setTotal(lesult.getInt("total"));
                udd.setNewDate(lesult.getTimestamp("newDate"));
            }
            System.out.println("login completed"); 
            return udd;
            
                }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
     }
        /**
     * 総購入金額の更新を行う
     * @param udd 対応したデータを保持しているJavaBeans,total 
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 加えたい金額
     */
    public void totalupdate(UserDataDTO udd,int total) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET total=total+? WHERE userID=?");
            st.setInt(1,total);
            st.setInt(2,udd.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
   /**
     * 購入情報の挿入を行う
     * @param pdd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void pdinsert(ProductDataDTO  pdd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO buy_t(userID,total,type,buyDate) VALUES(?,?,?,?)");
            st.setInt(1, pdd.getUserID());
            st.setInt(2, pdd.getTotal());
            st.setInt(3, pdd.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
}

