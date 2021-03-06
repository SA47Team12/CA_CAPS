<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<c:if test="${fn:length(course) gt 0}">
	<table class="table table-bordered">
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
				<td>${status.index+1}</td>
				<td>${course.courseId}</td>
				<td>${course.courseDetail.courseCode}</td>
				<td>${course.courseDetail.name}</td>
				<td>${course.courseDetail.description}</td>
				<td>${course.courseDetail.duration}</td>
				<td>${course.startDate}</td>
				<td>${course.capacity}</td>
				<td>${course.currentEnrollment}</td>
				<td>${course.courseDetail.credit}</td>
		<td><a href="${pageContext.request.contextPath}/admin/cedit/${course.courseId}.html">Edit</a></td>
			<td><a href="${pageContext.request.contextPath}/admin/cdelete/${course.courseId}.html">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</html>
