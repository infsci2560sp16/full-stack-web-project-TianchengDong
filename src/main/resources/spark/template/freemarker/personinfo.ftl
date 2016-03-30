<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" type="text/css" href="stylesheets/main.css">
  <title> My information </title>
</head>

<body>
<div class="navbar-wrapper">
    <nav class="navbar bg-faded navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand ripple-effect" href="#">MEET <span style="font-family:Skia;">Asia</span> </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active ripple-effect"><a href="index.html">Home</a></li>
            <li class="ripple-effect"><a href="login.html">Log in</a></li>
            <li class = "active"><a href="/personinfo"> My information</a></li>
            <li class="ripple-effect"><a href="mypage.html">My page</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle ripple-effect" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Gallery<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="gallery.html">All destinations</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Category</li>
                <li><a href="china.html">China</a></li>
                <li><a href="southkorea.html">South Korea</a></li>
                <li><a href="japan.html">Japan</a></li>
                <li><a href="india.html">India</a></li>
                <li><a href="thailand.html">Thailand</a></li>
                <li><a href="more.html">More ...</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a class="ripple-effect" href="">Log out</a></li>
          </ul>
        </div>
      </div>
    </nav>


</div>


<div id="person">

  	<h2><b>Hello, ${username}</b></h2>
    <#if city??>
    <div id ="personinfo">No cities have been favorited!</div>
    <#else >

    <ul>
      <#list cities as city>
      <li> ${city}</li>
    </ul>
      </#list>
    </div>
    </#if>
</div>

</body>
</html>
