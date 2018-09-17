<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="/resources/js/list.js">
	
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

.pageheader {
	border-top: 4px solid #333;
	background: linear-gradient(#585a61, #3c3f45);
	height: 30px;
}

.center-container {
	max-width: 1200px;
	box-sizing: border-box;
	margin: 0 auto;
}

.top-nav {
	
}

.main-menu {
	margin: 0;
	list-style: none;
	padding: 0px;
	float: left;
}

.main-menu>li {
	float: left
}

.main-menu>li>a {
	display: block;
	text-align: center;
	line-height: 30px;
	width: 80px;
	text-decoration: none;
	color: #fff
}

.main-menu>li:hover>a {
	background: #54565c;
}

.main-menu>li:hover>ul {
	display: block;
}

.category-list {
	position: absolute;
	box-sizing: border-box;
	width: 1200px;
	display: none;
	overflow: hidden;
	background: #54565c;
	z-index: 100;
	padding: 10px 0 15px 30px;
}

.category-list>li {
	width: 25%;
	float: left;
	line-height: 36px;
	color: #969696;
}

.category-list>li>a {
	display: block;
	box-sizing: border-box;
	color: #fff;
	position: relative;
	line-height: 1.5em;
	text-decoration: none;
}

.category-list>li:hover {
	list-style-type: disc;
	color: blue;
}

.right-menu {
	margin: 0;
	list-style: none;
	padding: 0px;
	float: right;
}

.right-menu>li {
	float: left;
}

.right-menu>li>a {
	display: block;
	text-align: center;
	line-height: 30px;
	width: 80px;
	text-decoration: none;
	color: #fff;
}

.right-menu>li>a:hover {
	background: #54565c;
}

.product {
	max-width: 1200px;
	box-sizing: border-box;
	margin: 0 auto;
	border-style: solid;
	border-color: #FFFFFF;
	border-radius: 10px;
	padding: 5px;
	height: 600px;
	background: #FFFFFF;
	position: relative;
	top: 20px;
}

.product div {
	float: left;
	height: 100px;
	width: 16%;
	padding: 5px;
	box-sizing: border-box;
	font-size: 5px;
}

.product a {
	text-decoration: none;
	color: #1C1CFF;
}
</style>
</head>
<body>
<script type="text/javascript">
alert(location.pathname);
</script>
	<header class="pageheader">
		<div class="center-container">
			<nav class="top-nav">
				<ul class="main-menu">
					<li><a href="#">書籍分類</a>
						<ul class="category-list">
							<li><a href="#">推理小說</a></li>
							<li><a href="#">科幻小說</a></li>
							<li><a href="#">推理小說</a></li>
							<li><a href="#">科幻小說</a></li>
							<li><a href="#">推理小說</a></li>
							<li><a href="#">科幻小說</a></li>
							<li><a href="#">推理小說</a></li>
							<li><a href="#">科幻小說</a></li>
						</ul></li>
					<li><a href="#">中文書</a></li>
					<li><a href="#">英文書</a></li>
				</ul>
				<ul class="right-menu">
					<li><a class="login" href="#">登入</a></li>
					<li><a href="#">註冊</a></li>
					<li><a href="#">購物車</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<div id="product" class="product"></div>
</body>
</html>
