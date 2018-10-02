/**
 * 
 */

function list() {
	var test;
	if (window.XMLHttpRequest) {
		test = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		test = new window.ActiveXObject();
	} else {
		alert("请升级至最新版本的浏览器");
	}
	if (test != null) {
		alert(location.pathname);
		test.open("POST", location.pathname, true);
		test.send(null);
		test.onreadystatechange = function() {
			if (test.readyState == 4 && test.status == 200) {
		       document.getElementById("center-main").innerHTML=test.responseText;
			}
		}
	};
}