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
<title>穷在闹市出品</title>

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
						<%-- <div class="layui-form-item">
					<label class="layui-form-label">查询时间</label>
	                <div class="layui-input-inline">
	                    <select name="provid" id="provid" lay-filter="provid">
	                        <option value="">年</option>
					        <option value="0">2019</option>
					        <option value="1">2018</option>
					        <option value="2">2017</option>
					        <option value="3">2016</option>
					        <option value="4">2015</option>
	                    </select>
	                </div>
	                <div class="layui-input-inline">
	                    <select name="cityid" id="cityid" lay-filter="cityid">
	                        <option value="">月</option>
					        <option value="0">5</option>
					        <option value="1">6</option>
					        <option value="2">7</option>
					        <option value="3">8</option>
					        <option value="4">9</option>
	                    </select>
	                </div>
	                
	                  <div class="layui-input-inline">
	                    <select name="cityid" id="cityid" lay-filter="cityid">
	                        <option value="">日</option>
					        <option value="0">5</option>
					        <option value="1">6</option>
					        <option value="2">7</option>
					        <option value="3">8</option>
					        <option value="4">9</option>
	                    </select>
	                </div>
	                
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">到达时间</label>
	                <div class="layui-input-inline">
	                    <select name="provid" id="provid" lay-filter="provid">
	                        <option value="">年</option>
					        <option value="0">2019</option>
					        <option value="1">2018</option>
					        <option value="2">2017</option>
					        <option value="3">2016</option>
					        <option value="4">2015</option>
	                    </select>
	                </div>
	                <div class="layui-input-inline">
	                    <select name="cityid" id="cityid" lay-filter="cityid">
	                        <option value="">月</option>
					        <option value="0">5</option>
					        <option value="1">6</option>
					        <option value="2">7</option>
					        <option value="3">8</option>
					        <option value="4">9</option>
	                    </select>
	                </div>
	                 <div class="layui-input-inline">
	                    <select name="cityid" id="cityid" lay-filter="cityid">
	                        <option value="">日</option>
					        <option value="0">5</option>
					        <option value="1">6</option>
					        <option value="2">7</option>
					        <option value="3">8</option>
					        <option value="4">9</option>
	                    </select>
	                </div> 
				</div> --%>

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
	
		<table id="customList" class="layui-table">
			<thead>
				<tr>
					<th>订单单号</th>
					<th>入库名称</th>
					<th>入库时间</th>
					<th>供应商</th>
					<!-- <th>制单人</th> -->
					<!-- <th>商品</th> -->

					<th>单价</th>
					<th>入库数量</th>

					<th>生产日期</th>
					<th>备注</th>
					<th>操作员</th>
					
					<th>出库</th>
					<th>禁止上架</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="repertoryall" var="reper">
					<!--   private Integer rid; //入库编号
     private String rnumber;//入库订单编号
     private String rproduct;//入库产品
     private String rdate; //入库时间
    
     private String rtotal; //入库总数 
    private  String  runit;//单价
    private  String  rname;//操作员
    private String rtext;//备注 -->
					<tr>
						<td><s:property value="#reper.rnumber" /></td>
						<td><s:property value="#reper.rproduct" /></td>
						<td><s:property value="#reper.rdate" /></td>
						<td><s:property value="#reper.rput" /></td>
						<td><s:property value="#reper.runit" /></td>
						<td><s:property value="#reper.rtotal" /></td>
						<td></td>
						<td><s:property value="#reper.rtext" /></td>
						<td><s:property value="#reper.rname" /></td>
			
						
						
						<td><a href="${pageContext.request.contextPath}/Outrepertory_outrepertory?number=<s:property value="#reper.rnumber"></s:property>">
						<input class="layui-btn" type="button" value="立即出库"></a></td>
						<td><a><input class="layui-btn" type="button" value="禁止出库"></a></td>
					</tr>


				</s:iterator>


			</tbody>
		</table>


	</div>
</body>

</html>