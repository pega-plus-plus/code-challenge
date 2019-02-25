function newWindow()
{
	window.open('../html/form.html');
}

function closeWindow()
{
	window.close();
}

function viewInfo()
{
	window.open('http://localhost:8082/Project1/ViewRequest');
}
function handleEvent(){
	
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET", "ViewRequest", true);
	
	xhr.send();
}
function viewInfoDh()
{
	window.open('http://localhost:8082/Project1/ViewRequestdh');
}
function signup(){
	window.open('http://localhost:8082/Project1/signup.html');

}

function handleEvent2(){
	
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET", "ViewRequestdh", true);
	
	xhr.send();
}


window.onload = function(){
	document.getElementById("myBtn").addEventListener("click", handleEvent, false);
	document.getElementById("myBtn2").addEventListener("click", handleEvent2, false);
}