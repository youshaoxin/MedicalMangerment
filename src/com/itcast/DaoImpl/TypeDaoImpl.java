package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.itcast.Dao.TypeDao;
import com.itcast.entity.Type;


public class TypeDaoImpl implements TypeDao{
	//在Dao中注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/**
	 * 查找所有类别
	 */
	@Override
	public List<Type> findAllType() {
		List<Type> type = (List<Type>) hibernateTemplate.find("from Type");
		
		List<Object> type2 = (List<Object>) hibernateTemplate.find("from Type");
		
		System.out.println("...............");
		
		return type;
	}
	/**
	 * 删除类别
	 */
	@Override
	public void delete(Integer id) {
		List<Type> find = (List<Type>) hibernateTemplate.find("from Type where id = ?", id);
		for (Type type : find) {
			hibernateTemplate.delete(type);
			System.out.println("删除成功！");
		}
		
		
	}
	/**
	 * 根据id查找某个类别
	 * @return
	 */
	@Override
	public Type TypeAboutId(Integer id) {
		System.out.println("根据id查找某个类别impl....");
		Type type = hibernateTemplate.get(Type.class, id);

		return type;
	}

	/**
	 * 类别保存
	 * @return
	 */
	@Override
	public void saveType(Type type) {
		
		hibernateTemplate.update(type);
	}

}
