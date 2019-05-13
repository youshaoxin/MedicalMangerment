package com.itcast.DaoImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.IndentDao;
import com.itcast.entity.Indent;
import com.itcast.entity.User;

public class IndentDaoImpl implements IndentDao {

	//在Dao中注入hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

		//生成订单
		@Override
		public void addIndent(Indent indent) {
			hibernateTemplate.save(indent);
		}

		//查询所有订单
		@Override
		public List<Indent> findList() {
			List<Indent> indentList = (List<Indent>) hibernateTemplate.find("from Indent i inner join fetch i.user");
			System.out.println(indentList);
			return indentList;
		}

		//通过手机号码查询其所有的订单
		@Override
		public List<Indent> SearchIndent(Integer uid) {
			System.out.println("进来了吗？SearchIndent");
			List<Indent> IndentList = (List<Indent>) hibernateTemplate.find("from Indent where uid=?",uid );
			
			System.out.println(IndentList);
			return IndentList;
		}

		
}
