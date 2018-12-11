<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>

	<form:form method="POST" modelAttribute="student"
		action="${pageContext.request.contextPath}/student/edit/${student.studentId}.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<td>Student ID</td>
					<td type="text"></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td type="text"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td type="text"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td type="text"></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td type="text"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td type="text"></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td type="text"></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td type="text"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td type="text"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Submit"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
			</table>
		</center>

	</form:form>
</body>
</html>