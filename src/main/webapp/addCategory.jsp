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
<link href="/resources/css/custom.css" rel="stylesheet">

<title>Add A Category</title>
</head>
<body>

	<div class="container-fluid">
		<nav class="navbar">
			<a class="navbar-brand" href="index.jsp">
				<h1>
					Flashcards! <small>Add A Category</small>
				</h1>
			</a> <span class="nav justify-content-end">
				<ul class="list-inline">
					<li class="list-inline-item"><a
						href="/flashcard/GetAFlashcardServlet"
						class="btn btn-primary" role="button">All Categories</a></li>
					<li class="list-inline-item"><a
						href="/flashcard/GetAFlashcardByCategoryServlet"
						class="btn btn-primary" role="button">Choose Category</a></li>
					<li class="list-inline-item"><a
						href="/flashcard/AddFlashcardServlet"
						class="btn btn-primary" role="button">Add Flashcard</a></li>
				</ul>
			</span>
		</nav>
		
		<form method="POST" action="AddCategoryServlet" id="addCategory">
			<div class="form-group">
				<label for="addCategory">New Category</label>
				<input type="text" class="form-control col-sm-4" id="categoryName"
					name="categoryName" placeholder="Category Name" required>
			</div>
			<button type="submit" class="btn btn-primary" >Submit</button>
		</form>

		
		<br>
		<table class="table table-bordered col-sm-4">
			<thead>
				<tr>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody id="categoryTableBody">
				<c:forEach var="cat" items="${catList}">
					<tr>
						<td><c:out value="${cat.categoryName }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<div style="height: 200px"></div>	

	</div>


	<script>
		document.getElementById('addCategory').addEventListener('submit',
				displayCategories);

		function displayCategories(e) {
			e.preventDefault();
			let catName = document.forms["addCategory"]["categoryName"].value;

			let params = "categoryName="+catName;

			let output = '';

			let categories = null;

			var xhr = new XMLHttpRequest();
			xhr.open('POST', 'AddCategoryServlet', true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					categories = JSON.parse(xhr.response);

					for ( let i in categories) {
						output += '<tr>' 
								+ '<td>' + categories[i].categoryName + '</td>' 
								+ '</tr>';
					}
					document.getElementById("categoryTableBody").innerHTML = output;
				}
			}

			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send(params);

		}
	</script>
	</div>

	<!-- bootstrap files for jquery and JavaScript -->	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<script src="/resources/js/tuition_reimbursement.js"></script>
	

</body>
</html>