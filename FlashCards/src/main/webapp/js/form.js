$(document).ready(function() {
	$("#e_cost").change(calculateReimbursement);
	$("#e_type").change(calculateReimbursement);
});

function calculateReimbursement() {
	console.log("inside e_cost change");
	var percent = .80;
	var type = $("#e_type").val();
	console.log("type " + type + ":" + typeof type);
	switch (type) {
	case "University Course":
		percent = .80;
		break;
	case "Seminars":
		percent = .60;
		break;
	case "Certificate Preparation Classes":
		percent = .75;
		break;
	case "Certification":
		percent = 1;
		break;
	case "Technical Training":
		percent = .90;
		break;
	case "Other":
		percent = .30;
		break;
	}
	console.log("percent " + percent);
	var amount = $("#e_cost").val() * percent;
	$("#projected").val(amount.toFixed(2));
}