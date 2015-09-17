<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
function validateForm(form){
	var nPass = form.npass.value;
	var rPass = form.rpass.value;
	
	if(nPass=='' || nPass==null){
		alert("Please enter new password.");
		return false;
	}
	if(rPass=='' || rPass==null){
		alert("Please confirm new password.");
		return false;
	}
}

function checkpassword(){
	var pswd=document.forms[0].npass.value;
	var repswd=document.forms[0].rpass.value;
	
	if(pswd != repswd){
		alert("Please confirm the new password correctly.");
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
div.square{
	float:left;
	padding: 3em 3em 3em 3em;
	background-color:#E6E7E3;
	margin-top:0.5em;
	margin-right:auto;
	margin-left:8em;
	width: 500px;
	height:auto;
	opacity: 0.8;
	filter:alpha(opacity=80);
}
</style>
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
			<a href="LoginPage.jsp"><font color="#ffffff">LogOut</font></a>
		</div>
	</div>
</div>
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Change Password
</div>

<div class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<form action="ChangePasswordController" onsubmit="return validateForm(this)">
<div class="square">
	<font size="4" color="red"><%=message%></font><br>
	<font size="4">Current password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : </font><input type="password" name="cpass"/><br><br>
	<font size="4">New password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </font><input type="password" name="npass"/><br><br>
	<font size="4">Confirm new password : </font><input type="password" name="rpass" onblur="checkpassword()"/><br><br>
	
	<input type="submit" value="Change Password"/>
</div>
</form>
</body>
</html>