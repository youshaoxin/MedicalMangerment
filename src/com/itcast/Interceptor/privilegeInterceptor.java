package com.itcast.Interceptor;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.Admin;
import com.itcast.entity.Clerk;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 权限拦截器(ypf+)
 * @author Administrator
 *
 */
public class privilegeInterceptor extends MethodFilterInterceptor{
	/**
	 * 客户端向服务器发送一个Action请求，执行核心过滤器（doFilter）方法，
	 * 在这个方法中，调用executeAction（）方法，
	 * 在这个方法内部调用dispatcher.serviceAction();
	 * 在这个方法内部创建一个Action代理，
	 * 最终执行的是Action代理中的execute()，
	 * 在代理中执行的execute方法中调用ActionInvocation的invocke方法，
	 * 在这个方法内部递归执行一组拦截器（完成部分功能），
	 * 如果没有下一个拦截器，就会执行目标Action，根据Action的返回的结果进行页面跳转。
	 */
	//拦截方法
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截器111");
		//判断session中是否有登录的店员信息
		Admin admin =(Admin) ServletActionContext.getRequest().getSession().getAttribute("adminlogin");
		Clerk clerk=(Clerk) ServletActionContext.getRequest().getSession().getAttribute("clerklogin");
		if(admin==null) {
			System.out.println("拦截器222");
			//存错误信息，页面跳转到指定页面
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("您暂时没有权限访问！");
			return "privilege";
		}else {
			//已经登录
			return invocation.invoke();
		}
		
	}

}
