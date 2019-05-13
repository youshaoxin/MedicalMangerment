package com.itcast.Action;

import java.util.List;

import com.itcast.entity.Supplier;
import com.itcast.service.SupplierService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierAction extends ActionSupport {
	
	
	private SupplierService applierService;
	
	/**
	 * 注入services
	 */
	public SupplierService getApplierService() {
		return applierService;
	}

	public void setApplierService(SupplierService applierService) {
		this.applierService = applierService;
	}
	
	/**
	 * 查找所有供应商
	 * @return
	 */
	
	public String allSuppliers(){
		
		System.out.println("查找所有供应商Action......");
		List<Supplier> allSuppliers = applierService.allSuppliers();
		
		ActionContext.getContext().getValueStack().set("allSuppliers", allSuppliers);
		
		return "allSuppliers";
	}
	
	
	/**
	 * 根据sid查询某个供应商
	 */
	public String findSupplierOfId(){
		
		return null;
	}
	
	
	
}
