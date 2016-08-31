<%-- 
    Document   : buyconfirm
    Created on : 2016/08/23, 17:31:23
    Author     : yuya
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ProductBeans"%>
<%@page import="jums.JumsHelper"%>
<%

    JumsHelper jh = new JumsHelper();
    HttpSession hs = request.getSession();
    ArrayList<ProductBeans> cartData =  (ArrayList)hs.getAttribute("cartData");
    int total = 0;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           for(int i=0;i<cartData.size();i++){               
            
            ProductBeans pdb = new ProductBeans();
            pdb = cartData.get(i);       
        %>
         名前<%=pdb.getName()%><br>
         価格<%=pdb.getPrice()%>円<br>
         
         <% total += pdb.getPrice();}%>
         
        合計金額は<%=total%>
        
        <form action="buycomplete" method="POST">
            発送方法<br>
            <input type="radio" name="type" value="1">郵送<br>
            <input type="radio" name="type" value="2">宅急便<br>
            <input type="hidden" name="total" value="<%=total%>">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="上記の内容で購入する">
        </form>
    </body>
</html>
