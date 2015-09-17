<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.cummins.project734.test.*" %>


<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
String result;
// Recipients email ID needs to be mentioned.
String to = "bhayani.urmi@gmail.com";

// Sender's email ID needs to be mentioned
String from = "sayali.rane@gmail.com";

// Assuming you are sending email from localhost
String host = "smtp.gmail.com";
String port="465";

/*   String username ="user";
String password="password";*/
// Get system properties object
Properties properties = System.getProperties();

// Setup mail server
properties.setProperty("mail.smtp.host", host);
//properties.put("mail.host",host);
//properties.put("mail.transport.protocol", "smtp");
properties.put("mail.smtp.port",port);
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable","true"); 
properties.put("mail.smtp.EnableSSL.enable","true");




//  properties.put("mail.smtp.starttls.enable", "true");


// Get the default Session object.
Session mailSession = Session.getDefaultInstance(properties,new Authenticator() {
    protected PasswordAuthentication  getPasswordAuthentication() {
        return new PasswordAuthentication(
                    "sayali.rane@gmail.com", "howtosavealife");
                }
    });

try{
	//  Transport transport = mailSession.getTransport("smtps");
   // Create a default MimeMessage object.
   MimeMessage message = new MimeMessage(mailSession);
   // Set From: header field of the header.
   message.setFrom(new InternetAddress(from));
   // Set To: header field of the header.
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
   // Set Subject: header field
   message.setSubject("This is the Subject Line!");
   // Now set the actual message
   message.setText("This is actual message");
   // Send message
   Transport.send(message);
  // transport.connect();
   //transport.sendMessage(message, message.getAllRecipients());
   result = "Sent message successfully....";
}catch (MessagingException mex) {
   mex.printStackTrace();
   result = "Error: unable to send message....";
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<p align="center">
<% 
   out.println("Result: " + result + "\n");
%>
</p>
</body>
</html>