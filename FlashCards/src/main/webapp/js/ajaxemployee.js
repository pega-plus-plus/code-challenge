function fetchEmployeeList(){
	let ajaxRequest = new XMLHttpRequest();
	let url = "FetchEmployee.do";
	
	let option = null;
	
	let employees = null;
	
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
			employees = JSON.parse(ajaxRequest.response);
			
			console.log(employees);
			console.log(employees[1])
			
			for(let index in employees){
				option = document.createElement("option");
				option.setAttribute("value", employees[index]["id"]);
				option.innerHTML=employees[index]["firstName"]+" "+employees[index]["lastName"]+
				" "+employees[index]["supervisor"];
				document.getElementById("employee").appendChild(option);
			}
			document.getElementById("listdefault").innerHTML = "--pick an employee--";
		}
	}
	ajaxRequest.open("GET", url);
	ajaxRequest.send();
}

window.onload = function(){
	fetchEmployeeList();
}