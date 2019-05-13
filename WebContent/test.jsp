<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>测试！！！
<form action="${pageContext.request.contextPath}/goodsAddAction" method="post">
	商品名：<input type="text" name="goodname">
	价格：<input type="text" name="price">
	库存：<input type="text" name="stock">
<input type="submit" value="提交">
</form>	


</body>
</html>