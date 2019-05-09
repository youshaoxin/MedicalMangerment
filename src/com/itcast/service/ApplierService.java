package com.itcast.service;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.ApplierDao;
//事务的注解记得一定不要忘了加！
@Transactional
public class ApplierService {

	/**
	 * 注入Dao
	 */
	private ApplierDao applierDao;

	public void setApplierDao(ApplierDao applierDao) {
		this.applierDao = applierDao;
	}

	
	
	
	
}
