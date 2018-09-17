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
				test.open("GET", "/getInformation?id=1", true);
				test.setRequestHeader('Accept', 'application/json');
				test.send(null);
				alert("请升级至最新版本的浏览器");
				test.onreadystatechange = function() {
					if (test.readyState == 4 && test.status == 200) {
						var obj = JSON.parse(test.responseText);
						var div = document.getElementById("products");
						getView(div, "商品名稱:" + obj[0])
						getView(div, "價格" + obj[1])
						getView(div, "詳細" + obj[2])
						document.body.appendChild(div);
					}
				};
			}

			function getView(div, value) {
				var newBaitTag = document.createElement('h2');
				var t = document.createTextNode(value);
				newBaitTag.appendChild(t);
				div.appendChild(newBaitTag);
			}
		}