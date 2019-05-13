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
				<form class="layui-form" action="${pageContext.request.contextPath}/user_searchUser" method="post">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="phone" required lay-verify="required" placeholder="请输入手机号查询" autocomplete="off" class="layui-input">
						</div>
						<%-- <div class="layui-input-inline">
				        	<input type="text" class="layui-input" id="time" placeholder=" - ">
						</div>
						<div class="layui-input-inline">
		                    <select name="provid" id="provid" lay-filter="provid">
		                        <option value="">一级分类</option>
		                    </select>
		                </div>
		                <div class="layui-input-inline">
		                    <select name="cityid" id="cityid" lay-filter="cityid">
		                        <option value="">二级分类</option>
		                    </select>
		                </div> --%>
						<button class="layui-btn" lay-submit lay-filter="submitBut " type="submit">查询会员</button>
					</div>
				</form>

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
				<thead>
					<tr>
						<th>会员名</th>
						<th>性别</th>
						<th>会员身份证</th>
						<th>电话号码</th>
						<th>地址</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="userlist">
					<tr>
						<td><s:property value="username"/></td>
						<td><s:property value="sex"/></td>
						<td><s:property value="cardNum"/></td>
						<td><s:property value="phone"/></td>
						<td><s:property value="adress"/></td>
						
						<td>
							<a href="${pageContext.request.contextPath}/user_editUser?uid=<s:property value="uid"/>"><button class="layui-btn layui-btn-xs">修改信息</button></a>
							<a href="${pageContext.request.contextPath}/user_deleteUser?uid=<s:property value="uid"/>"><button class="layui-btn layui-btn-xs">注销会员</button></a>
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