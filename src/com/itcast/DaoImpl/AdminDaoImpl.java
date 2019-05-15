package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.AdminDao;
import com.itcast.entity.Admin;

public class AdminDaoImpl implements AdminDao {

	//在Dao中注入hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
				
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
				this.hibernateTemplate = hibernateTemplate;
		}

		@Override
		public Admin findAdmin(Admin admin) {
			List<Admin> adminList =(List<Admin>) hibernateTemplate.find("from Admin where name=? and password=?", admin.getName(),admin.getPassword());
			if(adminList.size()>0) {
				return adminList.get(0);
			}
			return null;
		}
}
