<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page  import = "java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body{
	background-image:url(Images/image.jpg);
	height: 1150px;
	width: 1100px;
}
div.top{
	background:#2E2E2E;
	width:1260px;
	height:100px;
}
div.title{
	background-image:url(Images/title.jpg);
	width:150px;
	height:100px;
}
div.Link{
	font-size: 1.2em;
	font-style: italic;
	font-weight: bold;
	margin-left: 60em;
	margin-top: 2em;
}
div.leftfloat{
	background:#2E2E2E;
	float:left;
	margin:0.5em;
	width:150px;
	height:500px;
}
div.square{
	float:right;
	padding: 2em 0 0 2em;
	margin:0.5em;
	width: 50em;
	height: 26.5em;
	opacity: 0.8;
	filter:alpha(opacity=80);
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
<br><br>
<div class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<div class="square">
<div class="table">

	<table border="1" width="1020">
		<tr>
		<td width="200"><font size="4"><b>Records</b></font></td>
		</tr>
	<%List<String> l1 = new ArrayList<String>();
	l1 = (ArrayList<String>) request.getAttribute("list1");
	Iterator itl = l1.iterator();
	while(itl.hasNext()){%>
		<tr>
  		<td><font size="3"><%= itl.next()%></font></td>
		</tr>
	<%}%>
	</table>
	</div>
</div>
</body>
</html>