package com.itcast.Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.Type;
import com.itcast.service.TypeService;
import com.opensymphony.xwork2.ActionSupport;

public class TypeAction extends ActionSupport {
	private TypeService typeService ;
	
	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	private List<Type> typeList = new ArrayList<Type>();
	
	public List<Type> getTypeList() {
		return typeList;
	}
	
	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}

	public String findAllType() {
		
		List<Type> findAllType = typeService.findAllType();
		System.out.println("查找所有类别方法。。。。。");
		for (Type type : findAllType) {
			System.out.println(type.getTid()+":"+type.getTname());
		}
		
		for (Type type : findAllType) {
			typeList.add(type);
		}
		
		return "findAllType";
	}
	
	
	
	
	private String one;

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}
	
	

	
	/**
	 * 级联删除
	 * @return
	 */
	public String delete() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try {
			//解决jsp页面传过来的字符串中文乱码的问题
			String uid = new String(request.getParameter("uid").getBytes("iso-8859-1"), "utf-8");
			String uname = new String(request.getParameter("uname").getBytes("iso-8859-1"), "utf-8");
			System.out.println(uid+"***********");
			System.out.println(uname+"***********");
			Integer id=Integer.parseInt(uid);
			
			typeService.delete(id);
			
			System.out.println("级联删除avtion结束。。。。。");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "delete";
	}
	
	
	/**
	 * 
	 */
	
	
	
	
	
	
}
