<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>線上書局</title>
<script type="text/javascript" src="/resources/js/header.js"></script>
<script type="text/javascript">
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

div.alert-error {
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid transparent;
	border-radius: 5px;
	max-width: 1200px;
	box-sizing: border-box;
	margin: 20 auto 0 auto;
}
</style>
</head>
<body>
	<header class="pageheader" id="pageheader"> </header>
	<c:if test="${message!=null}">
	<div class="alert-error">${message}</div>
	</c:if>
	<div id="center-main" class="center-main">
		<form action="/users/register?id=0" accept-charset="UTF-8" method="post">
			<div>
				<label for="username">帳號</label>
				<div>
					<input type="text" name="username" id="username" />
				</div>
			</div>
			<div>
				<label for="username">密碼</label>
				<div>
					<input type="text" name="password" id="password" />
				</div>
			</div>
			<div class="form-footer">
				<input type="submit" name="commit" value="註冊" class="btn" />
			</div>
		</form>
	</div>
</body>
</html>