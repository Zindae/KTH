<?php

// Load the XML source
$xml = new DOMDocument;
$xml->load('nyheter.xml');

$xsl = new DOMDocument;
$xsl->load('nyheter-html.xsl');

// Configure the transformer
$proc = new XSLTProcessor;
$proc->importStyleSheet($xsl); // attach the xsl rules

?>
<!-- Christopher State-->


<?php echo $proc->transformToXML($xml); ?>




