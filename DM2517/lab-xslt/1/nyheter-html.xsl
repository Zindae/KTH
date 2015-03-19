<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">

            <html lang="en">

      <xsl:apply-templates/>

            </html>

  </xsl:template>

 <xsl:template match="page">

<head>
  <title><xsl:apply-templates select="title"/></title>
  <meta name="author">
          <xsl:attribute name="content">
            <xsl:apply-templates select="author"/> 
          </xsl:attribute>
        </meta>
        <meta name="version">
          <xsl:attribute name="content">
            <xsl:apply-templates select="version"/> 
          </xsl:attribute>
        </meta>
</head>

  <xsl:apply-templates select="newscolumn"/> 
  <xsl:apply-templates select="statuscolumn"/>  

  </xsl:template>

  <xsl:template match="newscolumn">

 <body>
    <h1>Nyheter</h1>
      <ul>
        <xsl:apply-templates/>
      </ul>
  </body>

</xsl:template>

   <xsl:template match="news">

    <li>
        <a>
          <xsl:attribute name="href">
            <xsl:apply-templates select="link"/> 
          </xsl:attribute>
          <strong><xsl:apply-templates select="title"/></strong>
        </a>
          -
          <xsl:apply-templates select="date"/>  

          <xsl:apply-templates select="content"/>  
      </li>

</xsl:template>

<xsl:template match="date">

   <strong><xsl:apply-templates select="day"/> &#160; <xsl:apply-templates select="month"/> &#160; <xsl:apply-templates select="year"/>.</strong>

</xsl:template>

  <xsl:template match="statuscolumn">

<h1>Projektstatus</h1>
    <ul>
  <xsl:apply-templates/>
    </ul>

</xsl:template>

  <xsl:template match="project">

  <li>
        <a>
          <xsl:attribute name="href">
            <xsl:apply-templates select="link"/> 
          </xsl:attribute>
          <strong><xsl:apply-templates select="title"/></strong>
        </a>
          <ul>
          <xsl:apply-templates select="release"/>  
          </ul>
      </li>
</xsl:template>

<xsl:template match="release">

  <li> 

    <strong><xsl:apply-templates select="version"/></strong> - <strong><xsl:apply-templates select="status"/> </strong> <xsl:apply-templates select="comment"/>

  </li>

</xsl:template>

</xsl:stylesheet>