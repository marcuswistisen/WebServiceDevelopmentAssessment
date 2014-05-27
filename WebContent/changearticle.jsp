<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="uts.ws.*"%>
    <%@ page import="uts.ws.dom.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CHANGE</title>
</head>
<body>
<%
 		String filePath = application.getRealPath("WEB-INF/articles.xml"); //Get articles.xml on server%> 
 		<jsp:useBean id="articleApp" class="uts.ws.ArticleApplication" scope="application">
	    <jsp:setProperty name="articleApp" property="filePath" value="<%=filePath%>"/>
	    </jsp:useBean>
	    <%
	    //Get all needed parameters
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String text = request.getParameter("fulltext");
		CudaDOM.changeArticle(filePath, text, id); //edit article xml using DOM
		articleApp.setFilePath(filePath); //Update filepath
		response.sendRedirect("cpanel.jsp"); // reDirect to index
	 %>
</body>
</html>