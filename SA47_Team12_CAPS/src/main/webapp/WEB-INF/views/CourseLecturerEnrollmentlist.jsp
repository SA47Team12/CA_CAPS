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
<c:if test="${fn:length(courselecturers) gt 0}">
	<table>
		<tr>
			<th>S. No.</th>
			<th>ID</th>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Size</th>
			<th>Current Enrollment</th>
			
		</tr>
		
		<c:forEach var="courselecturer" items="${courselecturers}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${courselecturer.courseLecturerId}</td>
			<td>${courselecturer.course.courseId}</td>
			<td>${courselecturer.course.courseDetail.name}</td>
			<td>${courselecturer.course.capacity}</td>
			<td>${courselecturer.course.currentEnrollment}</td>
			
		</tr>
		</c:forEach>
	</table>
</c:if>
</html>
