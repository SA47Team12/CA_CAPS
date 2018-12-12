<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<a href="${pageContext.request.contextPath}/admin/create.html">AddStudent</a>
<c:if test="${fn:length(students) gt 0}">
	<table class="table table-bordered">
		<tr>
			<th>S. No.</th>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Gender</th>
			<th>Date of birth</th>
			<th>Email id</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Enrollment Date</th>
			<th></th>
			<th></th>
		</tr>
		
		<c:forEach var="student" items="${students}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${student.studentId}</td>
			<td>${student.firstname}</td>
			<td>${student.lastname}</td>
			<td>${student.gender}</td>
			<td>${student.dob}</td>
			<td>${student.email}</td>
			<td>${student.phone}</td>
			<td>${student.address}</td>
			<td>${student.enrollmentDate}</td>
			<td><a href="${pageContext.request.contextPath}/admin/edit/${student.studentId}.html">Edit</a></td>
			<td><a href="${pageContext.request.contextPath}/admin/delete/${student.studentId}.html">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</html>
