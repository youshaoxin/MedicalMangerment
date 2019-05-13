package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.ShopDao;
import com.itcast.entity.Good;

public class ShopDaoImpl implements ShopDao{

	//在Dao中注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
			
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public Good finById(Integer gid) {
		
		return hibernateTemplate.get(Good.class, gid);
	}

	

	
}
