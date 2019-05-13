package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.RepertoryDao;
import com.itcast.entity.Good;
import com.itcast.entity.OrderDetial;
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
	
	
	
	//查询仓库信息
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

	
	
	public List<Repertory> repertoryall2() {
		// TODO Auto-generated method stub
		
		
		return repertoryDao.repertoryall2();
	}
	
	
	
	
//
	public List<Repertory> mohuselectService(String begintime, String endtime) {
		// TODO Auto-generated method stub
		
		 List<Repertory>  mohuselect=repertoryDao.mohuselectDao(begintime,endtime);
		
		return mohuselect;
	}

	

	
	
	
	
}
