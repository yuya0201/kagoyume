package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import jums.UserDataBeans;
import jums.JumsHelper;

public final class registrationconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>  \n");
      out.write("        ");
 if(chkList.size()==0){ 
      out.write("\n");
      out.write("          <h1>登録確認</h1>\n");
      out.write("          ユーザー名:");
      out.print(udb.getName());
      out.write("\n");
      out.write("          パスワード:");
      out.print(udb.getPassworod());
      out.write("\n");
      out.write("          メールアドレス:");
      out.print(udb.getMail());
      out.write("\n");
      out.write("          住所:");
      out.print(udb.getAddres());
      out.write("\n");
      out.write("         上記の内容で登録します。よろしいですか？\n");
      out.write("         <form action=\"registrationcomplete\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"ac\"  value=\"\">\n");
      out.write("            <input type=\"submit\" name=\"yes\" value=\"はい\">\n");
      out.write("        </form>\n");
      out.write("          ");
 }else{ 
      out.write("\n");
      out.write("        <h1>入力が不完全です</h1>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("        <form action=\"registration\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" name=\"no\" value=\"登録画面に戻る\">\n");
      out.write("            <input type=\"hidden\" name=\"mode\" value=\"REINPUT\">\n");
      out.write("        </form>\n");
      out.write("         ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
