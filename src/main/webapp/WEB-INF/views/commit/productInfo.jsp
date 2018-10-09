<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div.img-productinfo {
	float: left;
}

div.img-productinfo>img {
	max-width: 212px
}

span.item-name {
	width: 50px;
	display: block;
	position: absolute;
}

span.item-value {
	padding-left: 50px;
	display: block;
}

ul.item-info {
	list-style: none;
	padding-left: 212px;
}

div.item-tools {
	padding-left: 212px;
}
</style>
</head>
<body>
	<div>
		<div class="img-productinfo">
			<img src="/resources/img/${productInfo.get(3)}"><br>
		</div>
		<ul class="item-info">
			<li><span class="item-name">書名:</span><span class="item-value">${productInfo.get(0)}</span></li>
			<li><span class="item-name">作者:</span><span class="item-value">${productInfo.get(1)}</span></li>
			<li><span class="item-name">價格:</span><span class="item-value">$${productInfo.get(2)}</span></li>
		</ul>
	</div>
	<div class="item-tools">
		<form class="button_to" method="post"
			action="/cart?id=${productInfo.get(4)}&productname=${productInfo.get(0)}&productprice=${productInfo.get(2)}">
			<input type="submit" value="加入購物車">
		</form>
	</div>
</body>
</html>