// validate contact form
$(function() {
    $('#form-1').validate({
        rules: {
            recipe_id: {
                required: true,
                digits: true
            },
            title: {
                required: true,
                minlength: 5
            },
             ingredients: {
                required: true
            },
             alt: {
                required: true
            },
            username: {
                required: true,
            },
             password: {
                required: true,
            },
        },
        messages: {
             recipe_id: {
                required: "This field is required",
                digits: "This field can only contain numbers"
            },
            title: {
                required: "This field is required",
                minlength: "The title must consist of at least 5 characters"
            },
            ingredients: {
                required: "This field is required"
            },
            alt: {
                required: "This field is required",
            },
            username: {
                required: "This field is required",
            },
            password: {
                required: "This field is required",
            }
        },
        submitHandler: function(form) {
            $("#form-1").ajaxSubmit({
                type:"POST",
                data: $(form).serialize(),
                success: function() {
                    $('#form-1 :input').attr('disabled', 'disabled');
                    $('#form-1').fadeTo( "slow", 0.15, function() {
                        $(this).find(':input').attr('disabled', 'disabled');
                        $(this).find('label').css('cursor','default');
                        window.location = "recipes.php";
                    });
                },
                error: function() {
                    $('#form-1').fadeTo( "slow", 0.15, function() {
                        $('#error').fadeIn();
                    });
                }
            });
        }
    });
});


function showResult(str) {
    
if (str.length==0) { 
    document.getElementById("recipe").innerHTML="";
    document.getElementById("recipe").style.border="0px";
    return;
  }
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
  } else {  // code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState==4 && xmlhttp.status==200) {
      document.getElementById("recipe").innerHTML=xmlhttp.responseText;
      document.getElementById("recipe").style.border="0px solid #A5ACB2";
    }
  }
  xmlhttp.open("GET","index.php?q="+str,true);
  xmlhttp.send();
}

 $(function(){ 
        //alert(event.timeStamp);
        $('.new-com-bt').click(function(event){    
            $(this).hide();
            $('.new-com-cnt').show();
            $('#name-com').focus();
        });

        /* when start writing the comment activate the "add" button */
        $('.the-new-com').bind('input propertychange', function() {
           $(".bt-add-com").css({opacity:0.6});
           var checklength = $(this).val().length;
           if(checklength){ $(".bt-add-com").css({opacity:1}); }
        });

        /* on clic  on the cancel button */
        $('.bt-cancel-com').click(function(){
            $('.the-new-com').val('');
            $('.new-com-cnt').fadeOut('fast', function(){
                $('.new-com-bt').fadeIn('fast');
            });
        });

        // on post comment click 
        $('.bt-add-com').click(function(){
            var theCom = $('.the-new-com');
            var theName = $('#name-com');
            var theMail = $('#mail-com');

            if( !theCom.val()){ 
                alert('You need to write a comment!'); 
            }else{ 
                $("#form").ajaxSubmit({
                    type: "POST",
                    success: function(html){
                        theCom.val('');
                        theMail.val('');
                        theName.val('');
                        $('.new-com-cnt').hide('fast', function(){
                            $('.new-com-bt').show('fast');
                            window.location.reload();
                          
                        })
                    }  
                });
            }
        });

    });


(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/sv_SE/sdk.js#xfbml=1&appId=1598493660378988&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));