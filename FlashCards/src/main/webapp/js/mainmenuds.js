function newWindow()
{
	window.open('form.html');
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
function viewInfoDs()
{
	window.open('http://localhost:8020/TRMS/ViewRequestds');
}
function signup(){
	window.open('http://localhost:8020/TRMS/Signup.html');

}

function handleEvent2(){
	
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET", "ViewRequestds", true);
	
	xhr.send();
}


window.onload = function(){
	
	document.getElementById("myBtn").addEventListener("click", handleEvent, false);
	document.getElementById("myBtn2").addEventListener("click", handleEvent2, false);
}