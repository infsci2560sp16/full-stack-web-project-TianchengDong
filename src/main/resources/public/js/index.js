/* Ripple-effect animation */
(function($) {
    $(".ripple-effect").click(function(e){
        var rippler = $(this);

        // create .ink element if it doesn't exist
        if(rippler.find(".ink").length == 0) {
            rippler.append("<span class='ink'></span>");
        }

        var ink = rippler.find(".ink");

        // prevent quick double clicks
        ink.removeClass("animate");

        // set .ink diametr
        if(!ink.height() && !ink.width())
        {
            var d = Math.max(rippler.outerWidth(), rippler.outerHeight());
            ink.css({height: d, width: d});
        }

        // get click coordinates
        var x = e.pageX - rippler.offset().left - ink.width()/2;
        var y = e.pageY - rippler.offset().top - ink.height()/2;

        // set .ink position and add class .animate
        ink.css({
          top: y+'px',
          left:x+'px'
        }).addClass("animate");
    })
})(jQuery);


/* vavbar animation */
$("#toggle").click( function(event){
    event.preventDefault();
    if ($(this).hasClass("isDown") ) {
        $( ".navbar-fixed-top" ).animate({ "margin-top": "-62px" }, "fast" );
        $( "#content" ).animate({ "margin-top": "5px" }, "fast" );
        $(this).removeClass("isDown");
    } else {
        $( ".navbar-fixed-top" ).animate({ "margin-top": "0px" }, "fast" );
        $( "#content" ).animate({ "margin-top": "80px" }, "fast" );
        $(this).addClass("isDown");
    }
    return false;
});


/* gallery card animation */
$('.all-content').hide();

var bgColor;
var effect = 'animated bounceInLeft'; /* bounceIn, bounceInUp, bounceInDown, bounceInLeft,
										 bounceInRight, rotateIn, rotateInUpLeft, rotateInDownLeft,
										 rotateInUpRight, rotateInDownRight  */

$('.content li').click(function(){
	$('.card-front, .card-back').hide();
	$('.content li').removeClass('active').hide().css('border','none');
	$(this).addClass('active').show();
	bgColor = $('.active .card-back').css('background-color');
	$('.content').css('background-color',bgColor);
	$('.close, .all-content').show();
	$('.responsive').append('<span class="close">close</span>').addClass(effect);
});


$('.responsive').on('click', '.close', function(){

	$('.close').remove();
	bgColor = $('.active .card-front').css('background-color');
	$('.responsive').removeClass(effect);
	$('.all-content').hide();
	$('.content li').removeClass('active').show().css({ 'border-bottom':'1px solid #2c2c2c',
													    'border-left':'1px solid #2c2c2c' });
	$('.card-front, .card-back').show();
	$('.content').css('background-color',bgColor);
});


/* favorite animation */
$('.favorite').click(function(){
  $(this).toggleClass('favorited');
});
