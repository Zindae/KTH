<?php include("config.php"); ?>

<?php  // the query

if(empty($_SESSION["authenticated"]) || $_SESSION["authenticated"] != 'true') {

$username = null;
$password = null;

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    if(!empty($_POST["username"]) && !empty($_POST["password"])) {
        $username = $_POST["username"];
        $password = $_POST["password"];
        
        if($username == 'admin' && $password == 'password') {
            session_start();
            $_SESSION["authenticated"] = 'true';

               $result = mysql_query("SELECT * FROM recipes");
                 
                /* If you want to process the returned xml rather than send it
                    to the browser, remove the below line.
                */

                  if (!$result) {
                    die('Invalid query: ' . mysql_error());
                }

                echo utf8_encode(sqlToXml($result, "recipes_cookbook", "list_recipes")); 
        }
       
    } 
} else { 


echo utf8_encode(sqlToXml("recipes_cookbook", "login")); 

 } 

}  else if (isset($_GET['add'])) {

 if(isset($_POST['submit']))
{

     $img = mysql_real_escape_string(htmlspecialchars($_POST["img"]));
     $title = mysql_real_escape_string(htmlspecialchars($_POST["title"]));
     $alt = mysql_real_escape_string(htmlspecialchars($_POST["alt"]));
     $ingredients = mysql_real_escape_string(htmlspecialchars($_POST["ingredients"]));
     $directions = mysql_real_escape_string(htmlspecialchars($_POST["directions"]));
     $similar = mysql_real_escape_string(htmlspecialchars($_POST["similar"]));

mysql_query("SET NAMES 'utf8'"); 
mysql_query('SET CHARACTER SET utf8');

$sql = "INSERT INTO recipes (img, title, alt, directions, ingredients, similar, date) VALUES ('$img','$title','$alt','$directions','$ingredients', '$similar', NOW());";
 
mysql_query($sql);

}
    else{
       echo utf8_encode(sqlToXml("recipes_cookbook", "add"));                 // close it when finished   
}

}

 // get the 'id' value from the URL (if it exists), making sure that it is valid (checing that it is numeric/larger than 0)
 else if (isset($_GET['edit']) && is_numeric($_GET['edit']) && $_GET['edit'] > 0) 
 {

 // query db
 $id = $_GET['edit'];

 $result = mysql_query("SELECT * FROM recipes WHERE recipe_id='$id'");
$comments = mysql_query("SELECT comment_id, comment_date, comments, name, email
FROM recipes AS a 
LEFT JOIN reviews AS b ON a.recipe_id = b.recipe_id 
WHERE a.recipe_id='$id'") or die(mysql_error());


 if (isset($_POST['submit'])) {

 $title = mysql_real_escape_string(htmlspecialchars($_POST["title"]));
 $img = mysql_real_escape_string(htmlspecialchars($_POST["img"]));
 $alt = mysql_real_escape_string(htmlspecialchars($_POST["alt"]));
 $directions = mysql_real_escape_string(htmlspecialchars($_POST["directions"]));
 $ingredients = mysql_real_escape_string(htmlspecialchars($_POST["ingredients"]));
 $similar = mysql_real_escape_string(htmlspecialchars($_POST["similar"]));

mysql_query("SET NAMES 'utf8'"); 
mysql_query('SET CHARACTER SET utf8');

$query = mysql_query("UPDATE recipes SET title='$title', img='$img', alt='$alt', ingredients='$ingredients', directions='$directions', similar='$similar' WHERE recipe_id='$id'") or die(mysql_error());


  print utf8_encode(sqlToXml($result, "recipes_cookbook", "recipes_edit", $comments )); 


}
    else{
           print utf8_encode(sqlToXml($result, "recipes_cookbook", "recipes_edit", $comments ));         // close it when finished   
}


}  else if (isset($_GET['remove']) && is_numeric($_GET['remove']) && $_GET['remove'] > 0) 
 {

 $id = $_GET['remove'];

$query = mysql_query("DELETE FROM recipes WHERE recipe_id = '$id'") or die(mysql_error());

$result = mysql_query("SELECT * FROM recipes WHERE recipe_id='$id'");
$comments = mysql_query("SELECT comment_id, comment_date, comments, name, email
FROM recipes AS a 
LEFT JOIN reviews AS b ON a.recipe_id = b.recipe_id 
WHERE a.recipe_id='$id'") or die(mysql_error());

print utf8_encode(sqlToXml($result, "recipes_cookbook", "recipes_edit", $comments )); 

 }


else {

/* Sql query */
$result = mysql_query("SELECT * FROM recipes");
                 
/* If you want to process the returned xml rather than send it to the browser, remove the below line.
*/

if (!$result) {
  die('Invalid query: ' . mysql_error());
}

echo utf8_encode(sqlToXml($result, "recipes_cookbook", "list_recipes")); 

}


if (!($debug)) {
  // do the transformations. Look in the file postfix.php to see how it works.
  include("postfix.php");
}
?>