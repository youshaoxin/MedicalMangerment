<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="穷在闹市" />
		<!-- 作者 -->
		<meta name="revised" content="穷在闹市.v3, 2019/05/01" />
		<!-- 定义页面的最新版本 -->
		<meta name="description" content="网站简介" />
		<!-- 网站简介 -->
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>穷在闹市出品</title>

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconfont.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
		<script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<script src="${pageContext.request.contextPath}/js/out_intoData.js"></script>

	</head>

	<body>
		<form action="${pageContext.request.contextPath}/repertory_selectorder" method="post">
		<!--  请输入订单编号：<input type="text" placeholder="请输入订单编号"  name="ordernumber" multiple="multiple"> -->
                   <div class="layui-form-item">
					<label class="layui-form-label" >请输入订单编号：</label>
					<div class="layui-input-block">
						<input type="text" name="ordernumber"  placeholder="请输入订单编号" style="width:400px" lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
                   <div class="layui-form-item">
					<div class="layui-input-block">
						<input class="layui-btn" type="submit" value="立即提交">
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
               
		</form>
		
		
		
	</body>

</html>