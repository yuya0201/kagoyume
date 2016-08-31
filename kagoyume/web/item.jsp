<%-- 
    Document   : item
    Created on : 2016/08/23, 17:26:24
    Author     : yuya
--%>
<%@page import="jums.ProductBeans"%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession hs = request.getSession();
    ProductBeans pdb = (ProductBeans)hs.getAttribute("datalist");
   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>商品詳細</h1>
          <table border=1>
        <tr>
                <th>画像</th>
                <th>商品名</th>
                <th>値段</th>
                <th>説明</th>
                <th>レビュー</th>
                <th>カート</th>
        </tr>
   
        <tr>
               <td><img src="<%= pdb.getImage()%>"><br></td>
               <td><%=pdb.getName() %><br></td>
               <td><%=pdb.getPrice()%><br></td>
               <td><%=pdb.getDescription()%></td>
               <td><%=pdb.getRate()%></td>
               <td><a href="add?code=<%=pdb.getCode()%>">カートに追加</td>
        </tr>
        
        
        
    </body>
</html>
