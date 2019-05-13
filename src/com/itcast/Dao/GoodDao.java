package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.Good;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;

public interface GoodDao {
	/**
	 * 查询显示所有商品
	 */
	public List<Good> findAllGoods();
	
	/**
	 * 增加药品
	 * @param good
	 */
	public void goodsAdd(Good good,Type type,Supplier supplier);
	
	/**
	 * 更新药品信息
	 * @param good
	 */
	public void updateGoods(Integer id,Integer tid,Integer sid);
	
	/**
	 * 删除药品
	 */
	public void deleteGoods(Integer id);
	
	/**
	 * 模糊查找商品
	 * @return
	 */
	public List<Good> findSomeGood(String goodsname);
	/**
	 * 根据id查询商品
	 * @param gid
	 * @return
	 */
	public Good findById(Integer gid);
	

}
