<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="uts.ws.*"%>
    <%@ page import="uts.ws.dom.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 		String filePath = application.getRealPath("WEB-INF/articles.xml");%>
 		<jsp:useBean id="articleApp" class="uts.ws.ArticleApplication" scope="application">
	    <jsp:setProperty name="articleApp" property="filePath" value="<%=filePath%>"/>
	    </jsp:useBean>
	    <%
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String tag = request.getParameter("cat");
		String text = request.getParameter("fulltext");
		CudaDOM.addArticle(filePath, author, tag, title, text);
		articleApp.saveData(filePath);
	 %>
</body>
</html>