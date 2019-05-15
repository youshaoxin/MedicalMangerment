package com.itcast.Dao;

import java.util.List;

import org.hibernate.jpa.criteria.OrderImpl;

import com.itcast.entity.Good;
import com.itcast.entity.OrderDetial;
import com.itcast.entity.OutRepertory;
import com.itcast.entity.Repertory;




public interface RepertoryDao {
//  查询 仓库所有信息  暂时不用
	public List<Good> findrepertoryall();
	//查询是否存在 订单编号
	public List<OrderDetial> selectorder2(String ordernumberr);
	//往仓库中加入数据
	public void increasedate2(Repertory repertory);
	//查询仓库所有信息
	public List<Repertory> repertoryall2();
	
	//模糊查询
	public List<Repertory>  mohuselectDao(String begintime, String endtime);
	
	
	//出去先做 入库 订单号查询
	public List<Repertory> outrepertory(String rnumbe);
	//出库插入 数据 
	public void insertoutrepertory(OutRepertory outRepertory);
	//出库， 入库数量的减少 
	public void updatetotal(Repertory person);
	
	//出库列表查询  所有出库商品
	public List<OutRepertory> outRepertoryquery();
	
}
