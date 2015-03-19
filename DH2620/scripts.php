<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery-showcase-2.2.min.js"></script>


<script src="js/hammer.min.js"></script>
<script src="js/hammer.jquery.min.js"></script>

<script type="text/javascript">

function closewindow() {

       $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', 'c1.html'); 
              $('#targetFrame').fadeIn(1500);
      });

    document.getElementById('container').getElementsByClassName('metromp')[0].click();

$('audio').each(function() {
     if(!this.paused){
        this.pause();
     }
    });
}


 location.hash = "";
    function closep() {
        window.location.reload();
    }
    function prev(){
        document.getElementById('targetFrame').contentWindow.$('ul').previous();
    }
    function next(){
        document.getElementById('targetFrame').contentWindow.$('ul').next();
    }
    function goto0(){
        document.getElementById('targetFrame').contentWindow.$('ul').gotoSlide(0);
    }
    function goto1(){
        document.getElementById('targetFrame').contentWindow.$('ul').gotoSlide(1);
    }
    function goto2(){
        document.getElementById('targetFrame').contentWindow.$('ul').gotoSlide(2);
    }
    function goto3(){
        document.getElementById('targetFrame').contentWindow.$('ul').gotoSlide(3);
    
    }


$(function(){  
    
    /*  var red = document.querySelectorAll("#footer, #footer1, #footer2, #footer3");*/
        var foot = document.getElementById("footer");
        var foot1 = document.getElementById("footer1");
        var foot2 = document.getElementById("footer2");
        var foot3 = document.getElementById("footer3");
        var foot4 = document.getElementById("footer4");
        var foot5 = document.getElementById("footer5");

//Swipe
    Hammer(foot).on("swipeleft", function() {
       document.getElementById('targetFrame').contentWindow.$('ul').next();
    });

      Hammer(foot1).on("swipeleft", function() {
       document.getElementById('targetFrame').contentWindow.$('ul').next();
    });

    Hammer(foot).on("swiperight", function() {
       document.getElementById('targetFrame').contentWindow.$('ul').previous();
    });
    
      Hammer(foot1).on("swiperight", function() {
       document.getElementById('targetFrame').contentWindow.$('ul').previous();
    });
});



$(function(){
    $('#targetFrame').load(function(){
        $(this).show();
        console.log('load the iframe')
    });

});
 
  $("#kung,#tekniska,#tc,#stadion").on("play", function (me) {
         jQuery('audio').each(function (i,e) {
              if (e != me.currentTarget)
              { 
                  this.pause(); 
              }
         });
 });

$( ".metromp" ).click(function() {

       $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', 'c1.html'); 
              $('#targetFrame').fadeIn(1500);
      });

  $('#container').addClass('map_maximize');

     $('audio').each(function() {
     if(!this.paused){
        this.pause();
     }
    });

});

 $( "div#click1" ).click(function() {


 $('#targetFrame').fadeOut(500,function(){
          $('#targetFrame').attr('src','1p.html' );
          $('#targetFrame').fadeIn(1500);
      });

            $( "#container" ).removeClass( "map_maximize");
        $('#container').addClass('map_minimize');

    if ($(".popup_content").is(":visible")){
      document.getElementById('kung').play();
  } else {
       document.getElementById('kung').pause();

}

});
 $( "area#click1" ).click(function() {

   $('#targetFrame').fadeOut(500,function(){
          $('#targetFrame').attr('src', '1p.html'); 
          $('#targetFrame').fadeIn(1500);
      });

        
        

         if ($(".popup_content").is(":visible")){
      document.getElementById('kung').play();
  } else {
       document.getElementById('kung').pause();

}
});
$( "div#click2" ).click(function() {
        
          $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', '2p.html'); 
              $('#targetFrame').fadeIn(1500);
      });

        
        $( "#container" ).removeClass( "map_maximize");
        $('#container').addClass('map_minimize');

         if ($(".popup_content").is(":visible")){
      document.getElementById('tc').play();
  } else {
       document.getElementById('tc').pause();

}
});
$( "area#click2" ).click(function() {

       $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', '2p.html'); 
              $('#targetFrame').fadeIn(1500);
      });
        

         if ($(".popup_content").is(":visible")){
      document.getElementById('tc').play();
  } else {
       document.getElementById('tc').pause();

}
});
$( "div#click3" ).click(function() {

       $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', '3p.html'); 
              $('#targetFrame').fadeIn(1500);
      });
        

           $( "#container" ).removeClass( "map_maximize");
        $('#container').addClass('map_minimize');

         if ($(".popup_content").is(":visible")){
      document.getElementById('stadion').play();
  } else {
       document.getElementById('stadion').pause();

}
});
$( "area#click3" ).click(function() {

       $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', '3p.html'); 
              $('#targetFrame').fadeIn(1500);
      });
        

         if ($(".popup_content").is(":visible")){
      document.getElementById('stadion').play();
  } else {
       document.getElementById('stadion').pause();

}
});
$( "div#click4" ).click(function() {
        
             $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', '4p.html'); 
              $('#targetFrame').fadeIn(1500);
      });

           $( "#container" ).removeClass( "map_maximize");
        $('#container').addClass('map_minimize');
         if ($(".popup_content").is(":visible")){
      document.getElementById('tekniska').play();
  } else {
       document.getElementById('tekniska').pause();

}
});
$( "area#click4" ).click(function() {
        

             $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', '4p.html'); 
              $('#targetFrame').fadeIn(1500);
      });


         if ($(".popup_content").is(":visible")){
      document.getElementById('tekniska').play();
  } else {
       document.getElementById('tekniska').pause();

}
});
$( "div#click5" ).click(function() {

       $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', '5p.html'); 
              $('#targetFrame').fadeIn(1500);
      });
        

           $( "#container" ).removeClass( "map_maximize");
        $('#container').addClass('map_minimize');
});
$( "area#click5" ).click(function() {

       $('#targetFrame').fadeOut(500,function(){
              $('#targetFrame').attr('src', '5p.html'); 
              $('#targetFrame').fadeIn(1500);
      });
        
        $('#targetFrame').attr('src', '5p.html'); 
});



(function($){  //This functions first parameter is named $
   $(window).load(function(){
        $('#container').ShowCase();
   })
})(jQuery); 



 $("#grid").hide();

 $('#imgClick').click(function() {
  var clicks = $(this).data('clicks');
  if (clicks) {

 $( "#footer_btn" ).slideDown();

 $( "#grid" ).slideDown();

  } else {
 
 $( "#grid" ).slideUp();

  }
  $(this).data("clicks", !clicks);
});



</script>
<script src="js/classie.js"></script>
        <script src="js/uiMorphingButton_inflow.js"></script>
        <script>
            (function() {
                new UIMorphingButton( document.querySelector( '.morph-button' ) );

                // for demo purposes only
                [].slice.call( document.querySelectorAll( 'form button' ) ).forEach( function( bttn ) { 
                    bttn.addEventListener( 'click', function( ev ) { ev.preventDefault(); } );
                } );
            })();
        </script>
        <script src='js/packery.pkgd.js'></script>
        <script src="js/draggabilly.pkgd.min.js"></script>
        <script src="js/dragdrop.js"></script>
        <script>
            (function() {
                var body = document.body,
                    dropArea = document.getElementById( 'drop-area' ),
                    droppableArr = [], dropAreaTimeout;

var slidesElem = document.querySelector('#grid');
  var slideSize = getSize( document.querySelector('.grid__item') );
  var pckry = new Packery( slidesElem, {
    rowHeight: slideSize.outerHeight
  });

  // get item elements
  var itemElems = pckry.getItemElements();
  // for each item...
  for ( var i=0, len = itemElems.length; i < len; i++ ) {
    var elem = itemElems[i];
    // make element draggable with Draggabilly
    var draggie = new Draggabilly( elem, {
      axis: 'xy'
    });
    // bind Draggabilly events to Packery
    pckry.bindDraggabillyEvents( draggie );
  }

  // re-sort DOM after item is positioned
  pckry.on( 'dragItemPositioned', function( _pckry, draggedItem ) {
    var index = pckry.items.indexOf( draggedItem );
    var nextItem = pckry.items[ index + 1 ];
    if ( nextItem ) {
      slidesElem.insertBefore( draggedItem.element, nextItem.element );
    } else {
      slidesElem.appendChild( draggedItem.element );
    }

  });


   
            })();
        </script>