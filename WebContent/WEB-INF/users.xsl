<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="user">
<<<<<<< HEAD
=======
	<html>
<head>
<title>News Page</title>
<link type="text/css" rel="stylesheet" href="css/index.css" media="screen"/>
<link type="text/css" rel="stylesheet" href="css/index_class.css" media="screen"/>
</head>
<body>
>>>>>>> af10fdecebbce93b07c34c7b5727a3bb586afbd3
	<div id="author_content">
		<div id="author_name"><xsl:value-of select="name"></xsl:value-of></div>
		<div id="author_dob">Born in <xsl:value-of select="dob"></xsl:value-of></div>
		<div id="author_bio"> <xsl:value-of select="biography"></xsl:value-of></div>
	</div>
<<<<<<< HEAD
=======
</body>
</html>
>>>>>>> af10fdecebbce93b07c34c7b5727a3bb586afbd3
	</xsl:template>
	</xsl:stylesheet> 