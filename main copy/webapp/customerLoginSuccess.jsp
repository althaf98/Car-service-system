<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println("Dear "+session.getAttribute("sname")+",You have successfully Logged in");
%>
<a href="carDetails.html">Enter your Car Details</a><br>
<a href="editDetails.html">Edit Car Details</a><br>
<a href="serviceRequest.html">Request for a Service</a><br>
<a href="serviceStatus.html">Check Service Status</a><br>
</body>
</html>