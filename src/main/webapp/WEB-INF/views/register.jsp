<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>線上書局</title>
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

div.product {
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

div.alert-error {
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid transparent;
	border-radius: 5px;
	position: relative;
	top: 15px;
}
</style>
</head>
<body>
	<header class="pageheader">
		<div class="center-container">
			<nav class="top-nav">
				<ul class="main-menu">
					<li><a href="#">書籍分類</a>
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
					<li><a href="/users/sign_in">登入</a></li>
					<li><a href="/users/register">註冊</a></li>
					<li><a href="#">購物車</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<c:if test="${requestScope.message!=null}">
	<div class="center-container">
		<div class="alert-error">${requestScope.message}</div>
	</div>
	</c:if>
	<div id="product" class="product">
		<form action="/users/register" accept-charset="UTF-8" method="post">
			<div>
				<label for="username">帳號</label>
				<div>
					<input type="text" name="username" id="username" />
				</div>
			</div>
			<div>
				<label for="username">密碼</label>
				<div>
					<input type="password" name="password" id="password" />
				</div>
			</div>
			<div class="form-footer">
				<input type="submit" name="commit" value="註冊" class="btn" />
			</div>
		</form>
	</div>
</body>
</html>
