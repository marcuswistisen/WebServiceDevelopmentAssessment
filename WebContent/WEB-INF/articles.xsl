<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="article">
	<html>
<head>
<title>News Page</title>
<link type="text/css" rel="stylesheet" href="css/index.css" media="screen"/>
<link type="text/css" rel="stylesheet" href="css/index_class.css" media="screen"/>
</head>
<body>
<!-- 		XSL get title, date, name etc etc  -->
		<div id="article_wrapper">
			<div id="article_header">
				<div id="article_title" class="article_title">
					<xsl:value-of select="title"></xsl:value-of>
				</div>
				<div id="article_author" class="author_name">
				<xsl:variable name="NAME" select="author" />
				By <a href="/WebServiceDevelopmentAssessment/index.jsp?author={$NAME}"><xsl:value-of select="author"></xsl:value-of></a>
				</div>
				<div id="article_published" class="article_published">
					<xsl:value-of select="date"></xsl:value-of>
				</div>
			</div>
			<div id="article_summary" class="article_summary">
				<xsl:value-of select="previews"></xsl:value-of>
				  
			</div>
			<div id="article_footer">
				<div id="article_category" class="article_category">
					CATEGORY - <xsl:value-of select="tag"></xsl:value-of>
				</div>
				<div id="article_readmore" class="article_readmore">

					<xsl:variable name="ID"><xsl:value-of select="id"/></xsl:variable>
					<a href="/WebServiceDevelopmentAssessment/index.jsp?id={$ID}">Read More	</a>
<div id="test" border="600" align="center" style="display:none;"> 
<p><xsl:value-of select="text"></xsl:value-of></p> 
</div>
				</div>
			</div>
		</div></body>
</html>
	</xsl:template>
	</xsl:stylesheet> 