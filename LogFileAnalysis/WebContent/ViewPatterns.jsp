<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page  import = "java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="paging.js"></script>

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
	width: 990px;
	background-color:#E6E7E3;
	font-family:Calibri;
	padding: 1em 1em 1em 1em;
	margin-top: 0.2em;
	margin-left: 2em;
	opacity: 0.7;
	filter:alpha(opacity=70);
}
.evenrow{
    color: #000000;
    background-color: DarkGrey;
    text-align: center;
    font-family: Calibri;
    font-size: 15px;
 }
.oddrow{
    color: #000000;
    background-color: WhiteSmoke;
    text-align: center;
    font-family: Calibri;
    font-size: 15px;
    
 }
 .pg-normal {
    color: black;
    font-weight: normal;
	text-decoration: none;    
    cursor: pointer;    
}
.pg-selected {
    color: black;
    font-weight: bold;        
    text-decoration: underline;
    cursor: pointer;
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
<div style="background-color: ForestGreen; margin: 0.1em; width:100%; color: white;" align="center">
		Pattern
</div>
<div class="leftfloat">
		<%@ include file="SideMenu.jspbb" %>
</div>
<div class="square">
<div class="table">

	<table id="pattern">
		<tr>
		
		</tr>
	<%List<String> l1 = new ArrayList<String>();
	l1 = (ArrayList<String>) request.getSession().getAttribute("list1");
	Iterator<String> itl = l1.iterator();
	int cnt=0;
	while(itl.hasNext()){
		cnt++;%>
		<tr<%if (cnt%2==0) {%> class="evenrow" <%} else {%> class="oddrow"<%}%>>
  		<td><font size="3"><%= itl.next()%></font></td>
		</tr>
	<%}%>
	</table>
	<br><br>
			<div id="pageNavPosition" align="center"></div>
			<script type="text/javascript">
				var pager = new Pager('pattern', 30); 
				pager.init(); 
				pager.showPageNav('pager', 'pageNavPosition'); 
				pager.showPage(1);
			</script>
	</div>
</div>
</body>
</html>