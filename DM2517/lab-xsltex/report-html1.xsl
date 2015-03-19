<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" indent="yes"/>

<xsl:template match="report">

 <html>
	<head>
		<title><xsl:value-of select="head/title"/></title>
	</head>

	<body>
		
	
		<p>
			<h1><xsl:value-of select ="head/title"/></h1>
			<xsl:text>Authors: </xsl:text> 
			<xsl:for-each select="head/authors/author">
				<xsl:value-of select="."/>
				<xsl:if test="following-sibling::author">
				<xsl:text>, </xsl:text>
				</xsl:if>
			</xsl:for-each>	
			
			<br/>
			<br/>
			
			<xsl:text>Keywords: </xsl:text>
			<xsl:for-each select="head/keywords/keyword">
				<xsl:value-of select="."/>
				<xsl:if test="following-sibling::keyword">
				<xsl:text>, </xsl:text>
				</xsl:if>
			</xsl:for-each>
			
			<br/>
			<br/>
			
		
			
			<p>
				<xsl:for-each select="//body/h1">
					<xsl:number format="1. " level="multiple"/>
					<a href="#{generate-id(.)}"><xsl:value-of select="@title"/></a>
					<br></br>
													
					<xsl:for-each select="h2">
						<xsl:number format="1. " level="multiple" count="h1|h2"/>
						<a href="#{generate-id(.)}"><xsl:value-of select="@title"/></a>
						<br></br>
													
						<xsl:for-each select="h3">
							<xsl:number format="1. " level="multiple" count="h1|h2|h3"/>
							<a href="#{generate-id(.)}"><xsl:value-of select="@title"/>
							</a>
							<br></br>
						</xsl:for-each>    
					</xsl:for-each>				
				</xsl:for-each>	
			</p>	
			
			<p>
			
			<xsl:for-each select="//body/h1">
				<h2> 
					<xsl:number format="1. " level="multiple"/>
					<a id="{generate-id(.)}"><xsl:value-of select="@title" /></a>
				</h2>	
					<xsl:for-each select="p">
					<p><xsl:value-of select="." /></p>	
					</xsl:for-each>
																
					    <xsl:for-each select="h2">
						<h3>
							
							<xsl:number format="1. " level="multiple" count="h1|h2"/>
							<a id="{generate-id(.)}"><xsl:value-of select="@title"/></a>
						</h3>
						<xsl:for-each select="p">
						<p><xsl:value-of select="." /></p>	
						</xsl:for-each>				

						<xsl:for-each select="h3">
							<h3>
						
							<xsl:number format="1. " level="multiple" count="h1|h2|h3"/>
							<a id="{generate-id(.)}"><xsl:value-of select="@title"/></a>
							</h3>
							<xsl:for-each select="p">
							<p><xsl:value-of select="." /></p>	
							</xsl:for-each>
							
						</xsl:for-each>    

					</xsl:for-each>				

				</xsl:for-each>
									
	    	</p>
	
		</p>
  	</body>

.

</html>

</xsl:template>
</xsl:stylesheet>



<!---   <xsl:if test="not(position()=last())">  för att ta bort sista punkten i e lista -->
