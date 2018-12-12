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

<a>Pending Enrollment</a>
<c:if test="${fn:length(pcourses) gt 0}">
	<table>
		<tr>
			<th>S. No.</th>
			<th>Code</th>
			<th>Course Name</th>
			<th>Credit</th>
			<th>Cancel</th>
			
		</tr>
		
		<c:forEach var="coursestudent" items="${pcourses}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${coursestudent.course.courseDetail.courseCode}</td>
			<td>${coursestudent.course.courseDetail.name}</td>
			<td>${coursestudent.course.courseDetail.credit}</td>
			<td align="center"><a href="${pageContext.request.contextPath}/student/enroll_status/delete/${coursestudent.courseStudentId}">Cancel</a></td>		
		</tr>
		</c:forEach>
		</table>

</c:if>
<a>Rejected Courses</a>
<c:if test="${fn:length(rcourses) gt 0}">
	<table>
		<tr>
			<th>S. No.</th>
			<th>Code</th>
			<th>Course Name</th>
			<th>Credit</th>
			
		</tr>
		
		<c:forEach var="coursestudent" items="${rcourses}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${coursestudent.course.courseDetail.courseCode}</td>
			<td>${coursestudent.course.courseDetail.name}</td>
			<td>${coursestudent.course.courseDetail.credit}</td>
					
		</tr>
		</c:forEach>
		</table>

</c:if>
</html>
