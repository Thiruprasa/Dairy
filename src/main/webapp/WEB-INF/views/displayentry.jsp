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
   Welcome ${user.username}
   <a href="./signout" style="color: red; float: right;">Sing out</a>
	<div class="bodypart">
		<div class="bodypart1">
			<img class="img2" src="<c:url value="/resources/images/diary.jpeg"/>">
		</div>
		<div class="bodypart2">
			<h1>VIEW ENTRY</h1>
			<hr>
			<br>
			<br>
			<table>
			<tr><td>Date:</td><td>${entry.entrydate}</td></tr>
			<tr><td>Description :</td><td>${entry.description}</td></tr>
			</table>
			<br><br><br>
			<a href="./backtohome"><button type="button" class="button">BACK TO HOME</button></a>
			
		</div>
	</div>
</body>
</html>