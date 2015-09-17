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
h1{
	font-size:2.2em;
	font-style: italic;
	color:#000;
	text-transform:uppercase;
	/*font-family: algerian;*/
}
div.square1{
	background:#fff;
	margin-top: 12em;
	margin-left: 15em;
	width: 50em;
	height: 5em;
	opacity: 0.8;
	filter:alpha(opacity=80);
	padding: 1em 0 0 2em;
}
div.square{
	background:#fff;
	margin-left: 15em;
	width: 50em;
	height: 45em;
	opacity: 0.6;
	filter:alpha(opacity=60);
	padding: 1em 0 0 2em;
}
div.square2{
	background:#fff;
	margin-left: 15em;
	width: 50em;
	height: 4em;
	opacity: 0.8;
	filter:alpha(opacity=80);
	padding: 1em 0 0 2em;
}
input.btn {   
	font-weight: bold;
	font-family: Courier;
	font-size: 15px;
}
</style>
</head>
<body>
	<div class="square1">
		<h1>&nbsp;Registration Form</h1>
	</div>
	<div class="square">
		<font color="red" size="3">*</font>&nbsp;<font color="black" size="3">Marked fields are compulsory to fill.</font><br><br><br>
		<font size="5">First Name:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="firstname"/> <br><br>
		<font size="5">Last Name:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="lastname"/> <br><br>
		<font size="5">Contact Number:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="contact"/> <br><br>
		<font size="5">Gender:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="radio" name="gender" value="male"><font color="white" size="4">Male</font>&nbsp;&nbsp; <input type="radio" name="gender" value="female"><font color="white" size="4">Female</font><br><br>
		<font size="5">Email Id:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="email"/><br><br>
		<font size="5">Alternate Email Id:</font>&nbsp;&nbsp;<input type="text" name="a-email"/><br><br>
		<hr width=90%><br>
		<font size="5">User Name:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="user"/><br><br>
		<font size="5">Password:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="password" name="password"/><br><br>
		<font size="5">Re-enter Password:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="password" name="repassword"/><br><br>
		<font size="5">Security Question:<font color="red" size="3">*</font></font>&nbsp;&nbsp;
		<select>
 	 		<option value="option">Options</option>
  			<option value="school">What is your School name?</option>
  			<option value="destination">What is your Favourite destination?</option>
		</select><br><br>
		<font size="5">Answer:<font color="red" size="3">*</font></font>&nbsp;&nbsp;<input type="text" name="answer"/><br><br>
		<hr width=90%><br>
		<font size="3">By clicking Submit you agree to LogFileAnalysis </font><a href="TermsConditions.jsp"><font color="black" size="3"><b>Terms and Conditions</b></font></a>
	</div>
	<div class="square2">
		<input type="submit" class="btn" style="height: 30px; width: 100px" value="Submit"/>&nbsp;&nbsp;&nbsp;
		<input type="reset" class="btn" style="height: 30px; width: 100px" value="Cancel"/>
	</div>
</body>
</html>