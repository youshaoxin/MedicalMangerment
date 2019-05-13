package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.RepertoryDao;
import com.itcast.entity.Good;
import com.itcast.entity.OrderDetial;
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

//  查询 仓库所有信息      和Repertory连接
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

	@Override
	public void increasedate2(Repertory repertory) {
		// TODO Auto-generated method stub
		System.out.println("添加入商品impl 进入");
		hibernateTemplate.save(repertory);
		System.out.println("添加入商品impl......");
		
	}

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

	@Override
	public List<Repertory> mohuselectDao(String begintime, String endtime) {
		// TODO Auto-generated method stub
		
		//List<Repertory> mohuselect=hibernateTemplate.find("from Repertory where rdate between '"+?+"' and '"+?+"'",begintime,endtime);
		
		
		
		return null;
	}



}
