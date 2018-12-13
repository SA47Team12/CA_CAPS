<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<a>Enroll Courses</a>
<c:if test="${fn:length(courses) gt 0}">
	<table  class="table table-bordered">
		<tr>
			<th>S. No.</th>
			<th>Course ID</th>
			<th>Code</th>
			<th>Course Name</th>
			<th>Credit</th>
		    <th>Start Date</th>
			<th>Capacity</th>
			<th>Current Enrollment</th> 
	
		</tr>
		
		<c:forEach var="course" items="${courses}" varStatus="status">
		<form:form method="POST" action="${pageContext.request.contextPath}/student/enroll/create/${course.courseId}.html">
		
		<tr>
			<td>${status.index+1}</td>
			<td>${course.courseId}</td>
			<td>${course.courseDetail.courseCode}</td>
			<td>${course.courseDetail.name}</td>
			<td>${course.courseDetail.credit}</td>
			<td>${course.startDate}</td>
			<td>${course.capacity}</td>
			<td>${course.currentEnrollment}</td>
			<td><input type="submit" value="Enroll"/></td>
				
		</tr>
		</form:form>
		</c:forEach>
	
	</table>
</c:if>
</html>
