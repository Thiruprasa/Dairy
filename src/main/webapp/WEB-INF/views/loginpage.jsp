<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Diary App</title>
<link rel="stylesheet" href="<c:url value="/resources/css/diary.css"/>">
</head>
<body>
	<div class="header">

		<div class="first">
			<img class="img1" src="<c:url value="/resources/images/diary.jpeg"/>">
		</div>
		<div class="second">MyDiary app</div>
	</div>

	<br>
	<br>
	<hr />

	<div class="bodypart">
		<div class="bodypart1">
			<img class="img2" src="<c:url value="/resources/images/diary.jpeg"/>">
		</div>
		<div class="bodypart2">
			<h1>LOGIN HERE</h1>
			<hr>
			<br>
			<br>
			<form action="userhome" method="POST">
				<label>username :</label><input type="text" name="username" class="input"><br>
				<br> <label>password :</label><input type="password" name="password"
					class="input"><br>
				<br>
				<button type="submit" class="button">Login</button>
			</form>
			<br>
			<br>
			<h3>
				New User? <a href="./register">Register</a>Here
			</h3>
		</div>
	</div>
</body>
</html>