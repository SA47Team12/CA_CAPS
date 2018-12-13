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

	<form:form method="POST" modelAttribute="lecturer"
		action="${pageContext.request.contextPath}/admin/lecturer/create.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr> 
					<td>First Name</td>
					<td><form:input path="firstname"/></td>
					<td><form:errors path="firstname" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastname"/></td>
					<td><form:errors path="lastname" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><form:input path="address"/></td>
					<td><form:errors path="address" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><form:input path="email"/></td>
					<td><form:errors path="email" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><form:input path="phone"/></td>
					<td><form:errors path="phone" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="password"/></td>
					<td><form:errors path="password" cssStyle="color: red;" /></td>
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