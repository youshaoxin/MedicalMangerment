<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<title>出库查询列表</title>

<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/iconfont.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/layui/css/layui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
<!-- 公共样式 结束 -->

<script src="${pageContext.request.contextPath}/js/out_intoData.js"></script>

</head>

<body>
	<div class="cBody">

		<div class="layui-form">
			<div class="console">
				<div class="layui-form-item">
					<a class="layui-btn"
						href="${pageContext.request.contextPath}/tgls/into_out/increase.jsp">新增</a>
					<form
						action="${pageContext.request.contextPath}/repertory_mohuselect"
						method="post">
						<div class="layui-form-item">
							<label class="layui-form-label">开始时间</label>
							<div class="layui-input-block">
								<input type="datetime-local" name="begintime"
									style="width: 500px" lay-verify="required" autocomplete="off"
									class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">结束时间</label>
							<div class="layui-input-block">
								<input type="datetime-local" name="endtime" style="width: 500px"
									lay-verify="required" autocomplete="off" class="layui-input">
							</div>
						</div>
						

						<div class="layui-form-item">
							<div class="layui-input-block">
								<input class="layui-btn" type="submit" value="立即查询">
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>

					</form>


				</div>
			</div>

		</div>
	<!-- 	private String outnumber;// 上架订单编号
	private String outname;// 上架产品
	private String outdate; // 上架时间
	private String outprice;// 上架单价
	private String outfactory;//厂家
	private String outtext;// 备注 备用
	private String outbrithdate; // 生产日期
	private String outnum;// 上架数量 -->
		<table id="customList" class="layui-table">
			<thead>
				<tr>
					<th>订单单号</th>
					<th>入库名称</th>
					<th>入库时间</th>
					<th>供应商</th>

					<th>单价</th>
					<th>入库数量</th>

					<th>生产日期</th>
					<th>备注</th>
					<th>操作员</th>
					
				<!-- 	<th>出库</th> -->
					<th>下架</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="outRepertory" var="out">
				
					<tr>
						<td><s:property value="#out.outnumber" /></td>
						<td><s:property value="#out.outname" /></td>
						<td><s:property value="#out.outdate" /></td>
						<td><s:property value="#out.outprice" /></td>
						<td><s:property value="#out.outnum"/></td>
						<td><s:property value="#out.outfactory" /></td>
						<td><s:property value="#out.outbrithdate" /></td>
						
						<td><s:property value="#out." /></td>
						<td><s:property value="#out." /></td>

						<%-- <td><a href="${pageContext.request.contextPath}/Outrepertory_outrepertory?number=<s:property value="#reper.rnumber"></s:property>">
						<input class="layui-btn" type="button" value="立即出库"></a></td> --%>
						<td><a><input class="layui-btn" type="button" value="下架产品"></a></td>
					</tr>


				</s:iterator>


			</tbody>
		</table>


	</div>
</body>

</html>