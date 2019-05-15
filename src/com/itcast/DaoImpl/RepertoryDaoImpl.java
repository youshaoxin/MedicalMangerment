package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.RepertoryDao;
import com.itcast.entity.Good;
import com.itcast.entity.OrderDetial;
import com.itcast.entity.OutRepertory;
import com.itcast.entity.Repertory;

public class RepertoryDaoImpl implements RepertoryDao {

	// 在RepertoryDaoImpl注入 hibernate 并创建set
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

//  查询 仓库所有信息      和Repertory连接  暂时不用
	@Override
	public List<Good> findrepertoryall() {
		// TODO Auto-generated method stub
		System.out.println("repertorImpl--------");
//c inner join fetch c.good  c inner join fetch c.repertory      from Good  不能内连接不行
		List<Good> findGood = (List<Good>) hibernateTemplate.find("from Good c inner join fetch c.repertory ");

		System.out.println("能到吗。。。");
//		for (Good repertory : findGood) {
//			System.out.println("商品名"+repertory.getGname());
//		}

		return findGood;
	}

////查询是否存在 订单编号
	@Override
	public List<OrderDetial> selectorder2(String ordernumberr) {
		// TODO Auto-generated method stub

		System.out.println("repertorImpl 查询--------");
		//
		List<OrderDetial> findorder =  (List<OrderDetial>) hibernateTemplate.find("from OrderDetial where ordernumber=?",ordernumberr);
       for (OrderDetial orderetial : findorder) {
		     System.out.println("实现成打印"+orderetial.toString());
	}
		System.out.println("能到吗。。。实现出");
		return findorder;

	}
	//往仓库中加入数据
	@Override
	public void increasedate2(Repertory repertory) {
		// TODO Auto-generated method stub
		System.out.println("添加入商品impl 进入");
		hibernateTemplate.save(repertory);
		System.out.println("添加入商品impl......");
		
	}
	//查询仓库所有信息
	@Override
	public List<Repertory> repertoryall2() {
		// TODO Auto-generated method stub
		System.out.println("repertorImpl--------");
		//c inner join fetch c.good  c inner join fetch c.repertory      from Good  不能内连接不行
				List<Repertory> findRepertory = (List<Repertory>) hibernateTemplate.find("from Repertory");

				System.out.println("能到吗。。。");
//				for (Good repertory : findGood) {
//					System.out.println("商品名"+repertory.getGname());
//				}

				return findRepertory;
	}
//根据时间 做模糊查询
	@Override
	public List<Repertory> mohuselectDao(String begintime, String endtime) {
		// TODO Auto-generated method stub
		//from Repertory where date between '"+beginDate+"' and '"+endDate+"'
		//"from Repertory info where info.rdate <? and info.dataTime >=?"
		System.out.println("进入mohu实现层");
		//List<Repertory> mohuselect=(List<Repertory>) hibernateTemplate.find("from Repertory info where info.rdate <? and info.rdate >=?",endtime,begintime);
		List<Repertory> mohuselect2=(List<Repertory>) hibernateTemplate.find("from Repertory where rdate between ? and ?",begintime,endtime);
		
		/*
		 * for (Repertory tory : mohuselect) { System.out.println(tory.getRdate()); }
		 */
		 for (Repertory reper : mohuselect2) {
			System.out.println(reper);
		}
		 
		 System.out.println("出mohu实现层");
		
		return mohuselect2;
	}
	//====================================以下是出库================================================
// 根据出库id先查询 出list 在返回页面     Repertory 查询Repertory 单个数据
	@Override
	public List<Repertory> outrepertory(String rnumbe) {
		// TODO Auto-generated method stub
		//实现层 进入
		List<Repertory>  repertory = (List<Repertory>) hibernateTemplate.find("from Repertory");
		 
		 //实现层出
		
		return repertory;
	}

	//出库插入 数据 
	
	@Override
	public void insertoutrepertory(OutRepertory outRepertory) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(outRepertory);
	}
	
	
	//出库， 入库数量的减少 
	@Override
	public void updatetotal(Repertory person) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(person);
		
	}
	
	
	//出库列表查询  所有出库商品
	@Override
	public List<OutRepertory> outRepertoryquery() {
		// TODO Auto-generated method stub
		System.out.println("出库 列表 impl进");
		List<OutRepertory> outRepertory=(List<OutRepertory>) hibernateTemplate.find("from OutRepertory");
		 for (OutRepertory outRepertory2 : outRepertory) {
			System.out.println(outRepertory2);
		}
		System.out.println("出库 列表 impl出");
		return outRepertory;
	}



}
