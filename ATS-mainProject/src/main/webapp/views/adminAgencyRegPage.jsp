<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Sign Up</title>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>

<style>
.error {
	color: #FF0000
}
</style>

<script>
	$(function() {
		$('form[id="userDtle"]')
				.validate(
						{
							rules : {
								fname : 'required',
								lname : 'required',
								gender : 'required',
								email : {
									required : true,
									email : true,
								},
								phno : {
									required : true,
									minlength : 10,
									maxlength : 10
								},
								dob : 'required',
								role : 'required',
							},
							messages : {
								fname : 'Please Enter First Name',
								lname : 'please enter Last Name',
								gender : 'please enter Last Name',
								email : 'Please enter valid email',
								phno : {
									required : "Please Enter phone Number",
									minlength : "Phone number must be 10 digit",
									maxlength : "Phone number must be 10 digit"
								},
								dob : 'please enter Date Of Birth',
								role : 'please select role',
							},
							submitHandler : function(form) {
								form.submit();
							}
						});

	});
</script>
</head>
<body>

	<h2 style="color: red; text-align: center;">User Registration</h2>
	<form:form method="post" modelAttribute="cmd" id="userDtle">
		<table>
			<tr>
				<td>First Name ::</td>
				<td><form:input path="fname" /></td>
			</tr>

			<tr>
				<td>Last Name ::</td>
				<td><form:input path="lname" /></td>
			</tr>

			<tr >
				<td>Gender ::</td>
				<td><form:radiobutton path="gender" value="m"/>Male &nbsp;&nbsp; 
				<form:radiobutton path="gender" value="f"/>Female
				</td>
			</tr>

			<tr>
				<td>Email ::</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td>Phone No ::</td>
				<td><form:input path="phno" /></td>
			</tr>

			<tr>
				<td>Date of Birth ::</td>
				<td><form:input path="dob" id="datepicker" /></td>
			</tr>
			
			<tr>
				<td>Role ::</td>
				<td><form:select path="role">
					<form:option value="admin">Admin</form:option>
					<form:option value="agency">Agency</form:option>
					<form:option value="user">User</form:option>
				</form:select> </td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="SignUp" /></td>
			</tr>


		</table>
	</form:form>
	
</body>


</html>