<%-- 
    Document   : cart
    Created on : 2016/08/23, 17:31:06
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ProductBeans"%>
<%
    JumsHelper jh = new JumsHelper();
    HttpSession hs = request.getSession();
    ArrayList<ProductBeans> cartData =  (ArrayList)hs.getAttribute("cartData");
  

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        
         if(cartData.size()!=0){
            for(int i=0;i<cartData.size();i++){               
            
            ProductBeans pdb = new ProductBeans();
            pdb = cartData.get(i);
        
        %>
        <h1>マイカート</h1>
        
                <table border=1>
        <tr>
                <th>画像</th>
                <th>商品名</th>
                <th>値段</th>
        </tr>
        
        <tr>
                <td><img src="<%= pdb.getImage()%>"><br></td>
                <td><%=pdb.getName() %><br></td>
                <td><%=pdb.getPrice()%><br></td>
          <form action=" itemDelete" method="POST">
            <input type="submit" name="btnSubmit" value="カートから削除">
            <input type="hidden" name="id" value="<%=i%>">
        </form>
        <%}%>
          <form action="buyconfirm" method="POST">
            <input type="submit" name="btnSubmit" value="購入画面へ進む">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
          </form>
         <%}else{%>
        カートに商品はありません<br>
        <%}   
            if(hs.getAttribute("cartData")!=null){out.print("<a href=\"searchresult.jsp\">検索結果に戻る</a><br>");}

        %>  
        </tr>
         <%=JumsHelper.getInstance().home()%>
         
    </body>
</html>
