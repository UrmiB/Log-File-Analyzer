<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page   import="com.cummins.project734.dbHelper.ExistingFileHelper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page  import = "java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
div.Link{
	font-size: 1em;
	margin-left: 75em;
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
div.square{
	float:left;
	padding: 3em 3em 3em 3em;
	margin-right:auto;
	margin-left:8em;
	width: 500px;
	opacity: 0.8;
	filter:alpha(opacity=80);
}
div.x{
	padding:25px 25px;
	background-color:#E6E7E3;
	font-family:Calibri;
}
a:visited{color:#0000FF;}
a:hover{color:Red;}

</style>
</head>
<body>
<div class="top">
	<div class="title">
		<div class="Link">
			<a href="LoginPage.jsp"><font color="#ffffff">Logout</font></a>
		</div>
	</div>
</div>
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Open File
</div>	
<div id="menu" class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<div class="square">
<div class="x">

<B>FILES:</B>
<br><br>
<%
ArrayList<String> efiles = new ArrayList<String>();
efiles = (ArrayList<String>) request.getAttribute("EFiles");
String myString="";
if(efiles.isEmpty()==false)
{
	for(int i = 0; i < efiles.size(); i++) 
	{ 
	 	myString = (String) efiles.get(i);%>
	 	<a href="SearchIndex.jsp?id=<%=myString%>&jspPath=ExistingFiles"><%=myString%></a>
	 	<br>
	<%}
}
%>
</div>
</div>
</body>
</html>