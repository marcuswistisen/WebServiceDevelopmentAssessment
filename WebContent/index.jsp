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
			<a href="?cat=all">
			<div id="nav_item" class="nav_item" style="background : #5b5b5b">
				ALL
			</div>
			</a>
			<a href="?cat=sports">
			<div id="nav_item" class="nav_item">
				SPORTS
			</div>
			</a>
			<a href="?cat=games">
			<div id="nav_item" class="nav_item">
				GAMES
			</div>
			</a>
			<a href="?cat=entertainment">
			<div id="nav_item" class="nav_item">
				ENTERTAINMENT
			</div>
			</a>
			<a href="?cat=business">
			<div id="nav_item" class="nav_item">
				BUSINESS
			</div>
			</a>
			<a href="?cat=politics">
			<div id="nav_item" class="nav_item">
				POLITICS
			</div>
			</a>
		</div>
		<div id="login">
			<form action="loginaction.jsp" method="POST">
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
		<div id="article_wrapper">
			<div id="article_header">
				<div id="article_title" class="article_title">
					Article Title
				</div>
				<div id="article_author" class="author_name">
					By Author Name
				</div>
				<div id="article_published" class="article_published">
					02-02-2222
				</div>
			</div>
			<div id="article_summary" class="article_summary">
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
				Nam urna ante, facilisis scelerisque lacinia vitae, blandit bibendum ligula.
				 Maecenas luctus venenatis sem, ac mattis erat porta sit amet. Pellentesque egestas orci eu mi dignissim,
				  non commodo est accumsan. Ut congue arcu neque, a rutrum enim eleifend vitae. Aliquam lacinia velit
				  sit amet nunc viverra, non consectetur dui pellentesque. Cras eu ipsum tempor sapien tristique semper.
				  
			</div>
			<div id="article_footer">
				<div id="article_category" class="article_category">
					CATEGORY - blah
				</div>
				<div id="article_readmore" class="article_readmore">
					<a href="#readmore">Read more</a>
				</div>
			</div>
		</div>
		
		<div id="article_wrapper">
			<div id="article_header">
				<div id="article_title" class="article_title">
					Article Title
				</div>
				<div id="article_author" class="author_name">
					By Author Name
				</div>
				<div id="article_published" class="article_published">
					02-02-2222
				</div>
			</div>
			<div id="article_summary" class="article_summary">
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
				Nam urna ante, facilisis scelerisque lacinia vitae, blandit bibendum ligula.
				 Maecenas luctus venenatis sem, ac mattis erat porta sit amet. Pellentesque egestas orci eu mi dignissim,
				  non commodo est accumsan. Ut congue arcu neque, a rutrum enim eleifend vitae. Aliquam lacinia velit
				  sit amet nunc viverra, non consectetur dui pellentesque. Cras eu ipsum tempor sapien tristique semper.
				  
			</div>
			<div id="article_footer">
				<div id="article_category" class="article_category">
					CATEGORY - blah
				</div>
				<div id="article_readmore" class="article_readmore">
					<a href="#readmore">Read more</a>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>