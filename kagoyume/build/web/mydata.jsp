<%-- 
    Document   : mydata
    Created on : 2016/08/28, 14:43:39
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
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
        <h1>マイデータ</h1>
        ユーザー名:<%=udb.getName()%><br>
        パスワード:<%=udb.getPassword()%><br>
        メールアドレス:<%=udb.getMail()%><br>
        購入金額:<%=udb.getTotal()%><br>
      
        
        <form action="myupdate" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" value="ユーザー情報の更新"><br>
        </form>
        <form action="mydelete" method="POST"> 
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" value="ユーザー情報の削除"><br>
        </form>
          <%=JumsHelper.getInstance().home()%>
    </body>
</html>
