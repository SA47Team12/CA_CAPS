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

	<form:form method="POST" modelAttribute="courselecturer"
		action="${pageContext.request.contextPath}/admin/assignlecturer/createcourselecturer.html">
		<center>
			<table>
				
				<tr>
					<td>Course Lecturer Id</td>
					<td><form:input path="courseLecturerId" readonly ="true"/></td>
				</tr>
				
				<tr>
					<td>Start Date</td>
					<td><form:input path="scheduleStartdate"/></td>
				</tr>
				
				<tr>
					<td>End Date</td>
					<td><form:input path="scheduleEnddate"/></td>
				</tr>
				
				<tr>
				<td>Course Id</td>
					<td><form:input path="course.courseId" readonly ="true"/></td>
					
				</tr>
					
				<tr>
				<td>Course Code</td>
				<td><form:input path="course.courseDetail.courseCode" readonly ="true" /></td>	
				
				</tr>
			
			<tr>
				<td>Course Start Date</td>
					<td><form:input path="course.startDate" readonly ="true"/></td>	
				
			</tr>
			
			<tr>
				<td>Lecturer Id</td>
					<td><form:input path="lecturer.lecturerId" readonly ="true"/></td>
					
					</tr>
					
				<tr>
				<td>Course Code</td>
					<td><form:input path="lecturer.firstname" readonly ="true"/></td>	
				
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