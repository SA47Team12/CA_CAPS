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

<a>AddStudent</a>
<c:if test="${fn:length(coursestudents) gt 0}">
	<table>
		<tr>
			<th>S. No.</th>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Grade</th>
			<th>Edit</th>
			<th>Delete</th>
			
		</tr>
		
		<c:forEach var="coursestudent" items="${coursestudents}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			
			<td>${coursestudent.student.studentId}</td>
			<td>${coursestudent.student.firstname}</td>
			<td>${coursestudent.student.lastname}</td>
			<td>${coursestudent.grade}</td>
			
			<td align="center"><a
						href="${pageContext.request.contextPath}/courselecturer/editstudentgrade/${coursestudent.courseStudentId}.html">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/courselecturer/deletestudentgrade/${coursestudent.courseStudentId}.html">Delete
							</a></td>
			
			
		</tr>
		</c:forEach>
	</table>
</c:if>
</html>
