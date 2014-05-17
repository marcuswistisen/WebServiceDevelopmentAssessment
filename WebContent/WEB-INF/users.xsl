<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="user">
	<html>
<head>
<title>News Page</title>
<link type="text/css" rel="stylesheet" href="css/index.css" media="screen"/>
<link type="text/css" rel="stylesheet" href="css/index_class.css" media="screen"/>
</head>
<body>
<p><xsl:value-of select="name"></xsl:value-of></p>
<p>Date Of Birth: <xsl:value-of select="dob"></xsl:value-of></p>
<p> <xsl:value-of select="biography"></xsl:value-of></p>
</body>
</html>
	</xsl:template>
	</xsl:stylesheet> 