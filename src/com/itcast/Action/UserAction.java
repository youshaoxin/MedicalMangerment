package com.itcast.Action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.User;
import com.itcast.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ypf
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//注入userService
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	//模型驱动需要使用的对象
	private User user =new User();
	//设置模型驱动
	@Override
	public User getModel() {
		return user;
	}
	
	/**
	 *
	 * 	会员列表-查询所有会员
	 * @return
	 */
	public String findAllUserList() {
		
		List<User> userlist= userService.findAllUserList();
		//将查询到的findAllUserList存入到值栈
		ActionContext.getContext().getValueStack().set("userlist", userlist);
		return "success";
	}
	
	/**
	 * 添加会员
	 * @return
	 */
	public String addUser() {
		userService.addUser(user);
		return "addSuccess";
	}
	
	
	/**
	 * 删除会员
	 * @return
	 */
	public String deleteUser() {
		//先查询在删除，这样可以级联删除
		//先根据id查询到user
		user = userService.finById(user.getUid());
		//把查询到的user传进方法中删除
		userService.deleteUser(user);
		return "deleteSuccess";
	}


	/**
	 * 编辑会员信息
	 * @return
	 */
	public String editUser() {
		//跳转页面，回显
		user = userService.finById(user.getUid());
		/**
		 * 将user传递到页面：两种方式：一种，手动压栈。二种：因为模型驱动的对象，默认在栈顶
		 * 如果使用第一种方式：回显数据：<s:propety value="username"/> <s:name="username" value="">
		 * 如果使用第二种方式：回线数据：<s:propety value="model.username"/>
		 */
		ActionContext.getContext().getValueStack().push(user);
		return "editSuccess";
	}

	/**
	 * 修改会员信息
	 * @return
	 */
	public String updateUser() {
		userService.updateUser(user);
		return "updateSuccess";
	}
	
	
	/**
	 *查询会员信息
	 * @return
	 */
	public String searchUser() {
		//根据手机号码查询
		List<User> userlist = userService.searchUser(user.getPhone());
		ActionContext.getContext().getValueStack().set("userlist", userlist);;
		return "searchSuccess";
		
	}
	/**
	 *会员登录
	 * @return
	 */
	public String login() {
		User userlogin=userService.login(user);
		if(userlogin==null) {
			
		}else {
			ServletActionContext.getRequest().getSession().setAttribute("userlogin", userlogin);
			System.out.println(userlogin);}
		
		return "loginSuccess";
	}
}
