<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">

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
	float:right;
	margin:0.2em;
}

h1{
	margin-left: 5em;
}
</style>
<%
String errorMessage = "";
errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage==null){
	errorMessage=" ";
}	
%>

<%
String message = "";
message = (String)request.getAttribute("message");
if(message==null){
	message=" ";
}	
%>

</head>
<body onLoad="del()">
<div class="top">
	<div class="title">
		<div class="Link">
			<a href="LoginPage.jsp"><font color="#ffffff">Logout</font></a>
		</div>
	</div>
</div>
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Home Menu
</div>
<%String name = (String)session.getAttribute("UserName");%>
	<h1><font face="Calibri" size="4">Welcome <%=name%>,</font></h1>
<font size="4" color="red"><%=errorMessage%></font><br>
<font size="4" color="red"><%=message%></font><br>
<div id="menu" class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<div class="square">
	<marquee behavior="slide" direction="left" scrollamount="15" loop="100" onmousedown="this.stop();" onmouseup="this.start();">
	<img src="Images/Marquee1.jpg" width="900" height="500" />
	<img src="Images/Marquee2.jpg" width="900" height="500" />
</marquee>        

</div>
</body>
</html>