<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	</head>

	<body>
		<div class="cBody">
			<div class="console">
				<form class="layui-form" action="">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="name" required lay-verify="required" placeholder="输入分管名称" autocomplete="off" class="layui-input">
						</div>
						<button class="layui-btn" lay-submit lay-filter="submitBut">检索</button>
					</div>
				</form>

				<script>
					layui.use('form', function() {
						var form = layui.form;
				
						//监听提交
						form.on('submit(submitBut)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
					});
				</script>
			</div>
			
			<table class="layui-table">
				<thead>
					<tr>
						<th>名称</th>
						<th>描述</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				
				<s:iterator value="findAllType" var="type">
					<tr>
						<td><s:property value="#type.tid"></s:property></td>
						<td><s:property value="#type.tname"></s:property></td>
						<td>
							<button class="layui-btn layui-btn-xs">修改</button>
							<button class="layui-btn layui-btn-xs layui-btn-normal">添加二级分类</button>
							<button class="layui-btn layui-btn-xs layui-btn-warm">查看二级分类</button>
						</td>
					</tr>
				</s:iterator>
				
					
				</tbody>
			</table>
			
			<!-- layUI 分页模块 -->
			<div class="h_55"></div>
			<div id="pages"></div>
			<script>
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage,
						layer = layui.layer;
				
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: 100
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
					      console.log(obj)
					    }
					});
				});
			</script>
		</div>
	</body>

</html>