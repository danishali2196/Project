<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>ATS-About Us</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    
}
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><img alt="logo" src="/images/atsLogo.jpg" width="35" height="20"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/home">Home</a></li>
        <li class="active"><a href="#">About</a></li>
        <li><a href="/views/contactUs.jsp">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <h3 style="color: gray;">ATS-Automatic Tolling System</h3>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
   
    <div class="col-sm-8 text-left">
     <div class="split left">
		<h1>About Us</h1>
		<br>
		<p><h3>ATS is a simple to use, reloadable tag which enables automatic deduction of toll charges and lets you pass through the toll plaza without stopping for the cash transaction. ATS is linked to a prepaid account from which the applicable toll amount is deducted. </h3></p>
		<p><h3>The tag employs Radio-frequency Identification (RFID) technology and is affixed on the vehicle's windscreen after the tag account is active.</h3>	
		<p><h3>ATS is a perfect solution for a hassle free trip on national highways. ATS is presently operational at 407 toll plazas across national and state highways. More toll plazas will be brought under the ATS program in the future.</h3></p>
	</div>
    </div>
    <div class="col-sm-4 sidenav">
      <div class="well">
       
		</div>
      </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>&copy; 2015 Reserved All Content</p>
</footer>

</body>
</html>
