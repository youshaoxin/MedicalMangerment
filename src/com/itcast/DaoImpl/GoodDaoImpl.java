package com.itcast.DaoImpl;

import java.io.Serializable;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.itcast.Dao.GoodDao;
import com.itcast.entity.Good;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;
import com.itcast.service.GoodService;

public class GoodDaoImpl implements GoodDao {

	//在Dao中注入hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
	/**
	 * 查找所有药品列表
	 * @author 
	 * @return
	 */	
	@Override
	public List<Good> findAllGoods(){
		
		System.out.println("查找所有药品列表....");
		
		List<Good> goodlist = (List<Good>) hibernateTemplate.find("from Good c inner join fetch c.sid");
		
		for (Good good : goodlist) {
		
			System.out.println(good.toString());
			
		}
		
		
		return goodlist;
	}
	
	
	
	/**
	 * 增加药品
	 */
	@Override
	public void goodsAdd(Good good,Type type,Supplier supplier) {

		System.out.println("添加impl...");
		
		hibernateTemplate.saveOrUpdate(type);
		hibernateTemplate.saveOrUpdate(supplier);
		hibernateTemplate.saveOrUpdate(good);
		
		
	}
	/**
	 * 更新药品信息
	 */
	@Override
	public void updateGoods(Integer id,Integer tid,Integer sid) {
		//查询出要修改的药品
		Good good2 = hibernateTemplate.get(Good.class, id);
		Type goodstype = hibernateTemplate.get(Type.class, tid);
		Supplier goodssupplier = hibernateTemplate.get(Supplier.class, sid);
		
		goodstype.getSetgoods().add(good2);
		goodssupplier.getSuppliergoods().add(good2);
		
		
		System.out.println("更新药品信息impl。。。");

		
	}
	/**
	 * 删除商品方法
	 */
	@Override
	public void deleteGoods(Integer gid) {
		
		Good good = hibernateTemplate.get(Good.class, gid);
		hibernateTemplate.delete(good);
		System.out.println("删除成功！");
	}

	
	
	/**
	 * 模糊查找商品
	 * @return
	 */
	@Override
	public List<Good> findSomeGood(String gname) {
		System.out.println("模糊查找商品Impl....");
		System.out.println(gname);
		List<Good> findgoods = (List<Good>) hibernateTemplate.find("from Good g where g.gname like ?", "%"+gname+"%");
		for (Good good2 : findgoods) {
			System.out.println(good2.getGname());
			System.out.println("找到了");
		}
		
		return findgoods;
	}

	
	/**
	 * 根据id查询商品（ypf+）
	 */
	@Override
	public Good findById(Integer gid) {
		Good good=hibernateTemplate.get(Good.class, gid);
		return good;
	}

	
	
	
	
	
}
