<%-- 
    Document   : registrationcomplete
    Created on : 2016/08/23, 17:30:45
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
          <h1>登録結果</h1><br>
           ユーザー名:<%=udb.getName()%><br>
          パスワード:<%=udb.getPassword()%><br>
          メールアドレス:<%=udb.getMail()%><br>
          住所:<%=udb.getAddres()%><br>
          
          <%=JumsHelper.getInstance().home()%>
    </body>
</html>
