<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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

				<script>
					layui.use(['form','laydate'], function() {
						var form = layui.form;
						var laydate = layui.laydate;
				
						//监听提交
						form.on('submit(submitBut)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
						
						var newDate = new Date();
						nowTime = newDate.getFullYear()+"-"+(newDate.getMonth()+1)+"-"+newDate.getDate();
						laydate.render({
						    elem: '#time' 
					    	,range: '~'
//					    	,type: 'datetime'	//开启时分秒
					    	,format: 'yyyy-MM-dd'
					    	,max: nowTime	//min/max - 最小/大范围内的日期时间值
						});
					});
				</script>
			</div>
			
			<table class="layui-table">
			
				<tbody>
				
				<tr >
					<td height="40px" width="200px">会员名：</td>
					<td><s:property value="#session.userlogin.username"/></td>
				</tr>
				<tr>
					<td height="40px">手机号码：</td>
					<td><s:property value="#session.userlogin.phone"/></td>
				</tr>
				<tr>
					<td height="40px">药品清单：</td>
					<td>
				<table>
					<thead>
					<tr>
						<th>商品名称</th>
						<th>售价</th>
						<th>商品数量</th>
						<th>小计</th>
					</tr>
				</thead>
						<s:iterator value="#session.shop.shopItems" var="shopItem">
					<tr>
						<td><s:property value="#shopItem.good.gname"></s:property></td>
						<td><s:property value="#shopItem.good.price"></s:property></td>
						<td><s:property value="#shopItem.count"></s:property></td>
						<td><s:property value="#shopItem.subtotal"></s:property>元</td>
						
					</tr>
				</s:iterator> 
					</table>
					</td>
				</tr>
				<tr>
					<td height="40px">药品总金额：</td>
					<td><s:property value="#session.shop.total"></s:property>元</td>
				</tr>
				
				</tbody>
		
				
			</table>
			<table class="layui-table" style="margin-top: 20px">
				<tr>
				<td >
				<a href="${pageContext.request.contextPath}/indent_addIndent"><button style="float: right" class="layui-btn layui-btn-danger"  type="submit">确认订单</button></a>
				</td>
				</tr>
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