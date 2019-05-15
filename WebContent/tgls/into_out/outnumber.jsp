<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>添加订单</title>

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

<style>
.layui-form-label {
	width: 100px;
}

.layui-input-block {
	margin-left: 130px;
}

.layui-form {
	margin-right: 30%;
}
</style>

</head>
<!--  private Integer rid; //入库编号
     private String rnumber;//入库订单编号
     private String rproduct;//入库产品
     private String rdate; //入库时间
     private String rtotal; //入库总数 
    private  String  runit;//单价
    private  String  rname;//操作员
    private String rtext;//备注 
    private  String rbrithdate;  //生产日期
    private String rput;//上架数量  
    

private Integer outid; // 上架编号
	private String outnumber;// 上架订单编号
	private String outname;// 上架产品
	private String outdate; // 上架时间
	private String outprice;// 上架单价
	private String outfactory;//厂家
	private String outtext;// 备注 备用
	private String outbrithdate; // 生产日期
	private String outnum;// 上架数量

    -->
<body>
	<div class="cBody">
		<p style="font-size: larger; font-family: 黑体； color : red"
			value="请核对以下信息："></p>
		<form id="addForm" class="layui-form" method="post"
			action="${pageContext.request.contextPath}/Outrepertory_insertoutrepertory">

			<s:iterator value="outdate" var="outdate">
				<label class="layui-form-label" style="color:red">订单编号：</label>
				<!-- 订单编号 -->
				<input type="text" name="outnumber"  style="width:400px"  readonly="readonly"
					value="<s:property value="#outdate.rnumber"/>" required
					lay-verify="required" autocomplete="off" class="layui-input"><br>
				<!-- 产品名字 -->
				<label class="layui-form-label" style="color:red"> 产品名字： </label>
				<input type="text" name="outname" style="width:400px"  readonly="readonly"
					value="<s:property value="#outdate.rproduct"/>" required
					lay-verify="required" autocomplete="off" class="layui-input"><br>
				<label class="layui-form-label" style="color:red">产品单价： </label>
				<!-- orUnitPrice 单价-->
				<input type="text" name="outprice" style="width:400px"  readonly="readonly"
					value="<s:property value="#outdate.runit"/>" required
					lay-verify="required" autocomplete="off" class="layui-input"><br>
				<label class="layui-form-label" style="color:red">生产日期：</label>
				<!--生产日期  -->
				<input type="text" name="brithdate" style="width:400px"  readonly="readonly"
					value="<s:property value="#outdate.rbrithdate"/>" required
					lay-verify="required" autocomplete="off" class="layui-input"><br>
				<label class="layui-form-label" style="color:red"> 生厂厂家：</label>
				<!-- 厂家 -->
				<input type="text" name="outfactory" style="width:400px"  readonly="readonly"
					value="<s:property value="#outdate.rput"/>" required
					lay-verify="required" autocomplete="off" class="layui-input"><br>
			</s:iterator>

			<div class="layui-form-item">
				<label class="layui-form-label" style="color:red">上架数量：</label>
				<div class="layui-input-block">
					<input type="text" name="outnum" placeholder="请输入上架数量" style="width:400px"
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>



			<div class="layui-form-item">
				<div class="layui-input-block">
					<input class="layui-btn" type="submit" value="立即提交">
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	<div class="layui-form-item">
				<div class="layui-input-block">
					
					<a href="${pageContext.request.contextPath}/repertory_repertoryall2"><input type="button" class="layui-btn layui-btn-primary" value="返回"></a>
				</div>
			</div>

		<script>
			layui.use([ 'upload', 'form' ], function() {
				var form = layui.form;
				var upload = layui.upload;
				var layer = layui.layer;
				//监听提交
				form.on('submit(submitBut)', function(data) {
					return false;
				});
				form.verify({
					//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
					ZHCheck : [ /^[\u0391-\uFFE5]+$/, '只允许输入中文' ]
				});
				//拖拽上传
				upload.render({
					elem : '#goodsPic',
					url : '/upload/',
					done : function(res) {
						console.log(res)
					}
				});
			});
		</script>

	</div>
</body>

</html>