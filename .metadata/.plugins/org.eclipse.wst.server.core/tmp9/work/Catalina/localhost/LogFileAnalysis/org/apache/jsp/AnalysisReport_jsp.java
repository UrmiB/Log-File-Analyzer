package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cummins.project734.entity.AnalysisData;
import com.cummins.project734.entity.SearchResult;
import com.cummins.project734.dateTime.*;
import com.cummins.project734.entity.*;
import java.awt.*;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.entity.*;
import org.jfree.data.general.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class AnalysisReport_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");

String searchQuery = request.getParameter("searchQuery");
SearchResult sResult = new SearchResult();
// ArrayList<String> RecordList = new ArrayList<String>();
if(searchQuery != ""){
	
	sResult = (SearchResult)request.getSession().getAttribute("SearchResult");
	//RecordList = (ArrayList<String>)sResult.getRecords();
//	System.out.println("List: "+RecordList);
} 

AnalysisData analysis = new AnalysisData();
analysis = (AnalysisData)request.getAttribute("Analysis");

List<DatewiseRecord>  DateList = new ArrayList<DatewiseRecord>();
DateList = (ArrayList<DatewiseRecord>) analysis.getDatewiseRecords();
DatewiseRecord dr = new DatewiseRecord();
Iterator<DatewiseRecord> itd = DateList.iterator();
int count =0;
while(itd.hasNext())
{
	dr = itd.next();
	count++;
}

int noOfrecords = analysis.getTotalNoOfRecords();
System.out.println("Number of records: "+noOfrecords);

ArrayList<ErrorInformation> li = new ArrayList<ErrorInformation>();
li = (ArrayList<ErrorInformation>)analysis.getErrorInfo();

//Error List
// ArrayList<ErrorReport> erList = (ArrayList<ErrorReport>)request.getAttribute("erL");
DateTime d = new DateTime();
String [] str= d.dateTime1();
System.out.println("Date1: "+str[0]+"Date2: "+str[1]);


      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"timeline/timeline.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"timeline/timeline.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t    var timeline;\r\n");
      out.write("        // Calculate the color based on the given value.\r\n");
      out.write("        var hsv2rgb = function(H, S, V) {\r\n");
      out.write("            var R, G, B, C, Hi, X;\r\n");
      out.write("            C = V * S;\r\n");
      out.write("            Hi = Math.floor(H/60);  // hi = 0,1,2,3,4,5\r\n");
      out.write("            X = C * (1 - Math.abs(((H/60) % 2) - 1));\r\n");
      out.write("            switch (Hi) {\r\n");
      out.write("                case 0: R = C; G = X; B = 0; break;\r\n");
      out.write("                case 1: R = X; G = C; B = 0; break;\r\n");
      out.write("                case 2: R = 0; G = C; B = X; break;\r\n");
      out.write("                case 3: R = 0; G = X; B = C; break;\r\n");
      out.write("                case 4: R = X; G = 0; B = C; break;\r\n");
      out.write("                case 5: R = C; G = 0; B = X; break;\r\n");
      out.write("                default: R = 0; G = 0; B = 0; break;\r\n");
      out.write("            }\r\n");
      out.write("            return \"RGB(\" + parseInt(R*255) + \",\" + parseInt(G*255) + \",\" + parseInt(B*255) + \")\";\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        function drawVisualization() {\r\n");
      out.write("            var data = [];\r\n");
      out.write("\r\n");
      out.write("            ");
	DatewiseRecord tr = new DatewiseRecord();
				ArrayList<ArrayList<DatewiseRecord>> Main = new ArrayList<ArrayList<DatewiseRecord>>();
				Main = (ArrayList<ArrayList<DatewiseRecord>>)request.getAttribute("Mainlist");
				Iterator mIter = Main.iterator();
				Date date1 = new Date();
	        	String str1;
				Calendar cal = Calendar.getInstance();
    
				//System.out.println("\n\n");
				while(mIter.hasNext()){
					int cnt=0;
					ArrayList<DatewiseRecord> list = new ArrayList<DatewiseRecord>();
					list = (ArrayList<DatewiseRecord>) mIter.next();
					Iterator lt = list.iterator();
				//	System.out.println("\n");
					while(lt.hasNext())
					{
						tr = (DatewiseRecord) lt.next();
						//System.out.println("DRec date: "+tr.getDateOfEvent()+" DRec event: "+tr.getEvent());
						date1 = tr.getDateOfEvent();
						cal.setTime(date1);
						cnt++;
						str1 = tr.getEvent();
					}
			
      out.write("\t      \r\n");
      out.write("            var x = document.forms[0].Count.value;\r\n");
      out.write("            var count = ");
      out.print(cnt);
      out.write(";\r\n");
      out.write("            ");

            	//DateFormat outputFormatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
            	DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
				String output = outputFormatter.format(cal.getTime());
				Date date2 = outputFormatter.parse(output);
				System.out.println("date2 ndndn: "+date2);
			
      out.write("\r\n");
      out.write("\t\t\tvar d = new Date(");
      out.print(date2.getTime());
      out.write(");\r\n");
      out.write("            var hours = 24;\r\n");
      out.write("            var start = new Date(d);\r\n");
      out.write("            var end = new Date(d);\r\n");
      out.write("            end.setHours(end.getHours() + hours);\r\n");
      out.write("\r\n");
      out.write("            // create item with actual number\r\n");
      out.write("            // num = Math.round(Math.random() * maxNum);    // number of members available\r\n");
      out.write("            num = count; \r\n");
      out.write("            //height = Math.round(num / maxNum * 70 + 20); // a percentage, with a lower bound on 20%\r\n");
      out.write("            height = ((num/x)*100)+20; \r\n");
      out.write("            var hue = Math.min(Math.max(height, 20), 80) * 1.2; // hue between 0 (red) and 120 (green)\r\n");
      out.write("            var color = hsv2rgb(hue, 0.95, 0.95);\r\n");
      out.write("            var borderColor = hsv2rgb(hue, 0.9, 0.9);\r\n");
      out.write("            style = 'height:' + height + 'px;' +'background-color: ' + color + ';' +\r\n");
      out.write("                    'border-top: 2px solid ' + borderColor + ';';\r\n");
      out.write("            var actual = '<div class=\"bar\" style=\"' + style + '\" ' +\r\n");
      out.write("            \t\t\t'title=\"Actual: ' + num + ' Records\">' + num + '</div>';\r\n");
      out.write("              \r\n");
      out.write("            data.push({\r\n");
      out.write("                    'group': 'Number of Events Per Day',\r\n");
      out.write("                    'start': start,\r\n");
      out.write("                    'end': end,\r\n");
      out.write("                   // 'content': requirement + actual\r\n");
      out.write("                    'content': actual\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("            //data.push(item);\r\n");
      out.write("\t\t   /* var data = [];\r\n");
      out.write("\t          data.push({\r\n");
      out.write("              'start': new Date(2012, 1, 1),\r\n");
      out.write("              'end': new Date(2013, 2, 30),  // end is optional\r\n");
      out.write("              'content': 'Trajectory A'\r\n");
      out.write("              // Optional: a field 'group'\r\n");
      out.write("              // Optional: a field 'className'\r\n");
      out.write("              // Optional: a field 'editable'\r\n");
      out.write("            });*/\r\n");
      out.write("\r\n");
      out.write("            // specify options\r\n");
      out.write("            var options = {\r\n");
      out.write("                \"width\":  \"1060px\",\r\n");
      out.write("                \"height\": \"180px\",\r\n");
      out.write("                \"style\": \"box\"\r\n");
      out.write("            };\r\n");
      out.write("            \r\n");
      out.write("            // Instantiate our timeline object.\r\n");
      out.write("            timeline = new links.Timeline(document.getElementById('mytimeline'));\r\n");
      out.write("            // Draw our timeline with the created data and options\r\n");
      out.write("            timeline.draw(data, options);\r\n");
      out.write("            ");
	
			System.out.println("Count: "+cnt);
		}
      out.write("     \r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
      out.write("div.leftcolumn {  \r\n");
      out.write("\tborder: 1px; \r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin: 0.5em;\r\n");
      out.write("\twidth: 20em;\r\n");
      out.write("\theight: 20em;\r\n");
      out.write("}\r\n");
      out.write("div.rightcolumn {\r\n");
      out.write("\tbackground: #E6E7E3;\r\n");
      out.write("\tborder: 1px; \r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tpadding: 1em 0 0 1em;\r\n");
      out.write("\tmargin-left: 1em;\r\n");
      out.write("\twidth: 25em;\r\n");
      out.write("\theight: 18em;\r\n");
      out.write("\tfont-family: Calibri;\r\n");
      out.write("\topacity: 0.8;\r\n");
      out.write("\tfilter:alpha(opacity=80);\r\n");
      out.write("}\r\n");
      out.write("div.leftfloat{\r\n");
      out.write("\tbackground:#2E2E2E;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tpadding: 1em 0 1em 0;\r\n");
      out.write("\tmargin:0.1em;\r\n");
      out.write("\twidth:150px;\r\n");
      out.write("\theight:100%;\r\n");
      out.write("}\r\n");
      out.write("div.leftfull{\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tmargin:0.2em;\r\n");
      out.write("\twidth: 990px;\r\n");
      out.write("\theight: 300px;\r\n");
      out.write("}\r\n");
      out.write("div.rightfull{\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin:0.2em;\r\n");
      out.write("\twidth: 990px;\r\n");
      out.write("}\r\n");
      out.write("div.table{\r\n");
      out.write("\tmargin-top: 2em;\r\n");
      out.write("\tfont-family: Calibri;\r\n");
      out.write("}\r\n");
      out.write("div.Link{\r\n");
      out.write("\tfont-size: 1em;\r\n");
      out.write("\tmargin-left: 75em;\r\n");
      out.write("\tmargin-top: 4em;\r\n");
      out.write("\tfont-family:Calibri;\r\n");
      out.write("}\r\n");
      out.write(".evenrow{\r\n");
      out.write("    color: #000000;\r\n");
      out.write("    background-color: #D3D3D3;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    font-family: Calibri;\r\n");
      out.write("    font-size: 15px;\r\n");
      out.write(" }\r\n");
      out.write(".oddrow{\r\n");
      out.write("    color: #000000;\r\n");
      out.write("    background-color: #DCDCDC;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    font-family: Calibri;\r\n");
      out.write("    font-size: 15px;\r\n");
      out.write("    \r\n");
      out.write(" }\r\n");
      out.write(".button {\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    padding: 3px 5px;\r\n");
      out.write("    margin: 2em;\r\n");
      out.write("    border: 1px solid #000;\r\n");
      out.write("    background: #eee;\r\n");
      out.write("}\r\n");
      out.write("a:visited{color:#0000FF;}\r\n");
      out.write("a:hover{color:Red;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"drawVisualization()\">\r\n");
      out.write("\t<div class=\"top\">\r\n");
      out.write("\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t<div class=\"Link\">\r\n");
      out.write("\t\t\t\t<a href=\"LoginPage.jsp\"><font color=\"#ffffff\">Logout</font></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"background-color: ForestGreen; margin: 0.1em; width:100%; color: white;\" align=\"center\">\r\n");
      out.write("\t\tAnalysis Report\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"leftfloat\">\r\n");
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
      out.write("\t</div>\r\n");
      out.write("\t<br><div id=\"mytimeline\"></div><br>\r\n");
      out.write("<form>\r\n");
      out.write("\t<div class=\"rightfull\">\r\n");
      out.write("\t\t<div class=\"leftfull\">\r\n");
      out.write("\t\t\t<div class=\"leftcolumn\">\r\n");
      out.write("\t\t\t\t<img src=\"ChartController\"  width=\"450\" height=\"300\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"rightcolumn\">\t\r\n");
      out.write("\t\t\t\t<font size=\"4\"> Total number of records indexed: ");
      out.print(noOfrecords );
      out.write("\r\n");
      out.write("\t\t  \t\t");
if(searchQuery != ""){
      out.write("\r\n");
      out.write("\t\t\t \t<br>Frequency of Keyword: ");
      out.print(sResult.getFrequency());
      out.write("\r\n");
      out.write("\t\t\t\t<br> Percentage: ");
      out.print(analysis.getPercentage());
      out.write("\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t \t\t<br><br>  Earliest Record : ");
      out.print(str[0] );
      out.write("\r\n");
      out.write("\t\t \t\t<br> Latest Record : ");
      out.print(str[1]);
      out.write("</font><br><br>\r\n");
      out.write("\t\t\t\t<hr width=90%><br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<font size=\"4\">Error Details:</font>\r\n");
      out.write("\t\t\t\t");
 Iterator<ErrorInformation> it = li.iterator();
				ErrorInformation ei = new ErrorInformation();
				while(it.hasNext()){
				ei = (ErrorInformation)it.next();
				
      out.write("\r\n");
      out.write("\t\t\t\t<br><font size=\"4\">Error ");
      out.print(ei.getErrorType() );
      out.write("\r\n");
      out.write("\t\t\t\t: Frequency   ");
      out.print(  ei.getNumber() );
      out.write("</font>\r\n");
      out.write("\t\t\t\t");
	}
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div><br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<input name=\"Count\" value=\"");
      out.print(count);
      out.write("\" type=\"hidden\">\r\n");
      out.write("\t\t<a href=\"PatternController\" class=\"button\">View Pattern</a>\r\n");
      out.write("\t\t<a href=\"RecordListController\" class=\"button\">View Records</a>\r\n");
      out.write("\t\t<a href=\"PdfTrial\" class=\"button\">Save as pdf</a>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
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
