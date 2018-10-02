/**
 * 
 */

function headr() {
	var test;
	if (window.XMLHttpRequest) {
		test = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		test = new window.ActiveXObject();
	} else {
		alert("请升级至最新版本的浏览器");
	}
	if (test != null) {
		test.open("GET", "/getheader", true);
		test.send(null);
		test.onreadystatechange = function() {
			if (test.readyState == 4 && test.status == 200) {
		       document.getElementById("pageheader").innerHTML=test.responseText;
			}
		}
	};
}