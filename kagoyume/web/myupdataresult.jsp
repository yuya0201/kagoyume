<%-- 
    Document   : myupdataresult
    Created on : 2016/08/28, 14:26:15
    Author     : yuya
--%>

<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>更新完了</h1>
        <form action="myupdateresult" method="POST">
        ユーザー名:<%=udb.getName()%><br>
        パスワード:<%=udb.getPassword()%><br>
        メールアドレス:<%=udb.getMail()%><br>
        住所:<%=udb.getAddres()%><br>
        
         <br>
        以上の内容で更新しました。
        <br>
        </form>
          <%=JumsHelper.getInstance().home()%>

    </body>
</html>
