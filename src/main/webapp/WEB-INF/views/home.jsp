<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Home</title>
<style type="text/css">
.product {
	margin: 0px 0px 0px 200px
}
</style>
</head>
<body>
	<span id="dataBox" style="display: none;"></span>
	<script type="text/javascript">
		var myData = "{{str}}";
		alert(myData);
	</script>
	${str}
	<div id="products" class="products"></div>
</body>
</html>
