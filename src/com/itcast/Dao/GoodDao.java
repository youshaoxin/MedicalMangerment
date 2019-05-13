package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.Good;

public interface GoodDao {
	/**
	 * 查询显示所有商品
	 */
	public List<Good> findAllGoods();
	
	/**
	 * 增加药品
	 * @param good
	 */
	public void goodsAdd(Good good);
	
	/**
	 * 更新药品信息
	 * @param good
	 */
	public void updateGoods(Good good);
	
	/**
	 * 删除药品
	 */
	public void deleteGoods(Integer id);
	
	/**
	 * 模糊查找商品
	 * @return
	 */
	public List<Good> findSomeGood(String goodsname);

	public Good findById(Integer gid);
	
}
