<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<style type="text/css">

div.center-container {
	max-width: 1200px;
	box-sizing: border-box;
	margin: 0 auto;
}

.top-nav {
	
}

ul.main-menu {
	margin: 0;
	list-style: none;
	padding: 0px;
	float: left;
}

ul.main-menu>li {
	float: left
}

ul.main-menu>li>a {
	display: block;
	text-align: center;
	line-height: 30px;
	width: 80px;
	text-decoration: none;
	color: #fff
}

ul.main-menu>li:hover>a {
	background: #54565c;
}

ul.main-menu>li:hover>ul {
	display: block;
}

ul.category-list {
	position: absolute;
	box-sizing: border-box;
	width: 1200px;
	display: none;
	overflow: hidden;
	background: #54565c;
	z-index: 100;
	padding: 10px 0 15px 30px;
}

ul.category-list>li {
	width: 25%;
	float: left;
	line-height: 36px;
	color: #969696;
}

ul.category-list>li>a {
	display: block;
	box-sizing: border-box;
	color: #fff;
	position: relative;
	line-height: 1.5em;
	text-decoration: none;
}

ul.category-list>li:hover {
	list-style-type: disc;
	color: blue;
}

ul.right-menu {
	margin: 0;
	list-style: none;
	padding: 0px;
	float: right;
}

ul.right-menu>li {
	float: left;
}

ul.right-menu>li>a {
	display: block;
	text-align: center;
	line-height: 30px;
	width: 80px;
	text-decoration: none;
	color: #fff;
}

ul.right-menu>li>a:hover {
	background: #54565c;
}
</style>
</head>
<body>
		<div class="center-container">
			<nav class="top-nav">
				<ul class="main-menu">
					<li><a href="/#">書籍分類</a>
						<ul class="category-list">
							<li><a href="/category-list">全部分類</a></li>
							<li><a href="/category-list/001">推理小說</a></li>
							<li><a href="/category-list/002">科幻小說</a></li>
							<li><a href="/category-list/003">溫馨小說</a></li>
						</ul></li>
					<li><a href="/tw">中文書</a></li>
					<li><a href="/en">英文書</a></li>
				</ul>
				<ul class="right-menu">
					<c:if test="${sessionScope.User.getUsername() == null}">
						<li><a href="/users/sign_in">登入</a></li>
						<li><a href="/users/register">註冊</a></li>
					</c:if>
					<c:if test="${sessionScope.User.getUsername() != null}">
						<li><a href="#">${sessionScope.User.getUsername()}</a></li>
						<li><a href="/users/logout">登出</a></li>
					</c:if>
					<li><a href="/cart">購物車 ${sessionScope.order.size()}</a></li>
				</ul>
			</nav>
		</div>
</body>
</html>
