<%@page import="java.net.URLEncoder"%>
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

//reading using reader because the sender does not send it through parameter.
StringBuilder buffer = new StringBuilder();
BufferedReader reader = request.getReader();

String line;
while((line = reader.readLine()) != null){
 buffer.append(line);
}
//reqBytes = buffer.toString().getBytes();

result = buffer.toString();

log.warning("data from webhook=" + result);

JSONObject json = new JSONObject(result);

JSONObject data = json.getJSONObject("data");
String messageId = data.getString("id");

log.warning("message id=" + messageId);

String messageDetailUrl = "https://api.ciscospark.com/v1/messages/" + messageId;
log.warning("message url=" + messageDetailUrl);
//JSONObject messageJson = RetrieveData.postJson(messageDetailUrl);
//String text = messageJson.getString("text");

//log.warning("text from spark=" + text);

String text = "SMS to 16572052868 to send message to Spark meeting. Spark meeting is at";

// send this through sms
RetrieveData.xmlData("https://api.tropo.com/1.0/sessions?action=create&token=6c435a685a73666d6c556f7a6f734e4d6145665377494c6f4b68696b7964414244714b46646348587a787961&myNumber=16505333392&myString=" + URLEncoder.encode(text));

text = "http://maps.google.com/?q=37.4046748,-121.9774302";

RetrieveData.xmlData("https://api.tropo.com/1.0/sessions?action=create&token=6c435a685a73666d6c556f7a6f734e4d6145665377494c6f4b68696b7964414244714b46646348587a787961&myNumber=16505333392&myString=" + URLEncoder.encode(text));


%>
<%=result%>