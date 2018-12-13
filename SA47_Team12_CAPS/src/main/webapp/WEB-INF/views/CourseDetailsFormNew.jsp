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

	<form:form method="POST" modelAttribute="course"
		action="${pageContext.request.contextPath}/admin/createcourse.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<%-- <td>Student ID</td>
					<td><form:input path="studentId"/></td> --%>
				</tr>
				<tr>
					<td>Course id</td>
					<td><form:input path="courseId"/></td>
				</tr>
				<tr>
					<td>Capacity</td>
					<td><form:input path="capacity"/></td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td><form:input path="startDate"/></td>
				</tr>
			
				<tr>
				<td>Code</td>
					<td><form:input path="courseDetail.courseCode"/></td>
				
			</tr>
			
			<tr>
				<td>Course Name</td>
					<td><form:input path="courseDetail.name"/></td>
				
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