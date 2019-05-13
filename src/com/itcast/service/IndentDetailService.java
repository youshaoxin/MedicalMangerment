package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.IndentDetailDao;
import com.itcast.entity.IndentDetail;

//事务的注解记得一定不要忘了加！
@Transactional
public class IndentDetailService {

	private IndentDetailDao indentDetailDao;

	

	public void setIndentDetailDao(IndentDetailDao indentDetailDao) {
		this.indentDetailDao = indentDetailDao;
	}



	//生成订单详情
	public void addIndentDetail(IndentDetail indentDetail) {
		indentDetailDao.addIndentDetail(indentDetail);
	}



	//查看订单详情
	public List<IndentDetail> findByIndentId(String indentid) {
		
		return indentDetailDao.findByIndentId(indentid);
	}
	
	
}
