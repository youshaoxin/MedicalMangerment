package com.itcast.Dao;

import java.util.List;

import org.hibernate.jpa.criteria.OrderImpl;

import com.itcast.entity.Good;
import com.itcast.entity.OrderDetial;
import com.itcast.entity.Repertory;




public interface RepertoryDao {
//  查询 仓库所有信息
	public List<Good> findrepertoryall();
	//查询是否存在 订单编号
	public List<OrderDetial> selectorder2(String ordernumberr);
	//往仓库中加入数据
	public void increasedate2(Repertory repertory);
	public List<Repertory> repertoryall2();
	
	
	public List<Repertory>  mohuselectDao(String begintime, String endtime);
	
}
