<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>

	<xsl:template match="/">

		 <html lang="sv">

 			<p><xsl:apply-templates select="@*|node()"/></p>
   
	   </html>

	</xsl:template>
     
     <xsl:template match="/">

     <p> <xsl:value-of select="count(//ELECTORAL/VALID[@PARTY='M' and @PERCENTAGE &gt; 18])"/></p>
       
   </xsl:template>

</xsl:stylesheet>
