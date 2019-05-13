package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.GoodDao;
import com.itcast.entity.Good;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;

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
	public void goodsAdd(Good good,Type type,Supplier supplier) {
		// TODO Auto-generated method stub
		goodDao.goodsAdd(good,type,supplier);
	}
	
	
	/**
	 * 修改商品信息
	 * @param good
	 */
	public void updateGoods(Integer id,Integer tid,Integer sid) {
		// TODO Auto-generated method stub
		goodDao.updateGoods(id,tid,sid);
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
	/**
	 * 根据id查询商品（ypf+）
	 * @param gid
	 * @return 
	 */
	public Good findById(Integer gid) {
		return goodDao.findById(gid);
		
	}
	
	
	
	
}
