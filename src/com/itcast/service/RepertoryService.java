package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.RepertoryDao;
import com.itcast.entity.Good;
import com.itcast.entity.OrderDetial;
import com.itcast.entity.OutRepertory;
import com.itcast.entity.Repertory;

//事务的注解记得一定不要忘了加！
@Transactional
public class RepertoryService {
//在service 注入 RepertoryDao
	private RepertoryDao repertoryDao;

	public RepertoryDao getRepertoryDao() {
		return repertoryDao;
	}

	public void setRepertoryDao(RepertoryDao repertoryDao) {
		this.repertoryDao = repertoryDao;
	}
	
	
	
	//查询仓库信息  和good  一对多级联查询   暂时不用
	public List<Good> findrepertoryall(){
		
		System.out.println("Servoice ......");
		List<Good> findrepertoryall = repertoryDao.findrepertoryall();
		System.out.println("Servers.....");
		return findrepertoryall;
	}
	//查询是否存在 订单编号
	public List<OrderDetial> selectorder2(String ordernumberr) {
		// TODO Auto-generated method stub
		return (List<OrderDetial>) repertoryDao.selectorder2(ordernumberr);
		
	}
//往仓库中加入 商品 入库
	public void increasedate2(Repertory repertory) {
		// TODO Auto-generated method stub
		System.out.println("service.....");
		repertoryDao.increasedate2(repertory);
	}

	
	//查询仓库所有信息
	public List<Repertory> repertoryall2() {
		// TODO Auto-generated method stub
		
		
		return repertoryDao.repertoryall2();
	}
	
	
	
	
//
	public List<Repertory> mohuselectService(String begintime, String endtime) {
		// TODO Auto-generated method stub
		System.out.println("进去mohuservice");
		 List<Repertory>  mohuselect=repertoryDao.mohuselectDao(begintime,endtime);
		 System.out.println("出去mohuservice");
		return mohuselect;
	}
// 根据id 来查询
	public List<Repertory> outrepertory(String rnumbe) {
		// TODO Auto-generated method stub
		return repertoryDao.outrepertory(rnumbe);
	}
	//出库插入 数据 
	public void insertoutrepertory(OutRepertory outRepertory) {
		// TODO Auto-generated method stub
		repertoryDao.insertoutrepertory( outRepertory);
	}
	////出库， 入库数量的减少 
	public void updatetotal(Repertory person) {
		// TODO Auto-generated method stub
		repertoryDao.updatetotal(person);
		
	}
	//出库列表查询  所有出库商品
	public List<OutRepertory> outRepertoryquery() {
		// TODO Auto-generated method stub
		
		
		return repertoryDao.outRepertoryquery();
	}

	

	
	
	
	
}
