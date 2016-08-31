<%-- 
    Document   : mydelete
    Created on : 2016/08/25, 16:54:36
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataBeans"%>
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
        
        ユーザー名:<%=udb.getName()%><br>
        パスワード:<%=udb.getPassword()%><br>
        メールアドレス:<%=udb.getMail()%><br>
        住所:<%=udb.getAddres()%><br>        
        合計金額:<%=udb.getTotal()%><br>
        
        
        このユーザーをマジで削除しますか？
        <form action="mydeleteresult" method="GET">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>"><br>
            <input type="text" name="btnSubmit" value="はい">
        </form>>
        <form action="top.jsp" method="GET">
            <input type="submit" name="btnSubmit" value="いいえ">
        </form>>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
