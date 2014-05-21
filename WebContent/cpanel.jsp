<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="uts.ws.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%
	User user = (User)session.getAttribute("user");
	String[] views = new String[4];
	views[0]="posts";
	views[1]="create";
	views[2]="update";
	views[2]="edit";
	String view = "posts";
	boolean found = false;
	if(request.getParameter("view")==null)
	{
		response.sendRedirect("cpanel.jsp?view="+view);
	}
	else
	{
		for(int i =0;i<views.length;i++){
			if(views[i].equals(view))
			{
				found = true;
				break;
			}
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/cpanel.css" media="screen"/> 
<title>Insert title here</title>
</head>
<body>
<div id="header_wrapper">
	<div id="header">
		<div id="title">
			Cpanel
		</div>
		<div id="actions">

		</div>
	</div>
</div>
<%boolean lipsum = false; %>
<div id="content">
	<div id="cPost">
	CREATE
		<form action="postarticle.jsp" action="post">
			<label>Author</label><br/>
			<input type="text" name="author" value="<%=user.getName()%>"><br/>	
			<label>Title</label><br/>
			<input type="text" name="title"><br/>
			<label>Category</label><br/>
			<select name="cat">
				<option name="sport">Sport</option>
				<option name="games">Games</option>
				<option name="entertainment">Entertainment</option>
				<option name="business">Business</option>
				<option name="politics">Politics</option>
			</select><br/>
			<c:import var="lipout" url="http://www.lipsum.com/feed/xml?amount=5&apm;what=paras&start=0"/>
			<x:parse xml="${lipout}" var="lipsum"/>
			<label><input id="autolipsum" name="autolipsum" type="checkbox" checked="1" onclick="validate()" >Autofill with Lipsum</label>
			<label>Text</label><br/>
			<textarea id="fulltext" name ="fulltext" rows="20" cols="50" > <x:out select="$lipsum/feed[1]/lipsum" /></textarea><br/>
			<input type="submit" value="Create"/> 
			
			<script type=text/javascript>
function validate(){
if (autolipsum.checked == 0){
	document.getElementsByName("fulltext")[0].value = "Insert Own Text";
}else{
	location.reload();
}
}
</script>
		</form>
	</div>
</div>
<%
	if(user==null)
	{
%>
		You are not logged in.<br/>
		You will be redirected shortly..

<%
		response.setHeader("Refresh","3;url=index.jsp?cat=all");
	}
	else
	{
%>
		You are logged in as <%=user.getName()%> < <%=user.getEmail()%> ><br/>
		<a href="index.jsp?cat=all">Index</a> | <a href="logout.jsp">Logout</a>
<%
	}
%>
</body>
</html>