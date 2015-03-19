<xsl:stylesheet version="1.0" 
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 

<xsl:template match="/">
  <html>
    <xsl:apply-templates/>
  </html>
</xsl:template>

 <xsl:template match="page">
  <head>
    <title><xsl:apply-templates select="title"/></title>
    <meta name="author" content="{author}"/>
    <meta name="version" content="{version}"/>
  </head>

 <body>
    <h1>Nyheter</h1>
      <ul>
          <xsl:apply-templates select="newscolumn"/> 
      </ul>

    <h1>Projektstatus</h1>
      <ul>
          <xsl:apply-templates select="statuscolumn"/>
      </ul>
  </body>


  </xsl:template>

   <xsl:template match="news">
    <li>
        <strong>
          <a href="{link}"><xsl:value-of select="title"/></a>
            <xsl:text> - </xsl:text> 

            <xsl:value-of select ="date/day"/> 
            <xsl:text> </xsl:text> 
            <xsl:value-of select ="date/month"/> 
            <xsl:text> </xsl:text>
            <xsl:value-of select ="date/year"/> 
            <xsl:text>.</xsl:text>
        </strong>
      <xsl:apply-templates select="content"/>  
    </li>

</xsl:template>

  <xsl:template match="project">
  <li>
    <strong><a href="{link}"><xsl:value-of select="title"/></a></strong>
      <ul>
        <xsl:apply-templates select="release"/>
      </ul>
  </li>
</xsl:template>

<xsl:template match="release">

  <li> 
    <strong>
      <xsl:value-of select="version"/>
      <xsl:text> - </xsl:text>
      <xsl:value-of select="status"/>
      <xsl:text> </xsl:text>
  </strong>

    <xsl:value-of select="comment"/>
  </li>

</xsl:template>

</xsl:stylesheet>