<?php include 'prefix.php';?>

<rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns="http://purl.org/rss/1.0/" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:syn="http://purl.org/rss/1.0/modules/syndication/">
<channel rdf:about="http://www.nada.kth.se/media/Theses/"> 
        <title>Examensarbeten medieteknik</title>
        <link>http://www.nada.kth.se/media/Theses/</link>
        <description>Examensarbeten inom medieteknik.</description>
        <dc:language>sv</dc:language>
        <dc:rights>Copyright KTH/Nada/Media</dc:rights>
        <dc:date><?php echo date(DATE_ATOM, mktime(09, 41, 35, 10, 19, 2006)); ?></dc:date>



        <dc:publisher>KTH/Nada/Media</dc:publisher>
        <dc:creator>bjornh@kth.se</dc:creator>
        <syn:updatePeriod>daily</syn:updatePeriod>
        <syn:updateFrequency>1</syn:updateFrequency>
        <syn:updateBase><?php echo date(DATE_ATOM, mktime(0, 0, 0, 01, 01, 2006)); ?></syn:updateBase>

<?php
    // Connect using host, username, password and databasename
    $mysql = mysqli_connect('localhost', 'rsslab', 'rsslab', 'rsslab');

    // Check connection
    if (mysqli_connect_errno()) {
        printf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    }

    // The SQL query
   $query = "SELECT title, link, description, creator, feeddate
                FROM exjobbsfeed
                ORDER BY feeddate ASC";

    // Execute the query
    if (($result = mysqli_query($mysql, $query)) === false) {
       printf("Query failed: %s<br />\n%s", $query, mysqli_error($mysql));
       exit();
    }


    $returnheader = '';

    $querylink = mysqli_query($mysql,"SELECT link FROM exjobbsfeed");

    $returnheader .= "<items><rdf:Seq>";

            while($row = mysqli_fetch_array($querylink)){
                $linkformat = str_replace(' ','%20', $row['link']);

                $returnheader .= "<rdf:li rdf:resource='$linkformat' />"; 
            }

    $returnheader .= "</rdf:Seq></items><image rdf:resource='http://www.nada.kth.se/media/images/kth.png'/></channel>";


    $returnstring = '';
// Loop over the resulting lines
   while ($line = $result->fetch_object()) {
        // Store results from each row in variables
        $link = $line->link;
        $title = $line->title;
        $description = $line->description;
        $creator = $line->creator;
        $feeddate = $line->feeddate;

        $timestamp = strtotime($feeddate);
        $date = date("c", $timestamp);

        // Store the result we want by appending strings to the variable $returnstring

        $link_format = preg_replace('/ /','%20',$link);
        $desc_format = preg_replace('/&/','&amp;',$description);

        $returnstring .= "<item rdf:about='$link_format'>";
        $returnstring .= "<title>$title</title>";
        $returnstring .= "<link>$link_format</link>";
        $returnstring .= " <description>$desc_format</description>";
        $returnstring .= "<dc:creator>$creator</dc:creator>";
        $returnstring .= "<dc:date>$date</dc:date>";
        $returnstring .= "</item>";
    }

    // Free result and just in case encode result to utf8 before returning
    mysqli_free_result($result);
    print utf8_encode($returnheader);
    print utf8_encode($returnstring);

?>

</rdf:RDF>
<?php include 'postfix.php';?>