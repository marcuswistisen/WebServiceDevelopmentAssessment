<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="uts.ws.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%
	User user = (User)session.getAttribute("user");
	boolean isLogged = false;
	if(user!=null)
	{
		isLogged = true;
	}
	if(isLogged)
	{
		String[] actions = new String[4];
		actions[0]="posts";
		actions[1]="create";
		actions[2]="delete";
		actions[3]="edit";
		String action = "posts";
		boolean found = false;
		String id = null;
		if(request.getParameter("action")!=null)
		{
			for(int i = 0 ; i < actions.length;i++)
			{
				if(request.getParameter("action").equals(actions[i]))
				{
					action = actions[i];
					found = true;
					break;
				}
			}
		}
		
		
		if(found)
		{
			if(action.equals(actions[2]))
			{
				//delete the post
				//get id and action
				if(request.getParameter("id")!= null)
				{
					id = request.getParameter("id");
					//Methods to delete the id
					//Have to show a confirmation message
				}
			}
			else if(action.equals(actions[3]))
			{
				//edit the post
				//get id
				if(request.getParameter("id")!= null)
				{
					id = request.getParameter("id");
					//print the form im the html
					
				}
			}
				
		}
		else
		{
			response.sendRedirect("cpanel.jsp?action=posts");
		}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/cpanel.css" media="screen"/> 
<title>Cpanel</title>
</head>
<body>
<div id="header_wrapper">
	<div id="header">
		<div id="title">
			Cpanel
		</div>
		<div id="actions">
			<div id="welcome">
				Welcome,<br/>
				<b><%if(isLogged){out.println(user.getName());}%></b>
			</div>
			<div id="btns">
				<ul>
					<a href="cpanel.jsp?action=posts"><li>Posts</li></a>
					<a href="index.jsp?cat=all"><li>Home</li></a>
					<a href="logout.jsp"><li>Logout</li></a>
				</ul>
			</div>
		</div>
	</div>
</div>

<div id="content">
	<div id="c_head">
		<div id="c_head_title"><%=action%> :</div>
		<a href="?action=create"><div id="create">Create Post</div></a>
	</div>
	<div id="c_body">
	<%if(action.equals(actions[0])){//view posts %>
	<!-- This is for action the posts by the user Action = posts -->
		<div id="a_post">
			<div id="a_title">
				This is a post
			</div>
			<div id="options">
				<ul>
					<a href="cpanel.jsp?action=edit&id=1"><li>Edit</li></a>
					<a href="cpanel.jsp?action=delete&id=1"><li>Delete</li></a>
				</ul>
			</div>
		</div>
		
		<div id="a_post">
			<div id="a_title">
				This is a post
			</div>
			<div id="options">
				<ul>
					<a href="cpanel.jsp?action=edit&id=1"><li>Edit</li></a>
					<a href="cpanel.jsp?action=delete&id=1"><li>Delete</li></a>
				</ul>
			</div>
		</div>
		
		<div id="a_post">
			<div id="a_title">
				This is a post
			</div>
			<div id="options">
				<ul>
					<a href="cpanel.jsp?action=edit&id=1"><li>Edit</li></a>
					<a href="cpanel.jsp?action=delete&id=1"><li>Delete</li></a>
				</ul>
			</div>
		</div>
		
	<%}else if(action.equals(actions[1])){//create posts%>
	<!--  CREATE  A POST FORM -->
		<%boolean lipsum = false; %>
		<form action="postarticle.jsp" action="post">
			<label>Author</label><br/>
			<input type="text" name="author" value="<%=user.getName()%>" readonly><br/>	
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
			<label>Text</label>
			<c:import var="lipout" url="http://www.lipsum.com/feed/xml?amount=5&apm;what=paras&start=0"/>
			<x:parse xml="${lipout}" var="lipsum"/>
			<label><input id="autolipsum" name="autolipsum" type="checkbox" checked="1" onclick="validate()" >Autofill with Lipsum</label>
			<textarea id="fulltext" name ="fulltext" rows="20" cols="50" > <x:out select="$lipsum/feed[1]/lipsum" /></textarea><br/>
			<input type="submit" value="Create"/> 
			</form>
		
	<%}else if(action.equals(actions[2])){//delete post %>
	<!-- SHOW A DELETION MESSAGE AND THEN REDIRECT USER AFTER 2-3 SECONDS TO action=posts -->
		Post $(id) deleted<br/>
		You will be redirected in 2 secs..
		<%response.setHeader("Refresh", "2;url=cpanel.jsp?action=posts"); %>
		
	<%}else if(action.equals(actions[3])){//edit post %>
	<!--  DISPLAY THE CREATE FORM BUT THIS THIS THE FIELDS WILL BE ALREADY FILLED -->
		<form action="postarticle.jsp" action="post">
			<label>Post id</label><br/>
			<input type="text" name="author" value="<%=id%>" readonly><br/>	
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
			<label>Text</label>
			<c:import var="lipout" url="http://www.lipsum.com/feed/xml?amount=5&apm;what=paras&start=0"/>
			<x:parse xml="${lipout}" var="lipsum"/>
			<label><input id="autolipsum" name="autolipsum" type="checkbox" checked="1" onclick="validate()" >Autofill with Lipsum</label>
			<textarea id="fulltext" name ="fulltext" rows="20" cols="50" > <x:out select="$lipsum/feed[1]/lipsum" /></textarea><br/>
			<input type="submit" value="Create"/> 
			</form>
		
	<%}else{response.sendRedirect("cpanel.jsp?action=posts");} %>
	</div>
</div>

<script type=text/javascript>
	function validate(){
		if (autolipsum.checked == 0){
			document.getElementsByName("fulltext")[0].value = "Insert Own Text";
		}else{
			location.reload();
		}
	}
</script>
</body>
</html>
<%
	}else{
		response.sendRedirect("index.jsp?cat=all");
	}

%>