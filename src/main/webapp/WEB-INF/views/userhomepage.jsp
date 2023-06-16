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

	<div class="userhomepage">
	     Welcome <span style="color: blue"></span>
	    <a href="./signout" style="color: red;">Sign out</a>
	    
	    <br> <br> <br> <br>
	    
	    <span style="color: orange;">List of Past Entries</span>
	   <a href="./addentry"><button type="button" class="addbutton">ADD ENTRY</button></a>
	    
	     <br> <br> <br> <br>
	    
	    <table style=" width: 100%" border="1">
	    	<tr >
	    		<th>Date</th>
	    		<th colspan="3">Actions</th>
	    	</tr>
	    	
	    	<c:forEach items="${entrieslist}" var="e">
	    	<tr>
	    	<td><fmt:formatDate value="${e.entrydate}" pattern= "dd/MM/yyyy"/></td>
	    	<td><a href="./viewentry?id=${e.id}">views</a></td>
	    	<td><a href="./updateentry?id=${e.id}">update</a></td>
	    	<td><a href="./deleteentry?id=${e.id}">delete</a></td>
	    	</tr>
	    	</c:forEach>
	    </table>
	</div>
</body>
</html>