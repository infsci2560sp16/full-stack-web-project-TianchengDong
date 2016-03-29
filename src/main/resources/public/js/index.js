/* navbar animation */
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
    //alert($(this).attr("value"));
    var name = $(".favorited").val();
    alert(name);

    $.ajax({
      type: "GET",
      url: "/api/mapInfo/"+name,
      data: name,
      dataType: "xml",

      success: function (result) {

                console.log(result);
                var cname = $(result).find("name").first().text();
                if(cname !="information is not available yet")
                {
                var population = $(result).find("population").first().text();
                var location = $(result).find("location").first().text();
                var area = $(result).find("area").first().text();
                var language = $(result).find("language").first().text();
                var currency = $(result).find("currency").first().text();
                var time = $(result).find("time").first().text();
                var poi1 = $(result).find("poi1").first().text();
                var poi2 = $(result).find("poi2").first().text();
                var poi3 = $(result).find("poi3").first().text();
                $("#aaa").html("Description: <p>City Name: "+cname+";</p>"+
                                      "<p>Population: "+population+";</p>"+
                                      "<p>Location: "+location+";</p>"+
                                      "<p>Area: "+area+";</p>"+
                                      "<p>Language: "+language+";</p>"+
                                      "<p>Currency: "+currency+";</p>"+
                                      "<p>Time zone: "+time+";</p>"+
                                      "<p>Point of Interest: "+poi1+";</p>"+
                                      "<p>Point of Interest: "+poi2+";</p>"+
                                      "<p>Point of Interest: "+poi3+";</p>");
                }else{
                  $("#aaa").html("Description: <p>"+cname+"is favorited!</p>");

                }

                            },

      //If there was no resonse from the server
      error: function(jqXHR, textStatus, errorThrown){
           console.log("Something really bad happened " + textStatus);
            $("#aaa").html(jqXHR.responseText);
      }

  });


});


/* city info */
$(function () {
    $.ajax({
        url: "/api/about",
        success: function (result) {
            var data = JSON.parse(result);
             //alert(result.city);
            $("#bj h2").html(data.city1);
            $("#sh h2").html(data.city2);
            $("#xa h2").html(data.city3);
            $("#cd h2").html(data.city4);
            $("#hk h2").html(data.city5);
            $("#tp h2").html(data.city6);
            $("#bj p").html(data.description);
        }});
});
