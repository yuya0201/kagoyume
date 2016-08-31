/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonNode;

/**
 *
 * @author yuya
 */
public class search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try{
             
           request.setCharacterEncoding("UTF-8");
         
           HttpSession session = request.getSession(); 
           
            Json js = new Json();
            //商品検索リクエストURL
            String url ="http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
            //アプリケーションID
            String ApID = "dj0zaiZpPWJtMHNoQldIZ2dkRSZzPWNvbnN1bWVyc2VjcmV0Jng9NGQ-";
            //検索formからユーザーが入力するクエリ
            String query = request.getParameter("search");
            //ユーザーが入力した情報をエンコード
            String encodeResult = URLEncoder.encode(query,"UTF-8");
            
            String json = js.getResult(url+"?appid="+ApID+"&query="+encodeResult);
            
        
            JsonNode jn;
            jn = js.getJsonNode(json);
            
            ArrayList<ProductBeans> itemList = new  ArrayList<ProductBeans>();
            
            itemList = js.getItemList(jn);
            
            session.setAttribute("itemList", itemList);
            session.setAttribute("url", "/searchresult.jsp");
         
         request.getRequestDispatcher("/searchresult.jsp").forward(request,response);
            
       }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
            
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
