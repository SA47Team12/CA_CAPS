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

<a href="${pageContext.request.contextPath}/course/coursedetails/create.html">AddCourseDetails</a>
<c:if test="${fn:length(coursedetails) gt 0}">
	<table>
		<tr>
			<th>S. No.</th>
			<th>Course Code</th>
			<th>Course Name</th>
			<th>Description</th>
			<th>Credit</th>
			<th>Duration</th>
			
			<!-- <th>View</th> -->
			
		</tr>
		
		<c:forEach var="coursedetail" items="${coursedetails}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${coursedetail.courseCode}</td>
			<td>${coursedetail.name}</td>
			<td>${coursedetail.description}</td>
			<td>${coursedetail.credit}</td>
			<td>${coursedetail.duration}</td>

			
			
			<%-- <td align="center"><a
						href="${pageContext.request.contextPath}/admin/createcourse/${coursedetail.courseCode}.html">View</a></td>
			 --%>
		</tr>
		</c:forEach>
	</table>
</c:if>
</html>
