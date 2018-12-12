<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="style_base.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
.searchtab {
	background-color: #33cccc;
	border: 5px solid;
	padding: 25px;
	margin: 50px 250px;
}
</style>


</head>
<body>
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
						<img src="<%=request.getContextPath()%>/image/1.png" alt="CAPS" style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>CAPS</h3>
							<p>Knowledge is Power!</p>
						</div>
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/image/2.jpg" alt="Courses" style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>Courses</h3>
							<p>Check our courses!</p>
						</div>
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/image/3.jpg" alt="Classes" style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>Classes</h3>
							<p>Studying is great!</p>
						</div>
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/image/4.jpg" alt="About" style="width: 100%; height: 600px">
						<div class="carousel-caption">
							<h3>Contact us</h3>
							<p>Lets have fun !</p>
						</div>
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/image/5.jpg" alt="Classes" style="width: 100%; height: 600px">
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
			<table>
				<tr>
					<td>
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
					</td>
					<td></td>
				</tr>
			</table>
		</div>
	
</body>
</html>