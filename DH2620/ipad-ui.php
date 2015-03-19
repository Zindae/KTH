
<!DOCTYPE html>

<html>
    <head>
    <meta charset="UTF-8">

        <title>Prototype</title>
            <meta name="viewport" content="minimal-ui">


        <meta name="description" content="Grupp C1">
        <link rel="stylesheet" href="css/home.css" type="text/css" media="screen" />
        <script src="js/modernizr.custom.js"></script>

        <!-- Internet Explorer -->
        <!--[if lt IE 9]>
            <script type="text/javascript" src="js/html5shiv.js"></script>
        <![endif]-->


    </head>
    <body>
    
    <audio id="kung">
          <source src="audio/kung.mp3">
          <source src="audio/kung.ogg">
    </audio>
    <audio id="stadion">
          <source src="audio/stadion.mp3">
          <source src="audio/stadion.ogg">
    </audio>
    <audio id="tc">
          <source src="audio/tc.mp3">
          <source src="audio/tc.ogg">
    </audio>
     <audio id="tekniska">
          <source src="audio/tekniska.mp3">
          <source src="audio/tekniska.ogg">
    </audio>


<?php 
if(strstr($_SERVER['HTTP_USER_AGENT'],'iPod') || strstr($_SERVER['HTTP_USER_AGENT'],'iPhone') || strstr($_SERVER['HTTP_USER_AGENT'],'iPad')) { ?>


<?php include 'iui.php';?>

<?php } /* ELSE */ else { ?>

<?php include 'wui.php';?>


<?php } 
?>

<?php include 'scripts.php';?>

</body>
</html>



