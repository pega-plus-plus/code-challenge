function getAlert(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let alert = JSON.parse(xhttp.responseText);
			setAlert(alert);
		}
	}
	xhttp.open("GET", 'http://localhost:9000/Flashcards/html/alertJSON.do', true);
	xhttp.send();
}

function setAlert(alert){
	console.log(alert);
	if(alert!=null){
		let alert_html = '<div class="alert alert-' + alert.type + '" role="alert">'+alert.message+'</div>';
		document.getElementById("alert").innerHTML= alert_html;
	}
}