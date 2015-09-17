<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript">
function validateForm(form){
	var from = form.fromDate.value;
	var to = form.toDate.value;
	if((from=='' || from==null)&&(to=='' || to==null)){
		return true;
	}else{
		if(to<from || to == from){
			alert("Please enter correct date range.");
			return false;
		}
	}
}
</script>

<script language="javascript" type="text/javascript" src="datetimepick/datetimepicker.js"></script>
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
div.square{
	float:left;
	padding: 3em 3em 3em 3em;
	margin-right:auto;
	margin-left:8em;
	width: 700px;
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
div.Link{
	font-size: 1em;
	margin-left: 75em;
	margin-top: 4em;
	font-family:Calibri;
}
div.x{
	padding:25px 25px;
	background-color:#E6E7E3;
	font-family:Calibri;
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
		Search File
</div>
<div id="menu" class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<div class="square">
<div class="x">
	<form action = "SearchIndexController" onsubmit="return validateForm(this)">
		<font size="4">Search: </font><input type="text" name="searchQuery" style="height: 20px; width: 200px;"><img src="Images/search4.gif"><br><br>
		<font size="4">From Date:</font>
		<input name="fromDate" id="fromDate"  maxlength="25" type="text" readonly="readonly"/>&nbsp;&nbsp;
		<a href="javascript:NewCal('fromDate','ddmmyyyy','','')">
			<img src="datetimepick/cal.gif"  width="16" height="16" border="0" alt="Pick a date"/>
		</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<font size="4">To Date:</font>
		<input name="toDate" id="toDate"  maxlength="25" type="text" readonly="readonly"/>&nbsp;&nbsp;
		<a href="javascript:NewCal('toDate','ddmmyyyy','','')">
			<img src="datetimepick/cal.gif"  width="16" height="16" border="0" alt="Pick a date"/>
		</a><br><br><br>
		<%
			String jspPath="";
			String filename="";
			if(request.getParameter("jspPath")==null){
				jspPath = request.getAttribute("jspPath").toString();
			}
			else{
				jspPath = request.getParameter("jspPath").toString();	
			}
			System.out.println("jspPath in searchindex.jsp: "+jspPath);
			if(jspPath.equalsIgnoreCase("ExistingFiles")){	
				filename = request.getParameter("id");
			}
			else{
				filename = request.getSession().getAttribute("filename").toString();
			}
			System.out.println("filename in searchindex.jsp: "+filename);
		%>
		<input name="filename" value="<%=filename%>" type="hidden">
		<input name="jspPath" value="SearchIndex" type="hidden">
		<div align="center">
			<input type="submit" value="Analyze" style="height: 40px; width: 90px">
			&nbsp;&nbsp;	
			<input type="reset" style="height: 40px; width: 90px" value="Reset Value"/>				
		</div>
	</form>
	</div>
</div>
</body>
</html>