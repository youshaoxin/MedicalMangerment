package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.SupplierDao;
import com.itcast.entity.Supplier;




public class SupplierDaoImpl implements SupplierDao{

	//在Dao中注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/**
	 * 查询所有供应商的方法
	 */
	@Override
	public List<Supplier> allSuppliers() {
		System.out.println("查询所有供应商的方法......");
		List<Supplier> allSupplier = (List<Supplier>) hibernateTemplate.find("from Supplier");
		for (Supplier supplier : allSupplier) {
			System.out.println(supplier.getSname());
		}
		
		
		return allSupplier;
	}
	
	
	
	/**
	 * 根据sid查询某个供应商
	 */
	@Override
	public Supplier findSupplierOfId(Integer id) {
		System.out.println("根据sid查询某个供应商Impl......");
		//List<Supplier> oneSupplier = (List<Supplier>) hibernateTemplate.find("from Supplier where sid = ?",id);
		
		Supplier supplier = hibernateTemplate.get(Supplier.class, id);
		
//		for (Supplier supplier : oneSupplier) {
//			System.out.println(supplier.getSname());
//		}
		return supplier;
	}

	
	/**
	 * 供应商保存
	 */
	
	@Override
	public void saveSuppliers(Supplier supplier) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(supplier);
	}
	

	
	
			
			
}
