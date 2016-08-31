/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yuya
 */
public class LoginResult extends HttpServlet {

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
        HttpSession hs = request.getSession();
        //formで入力されたユーザー名とパスワードをudbに格納
        UserDataBeans udb = new UserDataBeans();
        udb.setName(request.getParameter("name"));
        udb.setPassword(request.getParameter("passworod"));
        
        //DTOオブジェクトにマッピング。DB専用のパラメータに変換
        UserDataDTO udd = new UserDataDTO();
        udb.UD2DTOMapping(udd);
       //loginメソッドで情報が一致するデータベースの情報を所得
        UserDataDAO.getInstance().login(udd);
           
        udb.DTO2DUDMapping(udd);
    
        if(udb.getUserID()!=0){
                   
                        hs.setAttribute("login", udb);
        if(hs.getAttribute("url")==null){
            request.getRequestDispatcher("/top.jsp").forward(request, response);   
        } else {
          String url = (String) hs.getAttribute("url");
                    request.getRequestDispatcher(url).forward(request, response); 
        }
        }else{
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                 }
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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
