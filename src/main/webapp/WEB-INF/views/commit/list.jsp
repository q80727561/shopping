<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<style type="text/css">
div.list{
	float: left;
	width: 20%;
	padding: 5px;
	box-sizing: border-box;
	font-size: 5px;
	height: 33%;
	text-align: center;
}
div.list>a {
	text-decoration: none;
	color: #1C1CFF;
}
div.list>img {
	height: 70%;
}
div.price {
	color: #911400;
}
</style>
</head>
<body>
	<c:forEach items="${personList}" var="p">
		<div class="list">
		<img src="/resources/img/${p.getImg()}"><br>
		${p.getName()}<br>
		<div class="price">售價:$${p.getPrice()}</div>	
	    <a href="/product/${p.getNo()}">詳情</a>			
		</div>
	</c:forEach>
</body>
</html>
