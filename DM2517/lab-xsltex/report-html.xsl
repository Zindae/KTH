<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" indent="yes"/>
<!-- Christopher State -->
<xsl:template match="report">

 <html>
	<head>
		<!-- title -->
		<title>
			<xsl:value-of select="head/title"/>
		</title>
	</head>

	<!-- body -->
		<body>
			<h1>
				<xsl:value-of select="head/title"/>
			</h1>

			<p>
				<xsl:text>Authors: </xsl:text> 

				<xsl:for-each select="head/authors/author">
					<xsl:value-of select="."/>
					<xsl:if test="following-sibling::author">
						<xsl:text>, </xsl:text>
					</xsl:if>
				</xsl:for-each>	
			</p>
		
			
			<p>
				<xsl:text>Keywords: </xsl:text>

				<xsl:for-each select="head/keywords/keyword">
					<xsl:value-of select="."/>
					<xsl:if test="following-sibling::keyword">
						<xsl:text>, </xsl:text>
					</xsl:if>
				</xsl:for-each> 
			</p>

			<!-- Navlinks -->
			<p><!-- First iteration -->	
				<xsl:for-each select="//body/h1">
					<xsl:number format="1." level="multiple" grouping-separator=" "/>
					<xsl:text>&#160;</xsl:text>
			
					<a href="#{generate-id(.)}">
						<xsl:value-of select="@title"/>
					</a>
					<br/>
					<!-- Second iteration -->										
					<xsl:for-each select="h2">
						<xsl:number format="1." level="multiple" count="h1|h2" grouping-separator=" "/>
						<xsl:text>&#160;</xsl:text>

						<a href="#{generate-id(.)}">
							<xsl:value-of select="@title"/>
						</a>
						<br />
						<!-- Third iteration -->									
						<xsl:for-each select="h3">
							<xsl:number format="1." level="multiple" count="h1|h2|h3" grouping-separator=" "/>
							<xsl:text>&#160;</xsl:text>

							<a href="#{generate-id(.)}">
								<xsl:value-of select="@title"/>
							</a>
							<br />
						</xsl:for-each>    
					</xsl:for-each>				
				</xsl:for-each>	
			</p>	
			

			<!-- Content -->
				<!-- First iteration -->	
			<p>
				<xsl:for-each select="//body/h1">
					<h2> 
						<xsl:number format="1." level="multiple"/>
						<xsl:text>&#160;</xsl:text>

						<a id="{generate-id(.)}">
							<xsl:value-of select="@title" />
						</a>

					</h2>	

					<xsl:for-each select="p">
						<p>
							<xsl:value-of select="." />
						</p>	
					</xsl:for-each>
												

					<!-- Second iteration -->			

					<xsl:for-each select="h2">
						<h3>
							<xsl:number format="1." level="multiple" count="h1|h2" />
							<xsl:text>&#160;</xsl:text>

								<a id="{generate-id(.)}">
									<xsl:value-of select="@title"/>
								</a>
						</h3>

						<xsl:for-each select="p">
							<p>
								<xsl:value-of select="." />
							</p>	
						</xsl:for-each>		

							<!-- Third iteration -->		

							<xsl:for-each select="h3">
								<h3>
									<xsl:number format="1." level="multiple" count="h1|h2|h3" />
									<xsl:text>&#160;</xsl:text>

										<a id="{generate-id(.)}">
											<xsl:value-of select="@title"/>
										</a>
								</h3>

								<xsl:for-each select="p">
								<p>
									<xsl:value-of select="." />
								</p>	
								</xsl:for-each>
							
							</xsl:for-each>    

					</xsl:for-each>				

				</xsl:for-each>
									
	    	</p>
	
  	</body>

</html>

</xsl:template>
</xsl:stylesheet>
