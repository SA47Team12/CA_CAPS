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

<a href="${pageContext.request.contextPath}/admin/lecturer/create.html">Add Lecturer</a>
<c:if test="${fn:length(lecturers) gt 0}">
	<table>
		<tr>
			<th>S.No.</th>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email id</th>
			<th>Phone</th>
			<th>Address</th>
		</tr>
		
		<c:forEach var="lecturer" items="${lecturers}" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${lecturer.lecturerId}</td>
			<td>${lecturer.firstname}</td>
			<td>${lecturer.lastname}</td>
			<td>${lecturer.email}</td>
			<td>${lecturer.phone}</td>
			<td>${lecturer.address}</td>
			<td><a href="${pageContext.request.contextPath}/admin/assignlecturer/courselist/${lecturer.lecturerId}.html">Choose</a></td>
			
		</tr>
		</c:forEach>
	</table>
</c:if>
</html>
