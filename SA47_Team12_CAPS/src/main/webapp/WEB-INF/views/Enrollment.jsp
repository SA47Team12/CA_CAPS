<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<style>
/* table, th, td {
	border: 1px solid black;
}
 */
td, th {  
  border: 1px solid #ddd;
  text-align: left;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}
</style>

<c:if test="${fn:length(students) gt 0}">
	<table>
		<tr>
			<th>S. No.</th>
			<th>Course Student ID</th>
			<th>Course ID</th>
			<th>Student ID</th>
			<th></th>
			<th></th>
		</tr>
		
		<c:forEach var="pending" items="${students}" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${pending.courseStudentId}</td>
			<td>${pending.course.courseId}</td>
			<td>${pending.student.studentId}</td>
			<td><a href="${pageContext.request.contextPath}/admin/accept/${pending.courseStudentId}.html">Accept</a></td>
			<td><a href="${pageContext.request.contextPath}/admin/reject/${pending.courseStudentId}.html">Reject</a></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</html>
