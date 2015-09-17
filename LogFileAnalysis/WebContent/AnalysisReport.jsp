<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cummins.project734.entity.AnalysisData"%>
<%@page import="com.cummins.project734.entity.SearchResult"%>
<%@page import="com.cummins.project734.dateTime.*" %>
<%@page import="com.cummins.project734.entity.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page  import = "java.awt.*" %>
<%@ page  import = "java.io.*" %>
<%@ page  import = "org.jfree.chart.*" %>
<%@ page  import = "org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>
<%@ page  import = "java.awt.image.*" %>
<%@ page  import = "javax.imageio.ImageIO" %>
<%@ page  import = "java.util.List" %>
<%@ page  import = "java.util.ArrayList" %>
<%@ page  import = "java.util.*" %>
<%@ page import="java.text.DateFormat"%> 
<%@ page import="java.text.SimpleDateFormat" %>

<%
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

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="timeline/timeline.js"></script>
<link rel="stylesheet" type="text/css" href="timeline/timeline.css">

<script type="text/javascript">

	    var timeline;
        // Calculate the color based on the given value.
        var hsv2rgb = function(H, S, V) {
            var R, G, B, C, Hi, X;
            C = V * S;
            Hi = Math.floor(H/60);  // hi = 0,1,2,3,4,5
            X = C * (1 - Math.abs(((H/60) % 2) - 1));
            switch (Hi) {
                case 0: R = C; G = X; B = 0; break;
                case 1: R = X; G = C; B = 0; break;
                case 2: R = 0; G = C; B = X; break;
                case 3: R = 0; G = X; B = C; break;
                case 4: R = X; G = 0; B = C; break;
                case 5: R = C; G = 0; B = X; break;
                default: R = 0; G = 0; B = 0; break;
            }
            return "RGB(" + parseInt(R*255) + "," + parseInt(G*255) + "," + parseInt(B*255) + ")";
        };

        function drawVisualization() {
            var data = [];

            <%	DatewiseRecord tr = new DatewiseRecord();
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
			%>	      
            var x = document.forms[0].Count.value;
            var count = <%=cnt%>;
            <%
            	//DateFormat outputFormatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
            	DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
				String output = outputFormatter.format(cal.getTime());
				Date date2 = outputFormatter.parse(output);
				System.out.println("date2 ndndn: "+date2);
			%>
			var d = new Date(<%=date2.getTime()%>);
            var hours = 24;
            var start = new Date(d);
            var end = new Date(d);
            end.setHours(end.getHours() + hours);

            // create item with actual number
            // num = Math.round(Math.random() * maxNum);    // number of members available
            num = count; 
            //height = Math.round(num / maxNum * 70 + 20); // a percentage, with a lower bound on 20%
            height = ((num/x)*100)+20; 
            var hue = Math.min(Math.max(height, 20), 80) * 1.2; // hue between 0 (red) and 120 (green)
            var color = hsv2rgb(hue, 0.95, 0.95);
            var borderColor = hsv2rgb(hue, 0.9, 0.9);
            style = 'height:' + height + 'px;' +'background-color: ' + color + ';' +
                    'border-top: 2px solid ' + borderColor + ';';
            var actual = '<div class="bar" style="' + style + '" ' +
            			'title="Actual: ' + num + ' Records">' + num + '</div>';
              
            data.push({
                    'group': 'Number of Events Per Day',
                    'start': start,
                    'end': end,
                   // 'content': requirement + actual
                    'content': actual
                    });

            //data.push(item);
		   /* var data = [];
	          data.push({
              'start': new Date(2012, 1, 1),
              'end': new Date(2013, 2, 30),  // end is optional
              'content': 'Trajectory A'
              // Optional: a field 'group'
              // Optional: a field 'className'
              // Optional: a field 'editable'
            });*/

            // specify options
            var options = {
                "width":  "1060px",
                "height": "180px",
                "style": "box"
            };
            
            // Instantiate our timeline object.
            timeline = new links.Timeline(document.getElementById('mytimeline'));
            // Draw our timeline with the created data and options
            timeline.draw(data, options);
            <%	
			System.out.println("Count: "+cnt);
		}%>     
   }
</script>

<style type="text/css">
body{
	background:#fff;
}
div.top{
	background:#2E2E2E;
	width:100%;
	height:100px;
	margin:0.2em;
}
div.title{
	background-image:url(Images/Logo.png);
	width:100px;
	height:100px;
}
div.leftcolumn {  
	border: 1px; 
	float: left;
	margin: 0.5em;
	width: 20em;
	height: 20em;
}
div.rightcolumn {
	background: #E6E7E3;
	border: 1px; 
	float: right;
	padding: 1em 0 0 1em;
	margin-left: 1em;
	width: 25em;
	height: 18em;
	font-family: Calibri;
	opacity: 0.8;
	filter:alpha(opacity=80);
}
div.leftfloat{
	background:#2E2E2E;
	float:left;
	padding: 1em 0 1em 0;
	margin:0.1em;
	width:150px;
	height:100%;
}
div.leftfull{
	float: right;
	margin:0.2em;
	width: 990px;
	height: 300px;
}
div.rightfull{
	float: left;
	margin:0.2em;
	width: 990px;
}
div.table{
	margin-top: 2em;
	font-family: Calibri;
}
div.Link{
	font-size: 1em;
	margin-left: 75em;
	margin-top: 4em;
	font-family:Calibri;
}
.evenrow{
    color: #000000;
    background-color: #D3D3D3;
    text-align: center;
    font-family: Calibri;
    font-size: 15px;
 }
.oddrow{
    color: #000000;
    background-color: #DCDCDC;
    text-align: center;
    font-family: Calibri;
    font-size: 15px;
    
 }
.button {
    display: inline-block;
    padding: 3px 5px;
    margin: 2em;
    border: 1px solid #000;
    background: #eee;
}
a:visited{color:#0000FF;}
a:hover{color:Red;}
</style>

</head>
<body onload="drawVisualization()">
	<div class="top">
		<div class="title">
			<div class="Link">
				<a href="LoginPage.jsp"><font color="#ffffff">Logout</font></a>
			</div>
		</div>
	</div>
	<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Analysis Report
	</div>
	<div class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
	</div>
	<br><div id="mytimeline"></div><br>
<form>
	<div class="rightfull">
		<div class="leftfull">
			<div class="leftcolumn">
				<img src="ChartController"  width="450" height="300"/>
			</div>
			
			<div class="rightcolumn">	
				<font size="4"> Total number of records indexed: <%=noOfrecords %>
		  		<%if(searchQuery != ""){%>
			 	<br>Frequency of Keyword: <%=sResult.getFrequency()%>
				<br> Percentage: <%=analysis.getPercentage()%>
				<%} %>
		 		<br><br>  Earliest Record : <%=str[0] %>
		 		<br> Latest Record : <%=str[1]%></font><br><br>
				<hr width=90%><br>
			
				<font size="4">Error Details:</font>
				<% Iterator<ErrorInformation> it = li.iterator();
				ErrorInformation ei = new ErrorInformation();
				while(it.hasNext()){
				ei = (ErrorInformation)it.next();
				%>
				<br><font size="4">Error <%=ei.getErrorType() %>
				: Frequency   <%=  ei.getNumber() %></font>
				<%	}%>
			</div>
		</div><br><br>
	
		<input name="Count" value="<%=count%>" type="hidden">
		<a href="PatternController" class="button">View Pattern</a>
		<a href="RecordListController" class="button">View Records</a>
		<a href="PdfTrial" class="button">Save as pdf</a>
</div>
</form>
</body>
</html>