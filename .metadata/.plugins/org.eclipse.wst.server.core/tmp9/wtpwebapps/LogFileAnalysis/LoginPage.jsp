<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogFileAnalysis: Login</title>
<script type="text/javascript">
function validateForm(form)
{
	var user = form.userid.value;
	var pswd = form.pswrd.value;
	if (user=='' || user==null || pswd=='' || pswd==null)
	  {
	  	alert("Please enter the Username and Password."); 	
	  	return false;
	  }
}
</script>

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
div.x{
	padding:25px 25px;
	background-color:#E6E7E3;
	font-family:Calibri;
	padding: 5em 0 0 3em;
	margin-top: 3em;
	margin-left: 30em;
	width: 20em;
	height: 15em;
	opacity: 0.7;
	filter:alpha(opacity=70);
}
div.leftfloat{
	background:#2E2E2E;
	float:left;
	margin:0.1em;
	width:140px;
	height:400px;
}
input.btn {   
	font-weight: bold;
	font-family: Calibri;
	font-size: 15px;
	margin:0.5em;
}
div.Link{
	font-size: 1em;
	margin-left: 70em;
	margin-top: 3.5em;
	font-family:Calibri;
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
<body>
<div class="top">
	<div class="title">
		<div class="Link">
			<a href="MainPage.jsp"><font color="#ffffff">Main_Page</font></a>
			<a href="CreateAccount.jsp"><font color="#ffffff">Create_Account</font></a>
		</div>
	</div>
</div>
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Login
</div>	
<div class="leftfloat"></div>
		<font size="3" color="red"><%=message%></font><br>

	<div class="x">
	<form action="LoginController" onsubmit="return validateForm(this)"  >
		<font class="label" size="3" color="black">Username</font>&nbsp;&nbsp;&nbsp;<input type="text" id="user"name="userid"/><br>
		<br>
		<font class="label" size="3" color="black">Password</font>&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="pswrd"/><br><br>
		<font size="3" color="red"><%=errorMessage%></font><br>
		<input type="submit" class="btn" style="height: 30px; width: 90px" value="Login"/>
		&nbsp;&nbsp;
		<input type="reset" class="btn" style="height: 30px; width: 90px" value="Cancel"/>
	</form>
	</div>
</body>
</html>