package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cummins.project734.dbHelper.ExistingFileHelper;
import java.util.*;

public final class ExistingFiles_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/SideMenu.jspbb");
  }

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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{\r\n");
      out.write("\tbackground:#fff;\r\n");
      out.write("}\r\n");
      out.write("div.top{\r\n");
      out.write("\tbackground:#2E2E2E;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\theight:100px;\r\n");
      out.write("\tmargin:0.2em;\r\n");
      out.write("}\r\n");
      out.write("div.title{\r\n");
      out.write("\tbackground-image:url(Images/Logo.png);\r\n");
      out.write("\twidth:100px;\r\n");
      out.write("\theight:100px;\r\n");
      out.write("}\r\n");
      out.write("div.Link{\r\n");
      out.write("\tfont-size: 1em;\r\n");
      out.write("\tmargin-left: 75em;\r\n");
      out.write("\tmargin-top: 4em;\r\n");
      out.write("\tfont-family:Calibri;\r\n");
      out.write("}\r\n");
      out.write("div.leftfloat{\r\n");
      out.write("\tbackground:#2E2E2E;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tpadding: 1em 0 1em 0;\r\n");
      out.write("\tmargin:0.1em;\r\n");
      out.write("\twidth:150px;\r\n");
      out.write("\theight:100%;\r\n");
      out.write("}\r\n");
      out.write("div.square{\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tpadding: 3em 3em 3em 3em;\r\n");
      out.write("\tmargin-right:auto;\r\n");
      out.write("\tmargin-left:8em;\r\n");
      out.write("\twidth: 500px;\r\n");
      out.write("\topacity: 0.8;\r\n");
      out.write("\tfilter:alpha(opacity=80);\r\n");
      out.write("}\r\n");
      out.write("div.x{\r\n");
      out.write("\tpadding:25px 25px;\r\n");
      out.write("\tbackground-color:#E6E7E3;\r\n");
      out.write("\tfont-family:Calibri;\r\n");
      out.write("}\r\n");
      out.write("a:visited{color:#0000FF;}\r\n");
      out.write("a:hover{color:Red;}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"top\">\r\n");
      out.write("\t<div class=\"title\">\r\n");
      out.write("\t\t<div class=\"Link\">\r\n");
      out.write("\t\t\t<a href=\"LoginPage.jsp\"><font color=\"#ffffff\">Logout</font></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"background-color: ForestGreen; margin: 0.1em; width:100%; color: white;\" align=\"center\">\r\n");
      out.write("\t\tOpen File\r\n");
      out.write("</div>\t\r\n");
      out.write("<div id=\"menu\" class=\"leftfloat\">\r\n");
      out.write("\t\t");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"menuitem\">\r\n");
      out.write("\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<a href=\"HomeMenu.jsp\"><img border=\"0\" src=\"Images/house.png\" height=\"35px\" width=\"35px\" ></a> \r\n");
      out.write("\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<font face=\"Calibri\" color=\"white\" size=\"3\">Home</font>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"menuitem\">\r\n");
      out.write("\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<a href=\"ExistingFileController?id=open\"><img border=\"0\" src=\"Images/file.png\" height=\"30px\" width=\"30px\" ></a> \r\n");
      out.write("\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<font face=\"Calibri\" color=\"white\" size=\"3\">Open File</font>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"menuitem\">\r\n");
      out.write("\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<a href=\"AcceptFile.jsp\"><img border=\"0\" src=\"Images/newfile.jpg\" height=\"30px\" width=\"30px\" ></a> \r\n");
      out.write("\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<font face=\"Calibri\" color=\"white\" size=\"3\">Add New File</font>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"menuitem\">\r\n");
      out.write("\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<a href=\"ExistingFileController?id=del\"><img border=\"0\" src=\"Images/trash.png\" height=\"30px\" width=\"30px\" ></a> \r\n");
      out.write("\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<font face=\"Calibri\" color=\"white\" size=\"3\">Delete Files</font>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"menuitem\">\r\n");
      out.write("\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<a href=\"ViewReports.jsp\"><img border=\"0\" src=\"Images/report.png\" height=\"30px\" width=\"30px\" ></a> \r\n");
      out.write("\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<font face=\"Calibri\" color=\"white\" size=\"3\">View Reports</font>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"menuitem\">\r\n");
      out.write("\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<a href=\"ProfileController\"><img border=\"0\" src=\"Images/profile.png\" height=\"30px\" width=\"30px\" ></a> \r\n");
      out.write("\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<font face=\"Calibri\" color=\"white\" size=\"3\">View Profile</font>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"square\">\r\n");
      out.write("<div class=\"x\">\r\n");
      out.write("\r\n");
      out.write("<B>FILES:</B>\r\n");
      out.write("<br><br>\r\n");

ArrayList<String> efiles = new ArrayList<String>();
efiles = (ArrayList<String>) request.getAttribute("EFiles");
String myString="";
if(efiles.isEmpty()==false)
{
	for(int i = 0; i < efiles.size(); i++) 
	{ 
	 	myString = (String) efiles.get(i);
      out.write("\r\n");
      out.write("\t \t<a href=\"SearchIndex.jsp?id=");
      out.print(myString);
      out.write("&jspPath=ExistingFiles\">");
      out.print(myString);
      out.write("</a>\r\n");
      out.write("\t \t<br>\r\n");
      out.write("\t");
}
}

      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
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
