<%-- 
    Document   : error
    Created on : 2016/08/25, 11:05:40
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
         エラーが発生しました。以下の項目を確認してください。<br>
         <%=request.getAttribute("error")%><br>
         <%=JumsHelper.getInstance().home()%>
    </body>
</html>
