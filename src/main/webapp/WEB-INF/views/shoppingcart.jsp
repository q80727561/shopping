<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>線上書局</title>
<script type="text/javascript" src="/resources/js/header.js"></script>
<script type="text/javascript">
	function show(event) {
		event = event || window.event;
		if (event.preventDefault) {
			event.preventDefault();
		} else {
			event.returnValue = false;
		}
		var elements = document.getElementsByClassName("btn btn-plain");		
		var test;
		var target = event.target || event.srcElement;  
		if (window.XMLHttpRequest) {
			test = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			test = new window.ActiveXObject();
		} else {
			alert("请升级至最新版本的浏览器");
		}
		if (test != null) {
			test.open("DELETE", target.href, true);
			test.setRequestHeader('Accept', 'application/json')
			test.send(null);
			test.onreadystatechange = function() {
				if (test.readyState == 4 && test.status == 200) {					
					if(test.responseText=='success'){
						 location.reload();
					}
				}
			}
		};
	}
	window.onload = function() {
		headr();
	}
</script>
<style type="text/css">
body {
	margin: 0;
	background-color: #cdcece;
	font-family: Helvetica, Arial, 'LiHei Pro', '微軟正黑體', sans-serif;
	font-size: 15px;
	line-height: 1.3333;
	color: #43464d;
}

header.pageheader {
	border-top: 4px solid #333;
	background: linear-gradient(#585a61, #3c3f45);
	height: 30px;
}

div.center-main {
	max-width: 1200px;
	box-sizing: border-box;
	margin: 0 auto;
	border-style: solid;
	border-color: #FFFFFF;
	border-radius: 10px;
	padding: 5px;
	height: 80%;
	background: #FFFFFF;
	position: relative;
	top: 20px;
}

div.list {
	padding: 5px;
	box-sizing: border-box;
	font-size: 5px;
	height: 12%;
}

table.cart-list {
	width: 100%;
}

table.cart-list>thead {
	text-align: left;
}

td.cover {
	width: 50px
}
td.name {
	width: 368px
}
td.quantity>input {
	width: 50px
}

td.cover>img {
	width: 100%;
}
</style>
</head>
<body>
	<header class="pageheader" id="pageheader"> </header>
	<div id="center-main" class="center-main">
		<div class="title">
			<table class="cart-list">
				<thead>
					<tr>
						<th class="name" colspan="2">商品名稱</th>
						<th class="price price-item">單價</th>
						<th class="quantity">數量</th>
						<th class="action">動作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${order}" var="p">
						<tr>
							<td class="cover"><img src="/resources/img/${p.value.getProductimg()}"><br>
							</td>
							<td class="name"><a href="/product/${p.value.getProductno()}">${p.value.getProductname()}</a>
							<td class="price price-item"><span>$${p.value.getProductprice()}</span></td>
							<td class="quantity"><input type="number" value="${p.value.getProductnum()}"
								class="update_qty"></td>
							<td class="action"><a class="btn btn-plain"
								onclick="show()" href="/cart?id=${p.value.getProductno()}">取消</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th class="align-left" colspan="2">總計</th>
						<td class="price price-total" colspan="4">$<span
							id="cart-amount">${pricetotal}</span></td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</body>
</html>
