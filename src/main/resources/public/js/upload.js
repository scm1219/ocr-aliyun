function generateHideElement(name, value) {
	var tempInput = document.createElement("input");
	tempInput.type = "hidden";
	tempInput.name = name;
	tempInput.value = value;
	return tempInput;
}

function upload(dataUrl){
	var data = dataUrl;
	var form = document.createElement("form");
	document.body.appendChild(form);
	var imgbase64 = generateHideElement("imgbase64", dataUrl);
	form.appendChild(imgbase64);
	form.method = "post";
	form.action = apipath;
	form.submit();
}