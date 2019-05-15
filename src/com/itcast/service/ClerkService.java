package com.itcast.service;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.ClerkDao;
import com.itcast.entity.Admin;
import com.itcast.entity.Clerk;

//事务的注解记得一定不要忘了加！
@Transactional
public class ClerkService {

	//注入Daoimpl
	private ClerkDao clerkDao;

	public void setClerkDao(ClerkDao clerkDao) {
		this.clerkDao = clerkDao;
	}



	//查询店员登录
	public Clerk findClerk(Clerk clerk) {
		return clerkDao.findClerk(clerk);
	}


	

}
