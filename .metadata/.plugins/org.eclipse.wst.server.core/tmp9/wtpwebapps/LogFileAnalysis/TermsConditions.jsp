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
div.title{
	background-image:url(Images/title.jpg);
	width:150px;
	height:100px;
}
div.top{
	background:#2E2E2E;
	width:1260px;
	height:100px;
}
div.square{
	background:#fff;
	margin-left: 15em;
	width: 50em;
	height: 50em;
	opacity: 0.6;
	filter:alpha(opacity=60);
	padding: 1em 0 0 2em;
}
div.square1{
	background:#fff;
	margin-top: 10em;
	margin-left: 15em;
	width: 50em;
	height: 4em;
	opacity: 0.8;
	filter:alpha(opacity=80);
	padding: 1em 0 0 2em;
}
h1{
	font-size:1.7em;
	font-style: italic;
	color:#000;
	text-transform:uppercase;
	/*font-family: algerian;*/
}
div.Link{
	font-size: 1.2em;
	font-style: italic;
	font-weight: bold;
	margin-left: 55em;
	margin-top: 1em;
}
</style>
</head>
<body>
<div class="top">
	<div class="title">
		<div class="Link">
			<a href="MainPage.jsp"><font color="#ffffff">Main_Page</font></a>
		</div>
	</div>
</div>
	<div class="square1">
		<h1>Terms and Conditions</h1>
	</div>
	<div class="square">
		<font size="4">
		1.<br><br>
		2.<br></font>
	</div>
</body>
</html>