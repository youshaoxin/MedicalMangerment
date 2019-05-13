package com.itcast.Dao;

import java.text.SimpleDateFormat;
import java.util.List;

import com.itcast.entity.Indent;
import com.itcast.entity.User;

public interface IndentDao {

	//生成订单
	void addIndent(Indent indent);

	//查询所有的订单
	List<Indent> findList();

	//通过手机号码查询其所有的订单
	List<Indent> SearchIndent(Integer uid);

}
