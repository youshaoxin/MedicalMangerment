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
		<title>药店管理系统出品</title>
		
		

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconfont.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-3.4.0.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
		<script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>
			.layui-table img {
			    max-width: none;
			}
		</style>

	</head>

	<body>
		<div class="cBody">
			<div class="console">
			<!-- layui-form -->
				<form class="form1" action="${pageContext.request.contextPath}/goods_findSomeGood" method="post">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="gname" required lay-verify="required" placeholder="输入商品名称" autocomplete="off" class="layui-input">
						</div>
						

						
						
		                    <select name="provid" id="provid" onchange="change()" lay-filter="cityid">
		                        <option value="1">全部类别</option>
		                        <option value="2">处方药</option>
		                        <option value="3">非处方药</option>
		                    </select>
		                    
		                 <script type="text/JavaScript">

						window.onload = function () {
						 document.getElementById('cityid').addEventListener('change',function(){
						  	alert("当前选项是:"+this.value);
							
						
						
						
						     },true);
						  } 
						
						 </script> 
		               
		                
		              
		                    <select name="cityid" id="cityid" lay-filter="cityid" >
		                        <option value="">全部类别</option>
		                      	<s:iterator value="findAllType" var="type">
		                        	<option value="<s:property value="#type.tname"></s:property>" >
		                        		<s:property value="#type.tname"></s:property>
		                        	</option>
		                        </s:iterator>
		                       
		                    </select>
		              
						<button class="layui-btn"  type="submit">检索</button>
						<!-- lay-submit lay-filter="submitBut" -->
						<a class="layui-btn">导入商品</a>
					</div>
				</form>

				<script>
				
					//页面加载就会立刻执行的函数
					/* window.onload = function(){
						/**
						 * 用jQuery的方式发起AJAX请求
						 */
							/* $.ajax({
								url:encodeURI(encodeURI("${pageContext.request.contextPath}/type_findIndexTypes")),
								type:"post",
								cache:false,
								success:function(msg){
									//$("#msg").append(msg);
									if(msg.isSuccess){
										alert("出手的速度");
										$("#option1").html("<font color='green'>用户名可用</font>"); 
									}else{
										$("#option1").html("<font color='red'>用户名重复！</font>"); 
									}
									
								}
							});	
											
				    }  */
				    
				    
				
				
				
				
					layui.use('form', function() {
						//var form = layui.form;


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
						<th>药品编号</th>
						<th>商品名称</th>
						<th>商品图片</th>
						<th>售价</th>
						<th>保质期</th>
						<th>类别</th>
						<th>库存数量</th>
						<th>进货价</th>
						<th>供应商</th>
						<th>生产日期</th>
						<th>距离过期</th>
						<th>操作<button onclick="myFunction()">点我</button></th>
					</tr>
				</thead>
				<tbody>
				
				<s:iterator value="GoodList" var="good">
					<tr>
						<td><s:property value="#good.gid"></s:property></td>
						<td><s:property value="#good.gname"></s:property></td>
						<td><img src="${pageContext.request.contextPath}/images/goodsPIC1.png" width="20" height="20" onmouseenter="imgBig(this)" onmouseleave="imgSmall(this)"/></td>
						<td><s:property value="#good.price"></s:property></td>
						<td><s:property value="#good.qualitaDate"></s:property></td>
						<td><s:property value="#good.type.tname"></s:property></td>
						<td><s:property value="#good.stockid"></s:property></td>
						<td></td>
						<td><s:property value="#good.sid.sname"></s:property></td>
						<td><s:property value="#good.date"></s:property></td>
						<td><s:property value="#good.overTime"></s:property></td>
						<td>
							<form id="form01" action="${pageContext.request.contextPath}/goods_updateShowGoods" method="post">
								<input type="hidden" name="gname" value="<s:property value="#good.gname"></s:property>">
								<input type="hidden" name="price" value="<s:property value="#good.price"></s:property>">
								<input type="hidden" name="" value="<s:property value="#good.type"></s:property>">
								<input type="hidden" name="stock">
								<input type="hidden" name="tidd">
								<input type="hidden" name="gid" value="<s:property value="#good.gid"></s:property>">
								
								<a><input id="btn01" class="layui-btn layui-btn-xs" type="submit" value="修改"></a>
								
								<a href="${pageContext.request.contextPath}/goods_deleteGoods?goodid=<s:property value="#good.gid"></s:property>">
									<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="删除"/>
								</a>
								
								<script>
									//定时器
									function myFunction() {
									    setTimeout(function(){ alert("Hello"); }, 0);
									}
									
									
						
								</script>
								
							</form>								
						</td>
					</tr>
				</s:iterator>
				
				
				</tbody>
			</table>
			
			<!-- layUI 分页模块 -->
			<!-- <div class="h_55"></div> -->
			<div id="pages"></div>
			<script>
			
			
				
			
			
			
			
			
			
			
			
				layui.use('laypage', function() {
					var laypage = layui.laypage;
				
					laypage.render({
					    elem: 'pages'
					    ,limit:10
					    ,count: 50
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
//					      console.log(obj)
							//alert(obj.curr);
					    }
					});
				});
				
				
				//删除规格
				function specificationsBut(){
					layui.use('layer', function() {
						var layer = layui.layer;
						
						//iframe层-父子操作
						layer.open({
							type: 2,
							area: ['70%', '60%'],
							fixed: false, //不固定
							maxmin: true,
							content: '${pageContext.request.contextPath}/goods_deleteGoods'
						});
					});
					
				}
				//修改按钮
				var updateFrame = null;
				function updateBut(){
					layui.use('layer', function() {
						var layer = layui.layer;
						var data=<s:property value="#good"/>
						//iframe层-父子操作
						updateFrame = layer.open({
                    		title: "商品信息修改",
							type: 2,
							area: ['70%', '60%'],
							scrollbar: false,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin: true,
							content: '${pageContext.request.contextPath}/goodsUpdateAction'
						});
					});
					
				}
			</script>
		</div>
	</body>

</html>