/**
 * 
 */

window.onload = function() {
	var test;
	if (window.XMLHttpRequest) {
		test = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		test = new window.ActiveXObject();
	} else {
		alert("请升级至最新版本的浏览器");
	}
	if (test != null) {
		test.open("GET", "/getList", true);
		test.setRequestHeader('Accept', 'application/json');
		test.send(null);
		test.onreadystatechange = function() {
			if (test.readyState == 4 && test.status == 200) {
				var obj = JSON.parse(test.responseText);
				productdiv=document.getElementById("product");
				for (num in obj) {
					div=document.createElement('div');
					getView(div, obj[num].price); 
                    getView(div, obj[num].price); 
                    productdiv.appendChild(div);
				}
			}
		}
	};
	function getView(div, value) {
		var t = document.createTextNode(value);
		div.appendChild(t);
		div.appendChild(div=document.createElement('br'));
	}
}