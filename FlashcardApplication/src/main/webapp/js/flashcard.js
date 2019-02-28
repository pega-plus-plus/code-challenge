window.onload = function() {

	getFormTableInfo();
}

function updateCard() {
	alert("Update" + this.value);
}
/* Delete a card with value assigned to button from parent card */
function deleteCard() {
	console.log(this.value);
  var data = new FormData();
  data.append('id', this.value);
	console.log(data);
	var params = { content: data};
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let json = JSON.parse(xhttp.responseText);
			
		}
		
	}
	xhttp.open("DELETE",
			'http://localhost:8080/FlashcardApplication/html/DeleteCard.do/', true);
	xhttp.send("id="+this.value);

}

/* Populate table of flashcards */
function getFormTableInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let formVals = JSON.parse(xhttp.responseText);

			if (formVals != "") {
				setValues(formVals);

				successbtns = document.getElementsByClassName("btn-success");
				console.log(successbtns);
				for (var i = 0; i < successbtns.length; i++) {
					successbtns[i].addEventListener('click', updateCard, false);
				}
				deletebtns = document.getElementsByClassName("btn-danger");
				for (var i = 0; i < deletebtns.length; i++) {
					deletebtns[i].addEventListener('click', deleteCard, false);
				}
			}
		}
	}
	xhttp.open("GET",
			'http://localhost:8080/FlashcardApplication/html/CardTable.do',
			true);
	xhttp.send();
}
function setValues(formVals) {
	var cols = Object.keys(formVals[0]);

	var cards = Object.entries(formVals);

	// var div = document.createElement("DIV");
	// div.classList.add("extradiv");
	var data = '';
	for ( var card in cards) {
		// console.log(cards[card][1]);

		data += '<div flash-id="' + cards[card][1]["id"]
				+ '" class="cardcontainer">';
		data += '<div class="card">';

		data += '<div class="front">';
		data += '<h1>Question</h2>';
		data += '<p>' + cards[card][1]["question"] + '</p>';
		data += '</div>';

		data += '<div class="back">';
		data += '<h1>Answer</h1>';
		data += '<p>' + cards[card][1]["answer"] + '</p>';
		data += '<p>' + cards[card][1]["catName"] + '</p>';
		data += '</div>';

		data += '</div>';/* card */
		data += '<button type="button" id="updateBtn"  value="'
				+ cards[card][1]["id"]
				+ '" class="btn btn-success">Update</button>';
		data += '<button type="button" id="deleteBtn"  value="'
				+ cards[card][1]["id"]
				+ '" class="btn btn-danger">Delete</button>';
		data += '</div>';/* cardcontainer */
		document.getElementById('cards').innerHTML = data;
	}
}
