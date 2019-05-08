package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.GoodDao;
import com.itcast.entity.Good;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Woodstox;
import com.sun.xml.internal.ws.assembler.MetroConfigNameImpl;

//事务的注解记得一定不要忘了加！
@Transactional
public class GoodService {
	private GoodDao goodDao;

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}
	
	/**
	 * 查询显示所有商品
	 */
	public List<Good> findAllGoods() {
		System.out.println("GoodService....");
		return goodDao.findAllGoods();
	}
	
	/**
	 * 增加商品
	 */
	public void goodsAdd(Good good) {
		// TODO Auto-generated method stub
		goodDao.goodsAdd(good);
	}
	
	
	/**
	 * 修改商品信息
	 * @param good
	 */
	public void updateGoods(Good good) {
		// TODO Auto-generated method stub
		goodDao.updateGoods(good);
	}
	
	/**
	 * 删除商品信息
	 * @param good
	 */
	
	public void deleteGoods(Integer id) {
		goodDao.deleteGoods(id);
	}
	
	
	/**
	 * 模糊查找商品
	 * @return
	 */
	public List<Good> findSomeGood(String goodsname) {
		List<Good> SomeGoodlist = goodDao.findSomeGood(goodsname);
		
		return SomeGoodlist;
	}
	
	
}
