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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<div class="container">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">

					<div class="item active">
						<img src="<%=request.getContextPath()%>/image/1.png" alt="CAPS"
							style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>CAPS</h3>
							<p>Knowledge is Power!</p>
						</div>
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/image/2.jpg" alt="Courses"
							style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>Courses</h3>
							<p>Check our courses!</p>
						</div>
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/image/3.jpg" alt="Classes"
							style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>Classes</h3>
							<p>Studying is great!</p>
						</div>
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/image/4.jpg" alt="About"
							style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>Contact us</h3>
							<p>Lets have fun !</p>
						</div>
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/image/5.jpg" alt="Classes"
							style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>CAPS</h3>
							<p>Gain knowledge!</p>
						</div>
					</div>

				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>

		<div class="searchtab">
			<form action="/action_page.php">
				<select name="courses">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3" selected>3</option>
					<option value="4">4</option>
				</select> <input type="text" id="courses"
					placeholder="Type the course code ..."> <br> <br>
				<input type="submit">
			</form>
			<%@include file="Menu.jsp"%>
			<table>
				<tr>
					<td>
						<div>
							<dec:body />
						</div>
					</td>
				</tr>
			</table>
		</div>


		<address>
			<div class="wrapper">
				<ul>
					<li>
						<p>
							<a href="https://smu.edu.sg" target="_blank"> <img
								src="<%=request.getContextPath()%>/image/nus.jpg" width="200"
								height="200"></a>
						</p>
					</li>
					<li>
						<p>
							<a href="https://twitter.com/codexworldblog" target="_blank">
								<img src="<%=request.getContextPath()%>/image/status.png"
								width="200" height="200">
							</a>
						</p>
					</li>
					<li>
						<p>
							<a href="mailto:nus@example.com" target="_blank"> <img
								src="<%=request.getContextPath()%>/image/contact.jpg"
								width="200" height="200"></a>
						</p>
					</li>
					<li>
						<p>
							<a href="http://alumnet.nus.edu.sg/module/portal/index.html"
								target="_blank"> <img
								src="<%=request.getContextPath()%>/image/alumni.png" width="200"
								height="200"></a>
						</p>
					</li>
				</ul>
			</div>
		</address>

	</div>

	<div id="Admin" class="tabcontent">
		<table class="sidebar">
			<tr>
				<td class="sidebar-links">

					<ul>
						<li><a href="/SA47_Team12_CAPS/admin/student/list">Manage Students</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/admin/lecturer/list">Manage Lecturer</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/admin/courselist">Manage Course</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/admin/listcoursedetail">Add Course Details</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/admin/enrollment">Manage Enrollment</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/admin/assignlecturer/list">Assign Lecturer</a></li>
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
						<li><a href="/SA47_Team12_CAPS/student/grade">Grades and GPA</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/student/enroll">View and Enroll Courses</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/student/currentcourses">Ongoing Courses</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/student/enroll_status">Courses Application Status</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/student/profile">Manage Student Profile</a></li>
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

	<div id="Lecturer" class="tabcontent">
		<table class="sidebar">
			<tr>
				<td class="sidebar-links">
					<ul>
						<li><a
							href="/SA47_Team12_CAPS/courselecturer/findcoursetaught">View
								Courses Taught</a></li>
						<br />
						<li><a
							href="/SA47_Team12_CAPS/courselecturer/findcourseenrollment">View
								Course Enrollment</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/courselecturer/findcourselist">Grade a Course</a></li>
						<br />
						<li><a href="/SA47_Team12_CAPS/courselecturer/profile">Manage Lecturer Profile</a></li>
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
