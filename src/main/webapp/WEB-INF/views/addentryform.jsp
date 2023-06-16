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
  <h1> Welcome ${user.username}</h1>
    <a href="./signout" style="color: red; float: right; font-size: 25px;">Sing out</a>
	<div class="bodypart">
		<div class="bodypart1">
			<img class="img2" src="<c:url value="/resources/images/diary.jpeg"/>">
		</div>
		<div class="bodypart2">
			<h1>ADD ENTRY</h1>
			<hr>
			<br>
			<br>
			<form action="./saveentry" method="POST">
				<label>Date</label><input type="date" name="entrydate"><br>
				<br> <label>Description :</label><textarea rows="4" cols="50" name="description"></textarea><br>
				<input type="hidden" name="userid" value="${user.id}">
				<br>
				<button type="submit" class="button">SAVE ENTRY</button>
			</form>
			
		</div>
	</div>
</body>
</html>