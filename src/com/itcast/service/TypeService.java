package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.TypeDao;
import com.itcast.entity.Type;
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
	
	
	
}
