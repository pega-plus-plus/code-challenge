<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link href="/resources/css/custom.css" rel="stylesheet">

<title>Flashcard Home</title>
</head>
<body>

	<div class="container-fluid">
	
		<h1>Flashcards!</h1><br>
		
		<div><a href="/flashcard/GetAFlashcardServlet" class="btn btn-primary" role="button">All Categories</a></div><br>
		
		<div><a href="/flashcard/GetAFlashcardByCategoryServlet" class="btn btn-primary" role="button">Choose Category</a></div><br>
		
		<div><a href="/flashcard/AddCategoryServlet" class="btn btn-primary" role="button">Add Category</a></div><br>
		
		<div><a href="/flashcard/AddFlashcardServlet" class="btn btn-primary" role="button">Add Flashcard</a></div><br>
	
	</div>
	
	<!-- bootstrap files for jquery and JavaScript -->	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<script src="/resources/js/tuition_reimbursement.js"></script>

</body>
</html>