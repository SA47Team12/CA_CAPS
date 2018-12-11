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
<c:if test="${fn:length(course) gt 0}">
	<table>
		<tr>
			<th>S. No.</th>
			<th>Course ID</th>
			<th>Code</th>
			<th>Name</th>
			<th>Description</th>
			<th>Duration</th>
			<th>Start Date</th>
			<th>Capacity</th>
			<th>Enrollment</th>		
			<th>Credit</th>
		
		</tr>

		<c:forEach var="course" items="${course}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${course.courseId}</td>
				<td>${course.courseDetail.courseCode}</td>
				<td>${course.courseDetail.name}</td>
				<td>${course.courseDetail.description}</td>
				<td>${course.courseDetail.duration}</td>
				<td>${course.startDate}</td>
				<td>${course.capacity}</td>
				<td>${course.currentEnrollment}</td>
				<td>${course.courseDetail.credit}</td>
				
			</tr>
		</c:forEach>
	</table>
</c:if>
</html>
