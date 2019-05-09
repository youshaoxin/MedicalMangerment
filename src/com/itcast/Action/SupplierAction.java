package com.itcast.Action;

import com.itcast.service.ApplierService;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierAction extends ActionSupport {
	
	
	private ApplierService applierService;
	
	/**
	 * 注入services
	 */
	public ApplierService getApplierService() {
		return applierService;
	}

	public void setApplierService(ApplierService applierService) {
		this.applierService = applierService;
	}
	
	
	
	
	
	
	
}
