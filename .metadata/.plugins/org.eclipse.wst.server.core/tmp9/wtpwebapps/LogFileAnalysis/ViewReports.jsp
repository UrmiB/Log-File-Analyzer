<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	width:150px;
	height:500px;
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
<div id="menu" class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>

</body>
</html>