<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
function validateForm(form){
	
	var fname = form.firstname.value;
	var lname = form.lastname.value;
	var contact = form.contact.value;
	var email = form.email.value;
	var username = form.user.value;
	var pswd = form.password.value;
	var repswd = form.repassword.value;

	var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");
	
	if(fname=='' || fname==null){
		alert("Please enter the first name.");
		return false;
	}
	if(lname=='' || lname==null){
		alert("Please enter the last name.");
		return false;
	}
	if(contact=='' || contact==null || isNaN(contact)|| contact.indexOf(" ")!=-1){
		alert("Please enter correct contact number.");
		return false;
	}
	if(username=='' || username==null){
		alert("Please enter the username.");
		return false;
	}
	if(pswd=='' || pswd==null){
		alert("Please enter the password.");
		return false;
	}
	if(repswd=='' || repswd==null){
		alert("Please confirm new password.");
		return false;
	}
	if(email=='' || email==null){
		alert("Please enter the email address.");
		return false;
	}else if(atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
		alert("Not a valid e-mail address");
	 	return false;
	}
}

function checkpassword(){
	var pswd=document.forms[0].password.value;
	var repswd=document.forms[0].repassword.value;
	
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
h1{
	font-size:2em;
	color:#000;
	text-transform:uppercase;
	font-family:Calibri;
}
div.square1{
	margin-top: 1em;
	margin-left: 20em;
	width: 50em;
	height: 5em;
	opacity: 0.8;
	filter:alpha(opacity=80);
	padding: 1em 1em 1em 1em;
}
div.square{
	margin-left: 20em;
	width: 50em;
	height: 30em;
	opacity: 0.6;
	filter:alpha(opacity=60);
	padding: 1em 1em 1em 1em;
}
div.square2{	
	margin-left: 20em;
	width: 50em;
	height: 4em;
	opacity: 0.8;
	filter:alpha(opacity=80);
	padding: 1em 1em 1em 1em;
}
div.leftfloat{
	background:#2E2E2E;
	float:left;
	margin:0.1em;
	width:140px;
	height:750px;
}
div.x{
	padding:25px 25px;
	background-color:#E6E7E3;
	font-family:Calibri;
}
input.btn {   
	font-weight: bold;
	font-family: Calibri;
	font-size: 15px;
	margin-left: 1em;
}
div.Link{
	font-size: 1em;
	margin-left: 73em;
	margin-top: 4em;
	font-family:Calibri;
}
</style>
<%
String errorMessage = "";
errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage==null){
	errorMessage = " ";
}
%>
</head>
<body>
<div class="top">
	<div class="title">
		<div class="Link">
			<a href="MainPage.jsp"><font color="#ffffff">Main_Page</font></a>
		</div>
	</div>
</div>
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Create Account
</div>
<div id="menu" class="leftfloat"></div>
	<div class="square1">
		<div class="x">
		<h1>&nbsp;Registration Form</h1>
		</div>
	</div>
<form action="CreateAccountController" onsubmit="return validateForm(this)">
	<div class="square">
	<div class="x">
		<font color="red" size="2">*</font>&nbsp;<font color="black" size="2">Marked fields are compulsory to fill.</font><br><br><br>
		<font size = "2" color="red"><%=errorMessage%></font>
		<font size="3">First Name:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="firstname"/> <br><br>
		<font size="3">Last Name:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="lastname"/> <br><br>
		<font size="3">Contact Number:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="contact"/> <br><br>
		<font size="3">Email Id:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="email"/><br><br>
		<hr width=90%><br>
		<font size="3">User Name:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="user"/><br><br>
		<font size="3">Password:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="password" name="password"/><br><br>
		<font size="3">Re-enter Password:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="password" name="repassword" onblur="checkpassword()"/><br><br>
		<hr width=90%><br>
		<font size="2">By clicking Submit you agree to LogFileAnalysis </font><a href="TermsConditions.jsp"><font color="black" size="2"><b>Terms and Conditions</b></font></a>
	</div>
	</div>
	<div class="square2">
	<div class="x">
		<input type="submit" class="btn" style="height: 30px; width: 100px" value="Submit"/>&nbsp;&nbsp;&nbsp;
		<input type="reset" class="btn" style="height: 30px; width: 100px" value="Cancel"/>
	</div>
	</div>
</form>
</body>
</html>