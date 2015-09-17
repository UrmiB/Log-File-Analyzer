<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
String fname = (String)request.getAttribute("fname");
String lname = (String)request.getAttribute("lname");
String contact= (String)request.getAttribute("contact");
String email = (String)request.getAttribute("email");
%>

<script type="text/javascript">
function show_confirm(){
	var choice = confirm("Are you sure?");
	if(choice){
		return true;
	}else{
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
.button {
    display: inline-block;
    padding: 3px 5px;
    margin: 2em;
    border: 1px solid #000;
    background: #eee;
}
a:visited{color:#0000FF;}
a:hover{color:Red;}
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
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		User Profile
</div>

<div class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<div class="square">
	<font size="5"><b><u>User Information</u></b></font><br><br><br>
	<font size="4"><b>First Name : <%=fname%></b></font><br><br>
	<font size="4"><b>Last Name : <%=lname%></b></font><br><br>
	<font size="4"><b>Contact&nbsp;&nbsp;&nbsp;&nbsp; : <%=contact%></b></font><br><br>
	<font size="4"><b>Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <%=email%></b></font><br><br>
	
	<a href="ChangePassword.jsp" class="button">Change Password</a>
	<a href="AccountDeleteController" class="button" onclick="return show_confirm()">Delete Account</a>
</div>
</body>
</html>