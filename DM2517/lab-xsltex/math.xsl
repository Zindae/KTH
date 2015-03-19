<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" indent="yes"/>
<!-- Christopher State -->
  <xsl:template match="/">
    <html>
      <head>
        <title>Extralaboration 1</title>
      </head>
      <body>
        <xsl:apply-templates/>
      </body>
    </html>
  </xsl:template>


<xsl:template match="h1">
	<xsl:copy-of select="."/>
</xsl:template>

<!-- Uppgift 2: Variabler och multiplikation (1p) -->

<xsl:template match="times">

<!-- Templaten ska använda två variabler, "times1" och "times2"-->
	 <xsl:variable name="times1">
		<xsl:apply-templates select="fact"/>
	  </xsl:variable>

<!-- Templaten ska använda två variabler, "times1" och "times2"-->
	 <xsl:variable name="times2">
		<xsl:apply-templates select="fib"/>
	  </xsl:variable>

	<xsl:variable name="sum" select= "$times1 * $times2"/>

	<!-- Siffrorna "5 8" under rubriken "Multiplikation" kommer nu vara "40" -->
	<xsl:value-of select="$sum"/>

</xsl:template>


<!-- Uppgift 3: Rekursivitet, parametrar och namngivna templates applicerat på fakultet (1p) -->

<xsl:template match="fact">
	<xsl:call-template name="factorial">
      <xsl:with-param name="n" select=".">
      </xsl:with-param>
	</xsl:call-template>
</xsl:template>

<xsl:template name="factorial">
    <xsl:param name="n" select="1"/>
    
	<xsl:variable name="factsumma">

		<!-- fact(n) {
			  if(n == 1) 
			    return 1
			  else 
			    return n*(fact(n-1))
			} -->

      <xsl:if test="$n = 1"> 1 </xsl:if>
      <xsl:if test="$n != 1">
        <xsl:call-template name="factorial">
          <xsl:with-param name="n" select="$n - 1"/>
        </xsl:call-template>
      </xsl:if>
    </xsl:variable>

    <!-- Talet under rubriken "Multiplikation" kommer nu vara 960.-->
	<xsl:value-of select="$factsumma * $n"/>
</xsl:template>


<!-- Uppgift 4: Fibonaccital (1p) -->

<xsl:template match = "fib">
	<xsl:call-template name="fibionacci">
		<xsl:with-param name="prev" select="0" />
		<xsl:with-param name="next" select="1" />
		<xsl:with-param name="itemsLeft" select="."/>
	</xsl:call-template>
</xsl:template>

<xsl:template name="fibionacci">
<xsl:param name="prev"/>
  	<xsl:param name="next"/>
  	<xsl:param name="itemsLeft"/>

	<xsl:if test="$itemsLeft = 1">
		<xsl:value-of select="$next"/><br/>
	</xsl:if>
  
  <!-- Din uppgift är nu att göra lämpliga templates så att ett element <fib>n</fib> returnerar fibonaccivärdet av n. När du är klar kommer talet under rubriken "Multiplikation" nu vara 2520. -->

	<xsl:if test="$itemsLeft != 0">
    	<xsl:call-template name="fibionacci">
      		<xsl:with-param name="prev" select="$next" />
      		<xsl:with-param name="next" select="$prev+$next" />
      		<xsl:with-param name="itemsLeft" select="$itemsLeft - 1" />
    	</xsl:call-template>
  	</xsl:if>
</xsl:template>


<!-- Uppgift 5: att vända en sträng (1p) -->

<xsl:template match="reverse">
	<xsl:call-template name="reverse_string">
		<xsl:with-param name="input" select="." />
	</xsl:call-template>
	
</xsl:template>

<xsl:template name="reverse_string">
     <xsl:param name="input"/>
     <xsl:variable name="len" select="string-length($input)"/>
     <xsl:choose>
          <xsl:when test="$len &lt; 2">
               <xsl:value-of select="$input"/>
          </xsl:when>
          <xsl:when test="$len = 2">
               <xsl:value-of select="substring($input,2,1)"/>
               <xsl:value-of select="substring($input,1,1)"/>
          </xsl:when>
          <xsl:otherwise>
               <xsl:variable name="mid" select="floor($len div 2)"/>
               <xsl:call-template name="reverse_string">
                    <xsl:with-param name="input"
                         select="substring($input,$mid+1,$mid+1)"/>
               </xsl:call-template>
               <xsl:call-template name="reverse_string">
                    <xsl:with-param name="input"
                         select="substring($input,1,$mid)"/>
               </xsl:call-template>
          </xsl:otherwise>
     </xsl:choose>
</xsl:template>

<!-- Uppgift 6: Euclides algoritm (1p)-->
<!-- När du är klar bör talen "693 147" under rubriken "Euclides algoritm" vara ersatta med talet "21".-->

<xsl:template match = "euclides">
	
	<xsl:call-template name="Euclides">
		<xsl:with-param name="x" select="term[1]"/>
		<xsl:with-param name="y" select="term[2]"/>
	</xsl:call-template>
	
</xsl:template>
	
	<xsl:template name="Euclides">
		<xsl:param name="x"/>
		<xsl:param name="y"/>
		<xsl:choose>
			<xsl:when test="$x = $y">
				<xsl:value-of select="$x"/>
			</xsl:when>
			<xsl:when test="$x &lt; $y">
				<xsl:call-template name="Euclides">
					<xsl:with-param name="x" select="$x"/>
					<xsl:with-param name="y" select="$y - $x"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:call-template name="Euclides">
					<xsl:with-param name="x" select="$x - $y"/>
					<xsl:with-param name="y" select="$y"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
</xsl:stylesheet>


