<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.logging.*" %>
<%@ page import="aedalert.net.*" %>
<%@ page import="org.json.*" %>
<%
// this jsp is called when receiving sms.
Logger log = Logger.getLogger(this.getServletName());


String result = "";

log.warning("test");

String smsText = "test"; // sms text

// reading using reader because the sender does not send it through parameter.
StringBuilder buffer = new StringBuilder();
BufferedReader reader = request.getReader();

String line;
while((line = reader.readLine()) != null){
    buffer.append(line);
}
// reqBytes = buffer.toString().getBytes();

result = buffer.toString();
if (result.length() > 0) {
	smsText = buffer.toString();
}

RetrieveData.sendSpark("https://api.ciscospark.com/v1/messages", smsText, "codercollective3@gmail.com"); 
%>
<%=result%>