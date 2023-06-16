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
		<div class="bodypart12">
			<h1>"Your Pen and Diary Knows"</h1>
			<br>
			<h1>&nbsp All my Deepest secrets,</h1>
			<br>
			<h1>&nbsp which I can't tell to</h1>
			<br>
			<h1>&nbsp&nbsp&nbsp Everyone</h1>
		</div>
		<div class="bodypart21">
			<h1>Registration</h1>
			<hr>
			<br> <br>
			<form action="./saveuser" method="POST">

				<label>name :&nbsp&nbsp&nbsp&nbsp&nbsp</label><input type="text"
					name="name" class="input"><br>
				<br> <label>Mobile :&nbsp&nbsp&nbsp&nbsp&nbsp</label><input
					type="number" name="mobile" class="input"><br>
				<br> <label>Email :&nbsp&nbsp&nbsp&nbsp&nbsp</label><input
					type="email" name="email" class="input"><br>
				<br> <label>username :</label><input type="text" name="username"
					class="input"><br> <br> <label>password :</label><input
					type="password" name="password" class="input"><br> <br>
				<button type="submit" class="button">Register</button>
			</form>
			<br> <br>
			<h3>
				Already Register? <a href="./login">Login</a>Here
			</h3>
		</div>
	</div>
</body>