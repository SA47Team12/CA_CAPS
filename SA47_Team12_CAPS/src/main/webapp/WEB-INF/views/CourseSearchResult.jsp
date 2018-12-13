<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>

<%--  <c:set var = "coursesearchurl" value = "${pageContext.request.contextPath}/course/display/${course.courseId}.html" /> --%>
			<form:form method="POST" modelAttribute="course" action="${pageContext.request.contextPath}/course/display/${course.courseId}.html"   >
				<table>
					<tr>
						<td>Course ID</td>
						<td><form:input path="courseId" readonly ="true"/></td>
					</tr>
					<tr>
						<!-- <td><input type="submit" value="Submit"></td> -->
						<td><input type="reset" value="Reset"></td>
					</tr>
				</table>
			</form:form>
			
			<%-- <form  class="form-horizontal"  role="form" th:action="@{/course/display}" 
			th:object="${course}" method="post" id="course-form">
			<input  type="text" class="form-control" required th:field="*{courseid}"  id="courserID" >
			<form action="@{/course/display}" object="${course}" method="post" id="course-form">
			 <input type="text" id="courses" value="${course.courseId}"
					placeholder="Type the course code ..." > <br> <br> 
				<input type="submit">
			</form>  --%>
			

<table class="table table-bordered">
	<tr>
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
	<tr>
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
</table>

</html>
