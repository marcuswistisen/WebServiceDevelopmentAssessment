<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="uts.ws.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%
String id = "1";

if (request.getParameter("id")!= null){
	id = request.getParameter("id");
}

else
	response.sendRedirect("index.jsp?cat=all");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Page</title>
<link type="text/css" rel="stylesheet" href="css/index.css" media="screen"/>
<link type="text/css" rel="stylesheet" href="css/index_class.css" media="screen"/>
</head>
<body>
		<div id="nav"> <jsp:include page="index.jsp"/></div>
		<div id="right">
		<!-- 	Getting a Article after ID -->
	<%
	if (!id.equals("000")){
	%>
	<c:set var="ID" value="<%=id%>"/>
	<c:import var="xml" url="http://localhost:8080/WebServiceDevelopmentAssessment/rest/articles/article?id=${ID}" />
	<c:import var="xslt" url="WEB-INF/articlefull.xsl" />
	<x:transform xml="${xml}" xslt="${xslt}" />
	<%}%>
		</body>
</html>