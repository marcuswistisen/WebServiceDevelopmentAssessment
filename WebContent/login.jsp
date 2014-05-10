<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="uts.ws.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
	<jsp:useBean id="userApp" class="uts.ws.UserApplication" scope="application">
	    <jsp:setProperty name="userApp" property="filePath" value="<%=filePath%>"/>
	</jsp:useBean>
	<%
	    String email = request.getParameter("log_username");
	    String password = request.getParameter("log_password");
		User user = (User)(userApp.getUsers().login(email,password));
		
		if(user != null)
		{
			out.println("Login Successful..");
			out.println("You will be redirected shortly..");
			session.setAttribute("user",user);
			response.setHeader("Refresh", "3;url=cpanel.jsp");
		}
		else
		{
			out.println("login failed..");
			out.println("You will be redirected shortly..");
			response.setHeader("Refresh","3;url=index.jsp?cat=all");
		}
		
		
	    
	 %>
</body>
</html>