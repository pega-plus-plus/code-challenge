<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link href="resources/css/custom.css" rel="stylesheet">

<title>All Categories</title>
</head>
<body class="my-background-image">

	<div class="container-fluid">
		<nav class="navbar">
			<a class="navbar-brand" href="index.jsp">
				<h1>
					Flashcards! <small>All Categories</small>
				</h1>
			</a> <span class="nav justify-content-end">
				<ul class="list-inline">
					<li class="list-inline-item"><a
						href="/flashcard/GetAFlashcardByCategoryServlet"
						class="btn btn-primary" role="button">Choose Category</a></li>
					<li class="list-inline-item"><a
						href="/flashcard/AddCategoryServlet" class="btn btn-primary"
						role="button">Add Category</a></li>
					<li class="list-inline-item"><a
						href="/flashcard/AddFlashcardServlet"
						class="btn btn-primary" role="button">Add Flashcard</a></li>
				</ul>
			</span>
		</nav>
		
		<h3 id="category"><c:out value="${fc.categoryName}" /></h3>
		
		<div class="card">
  			<div class="card-header">Question</div>
  			<div class="card-body" id="question">
  				<c:out value="${fc.question}" />
  			</div> 
		</div>
		<br>
		<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#answerCard" aria-expanded="false" aria-controls="answerCard">Show Answer</button>
		<br>
		<br>
		<div id="answerCard" class="collapse">
			<div class="card">
	  			<div class="card-header">Answer</div>
	  			<div class="card-body" id="answer">
	  				<c:out value="${fc.answer}" />
	  			</div> 
			</div>
		</div>
		<br>
		
		<button class="btn btn-primary" type="button" onclick="nextCard()">Next</button>
		
		<p>
			<form method="get" action="UpdateFlashcardServlet" id="updateFlashcard">
	     		<input id="editCard" type="hidden" name="flashcardId" value=<c:out value="${fc.flashcardId }" />>				      							      			
	       		<button type="submit" class="btn btn-warning" >Edit</button>
	       	</form>
		</p>
		<p>
			<form method="post" action="DeleteFlashcardServlet" id="deleteFlashcard">
	     		<input id="deleteCard" type="hidden" name="flashcardId" value=<c:out value="${fc.flashcardId }" />>
	       		<button type="submit" class="btn btn-danger" >Delete</button>
	       	</form>
       	</p>
     
		<div style="height: 200px"></div>	

	</div>
	
	<script>
		function nextCard() {
			
			let flashcard = null;
	
			var xhr = new XMLHttpRequest();
			xhr.open('GET', 'NextFlashcardServlet', true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					flashcard = JSON.parse(xhr.response);
					
					document.getElementById("category").innerHTML = flashcard.categoryName;
					document.getElementById("question").innerHTML = flashcard.question;
					document.getElementById("answer").innerHTML = flashcard.answer;
					document.getElementById("editCard").setAttribute("value", flashcard.flashcardId);
					document.getElementById("deleteCard").setAttribute("value", flashcard.flashcardId);
				}
			}
	
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send();
	
		}
	
	</script>

	<!-- bootstrap files for jquery and JavaScript -->	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<script src="/resources/js/tuition_reimbursement.js"></script>
	

</body>
</html>