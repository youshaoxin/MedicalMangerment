package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.Type;

public interface TypeDao {
	/**
	 * 查找所有类别
	 * @return
	 */
	public List<Type> findAllType();
	/**
	 * 删除类别
	 * @param id
	 */	
	public void delete(Integer id);
	
	
}
