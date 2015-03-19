//menu.js
//Christopher State

//FrontPage slide class
$(window).load(function(){
$(function(){
    $(".pic").hover(function() {
      //Load class 'hover' when class .pic is mousehovered
      $( this ).addClass( "hover" ); 
    }, function() {
      //remove class
    $( this ).removeClass( "hover" ); 
    });
});
});

//Lightbox Login form
 function createlightbox()
    {
        document.getElementById('light').style.display='block';
        document.getElementById('fade').style.display='block'
    }
    function closelightbox()
    {
        document.getElementById('light').style.display='none';
        document.getElementById('fade').style.display='none'
    }

//MouseHover one recipe in menu, timeout 4 sec and autoload url
$(window).load(function(){
  $('.onhover').hover(function()
  {
      $(this).data('timeout', window.setTimeout(function()
      {
        //causes the browser to refresh and load the requested url (in 4 seconds)
        var href = $('.onhover').attr('href');
        window.location.href = href; 
      }, 4000));

  },function() {
        //The clearTimeout() method clears a timer set with the setTimeout() method.
        clearTimeout($(this).data('timeout')); 
      });
});

//Hide/show registration/login form
$(window).load(function(){

    //hide registration div
   $(".registration").hide(); 
   //show regisistration form
   $(".registerform").show(); 

  //toggle
   $('.registerform').toggle(function(){ 

      //login form slides up
      $(".login").slideUp(); 

       //registration div slides down
       $(".registration").slideDown();
   },function(){
    //registration div slides up
       $(".registration").slideUp();
   });
   $('.loginform').toggle(function(){
      $(".login").slideDown();
       $(".registration").slideUp();
   },function(){
       $(".registration").slideDown();
   });
});

//Validation of Password input
$(window).load(function(){
$(document).ready(function () {

  //AddMethod to validate PasswordOneDigit
  jQuery.validator.addMethod( 
        'ContainsAtLeastOneDigit',
        function (value) {
            return /[0-9]/.test(value);
        },
        'Your password must end with a digit.'
    );
    
    //addMethod to validate OneCaptialLetter
    jQuery.validator.addMethod( 
        'ContainsAtLeastOneCapitalLetter',
        function (value) {
            return /[A-Z]/.test(value);
        },
        'Your password must start with a capital letter.'
    );

    // initialize the validation
    $('#registration').validate({ 
        rules: {
            password: {
                required: true,
                minlength: 10,
                ContainsAtLeastOneDigit: true,
                ContainsAtLeastOneCapitalLetter: true
            },
            c_password: {
              required: true, equalTo: "#password", minlength: 10
            }
        }
    });

});
});

//Password Generator

$.extend({
  password: function (length) {

    //The random string will be created from these characters.
    var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
    var capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    var numbers = "0123456789";
    var string_length = 4;
    var password = '';

      for (var i=0; i<string_length; i++) {
      var rchar = Math.floor(Math.random() * chars.length);
      var rlet = Math.floor(Math.random() * capitalLetters.length);
      var rnumb = Math.floor(Math.random() * numbers.length);
      //string_length of each element, CapitalLetters, Chars and Numbers
      password += capitalLetters.substring(rlet,rlet+1)+chars.substring(rchar,rchar+1)+numbers.substring(rnumb,rnumb+1);
  }
    return password;
  }
});
//Confirm password
$(document).ready(function() {
  $('.link-password').click(function(e){

    // First check which link was clicked
    linkId = $(this).attr('id');
    if (linkId == 'generate'){
        password = $.password();

        // Empty the random tag then append the password and fade In
        $('#random').empty().hide().append(password).fadeIn('slow');

        // Also fade in the confirm link
        $('#confirm').fadeIn('slow');
    } else {

      // If the confirm link is clicked then input the password into our form field
      $('.loginPassword').val(password);

      // remove password from the random tag
      $('#random').empty();

      // Hide the confirm link again
      $(this).hide();
    }
    e.preventDefault();
  });
});