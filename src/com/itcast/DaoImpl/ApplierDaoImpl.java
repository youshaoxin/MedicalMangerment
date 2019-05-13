package com.itcast.DaoImpl;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.ApplierDao;

public class ApplierDaoImpl implements ApplierDao{

	//在Dao中注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
			
			
}
