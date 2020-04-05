<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Password Page</title>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<style>
.error {
	color: #FF0000
}
</style>

<script>
	$(function() {
		$('form[id="chngPwd"]').validate({
			rules : {
				tempPwd : 'required',
				newPwd : {
					required : true
				},
				cnfPwd : {
					required : true,
					equalTo : '[name="newPwd"]' // <- any valid jQuery selector
				}

			},
			messages : {

				tempPwd : 'please enter temp pwd',
				newPwd : {
					required : ' Please enter new password'
				},
				cnfPwd : {
					required : ' Please make sure password matches above'
				}
			},
			submitHandler : function(form) {
				form.submit();
			}
		});

	});
</script>
</head>
<body>
	<form:form method="post" modelAttribute="cmd" id="chngPwd">

		<table>
			<tr>
				<td>Email ::</td>
				<td><form:input path="temail" value="${cmd.temail}"
						readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Temporary Password ::</td>
				<td><form:input path="tempPwd" /></td>
			</tr>
			<tr>
				<td>Enter New Password ::</td>
				<td><form:input path="newPwd" /></td>
			</tr>
			<tr>
				<td>Confirm New Password ::</td>
				<td><input type="text" name="cnfPwd" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form:form>


</body>
</html>