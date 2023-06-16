<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
			<h1>UPDATE ENTRY</h1>
			<hr>
			<br>
			<br>
			<form action="./processentryupdate" method="POST">
				<label>Date</label><input type="text" name="entrydate" value="${entry.entrydate}" readonly><br>
				<br> <label>Description :</label><textarea rows="4" cols="50" name="description">
				${entry.description}
				</textarea><br>
				<input type="hidden" name="userid" value="${user.id}">
				<input type="hidden" name="id" value="${entry.id}">
				<br>
				<button type="submit" class="button">UPDATE ENTRY</button>
			</form>
			
		</div>
	</div>
</body>
</html>