<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit User page</h3>

<form:form method="POST" modelAttribute="coursestudents"
	action="${pageContext.request.contextPath}/courselecturer/editstudentgrade/${coursestudents.courseStudentId}.html">
	<table>
		<tbody>
			<tr>
				<td>ID</td>
				<td><form:input path="courseStudentId" readonly="true" /></td>
				<td><form:errors path="courseStudentId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Grade</td>
				<td><form:input path="grade" /></td>
				<td><form:errors path="grade" cssStyle="color: red;" /></td>
			</tr>
			
		
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

