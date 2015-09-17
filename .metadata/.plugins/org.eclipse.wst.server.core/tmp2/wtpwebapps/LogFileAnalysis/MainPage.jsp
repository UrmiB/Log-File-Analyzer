<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log File Analysis</title>

<style type="text/css">
body{
	background-image:url(Images/blue2.jpg);
	height: 1150px;
	width: 1100px;
}
div.domtab{
	padding:0 12em;
	width:80%;
	font-size:90%;
	opacity: 0.5;
	filter:alpha(opacity=50);
}
ul.domtabs{
	float:left;
	width:100%;
	margin:2em 0 0 0;				
}
ul.domtabs li{
	float:left;
	padding:0 0.5em 0 0;
	font-size: 1.3em;
}
ul.domtabs a:link,
ul.domtabs a:visited,
ul.domtabs a:active,
ul.domtabs a:hover{
	width:8em;
	padding:.2em 1em;
	display:block;
	background:#093188;
	color:#fff;
	height:3em;
	font-weight:bold;
	text-decoration:none;
}
html>body ul.domtabs a:link,
html>body ul.domtabs a:visited,
html>body ul.domtabs a:active,
html>body ul.domtabs a:hover{
	height:auto;
	min-height:2em;
}
ul.domtabs a:hover{
	background:#fff;
	color: #000;
}
div.domtab div{
	clear:both;
	width:auto;
	background:#fff;
	color:#000;
	padding:1em 3em;
}
ul.domtabs li.active a:link,
ul.domtabs li.active a:visited,
ul.domtabs li.active a:active,
ul.domtabs li.active a:hover{
	background:#fff;
	color:#000;
}
p{
	margin:0 0 0.5em 0;
	line-height:1.5em;
	font-size: 1.2em;
}
h2{
	font-size:1.3em;
	text-transform:uppercase;
	/*font-family:"Trebuchet MS",Arial,Sans-Serif;*/
	padding:0 0 .7em .2em;
}
h1{
	font-size:3em;
	text-align: center;
	font-style: bold;
	font-family: algerian;
	text-transform:uppercase;
	font-style: italic;
	color: #fff;
	padding-bottom: .5em;
}
div.domtab div a:link,
div.domtab div a:visited,
div.domtab div a:active
{
	color:#fff;
	display:block;
	padding:1em .5em;
	font-weight:bold;
	font-size:1.3em;
}
div.domtab div h2 a,
div.domtab div h2 a:hover,
div.domtab div h2 a:active
{
	color:#000;
	display:inline;
	font-weight:normal;
	font-size:1em;
}
div.Link{
	font-size: 1.5em;
	font-style: italic;
	font-weight: bold;
	margin-left: 35em;
	margin-top: 5em;
}
</style>
<script type="text/javascript" src="domtab.js"></script>

</head>
<body>
<div class="Link">
	<a href="LoginPage.jsp"><font color="#ffffff">Login</font></a>
	&nbsp;&nbsp;<a href="CreateAccount.jsp"><font color="#ffffff">CreateAccount</font></a>
</div>

<br><br><br><br><br>
<h1>Log File Analysis</h1>
<br><br>
<div class="domtab">
	<ul class="domtabs">
		<li><a href="#home">Home</a></li>
		<li><a href="#about">About</a></li>
		<li><a href="#contact">Contact Us</a></li>
		<li><a href="#download">Download</a></li>
	</ul>
	<div>
		<h2><a name="home" id="home">Home</a></h2>
		<p>Data is collected at an enormous rate and as amount of data increases, manual analysis is almost impossible. 
		It can be in the form of application logs, firewall logs or proxy server logs. It is essential to have quick analysis of this 
		data to take any actions based on it. Detecting anomalies in data is easier using a tool. A tool can help detect malicious activity 
		that manual checking is very likely to miss. Our tool applies a generic algorithm to these log files in order to intelligently detect 
		the important fields in the log file, indexes them accordingly and stores them into the database. The user can make use of the keyword 
		search feature to get data important to him/her in a text format as well as its graphical representation in the form of graphs and 
		charts. </p>
		<p><strong>New:</strong> Something Important</p>
	</div>
	<div>
		<h2><a name="about" id="about">About</a></h2>
		<p>The tool is built using J2EE as a web application and using Lucene index for indexing the data. 
		The user can make use of the keyword search feature to get data important to him/her in a text format as well as its 
		graphical representation in the form of graphs and charts. The tool will allow users to import logs that they want to analyze.
		It is a generic tool where logs of any type or format can be imported. Users can view summarized dashboard from the UI.</p>
	</div>
	<div>
		<h2><a name="contact" id="contact">Contact Us</a></h2>
		<p>Incase of any enquiries, please contact the numbers given below - <br><br>
		   Urmi Bhayani: 9860277068 <br>
		   Saniya Shukla: 9890509958 <br>
		   Sayali Rane: 7798428954 <br>
		</p>
	</div>
	<div>
		<h2><a name="download" id="download">Download</a></h2>
		<p> Download the application from the link below: <br><br>Link to download</p>
	</div>
		
</div>

</body>
</html>