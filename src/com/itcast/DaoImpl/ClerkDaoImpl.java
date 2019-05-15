package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.ClerkDao;
import com.itcast.entity.Clerk;

public class ClerkDaoImpl implements ClerkDao {
	//在Dao中注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
			
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
	}
	
	
	//判断店员是否登录
	@Override
	public Clerk findClerk(Clerk clerk) {
		System.out.println(clerk.getCname()+"...!!"+clerk.getCpassword());
		List<Clerk> clerkList = (List<Clerk>) hibernateTemplate.find("from Clerk c where c.cname=? and cpassword=?", clerk.getCname(),clerk.getCpassword());
		System.out.println("测试测试");
		System.out.println(clerkList);
		if(clerkList.size()>0) {
			return clerkList.get(0);
		}
		return null;
	}
}
