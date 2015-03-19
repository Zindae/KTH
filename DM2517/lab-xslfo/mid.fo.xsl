<?xml version="1.0"?>
<!-- Christopher State -->
<xsl:stylesheet version="1.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:fo="http://www.w3.org/1999/XSL/Format">

  <xsl:template match="PLAY">
    <fo:root>
      <fo:layout-master-set>
        <fo:simple-page-master 
		 master-name="front-page-master"
		 page-width="21.0cm"
		 page-height="29.7cm"
		 margin-top="3.54cm"
		 margin-bottom="3.54cm"
		 margin-right="2.1cm"
		 margin-left="2.1cm">
		<fo:region-body
		 margin-top="3.5cm"
		 margin-bottom="1.5cm"/>
		
		<fo:region-before extent="3.5cm" region-name="front-region-before"/>
		<fo:region-after extent="1.5cm" region-name="front-region-after"/>

        </fo:simple-page-master>

		<fo:simple-page-master 
		 master-name="personae-page-master"
		 page-width="21.0cm"
		 page-height="29.7cm"
		 margin-top="3.54cm"
		 margin-bottom="3.54cm"
		 margin-right="2.1cm"
		 margin-left="2.1cm">

		<fo:region-body
		 margin-top="5.5cm"
		 margin-bottom="5.5cm"
		 column-count="2"
		 column-gap="1cm"/>
			
		<fo:region-before extent="5.5cm" region-name="personae-region-before"/>
		<fo:region-after extent="5.0cm" region-name="personae-region-after"/>

        </fo:simple-page-master>
		
		<fo:simple-page-master 
		 master-name="act-page-master"
		 page-width="21.0cm"
		 page-height="29.7cm"
		 margin-top="3.54cm"
		 margin-bottom="3.54cm"
		 margin-right="2.1cm"
		 margin-left="2.1cm">

		<fo:region-body
		 margin-top="2.2cm"
		 margin-bottom="2.2cm"
		 column-count="2"
		 column-gap="1cm"/>

			<fo:region-before extent="2.2cm" region-name="act-region-before"/>
			<fo:region-after extent="1.5cm" region-name="act-region-after"/>

        </fo:simple-page-master>
		<fo:simple-page-master 
		 master-name="act-page-rest"
		 page-width="21.0cm"
		 page-height="29.7cm"
		 margin-top="3.54cm"
		 margin-bottom="3.54cm"
		 margin-right="2.1cm"
		 margin-left="2.1cm">

		<fo:region-body
		 margin-top="2.2cm"
		 margin-bottom="2.2cm"
		 column-count="2"
		 column-gap="1cm"/>

			<fo:region-before extent="2.2cm" region-name="act-region-before-rest"/>
			<fo:region-after extent="1.5cm" region-name="act-region-after"/>

        </fo:simple-page-master>

		<fo:page-sequence-master master-name="act-content">
			<fo:repeatable-page-master-alternatives>
				<fo:conditional-page-master-reference 
				page-position="first" master-reference="act-page-master"/>
				<fo:conditional-page-master-reference 
				page-position="rest"  master-reference="act-page-rest"/>
			</fo:repeatable-page-master-alternatives>
		</fo:page-sequence-master>
      </fo:layout-master-set>

		<fo:page-sequence master-reference="front-page-master">
		<fo:static-content flow-name="front-region-after">
		  <fo:block> 
		  </fo:block>
		</fo:static-content>

		<fo:static-content flow-name="front-region-before">
		<fo:block font-size="18pt" font-family="serif" font-style="italic" text-align="center"> 
			VOLUME <xsl:value-of select="@volume"/> BOOK <xsl:value-of select="@book"/>
		</fo:block>
		</fo:static-content>

		<fo:flow flow-name="xsl-region-body">
		<fo:block font-size="33pt" font-family="serif" text-align="center">
			<xsl:value-of select="MAINTITLE"/>
		</fo:block>
		<fo:block text-align="center">
			<fo:external-graphic content-height="83%" scaling="uniform" src="http://xml.csc.kth.se/~state/DM2517/lab-xslfo/shakespeare.jpg" />
		  </fo:block>
		<fo:block font-size="18pt" font-family="serif" font-style="italic" text-align="center" >
				By <xsl:value-of select="WRITER"/>
		</fo:block>
		</fo:flow>
		</fo:page-sequence>
		<fo:page-sequence master-reference="personae-page-master">
		<fo:static-content flow-name="personae-region-before">
		  <fo:block font-size="18pt" font-family="serif" font-style="italic" text-align="center"  >
			<xsl:value-of select="PERSONAE/TITLE" />
		  </fo:block>
		</fo:static-content>
		<fo:static-content flow-name="personae-region-after">
		  <fo:block font-size="12pt" font-family="serif" text-align="center"> 
			<xsl:value-of select="//SCENE/TITLE" />
		  </fo:block>
		</fo:static-content>
		
		<fo:flow flow-name="xsl-region-body">
			<fo:block font-size="10pt" font-family="serif" text-align="center">
				<xsl:apply-templates select="PERSONAE" />
			</fo:block>
		</fo:flow>
		</fo:page-sequence>
		
		<xsl:for-each select="ACT">
			<fo:page-sequence master-reference="act-content">
				<fo:static-content flow-name="act-region-before">
					<fo:block font-size="30pt" font-family="serif" font-style="italic" space-after="0.32cm" border-after-style="solid" border-after-width="thin" text-align="center" >
					<xsl:value-of select="TITLE" />
				  	</fo:block>
				</fo:static-content>

				<fo:static-content flow-name="act-region-before-rest">
					<fo:block font-size="12pt" font-family="serif" font-style="italic" space-after="0.32cm" border-after-style="solid" border-after-width="thin" text-align="center" >
					<xsl:value-of select="//MAINTITLE" />: <xsl:value-of select="TITLE" />
				  	</fo:block>
				</fo:static-content>
		
				<fo:static-content flow-name="act-region-after">
				  <fo:block font-size="10pt" font-family="serif" font-style="italic">
					<fo:page-number font-style="normal"/>
					Volume <xsl:value-of select="//@volume" /> Book <xsl:value-of select="//@book"/>
				  </fo:block>
				</fo:static-content>
		
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="10pt" font-family="serif">
						<xsl:apply-templates select="." />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</xsl:for-each>
    </fo:root>


  </xsl:template>
	<xsl:template match="PERSONAE">
		<fo:block text-align="center">
		  <xsl:apply-templates/>
		</fo:block>
	</xsl:template>

	<xsl:template match="PERSONA">
		<fo:block line-height="2.4">
			<xsl:value-of select="."/>
		</fo:block>
	</xsl:template>
	<xsl:template match="PGROUP">
		<fo:block line-height="2.4">
			<fo:table>
				<fo:table-body>
					<fo:table-cell>
						<fo:block width="3.8cm" border-right-style="solid" >
								<xsl:apply-templates select="PERSONA" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center">
						<fo:block width="3.8cm" >
								<xsl:value-of select="GRPDESCR" />
						</fo:block>
					</fo:table-cell>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<xsl:template match="ACT">
		<xsl:apply-templates select="SCENE" />
	</xsl:template>
	
	<xsl:template match="ACT/TITLE">
		<fo:block font-size="30pt" font-family="serif" font-style="italic" space-after="0.32cm" border-after-style="solid" border-after-width="thin" text-align="center">
			<xsl:value-of select="." />
		  </fo:block>
	</xsl:template>

	<xsl:template match="SCENE">
		<fo:block text-align="center" padding-before="-0.2cm" space-after="0.25cm">
			<xsl:value-of select="TITLE"/>
		</fo:block>

		<xsl:apply-templates />
	
	</xsl:template>

	<xsl:template match="STAGEDIR">
		<fo:block space-after="0.25cm" font-style="italic">
			<xsl:apply-templates />
		</fo:block>
	</xsl:template>

  <xsl:template match="SPEECH">
	<fo:block space-after="0.25cm" >
		<fo:block>
			<xsl:value-of select="SPEAKER" />
		</fo:block>
		<xsl:apply-templates select="LINE"/>
	</fo:block>
    
  </xsl:template>

	<xsl:template match="LINE">
		<fo:block>
			<xsl:apply-templates />
		</fo:block>
	</xsl:template>

  <xsl:template match="*">
  </xsl:template>


</xsl:stylesheet>
