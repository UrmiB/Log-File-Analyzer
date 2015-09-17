<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.cummins.project734.entity.*" %>

<%
ArrayList<String> RecordList = new ArrayList<String>();
ArrayList<ErrorReport> ErrorList = new ArrayList<ErrorReport>();

RecordList = (ArrayList<String>)request.getAttribute("Recordlist");
String query = (String)request.getAttribute("query");
ErrorList = (ArrayList<ErrorReport>)request.getAttribute("erlist");

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="paging.js"></script>

<%@ page  import = "java.util.*" %>
<style type="text/css">
body{
	background:#fff;
}
div.title{
	background-image:url(Images/Logo.png);
	width:100px;
	height:100px;
}
div.top{
	background:#2E2E2E;
	width:100%;
	height:100px;
	margin:0.2em;
}
div.Link{
	font-size: 1em;
	margin-left: 73em;
	margin-top: 4em;
	font-family:Calibri;
}
div.leftfloat{
	background:#2E2E2E;
	float:left;
	padding: 1em 0 1em 0;
	margin:0.1em;
	width:150px;
	height:100%;
}
div.rightfloat{
	float:left;
	width: 990px;
	background-color:#E6E7E3;
	font-family:Calibri;
	padding: 1em 1em 1em 1em;
	margin-top: 0.2em;
	margin-left: 2em;
	opacity: 0.7;
	filter:alpha(opacity=70);
	
}
div.table{
	margin-top: 1em;
	font-family: Calibri;
}
.evenrow{
    color: #000000;
    background-color: DarkGrey;
    text-align: center;
    font-family: Calibri;
    font-size: 15px;
 }
.oddrow{
    color: #000000;
    background-color: WhiteSmoke;
    text-align: center;
    font-family: Calibri;
    font-size: 15px;
    
 }
.pg-normal {
    color: black;
    font-weight: normal;
	text-decoration: none;    
    cursor: pointer;    
}
.pg-selected {
    color: black;
    font-weight: bold;        
    text-decoration: underline;
    cursor: pointer;
}
</style>
</head>
<body>

<div class="top">
	<div class="title">
		<div class="Link">
			<a href="LoginPage.jsp"><font color="#ffffff">LogOut</font></a>
		</div>
	</div>
</div>
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Records
	</div>
<div class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<div class="rightfloat">
<div class="table">
			<table id="records">
			<tr>
				<td><font size="4"><b>Records</b></font></td>
			</tr>
			<%if(query != ""){
			Iterator<String> iterator = RecordList.iterator();
			List<Integer> fieldArray = new ArrayList<Integer>();
			fieldArray = (ArrayList<Integer>)request.getAttribute("FieldArray");
				
	    	while(iterator.hasNext()){
	           // System.out.println(iterator.next());
	    		int lowerbound=0;
				int sum=0;
				int upperbound=0;
				int ct=0;
				String field;
	        	field= iterator.next();
	        	Iterator fieldLenIter = fieldArray.iterator();
	        	ct++;
			%>
			<tr <%if (ct%2 == 0) {%> class="evenrow" <%} else {%> class="oddrow"<%}%>>
			<%
				while(fieldLenIter.hasNext()){
				int temp = (Integer) fieldLenIter.next();
				lowerbound=sum;
				sum=sum+temp;
				upperbound=sum;
				//dateList.add(strLine.substring(lowerbound, upperbound));
			%>		
			<td><font size="3"><%= field.substring(lowerbound, upperbound)%></font></td>
			<%}%>
			<td><font size="3"><%= field.substring(upperbound, field.length())%></font></td>
			</tr>
			<%}}else{
	  			Iterator<ErrorReport> it1 = ErrorList.iterator();
	  			List<Integer> fieldArray = new ArrayList<Integer>();
				fieldArray = (ArrayList<Integer>)request.getAttribute("FieldArray");
	  			int ct =0;
	  			ErrorReport erRep = new ErrorReport();
				while(it1.hasNext()){
				int lowerbound=0;
				int sum=0;
				int upperbound=0;
				String field="";
	            Iterator fieldLenIter = fieldArray.iterator();
				erRep = (ErrorReport) it1.next();
				ct++;
			%>
			<tr<%if (ct%2 == 0) {%> class="evenrow" <%} else {%> class="oddrow"<%}%>>
			<%
				while(fieldLenIter.hasNext()){
					int temp = (Integer) fieldLenIter.next();
					lowerbound=sum;
					sum=sum+temp;
					upperbound=sum;
					field =erRep.getErrorRecord();
					//dateList.add(strLine.substring(lowerbound, upperbound));
			%>
			<td><font size="3"><%=field.substring(lowerbound, upperbound)%></font></td>
			<%}%>
			<td><font size="3"><%= erRep.getErrorRecord().substring(upperbound, field.length())%></font></td>
			</tr>	
		<%}}%>
			</table>
			<br><br>
			<div id="pageNavPosition" align="center"></div>
			<script type="text/javascript">
				var pager = new Pager('records', 8); 
				pager.init(); 
				pager.showPageNav('pager', 'pageNavPosition'); 
				pager.showPage(1);
			</script>
			
		</div>
</div>

</body>
</html>