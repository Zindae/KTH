<?php
//database configuration
$config['mysql_host'] = "localhost";
$config['mysql_user'] = "dm2517";
$config['mysql_pass'] = "dm2517";
$config['db_name']    = "dm2517";

//connect to host
mysql_connect($config['mysql_host'],$config['mysql_user'],$config['mysql_pass']);
//select database
@mysql_select_db($config['db_name']) or die( "Unable to select database");


header('Content-Type: text/xml');

echo '<?xml version="1.0" encoding="ISO-8859-1"?>
<rss version="2.0">
<channel>
<title>Recipe</title>
<description>Recipe Databas</description>
<link>http://statecs.com/DM2517</link>';
$get_articles = "SELECT recipe_id, title, directions, 
DATE_FORMAT(date,'%a, %e %b %Y %T') as date
FROM recipes ORDER BY recipe_id DESC LIMIT 5";

$articles = mysql_query($get_articles) or die(mysql_error());

while ($article = mysql_fetch_array($articles)){
      
    echo '
       <item>
          <title>'.$article[title].'</title>
          <description><![CDATA[
          '.$article[directions].'
          ]]></description>
          <link>http://statecs.com/DM2517/index.php?id='.$article[recipe_id].'</link>
          <pubDate>'.$article[date].' GMT</pubDate>
      </item>';
}
echo '</channel>
</rss>';
?>