<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Page</title>
<link type="text/css" rel="stylesheet" href="css/index.css" media="screen"/>
<link type="text/css" rel="stylesheet" href="css/index_class.css" media="screen"/>
</head>
<body>
	<div id="left">
		<div id="appname" class="appname">
			NEWSAPP
		</div>
		<div id="nav">
			<a href="#All">
			<div id="nav_item" class="nav_item">
				ALL
			</div>
			</a>
			<a href="#sports">
			<div id="nav_item" class="nav_item">
				SPORTS
			</div>
			</a>
			<a href="#games">
			<div id="nav_item" class="nav_item">
				GAMES
			</div>
			</a>
			<a href="#entertainment">
			<div id="nav_item" class="nav_item">
				ENTERTAINMENT
			</div>
			</a>
			<a href="#business">
			<div id="nav_item" class="nav_item">
				BUSINESS
			</div>
			</a>
			<a href="#politics">
			<div id="nav_item" class="nav_item">
				POLITICS
			</div>
			</a>
		</div>
		<div id="login">
			<form action="#" method="POST">
				<div id="log_label" class="log_label">LOGIN</div>
				<label>Username : </label><br/>
					<input id="log_input" type="text" name="log_username" /><br/>
				<label>Password : </label><br/>
					<input id="log_input" type="password" name="log_password"/><br/>
				<input type="submit" value="Login" id="log_submit"/>
			</form>
		</div>
	</div>
	<div id="right">
		Testing
	</div>
</body>
</html>