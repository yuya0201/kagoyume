<%-- 
    Document   : top
    Created on : 2016/08/23, 17:25:45
    Author     : yuya
--%>

<%@page import="jums.JumsHelper"%>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>トップページ</h1>
        <p>ようこそ！このサイトは金銭取引が発生しない夢のようなサイトです</p>
        <form action="search" method="GET">
            <input type="text" name="search" value="">
            <input type="submit" name="btnsubmit" value="商品を検索">
        </form>  
        <a href="registration.jsp">新規会員登録</a>
        <a href="login.jsp">ログイン</a>
    </body>
</html>
