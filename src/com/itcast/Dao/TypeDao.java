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
	/**
	 * 根据id查找某个类别
	 * @return
	 */
	public Type TypeAboutId(Integer id);
	/**
	 * 类别保存
	 * @return
	 */
	public void saveType(Type type);
	
	
	
	
	
}
