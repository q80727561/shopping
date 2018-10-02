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
	position: relative;
	top: 15px;
}
</style>
</head>
<body>
	<header class="pageheader" id="pageheader"> </header>
	<div id="center-main" class="center-main">
		
	</div>
</body>
</html>
