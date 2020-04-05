<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<thead>
			<tr>
				<th>S. No.</th>
				<th>User Id</th>
				<th>User Name</th>
				<th>DOB</th>				
				<th>Gender</th>
				<th>Email</th>
				<th>Phone No</th>
				<th>Role</th>
				<th>Status</th>
				<th>Action</th>
				
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${record}" var="user">
				<tr>
					<td>${count.index}</td>
					<td>${user.userId}</td>
					<td>${user.fname}&nbsp;${user.lname}</td>
					<td>${user.dob}</td>
					<td>${user.gender}</td>
					<td>${user.email}</td>
					<td>${user.phno}</td>
					<td>${user.role}</td>
					<td>${user.accStatus}</td>
					<td>${user.activeSwitch}</td>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	
</body>
</html>