function newRequest()
{
	window.open('./html/form.html',"_self");
}

function closeWindow()
{
	window.close();
}

function viewInformation()
{
	window.open('./username.html',"_self");
}
function handleEvent(){
	
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET", "../ViewRequest", true);
	
	xhr.send();
}

window.onload = function(){
	
	document.getElementById("myBtn").addEventListener("click", handleEvent, false);

}