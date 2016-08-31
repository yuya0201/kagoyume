<%-- 
    Document   : logout
    Created on : 2016/08/28, 14:14:01
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
        <h1>ログアウトしました</h1>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
