<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="user">
	<div id="author_content">
		<div id="author_name"><xsl:value-of select="name"></xsl:value-of></div>
		<div id="author_dob">Born in <xsl:value-of select="dob"></xsl:value-of></div>
		<div id="author_bio"> <xsl:value-of select="biography"></xsl:value-of></div>
	</div>
	</xsl:template>
	</xsl:stylesheet> 