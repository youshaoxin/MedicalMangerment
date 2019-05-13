package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.IndentDetailDao;
import com.itcast.entity.IndentDetail;

public class IndentDetailDaoImpl implements IndentDetailDao {

	//在Dao中注入hibernateTemplate对象
			private HibernateTemplate hibernateTemplate;
			
			public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
				this.hibernateTemplate = hibernateTemplate;
			}

			//生成点单详情
			@Override
			public void addIndentDetail(IndentDetail indentDetail) {

				hibernateTemplate.save(indentDetail);
				System.out.println(indentDetail);
			}

			//查看订单详情
			@Override
			public List<IndentDetail> findByIndentId(String indentid) {
				List<IndentDetail> IndentDetailList = (List<IndentDetail>) hibernateTemplate.find("from IndentDetail  where indentid=?", indentid);
				return IndentDetailList;
			}

	
}
