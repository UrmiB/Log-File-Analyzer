<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body{

	background:#fff;
}
div.top{
	background:#2E2E2E;
	width:100%;
	height:100px;
	margin:0.1em;
}
h1{
	font-size:1em;
	font-style: italic;
	color:#fff;
	margin-left: 3em;
	margin-top: 2em;
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
	float:left;
	padding: 3em 3em 3em 3em;
	background-color:#E6E7E3;
	margin-top:1em;
	margin-right:auto;
	margin-left:8em;
	width: 500px;
	height:auto;
	opacity: 0.8;
	filter:alpha(opacity=80);
}
div.x{
	padding:25px 25px;
	background-color:#E6E7E3;
	font-family:Calibri;
}
div.title{
	background-image:url(Images/Logo.png);
	width:100px;
	height:100px;
}
</style>

<script type="text/javascript">
	/* function toggle(selObj){
		textObj = document.getElementById("opr");
		add = document.getElementById("add");
		remove = document.getElementById("remove");
		if(selObj.options[selObj.selectedIndex].value == "delimiter")
		{
			textObj.disabled = false;
			add.disabled = true;
			remove.disabled = true;
		}
		else if(selObj.options[selObj.selectedIndex].value == "fieldLength"){
			textObj.value = " ";
			textObj.disabled = true;
			add.disabled = false;
			remove.disabled = false;
		}
		else{
			textObj.value = " ";
			textObj.disabled = true;
			add.disabled = true;
			remove.disabled = true;
		}	
	} */
	function incrementCount() {
		document.frm.count.value = parseInt(document.frm.count.value) + 1;
		addTextBox();
	}
	function decCount() {
		document.frm.count.value = parseInt(document.frm.count.value) - 1;
		removeTextBox();
	}
	function addTextBox() {
		var form = document.frm;
		//var cnt = document.frm.count.value;
		form.appendChild(document.createElement('div')).innerHTML = "Field Length: <input type=\"text\" name=\"txt\">";
	}
	function removeTextBox() {
		var form = document.frm;
		if (form.lastChild.nodeName.toLowerCase() == 'div')
			form.removeChild(form.lastChild);
	}
	
</script>
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
			<a href="LoginPage.jsp"><font color="#ffffff">Logout</font></a>
		</div>
	</div>
</div>
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Accept File</div>
<div id="menu" class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<div class="square">
	<form name = "frm" action="AcceptFileController">
	<div class="x">
		<font size="3" color="red"><%=errorMessage%> </font><br>
		<font size="3">Enter File Path: </font><input size="50" name="filePath" type="file"/><br><br>
		<hr width=70%><br>
		<font size="3">Enter field lengths below:</font>
		<input type="hidden" name="count" value="0" readonly>
		<input type="button" value="Add field" id="add" name="add" onClick="incrementCount()" >
		<input type="button" value="Remove field" id="remove" name="remove" onClick="decCount()" >

		<input type="submit" value="Submit">
		</div>
		</form>
</div>
</body>
</html>