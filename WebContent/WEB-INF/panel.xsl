<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="article">
	<div id="a_post">
			<div id="a_title">
				<xsl:value-of select="title"></xsl:value-of>
			</div>
			<div id="options">
				<ul>
					<xsl:variable name="ID" select="id" />
					<a href="cpanel.jsp?action=edit&amp;id={$ID}"><li>Edit</li></a>
					<a href="cpanel.jsp?action=delete&amp;id={$ID}"><li>Delete</li></a>
				</ul>
			</div>
		</div>
		
			</xsl:template>
	</xsl:stylesheet> 