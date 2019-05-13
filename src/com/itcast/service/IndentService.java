package com.itcast.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.IndentDao;
import com.itcast.entity.Indent;
import com.itcast.entity.User;

//事务的注解记得一定不要忘了加！
@Transactional
public class IndentService {

	private IndentDao indentDao;

	public void setIndentDao(IndentDao indentDao) {
		this.indentDao = indentDao;
	}


	//生成订单
	public void addIndent(Indent indent) {

		indentDao.addIndent(indent);
	}

	//查询所有的订单
	public List<Indent> findList() {
		return indentDao.findList();
	}

	//通过手机号码查询相对应的所有订单
	public List<Indent> SearchIndent(Integer uid) {
		return indentDao.SearchIndent(uid);
	}
	
}
