<%-- 
    Document   : registrationconfirm
    Created on : 2016/08/23, 17:30:23
    Author     : yuya
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
          <% if(chkList.size()==0){ %>
          <h1>登録確認</h1>
          ユーザー名:<%=udb.getName()%><br>
          パスワード:<%=udb.getPassword()%><br>
       メールアドレス:<%=udb.getMail()%><br>
               住所:<%=udb.getAddres()%><br>
         上記の内容で登録します。よろしいですか？
         <form action="registrationResult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
         </form>  
          <% }else{ %>
        <h1>入力が不完全です</h1>
      <%=jh.chkinput(chkList) %>
      <% } %>
        <form action="registration" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="mode" value="REINPUT">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        </form>
         <%=JumsHelper.getInstance().home()%>
    </body>
</html>
