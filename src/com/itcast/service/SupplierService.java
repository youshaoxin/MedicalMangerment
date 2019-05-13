package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.SupplierDao;
import com.itcast.entity.Supplier;


//事务的注解记得一定不要忘了加！
@Transactional
public class SupplierService {

	/**
	 * 注入Dao
	 */
	private SupplierDao supplierDao;

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	

	/**
	 * 查找所有供应商的方法
	 */
	public List<Supplier> allSuppliers(){
		
		return supplierDao.allSuppliers();
		
	}
	
	/**
	 * 根据sid查询某个供应商
	 */
	public Supplier findSupplierOfId(Integer id){
		
		Supplier findSupplierOfId = supplierDao.findSupplierOfId(id);
		
		return findSupplierOfId;
		
	}
	
	/**
	 * 保存供应商
	 */
	public void saveSuppliers(Supplier supplier) {
		
		supplierDao.saveSuppliers(supplier);
		
	}
}
