<?xml version='1.0'?>
<!--
  Converts a recipe in RecipeML format to HTML
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fb="urn:facebook.com:xslt" version="1.0">
<xsl:import href="assets/strSplit-to-Words.xsl"/>

<xsl:template match="root">
<html lang="en">
    <head>
    <meta charset="UTF-8"/>
    <link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="http://statecs.com/DM2517/rss.php"/>
    <title>DM2517</title>
    <link rel="stylesheet" type="text/css" href="assets/css/index.css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.32/jquery.form.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.11.1/jquery.validate.min.js"></script>
     <script src="assets/post.js"></script>

<div id="fb-root"></div>

  </head>

  <div class="container_12">

  <xsl:apply-templates />
</div>
</html>
</xsl:template>  


 <!--  match "index.php" -->
<xsl:template match="root/menu">

<div class="menu"> 
<!-- Start menu section -->
<ul id="menu" class="topmenu">

  <xsl:for-each select="menu_item">

    <li class="topmenu">
      <a>
        <xsl:attribute name="id">
         <xsl:apply-templates select="menu_id"/>
        </xsl:attribute>
        <xsl:attribute name="href">
          <xsl:apply-templates select="url"/>
        </xsl:attribute>
        <xsl:value-of select="name"/>
      </a>

 <xsl:if test="menu_id = '2'"> 

<div class="submenu">
  <div class="column">
    <ul>
      <xsl:for-each select="/root/recipes_cookbook/front_recipes | /root/recipes_cookbook/recipes | /root/recipes_cookbook/list_recipes">
        <li class="onhover">
          <a>
            <xsl:attribute name="href">
              <xsl:text>recipes.php?edit=</xsl:text>
              <xsl:apply-templates select="recipe_id"/>
            </xsl:attribute>
            <xsl:value-of select="title"/>
          </a></li>

         </xsl:for-each>
       </ul></div></div>

  </xsl:if>

    </li>
  </xsl:for-each>
<li class="topmenu"><p class="field"><input type="text" size="30" placeholder="Search" onkeyup="showResult(this.value)"/></p></li>
</ul></div>
</xsl:template>  


<xsl:template match="recipes_cookbook">

  <div id="recipe" class="recipe">
    <xsl:apply-templates />
  </div>

</xsl:template>

<!--  match "index.php" -->
<xsl:template match="root/recipes_cookbook/front_recipes">

  <div class="grid_2 pull_2">
    <div class="vertical pic">
      <a>
        <xsl:attribute name="href">
          <xsl:text>index.php?id=</xsl:text>
          <xsl:apply-templates select="recipe_id"/>
        </xsl:attribute>
        <img>
          <xsl:attribute name="src">
            <xsl:value-of select="img"/>
          </xsl:attribute>
        </img>
      </a>
    </div>
  </div>
</xsl:template>

<!--  match "index.php?=id" & "recipes.php?=id" -->
<xsl:template match="root/recipes_cookbook/recipes">


<fb:like href="https://developers.facebook.com/docs/plugins/" send="true" width="450" show_faces="true"></fb:like>

    <div class="grid_4">
      <img>
        <xsl:attribute name="src">
          <xsl:value-of select="img"/>
        </xsl:attribute>
      </img>
    </div>

    <div class="contentid">
    <!-- H1 title -->
    <h1 class="htop">
      <xsl:apply-templates select="title"/>
    </h1>


    <div class="grid_8" id="ingredients">
      <h2>
        <xsl:text>Ingredients: </xsl:text>
      </h2>

          <ul class="item">
            <xsl:call-template name="str-split-to-li">
              <xsl:with-param name="pStr" select="ingredients"/>
              <xsl:with-param name="pDelimiters"
                        select="','"/>
           </xsl:call-template>
          </ul>

    </div>
    <div class="grid_8" id="directions">
      <h2>
        <xsl:text>Directions: </xsl:text> 
      </h2>
      <xsl:value-of select="directions"/>
    </div>
  
    <div class="grid_8" id="reviews">
      <h2>
        <xsl:text>Comments: </xsl:text>
      </h2>
    <!-- content head reviews -->
    <p class="hreviews"></p>

    <div class="popover-content">
      <div class="new-com-bt">
         <span><xsl:text>Write a comment ...</xsl:text></span> 
    </div>
    <div class="new-com-cnt">
  <form id="form" method="post">
        <input type="text" id="name" name="name" value="" placeholder="Your name" />
        <input type="text" id="email" name="email" value="" placeholder="Your e-mail adress" />
        <textarea id="comment" name="comment" class="the-new-com"></textarea>
        <div class="bt-add-com"><input name="send" id="send" value="Send Comment" /></div>
         <div class="bt-cancel-com"><input name="cancel" id="cancel" value="Cancel" /></div></form>
    </div>
    <div class="clear"></div>
    
      <p>
        <xsl:for-each select="reviews/comment">
        <ul>
          <li>
            <xsl:value-of select="comments"/>
          </li>
          <li style="font-size:10px;">
            <xsl:value-of select="name"/>
          </li>
          <li style="font-size:10px;">
            <xsl:value-of select="comment_date"/>
          </li>
        </ul>
        </xsl:for-each>
      </p>
    </div>
  </div>
</div>
</xsl:template>

<!--  match "recipes.php" -->
<xsl:template match="root/recipes_cookbook/list_recipes">

  

  <div class="grid_list">
    <!-- H1 title -->
    <a>
      <xsl:attribute name="href">
        <xsl:text>index.php?id=</xsl:text>
        <xsl:value-of select="recipe_id"/>
      </xsl:attribute>
      <img>
        <xsl:attribute name="src">
          <xsl:value-of select="img"/>
        </xsl:attribute>
      </img>
    </a>
       <h1 class="htop"><a>
       <xsl:attribute name="href">
        <xsl:text>recipes.php?add</xsl:text>
      </xsl:attribute>
   <xsl:text> Add</xsl:text></a>

   <a><xsl:attribute name="href">
        <xsl:text>recipes.php?edit=</xsl:text>
        <xsl:value-of select="recipe_id"/>
      </xsl:attribute><xsl:text> Edit</xsl:text></a>

  <a><xsl:attribute name="href">
        <xsl:text>recipes.php?remove=</xsl:text>
        <xsl:value-of select="recipe_id"/>
      </xsl:attribute>
   <xsl:text> Remove</xsl:text>
    </a></h1>
    </div>
  </xsl:template>

<!--  match "recipes.php?edit=id" -->
<xsl:template match="root/recipes_cookbook/recipes_edit">

  <div class="grid_12">
    <form id="form-1" name="edit" method="post" novalidate="novalidate">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
        <!--Apply-templates for all of the record/property elements -->
        <tr><td><xsl:text>Recipe_id:</xsl:text></td><td><input id="recipe_id" type="text" name="recipe_id" value="{recipe_id}" size="45"/></td></tr>
        <tr><td><xsl:text>Title:</xsl:text></td><td><input id="title" type="text" name="title" value="{title}" size="45" /></td></tr>
        <tr><td><xsl:text>Img:</xsl:text></td><td><input id="img" type="text" name="img" value="{img}" size="45"/></td></tr>
        <tr><td><xsl:text>Alt:</xsl:text></td><td><input id="alt" type="text" name="alt" value="{alt}" size="45"/></td></tr>

        <tr><td><xsl:text>Ingredients:</xsl:text></td><td><textarea id="ingredients" name="ingredients" cols="80" rows="5">  <xsl:value-of select="ingredients"/></textarea></td></tr>

         <tr><td><xsl:text>Directions:</xsl:text></td><td><textarea id="directions" name="directions" cols="80" rows="10">  <xsl:value-of select="directions"/></textarea></td></tr>

       <tr><td><xsl:text>Similar:</xsl:text></td><td><input id="similar" type="text" name="similar" value="{similar}" size="45"/></td></tr>

        <tr><td><input type="submit" name="submit" id="submit" value="Submit"/><xsl:text>   </xsl:text><a href="recipes.php?remove={recipe_id}" class="button">Delete</a></td></tr>

      </table>

    </form>
  </div>



</xsl:template>

  <!--  match "recipes.php login page" -->
    <xsl:template match="login">

    <xsl:variable name="name" select="name"/>
    <xsl:variable name="password" select="password"/>
    <form class="form-1" id="form-1" method="post">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
        <p class="field"><input id="username" type="text" name="username" placeholder="Username" value=""/>
        <i class="icon-user icon-large"></i></p>
       <p class="field"><input id="password" type="password" name="password" placeholder="Password" value=""/>
       <i class="icon-lock icon-large"></i></p>
      <p class="submit"><button type="submit" name="submit"><i class="icon-arrow-right icon-large"></i></button></p>
      </table>
    </form>

  </xsl:template>

 <xsl:template match="add">

<form id="form-1" name="edit" method="post" novalidate="novalidate">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
        <!--Apply-templates for all of the record/property elements -->
        <tr><td><xsl:text>Title:</xsl:text></td><td><input id="title" type="text" name="title" value="" size="45" /></td></tr>
        <tr><td><xsl:text>Img:</xsl:text></td><td><input id="img" type="text" name="img" value="" size="45"/></td></tr>
        <tr><td><xsl:text>Alt:</xsl:text></td><td><input id="alt" type="text" name="alt" value="" size="45"/></td></tr>

        <tr><td><xsl:text>Ingredients:</xsl:text></td><td><textarea id="ingredients" name="ingredients" cols="80" rows="5"> </textarea></td></tr>

         <tr><td><xsl:text>Directions:</xsl:text></td><td><textarea id="directions" name="directions" cols="80" rows="10">  </textarea></td></tr>

       <tr><td><xsl:text>Similar:</xsl:text></td><td><input id="similar" type="text" name="similar" value="" size="45"/></td></tr>
        <tr><td><input type="submit" name="submit" id="submit" value="Submit"/></td></tr>
      </table>

    </form>

   
    
  </xsl:template>




</xsl:stylesheet>