<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<c:url value="/css/style.css" var="ss" />
<link rel="STYLESHEET" type="text/css" href="${ss}" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div>
		<h1>
			<i class="fa fa-graduation-cap" style="font-size: 60px"></i>CAPS
		</h1>
	</div>

	<div class="tab">
		<button class="tablinks" onclick="openTab(event, 'Home')">
			<i class="fa fa-home" style="font-size: 30px"></i>
		</button>
		<button class="tablinks" onclick="openTab(event, 'Admin')">Admin</button>
		<button class="tablinks" onclick="openTab(event, 'Student')">Student</button>
		<button class="tablinks" onclick="openTab(event, 'Lecturer')">Lecturer</button>
		<div class="topnav-right">
			<button class="tablinks" onclick="openTab(event, 'Logout')">
				<i class="fa fa-power-off" style="font-size: 30px"></i>
			</button>
		</div>
	</div>

	<div id="Home" class="tabcontent">
		<h3>Welcome ^_^</h3>
	</div>

	<div id="Admin" class="tabcontent">
		<table class="sidebar">
			<tr>
				<td class="sidebar-links">

					<ul>
						<li><a href="#1">Manage Students</a></li>
						<br />
						<li><a href="#2">Manage Lecturer</a></li>
						<br />
						<li><a href="#3">Manage Course</a></li>
						<br />
						<li><a href="#4">Manage Enrollment</a></li>
					</ul>

				</td>
				<td><%@include file="Menu.jsp"%>
					<table>
						<tr>
							<td>
								<div>
									<dec:body />
								</div>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>

	<div id="Student" class="tabcontent">
		<table class="sidebar">
			<tr>
				<td class="sidebar-links">
					<ul>
						<li><a href="#1">Grades and GPA</a></li>
						<br />
						<li><a href="#2">View Courses</a></li>
						<br />
						<li><a href="#3">Enroll for a Course</a></li>
					</ul>
				</td>
				<td><%@include file="Menu.jsp"%>
					<table>
						<tr>
							<td>
								<div>
									<dec:body />
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<div id="Lecturer" class="tabcontent">
		<table class="sidebar">
			<tr>
				<td class="sidebar-links">
					<ul>
						<li><a href="/SA47_Team12_CAPS/courselecturer/findcoursetaught">View Courses Taught</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/courselecturer/findcourseenrollment">View Course Enrollment</a></li>
						<br />
						<li><a href="#3">Grade a Course</a></li>
						<br />
						<li><a href="#4">View a Student Performance</a></li>
					</ul>
				</td>
				<td><%@include file="Menu.jsp"%>
					<table>
						<tr>
							<td>
								<div>
									<dec:body />
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<div id="Logout" class="tabcontent">
			<div class="login">
			<form action="/action_page.php">
				<input type="text" id="fname" name="firstname"
					placeholder="Your user name ..."> <br> <br> <input
					type="text" id="lname" name="lastname"
					placeholder="Your password ..."> <br> <br> <input
					type="login" value="Login">
			</form>
		</div>
		<div></div>
		<h3>Thank you !</h3>
	</div>

	<!-- ======== Footer ======== -->
	<div id="footer" align="center">
		<hr>
		<small> &copy; ISS NUS SA47 Team-12 2018 </small>
	</div>

	<script>
		function openTab(evt, tabName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(tabName).style.display = "block";
			evt.currentTarget.className += " active";
		}
	</script>


</body>
</html>
