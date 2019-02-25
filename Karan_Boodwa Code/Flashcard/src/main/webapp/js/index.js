/**
 * 
 */
window.onload = function() {
	getFlashCards();
	getAlert();
}

function getFlashCards() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {	
			let emp = JSON.parse(xhttp.responseText);
			setFlashCards(emp);
		}
	};
	xhttp.open("GET",
			'http://localhost:9000/Flashcards/html/flashcardJSON.do',
			true);
	xhttp.send();
}

function setFlashCards(fc) {
	let view = '<h3> Flashcards </h3> <hr>';
	if(fc!=null){
		console.log(fc);
		for(let i = 0; i < fc.length; i++){
			view = view + '<div class="container"> <p>';
			view = view + 'Question: ' + fc[i].question + '</p><p> Answer: ' + fc[i].answer + '</p>';
			view = view + '</p></div>';
		}
	}
	
	document.getElementById('flashcards').innerHTML = view;
	
}
