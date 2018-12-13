<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
        
<form:form method="POST" modelAttribute="course"
	action="${pageContext.request.contextPath}/admin/cedit/${course.courseId}.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
				   <td> Course ID</td>
				   <td><form:input path="courseId" readonly="true" /></td>
				 </tr>
				 
				 <tr> 
				   <td> Start Date</td>
				   <td><form:input type="date" path="startDate" /></td>
				 </tr>
				<tr>
				   <td> Capacity</td>
				   <td><form:input path="capacity"/></td>
				 </tr>
				<tr>
				  	<td> Enrollment</td>
				   <td><form:input path="currentEnrollment"/></td>
				 </tr>
				
				<tr>
				 <td><input type="submit" value="Submit"> </td>
				 <td><input type="reset" value="Reset"></td>
				 </tr>
		</table>
		</center>
	
	</form:form>
</body>
