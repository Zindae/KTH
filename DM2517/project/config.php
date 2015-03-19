<?php
session_start();

// if debug is set to 1, the XML structure is printed instead of the result of the transformation
$debug = 0;

//connect to host
mysql_connect("localhost","dm2517","dm2517");
//select database
@mysql_select_db("dm2517") or die( "Unable to select database");


if($debug) {
  header("Content-type:text/xml");
} else {



// start buffering XML-content
ob_start();

}

function sqlToXml( $queryResult, $rootElementName, $childElementName, $comments=null)

{ 
    
$xmlData = '<root>';

if (!isset($_GET['q'])) {
$menu = mysql_query("SELECT * FROM menu ORDER BY menu_id ASC");

$xmlData .= "<menu>";
    while($record = mysql_fetch_object($menu)) {

    /* xml data tag ingredient  */
    $xmlData .= "<menu_item>";

    /* for each row */
    for ($c = 0; $c < mysql_num_fields($menu); $c++) {  
        /* create the nested filename with the table content */
        $fieldName = mysql_field_name($menu, $c); 

        $xmlData .= "<" . $fieldName . ">";
        /* print content of the ingredient record */
        $xmlData .= $record->$fieldName; 
        $xmlData .= "</" . $fieldName . ">"; 
    }

    $xmlData .= "</menu_item>";
} 
    $xmlData .= "</menu>";
}
    /* root element Name */
    $xmlData .= "<" . $rootElementName . ">";

    /* fetch object */
    while($record = mysql_fetch_object($queryResult))
    { 
        /* Create the first child element */
        $xmlData .= "<" . $childElementName . ">";
        
        /* for each result */
        for ($i = 0; $i < mysql_num_fields($queryResult); $i++)
        { 
            /* create field name with queryresult */
            $fieldName = mysql_field_name($queryResult, $i); 

              /* The child will take the name of the table column */
            $xmlData .= "<" . $fieldName . ">";
            

        if ( ($fieldName) == ('reviews') && (!$comments == null) ) {


                while($record_name = mysql_fetch_object($comments)) {

  /* xml data + counter */
                         $xmlData .= "<comment>";

                      for ($t = 0; $t < mysql_num_fields($comments); $t++) {  

                        $fieldName_nested = mysql_field_name($comments, $t); 

                            $xmlData .= "<" . $fieldName_nested . ">";

                            $xmlData .= $record_name->$fieldName_nested; 

                            $xmlData .= "</" . $fieldName_nested . ">"; 
                        }
              $xmlData .= "</comment>";

                }   


         }  else if (!empty($record->$fieldName)) {

                $xmlData .= $record->$fieldName; 

            } else {
                $xmlData .= "null"; 
            /* set empty columns with NULL */
               
            }
 
    $xmlData .= "</" . $fieldName . ">"; 

        } 
        $xmlData .= "</" . $childElementName . ">"; 
    } 
    $xmlData .= "</" . $rootElementName . ">"; 

 $xmlData .= '</root>';

    return $xmlData; 


}




?>


