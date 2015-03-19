<?php include("config.php"); ?>

<?php  // the query



 // get the 'id' value from the URL (if it exists), making sure that it is valid (checking that it is numeric/larger than 0)
 if (isset($_GET['id']) && (isset($_POST['send'])) && is_numeric($_GET['id']) && $_GET['id'] > 0)
 {


 $id = $_GET['id'];

    $comments = mysql_real_escape_string(htmlspecialchars($_POST["comment"]));
   	$name = mysql_real_escape_string(htmlspecialchars($_POST["name"]));
    $email = mysql_real_escape_string(htmlspecialchars($_POST["email"]));

if(strlen($name) <= '1'){ $name = 'Guest';}

mysql_query("SET NAMES 'utf8'"); 
mysql_query('SET CHARACTER SET utf8');
 mysql_query("INSERT INTO reviews (comments, name, email, recipe_id, comment_date) VALUES( '$comments', '$name', '$email', '$id', NOW());") or die(mysql_error());



} else if (isset($_GET['id']) && is_numeric($_GET['id']) && $_GET['id'] > 0){

	 $id = $_GET['id'];

	$result = mysql_query("SELECT * FROM recipes WHERE recipe_id='$id'");
$comments = mysql_query("SELECT comment_id, comment_date, comments, name, email
FROM recipes AS a 
LEFT JOIN reviews AS b ON a.recipe_id = b.recipe_id 
WHERE a.recipe_id='$id'") or die(mysql_error());

	print utf8_encode(sqlToXml($result, "recipes_cookbook", "recipes", $comments )); 

}


  else if (isset($_GET['q'])) {

$q = mysql_real_escape_string($_GET['q']);

if (empty($_GET)){
$result = mysql_query("SELECT * FROM recipes" );
echo utf8_encode(sqlToXml($result, "recipes_cookbook", "front_recipes")); 
}

$result = mysql_query("SELECT * FROM recipes WHERE title LIKE '%{$q}%'");

echo utf8_encode(sqlToXml($result, "recipes_cookbook", "front_recipes")); 
}

else {

/* Sql query GROUP_CONCAT amount, ingredient_name, similar_id and comments LEFT JOIN */
$result = mysql_query("SELECT * FROM recipes" );

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

	echo utf8_encode(sqlToXml($result, "recipes_cookbook", "front_recipes")); 

}




if (!($debug)) {
  // do the transformations. Look in the file postfix.php to see how it works.
  include("postfix.php");
}
?>