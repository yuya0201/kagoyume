<%-- 
    Document   : mydeleteresult
    Created on : 2016/08/25, 16:54:57
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataBeans"%>
<%

HttpSession hs = request.getSession();
UserDataBeans udb = (UserDataBeans)hs.getAttribute("udd");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>削除しました</h1>
        <br>
        
          <%=JumsHelper.getInstance().home()%>
    </body>
</html>
