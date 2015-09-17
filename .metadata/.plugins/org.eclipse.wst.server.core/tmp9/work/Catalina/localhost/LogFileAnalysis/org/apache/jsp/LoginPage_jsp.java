package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>LogFileAnalysis: Login</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function validateForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar user = form.userid.value;\r\n");
      out.write("\tvar pswd = form.pswrd.value;\r\n");
      out.write("\tif (user=='' || user==null || pswd=='' || pswd==null)\r\n");
      out.write("\t  {\r\n");
      out.write("\t  \talert(\"Please enter the Username and Password.\"); \t\r\n");
      out.write("\t  \treturn false;\r\n");
      out.write("\t  }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{\r\n");
      out.write("\tbackground:#fff;\r\n");
      out.write("}\r\n");
      out.write("div.title{\r\n");
      out.write("\tbackground-image:url(Images/Logo.png);\r\n");
      out.write("\twidth:100px;\r\n");
      out.write("\theight:100px;\r\n");
      out.write("}\r\n");
      out.write("div.top{\r\n");
      out.write("\tbackground:#2E2E2E;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\theight:100px;\r\n");
      out.write("\tmargin:0.2em;\r\n");
      out.write("}\r\n");
      out.write("div.x{\r\n");
      out.write("\tpadding:25px 25px;\r\n");
      out.write("\tbackground-color:#E6E7E3;\r\n");
      out.write("\tfont-family:Calibri;\r\n");
      out.write("\tpadding: 5em 0 0 3em;\r\n");
      out.write("\tmargin-top: 3em;\r\n");
      out.write("\tmargin-left: 30em;\r\n");
      out.write("\twidth: 20em;\r\n");
      out.write("\theight: 15em;\r\n");
      out.write("\topacity: 0.7;\r\n");
      out.write("\tfilter:alpha(opacity=70);\r\n");
      out.write("}\r\n");
      out.write("div.leftfloat{\r\n");
      out.write("\tbackground:#2E2E2E;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tmargin:0.1em;\r\n");
      out.write("\twidth:140px;\r\n");
      out.write("\theight:400px;\r\n");
      out.write("}\r\n");
      out.write("input.btn {   \r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-family: Calibri;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tmargin:0.5em;\r\n");
      out.write("}\r\n");
      out.write("div.Link{\r\n");
      out.write("\tfont-size: 1em;\r\n");
      out.write("\tmargin-left: 70em;\r\n");
      out.write("\tmargin-top: 3.5em;\r\n");
      out.write("\tfont-family:Calibri;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");

String errorMessage = "";
errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage==null){
	errorMessage=" ";
}

      out.write(' ');
      out.write('\r');
      out.write('\n');

String message = "";
message = (String)request.getAttribute("message");
if(message==null){
	message=" ";
}

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"top\">\r\n");
      out.write("\t<div class=\"title\">\r\n");
      out.write("\t\t<div class=\"Link\">\r\n");
      out.write("\t\t\t<a href=\"MainPage.jsp\"><font color=\"#ffffff\">Main_Page</font></a>\r\n");
      out.write("\t\t\t<a href=\"CreateAccount.jsp\"><font color=\"#ffffff\">Create_Account</font></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"background-color: ForestGreen; margin: 0.1em; width:100%; color: white;\" align=\"center\">\r\n");
      out.write("\t\tLogin\r\n");
      out.write("</div>\t\r\n");
      out.write("<div class=\"leftfloat\"></div>\r\n");
      out.write("\t\t<font size=\"3\" color=\"red\">");
      out.print(message);
      out.write("</font><br>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"x\">\r\n");
      out.write("\t<form action=\"LoginController\" onsubmit=\"return validateForm(this)\"  >\r\n");
      out.write("\t\t<font class=\"label\" size=\"3\" color=\"black\">Username</font>&nbsp;&nbsp;&nbsp;<input type=\"text\" id=\"user\"name=\"userid\"/><br>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<font class=\"label\" size=\"3\" color=\"black\">Password</font>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"password\" name=\"pswrd\"/><br><br>\r\n");
      out.write("\t\t<font size=\"3\" color=\"red\">");
      out.print(errorMessage);
      out.write("</font><br>\r\n");
      out.write("\t\t<input type=\"submit\" class=\"btn\" style=\"height: 30px; width: 90px\" value=\"Login\"/>\r\n");
      out.write("\t\t&nbsp;&nbsp;\r\n");
      out.write("\t\t<input type=\"reset\" class=\"btn\" style=\"height: 30px; width: 90px\" value=\"Cancel\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
