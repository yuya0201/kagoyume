<%-- 
    Document   : myupdate
    Created on : 2016/08/25, 16:59:26
    Author     : yuya
--%>
<%@page import="jums.UserDataBeans"%>
<%
HttpSession hs = request.getSession();
UserDataBeans udb = (UserDataBeans)hs.getAttribute("login");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             <h1>更新画面</h1>
             <input type="text" name="name" value="<% udb.getName();%>"><br>
             <input type="text" name="password" value="<% udb.getPassword();%>"><br>
             <input type="text" name="mail" value="<% udb.getMail();%>"><br>
             <input type="text" name="addres" value="<% udb.getAddres();%>"><br>
             
             <form action="myupdateresult?id=<%=udb.getUserID()%>" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="更新する">
         </form>
    </body>
</html>
