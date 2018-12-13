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

	<form:form method="POST" modelAttribute="CourseDetails"
		action="${pageContext.request.contextPath}/course/coursedetails/create.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
<%-- 				<tr>
					<td>Course Code</td>
					<td><form:input path="courseCode" readonly="true"/></td>
				</tr> --%>
				<tr>
					<td>Credit</td>
					<td><form:input path="credit"/></td>>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:input path="description"/></td>
				</tr>
				<tr>
					<td>Duration</td>
					<td><form:input path="duration"/></td>
				</tr>
				<tr>
					<td>Course Name</td>
					<td><form:input path="name"/></td>
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