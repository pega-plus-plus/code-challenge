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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link href="resources/css/custom.css" rel="stylesheet">

<title>Add A Flashcard</title>
</head>
<body class="my-background-image">

	<div class="container-fluid">
		<nav class="navbar">
			<a class="navbar-brand" href="index.jsp">
				<h1>
					Flashcards! <small>Add A Flashcard</small>
				</h1>
			</a> <span class="nav justify-content-end">
				<ul class="list-inline">
					<li class="list-inline-item"><a
						href="/flashcard/GetAFlashcardServlet" class="btn btn-primary"
						role="button">All Categories</a></li>
					<li class="list-inline-item"><a
						href="/flashcard/GetAFlashcardByCategoryServlet"
						class="btn btn-primary" role="button">Choose Category</a></li>
					<li class="list-inline-item"><a
						href="/flashcard/AddCategoryServlet" class="btn btn-primary"
						role="button">Add Category</a></li>
				</ul>
			</span>
		</nav>

		<form method="POST" action="AddFlashcardServlet" id="addFlashcard">
			<div class="form-group">
				<label for="category">Category</label> 
				<select required="required" class="form-control" name="category" id="category">
					<option value="0">Select Category</option>
					<c:forEach var="cat" items="${catList}">
						<option value="${cat.categoryId}">
							<c:out value="${cat.categoryName}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="question">Question</label>
				<input type="text" class="form-control" id="question"
					name="question" placeholder="Question" required>
			</div>
			<div class="form-group">
				<label for="answer">Answer</label>
				<input type="text" class="form-control" id="answer"
					name="answer" placeholder="Answer" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


		<br>
		<table class="table table-light table-striped">
			<thead>
				<tr>
					<th>Category</th>
					<th>Question</th>
					<th>Answer</th>
					<th>Delete</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody id="flashcardTableBody">
				<c:forEach var="fc" items="${fcList}">
					<tr>
						<td><c:out value="${fc.categoryName }" /></td>
						<td><c:out value="${fc.question }" /></td>
						<td><c:out value="${fc.answer }" /></td>
						<td>
							<form method="post" action="DeleteFlashcardServlet" id="deleteFlashcard">
				      			<input type="hidden" name="flashcardId" value=<c:out value="${fc.flashcardId }" />>
				        		<button type="submit" class="btn btn-danger" >Delete</button>
				        	</form>
						</td>
						<td>
							<form method="get" action="UpdateFlashcardServlet" id="updateFlashcard">
				      			<input type="hidden" name="flashcardId" value=<c:out value="${fc.flashcardId }" />>				      							      			
				        		<button type="submit" class="btn btn-warning" >Edit</button>
				        	</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="height: 200px"></div>

	</div>


	<script>
		document.getElementById('addFlashcard').addEventListener('submit',
				displayFlashcards);

		function displayFlashcards(e) {
			e.preventDefault();
			let catId = document.forms["addFlashcard"]["category"].value;
			let question = document.forms["addFlashcard"]["question"].value;
			let answer = document.forms["addFlashcard"]["answer"].value;

			let params = "categoryId=" + catId + "&question=" + question + "&answer=" + answer;

			let output = '';

			let flashcards = null;

			var xhr = new XMLHttpRequest();
			xhr.open('POST', 'AddFlashcardServlet', true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					flashcards = JSON.parse(xhr.response);

					for ( let i in flashcards) {
						output += '<tr>' + 
								'<td>' + flashcards[i].categoryName + '</td>' + 
								'<td>' + flashcards[i].question + '</td>' +
								'<td>' + flashcards[i].answer + '</td>' +
								'</tr>';
					}
					document.getElementById("flashcardTableBody").innerHTML = output;
				}
			}

			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhr.send(params);

		}
	</script>

	<!-- bootstrap files for jquery and JavaScript -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
	<script src="/resources/js/tuition_reimbursement.js"></script>


</body>
</html>