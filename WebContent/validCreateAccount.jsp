<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid Create Account</title>
</head>

<style>
	
* {
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
}

body {
  padding: 0;
  margin: 0;
}

#notfound {
  position: relative;
  height: 100vh;
  background-color: #fafbfd;
}

#notfound .notfound {
  position: absolute;
  left: 50%;
  top: 50%;
  -webkit-transform: translate(-50%, -50%);
      -ms-transform: translate(-50%, -50%);
          transform: translate(-50%, -50%);
}

.notfound {
  max-width: 520px;
  width: 100%;
  text-align: center;
}

.notfound .notfound-bg {
  position: absolute;
  left: 0px;
  right: 0px;
  top: 50%;
  -webkit-transform: translateY(-50%);
      -ms-transform: translateY(-50%);
          transform: translateY(-50%);
  z-index: -1;
}

.notfound .notfound-bg > div {
  width: 100%;
  background: #fff;
  border-radius: 90px;
  height: 125px;
}

.notfound .notfound-bg > div:nth-child(1) {
  -webkit-box-shadow: 5px 5px 0px 0px #f3f3f3;
          box-shadow: 5px 5px 0px 0px #f3f3f3;
}

.notfound .notfound-bg > div:nth-child(2) {
  -webkit-transform: scale(1.3);
      -ms-transform: scale(1.3);
          transform: scale(1.3);
  -webkit-box-shadow: 5px 5px 0px 0px #f3f3f3;
          box-shadow: 5px 5px 0px 0px #f3f3f3;
  position: relative;
  z-index: 10;
}

.notfound .notfound-bg > div:nth-child(3) {
  -webkit-box-shadow: 5px 5px 0px 0px #f3f3f3;
          box-shadow: 5px 5px 0px 0px #f3f3f3;
  position: relative;
  z-index: 90;
}

.notfound h1 {
  font-family: 'Quicksand', sans-serif;
  font-size: 86px;
  text-transform: uppercase;
  font-weight: 700;
  margin-top: 0;
  margin-bottom: 8px;
  color: #151515;
}

.notfound h2 {
  font-family: 'Quicksand', sans-serif;
  font-size: 26px;
  margin: 0;
  font-weight: 700;
  color: #151515;
}

.notfound a {
  font-family: 'Quicksand', sans-serif;
  font-size: 14px;
  text-decoration: none;
  text-transform: uppercase;
  background: #18e06f;
  display: inline-block;
  padding: 15px 30px;
  border-radius: 5px;
  color: #fff;
  font-weight: 700;
  margin-top: 20px;
}

.notfound-social {
  margin-top: 20px;
}

.notfound-social>a {
  display: inline-block;
  height: 40px;
  line-height: 40px;
  width: 40px;
  font-size: 14px;
  color: #fff;
  background-color: #dedede;
  margin: 3px;
  padding: 0px;
  -webkit-transition: 0.2s all;
  transition: 0.2s all;
}
.notfound-social>a:hover {
  background-color: #18e06f;
}

@media only screen and (max-width: 767px) {
    .notfound .notfound-bg {
      width: 287px;
      margin: auto;
    }

    .notfound .notfound-bg > div {
      height: 85px;
  }
}

@media only screen and (max-width: 480px) {
  .notfound h1 {
    font-size: 68px;
  }

  .notfound h2 {
    font-size: 18px;
  }
}





</style>




<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Quicksand:700" rel="stylesheet">

	<!-- Font Awesome Icon -->
	<link type="text/css" rel="stylesheet" href="css/font-awesome.min.css" />

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

<body>

	<c:if test="${requestScope.noerr == true }">
		<div id="notfound">
			<div class="notfound">
				<div class="notfound-bg">
					<div></div>
					<div></div>
					<div></div>
				</div>
				<h2>Succesfully Create Admin</h2>
				<a href="viewAccount?action=viewaccount">View Admin</a>
				
			</div>
		</div>
	</c:if>

	<c:if test="${requestScope.noerr2 == true }">
		<div id="notfound">
			<div class="notfound">
				<div class="notfound-bg">
					<div></div>
					<div></div>
					<div></div>
				</div>
				<h2>Succesfully Create Customer Account</h2>
				<a href="customerLogin.jsp">Login</a>
				
			</div>
		</div>
	</c:if>


</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>