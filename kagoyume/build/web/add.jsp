<%-- 
    Document   : add
    Created on : 2016/08/23, 17:29:16
    Author     : yuya
--%>

<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>カートに追加しました</h1>
        <form action="cart" method="GET">
            <input type="submit" name="btnSbmit" value="買い物かごへ">
        </form>
        <a href="searchresult.jsp">検索結果に戻る </a><br>
         <%=JumsHelper.getInstance().home()%>
        
    </body>
</html>
