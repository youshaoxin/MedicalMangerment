<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>医药管理系统后台登录</title>
<style>
*{padding:0px; margin:0px; list-style:none;}
body{width:100%;margin:0px;padding:0px;background:url(images/bg03.jpg);width:100%;height:100%}
.top{width:960px;height:336px;margin:0 auto; background:url(images/bg01s.jpg) no-repeat; position:relative}
.bottom{width:960px;height:305px;margin:0 auto; background:url(images/bg02.jpg) no-repeat; position:relative}
#username,#p_t,#userpwd,#validatecode{ position:absolute;top:206px;left:187px;width:193px;height:34px;border:0px;font-size:14px;line-height:30px;color:#666}
#p_t,#userpwd{left:402px; z-index:2}
#validatecode{left:618px; z-index:2;width:113px}
#vcodesrc{ position:absolute;top:165px;left:616px; font-family:Arial}
#userpwd{z-index:1;color:#333}
#login_bt{position:absolute;top:207px;left:751px;width:102px;height:33px; background:transparent; z-index:3;border:0px; cursor:pointer}
.forget{color:#94adc3;position:absolute;top:247px;left:805px;font-size:12px; text-decoration:none}
.forget1{color:#ff6600;position:absolute;top:247px;left:745px;font-size:12px; text-decoration:none}
.item_list{position:absolute;top:70px;left:505px;width:300px;padding-top:20px;}
ul,li{padding:0;margin:0; font-size:12px;list-style:none; border:0;font-weight:normal;}
.item_list ul{width:100%}
.item_list li{width:100%;line-height:24px;color:#fff;}
</style>
</head>
<body>
<div class="top">
<h1>店员登录</h1><a href="${pageContext.request.contextPath}/AdminLogin.jsp">店长登录</a>
<form name="userLoginActionForm" id="userLoginActionForm" method="post" action="${pageContext.request.contextPath}/login_checkLogin"  target="_parent" >
	<input type="text" autofocus="true" id="username" name="name" placeholder="请输入用户名" maxlength="20"  onfocus="userInter('F','username',this);"onblur="userInter('B','username',this)"  />
    <input type="password" id="p_t" name="password" placeholder="请输入密码" onfocus="hide_pw()" />
    <input type="submit" value="" id="login_bt" name="login_bt" onclick="logincheck()"/>
    <a href="" class="forget">忘记密码？</a>
   
</form>
</div>
<div class="bottom">
	
	<div class="item_list">
    <ul>
    	<li>一、1月28日手机版、微信网站上线</li>
    	<li>二、12月20日高级功能新增网站小图标</li>
    	<li>三、12月19日拖拽建站新增6个色系，增加选色功能</li>
    	<li>四、12月12日拖拽建站新增10个色系</li>
    	<li>五、12月6日拖拽建站新增焦点图，10个色系、模块样式扩展等</li>
    	<li>六、12月3日头部LOGO，栏目条，焦点图功能升级！</li>
    	<li>七、11月8日拖拽建站模块样式全线升级啦！</li>
        </ul>
    </div>
   
</div> 

</body>
</html>