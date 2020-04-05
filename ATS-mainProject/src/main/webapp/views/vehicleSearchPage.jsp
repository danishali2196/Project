<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

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
	.row.content {
		height: auto;
	}
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.container {
	padding: 16px;
}

span.psw {
	float: left;
	padding-top: 16px;
}

span.signup {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
}
</style>

</head>
<body>


	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img alt="logo"
				src="/images/atsLogo.jpg" width="35" height="20"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">

				<li><a href="/home">Home</a></li>
				<li class="active"><a href="/user/searchVhcl">Perchase Tag</a></li>
				<li><a href="#">My Tag</a></li>
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
					<c:choose>
						<c:when test="${!empty vhclInfo}">
							<form:form action="/tag/perchase" method="post" modelAttribute="info">
							<form:hidden path="vchlRegNo" value="${vhclInfo.vehicleReg.vehicleRegNo}"/>
							<form:hidden path="vhclType" value="${vhclInfo.vehicle.type}"/>
							<h2>
								Vehicle Registration Number :: <b>${vhclInfo.vehicleReg.vehicleRegNo}</b>
							</h2>
							<h4>
								<table >
									<tr>
										<td>Vehicle Owner Name</td>
										<td><label>
												${vhclInfo.owner.fname}&nbsp;${vhclInfo.owner.lname} </label></td>
									</tr>
									<tr>
										<td>Vehicle Type</td>
										<td><label>${vhclInfo.vehicle.type}</label></td>
									</tr>
									<tr>
										<td>Manufacturing Year</td>
										<td><label> ${vhclInfo.vehicle.year} </label></td>
									</tr>
									<tr>
										<td>Vehicle Company</td>
										<td><label> ${vhclInfo.vehicle.company}<label></td>
									</tr>
									<tr>
										<td>Vehicle Owner Address</td>
										<td><label> ${vhclInfo.ownerAddrs.hno},
												${vhclInfo.ownerAddrs.street}<br>${vhclInfo.ownerAddrs.city},
												${vhclInfo.ownerAddrs.zip}
										</label></td>
									</tr>
								</table>
							</h4>
							<button type="submit" >Proceed</button>
							</form:form>
						</c:when>
						<c:otherwise>
							<center><img alt="sad_emoji" src="/images/sad_emoji.png" width="300" height="250"> </center>
							<h1 style="color: red; text-align: center; font-style: italic; font-family: serif;">Vehicle Registration number is invalid..!!</h1><br><br>
							<h3 style="color: blue; text-align: center; font-style: italic; font-family: cursive;"> try again with valid Vehicle Registration number..!!</h3>
						</c:otherwise>
					</c:choose>

				</div>
			</div>

			<div class="col-sm-4 sidenav">
				<div class="well">
					<h2>Search Vehicle</h2>

					<div class="container" style="width: 270px;">
						<form action="/rest/info" method="get">
							<label for="uname"><b>Enter Vehicle Reg No</b></label> <input
								type="text" name="vhclRegNo" placeholder="enter vehicle no">
							<button type="submit" >Search</button>

						</form>

					</div>


				</div>
			</div>

		</div>
	</div>

	<footer class="container-fluid text-center">
	<p>&copy; 2015 Reserved All Content</p>
	</footer>
</body>
</html>