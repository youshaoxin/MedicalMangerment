package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.Supplier;


public interface SupplierDao {

	
	/**
	 * 查询所有供应商的方法
	 */
	//public String findAll
	
	public List<Supplier> allSuppliers();
	
	/**
	 * 根据sid查询某个供应商
	 */
	public Supplier findSupplierOfId(Integer id);
	
	
	
	public void saveSuppliers(Supplier supplier);
	
}
