<%-- 
    Document   : searchresult
    Created on : 2016/08/29, 13:07:30
    Author     : yuya
--%>
<%@page import="jums.ProductBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="org.codehaus.jackson.JsonNode"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.search"%>
<%
    HttpSession hs = request.getSession();
    ArrayList<ProductBeans> itemList = (ArrayList<ProductBeans>)hs.getAttribute("itemList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border="1">
           <tr>
                <th>名前</th>
                <th>画像</th>
                <th>値段</th>
           </tr>
           <tr>
       <%for(int i=0; i<itemList.size();i++){%>
       <td> <a href="item?code=<%=itemList.get(i).getCode()%>"><%=itemList.get(i).getName()%></td>
               <td><img src="<%= itemList.get(i).getImage()%>"></td>
               <td><%= itemList.get(i).getPrice()%></td> 
           </tr>    
        <%}%> 
      
        </table>    
    </body>
</html>
