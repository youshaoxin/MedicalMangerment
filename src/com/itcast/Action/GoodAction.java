package com.itcast.Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;


import com.itcast.entity.Good;
import com.itcast.entity.Type;
import com.itcast.service.GoodService;
import com.itcast.service.TypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class GoodAction extends ActionSupport implements ModelDriven<Good>{
	
	/**
	 * 注入goodservices
	 */
	private GoodService goodService;

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public GoodService getGoodService() {
		return goodService;
	}
	
	/**
	 * 注入type services
	 */
	private TypeService typeService;
	
	
	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	
	
	
	

	/**
	 *  商品的集合
	 */
	private List<Good> goodList = new ArrayList<Good>();

	public List<Good> getGoodList() {
		return goodList;
	}
	public void setGoodList(List<Good> goodList) {
		this.goodList = goodList;
	}
	

	
	
	/**
	 * 模型驱动封装，封装商品jsp页面提交的表单信息
	 */
	private Good goods =new Good();

	
	public Good getGoods() {
		return goods;
	}

	public void setGoods(Good goods) {
		this.goods = goods;
	}
	
	
	/**
	 * 查找所有商品列表
	 * 
	 * @author
	 * @return
	 */
	public String findAllGoods() {
		System.out.println("查找所有商品列表action.....");
		
		List<Good> GoodList = goodService.findAllGoods();
		List<Type> findAllType = typeService.findAllType();
		
		ActionContext.getContext().getValueStack().set("GoodList", GoodList);
		ActionContext.getContext().getValueStack().set("findAllType", findAllType);
		
		System.out.println("查找所有类别。。。。。");
		for (Type type : findAllType) {
			System.out.println(type.getTname());
		}
		System.out.println("查找所有药品。。。。。");
		for (Good good : GoodList) {
			System.out.println(good.getGname());
		}

		
		System.out.println("findAllGoodList............");
		
		return "findAllGoods";
	}

	/**
	 * 增加商品
	 * 
	 * @return
	 */
	public String goodsAdd() {
		System.out.println("增加商品Action...");
		
		goodService.goodsAdd(goods);

		return "goodsAdd";
	}


	/**
	 * 显示修改页面商品信息
	 */
	public String updateShowGoods() {


		System.out.println(
				"显示修改页面商品信息" + goods.getGid() + ":" + goods.getGname() + ":" + goods.getPrice());

		return "updateShowGoods";

	}

	/**
	 * 修改药品信息
	 */
	public String updateGoods() {
		System.out.println("修改信息方法。。。。");

		
		
		System.out.println("修改测试："+goods.getGname()+":"+goods.getPrice
		()+":id:"+goods.getGid());
		 
		 
		goodService.updateGoods(goods);

		

		return "updateGoods";
	}

	/**
	 * 删除药品
	 */

	public String deleteGoods() {
		System.out.println("删除药品方法测试。。。。。");
	
		HttpServletRequest request = ServletActionContext.getRequest();
		String gid;
		try {
			gid = new String(request.getParameter("goodid").getBytes("iso-8859-1"), "utf-8");
			Integer id = Integer.parseInt(gid);
			goodService.deleteGoods(id);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "deleteGoods";
	}

	/**
	 * 模糊查找商品
	 * 
	 * @return
	 */
	public String findSomeGood() {
		System.out.println(" 模糊查找商品测试。。。。。");
		List<Good> findSomeGood = goodService.findSomeGood(goods.getGname());
		//向值栈放对象
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		valueStack.set("findSomeGood", findSomeGood);
		
		System.out.println("findSomeGood.....");

		return "findSomeGood";
	}
	
	/**
	 * 根据类别查找商品
	 */
	public String findTypeGoods() {
		
		System.out.println("根据类别查找商品Action方法");
		return "findTypeGoods";
	}
	
	
	
	
	
	
	
	

	@Override
	public Good getModel() {
		// TODO Auto-generated method stub
		return goods;
	}

}
