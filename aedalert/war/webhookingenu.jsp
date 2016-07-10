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

log.warning("calling genu");

try {
	RetrieveData.callIngenu("https://intellect.ingenu.com/data/v1/send"); 
} catch (HttpResponseCodeException ex) {
	result = "called ingenu";
	ex.printStackTrace();
}
%>
<%=result%>