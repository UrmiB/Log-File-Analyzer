<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body{
	background-image:url(Images/blue2.jpg);
	height: 1150px;
	width: 1100px;
}
div.square{
	background:#fff;
	padding: 5em 0 0 3em;
	margin-top: 6em;
	margin-left: 30em;
	width: 20em;
	height: 15em;
	opacity: 0.7;
	filter:alpha(opacity=70);
}
h1{
	font-size:3em;
	font-style: italic;
	/*font-family: algerian;*/
	color:#fff;
	text-transform:uppercase;
	margin-left: 11em;
	margin-top: 3em;
}
input.btn {   
	font-weight: bold;
	font-family: Courier;
	font-size: 15px;
}
div.Link{
	font-size: 1.2em;
	font-style: italic;
	font-weight: bold;
	margin-left: 10em;
	margin-top: 3em;
}
/*font.label{
	font-family: Courier;
}*/
</style>
</head>
<body>
	<div class="Link">
		<a href="MainPage.jsp"><font color="#ffffff">Go back to Main Page</font></a>
	</div>
<h1>Login Page</h1>
<div class="square">
		<font class="label" size="5" color="black">Username</font>&nbsp;&nbsp;&nbsp;<input type="text" name="userid"/><br><br>
		<br>
		<font class="label" size="5" color="black">Password</font>&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="pswrd"/><br><br>
		<br>	
		<input type="submit" class="btn" style="height: 30px; width: 100px" value="Login"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" class="btn" style="height: 30px; width: 100px" value="Cancel"/>
	</form>
</div>
</body>
</html>