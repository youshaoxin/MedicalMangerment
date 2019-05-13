package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.TypeDao;
import com.itcast.entity.Type;

//事务的注解记得一定不要忘了加！
@Transactional
public class TypeService {
	
	private TypeDao typeDao;
	
	
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	/**
	 * 查找所有类别
	 * @return
	 */
	public List<Type> findAllType() {
		List<Type> findAllType = typeDao.findAllType();
		return findAllType;
	}
	
	/**
	 * 删除类别
	 */
	public void delete(Integer id) {
		typeDao.delete(id);
	}
	
	/**
	 * 根据id查找某个类别
	 * @return
	 */
	public Type TypeAboutId(Integer id) {
		Type typeAboutId = typeDao.TypeAboutId(id);
		System.out.println("类别名："+typeAboutId.getTname());

		return typeAboutId;
	}
	
	/**
	 * 类别保存
	 * @return
	 */
	public void saveType(Type type) {
		
		typeDao.saveType(type);
	}
	
	
	
	
	
	}
