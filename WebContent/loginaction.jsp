<%@ page import="uts.ws.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="userApp" class="uts.ws.UserApplication" scope="application">
   <jsp:setProperty name="userApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<%
String email = request.getParameter("log_username");
String password = request.getParameter("log_password");
User user = (User)(userApp.getUsers().login(email, password));

if(user != null){
%>
<% session.setAttribute("user", user); %>
<% response.sendRedirect("index.jsp?cat=all");%>
<title>Login Successful</title>
</head>
<body> <p>Login successful. Click <a href="index.jsp">here</a> to return to the main page.</p>


</body>

<% }else{%>

<title>Login Failed</title>
</head>
<body> <p>Password incorrect. Click <a href="login.jsp">here</a> to try again.</p>
</body>
<%} %>

</html>
