package com.itcast.Action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.ServletActionContext;


import com.itcast.entity.Good;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;
import com.itcast.service.GoodService;
import com.itcast.service.SupplierService;
import com.itcast.service.TypeService;
import com.itcast.utils.Utils;
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
	 * 注入 supplierService
	 */
	private SupplierService supplierService;
	

	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
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
	 * 查找所有商品列表页面
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
		
		String today = Utils.getToday();
		
		for (Good good : GoodList) {
			System.out.println("商品名："+good.getGname());
			System.out.println("生产日期"+good.getDate());
			System.out.println("保质期"+good.getQualitaDate());
			Date d1 = null;
	        Date d2 = null;
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        
			try {
				d1 = format.parse(today);
	            d2 = format.parse(good.getDate());
	            
				//获取现在的时间距离生产日期的天数
	            long day =(d1.getTime()-d2.getTime())/(24*60*60*1000);
	            //保质期 - 相差的日期天数 = 距离过期的天数 
	            long overDate = (long)good.getQualitaDate() - day;
	             
	            //两个日期之间相差的天数，转为字符串
	            String daynum = String.valueOf(overDate);
	            
				System.out.println("相差的天数："+ daynum);
				if(daynum != null) {
					if(overDate>0 && overDate<=30) {
						good.setOverTime("只剩："+daynum+"天！");
					}else if(overDate>30){
						good.setOverTime("距离过期："+daynum+"天");
					}else{
						good.setOverTime("已过期！");
					}
				}				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
					
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
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取前台表单选择的类别id
		String tid = request.getParameter("one");
		//获取前台供应商的id值
		String sid = request.getParameter("two");
				
		System.out.println("类型id："+tid);
		System.out.println("供应商id："+sid);
		//将String转为int
		int ttid = Integer.parseInt(tid);
		int ssid = Integer.parseInt(sid);
		
		if(ttid!=-1 && ssid!=-1) {
			//查询对应的类别
			Type typeAboutId = typeService.TypeAboutId(ttid);
			//级联保存
			typeAboutId.getSetgoods().add(goods);
			
			//查询对应的供应商
			Supplier findSupplierOfId = supplierService.findSupplierOfId(ssid);
			//级联保存
			findSupplierOfId.getSuppliergoods().add(goods);
		
			//增加商品
			goodService.goodsAdd(goods,typeAboutId,findSupplierOfId);
			
		}else {
			System.out.println("类别或者供应商没有选择！");
		}
		
		
		

		return "goodsAdd";
	}


	/**
	 * 显示修改页面商品信息
	 */
	public String updateShowGoods() {


		System.out.println(
				"显示修改页面商品信息" + goods.getGid() + ":" + goods.getGname() + ":" + goods.getPrice());
		
		List<Type> findAllType = typeService.findAllType();
		List<Supplier> allSuppliers = supplierService.allSuppliers();

		ActionContext.getContext().getValueStack().set("allSuppliers", allSuppliers);
		ActionContext.getContext().getValueStack().set("findAllType", findAllType);
		

		return "updateShowGoods";

	}

	/**
	 * 修改药品信息
	 */
	public String updateGoods() {
		
		System.out.println("修改商品Action...");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取前台表单选择的类别id
		String tid = request.getParameter("one");
		//获取前台供应商的id值
		String two = request.getParameter("two");
				
		System.out.println("类型id："+tid);
		System.out.println("供应商id："+two);
		//将String转为int
		int ttid = Integer.parseInt(tid);
		int ssid = Integer.parseInt(two);
		//得到需要修改的商品id
		int goodsid = goods.getGid();
		
		if(ttid!=-1 && ssid!=-1) {
			//修改商品
			goodService.updateGoods(goodsid,ttid,ssid);
			
		}else {
			System.out.println("类别或者供应商没有选择！");
		}
		 
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
	
	
	
	/**
	 * 主页跳转到添加药品页面
	 */
	public String addGoodsPage() {
		
		System.out.println("主页跳转到添加药品页面......");
		List<Type> findAllType = typeService.findAllType();
		List<Supplier> allSuppliers = supplierService.allSuppliers();
		
		ActionContext.getContext().getValueStack().set("allSuppliers", allSuppliers);
		ActionContext.getContext().getValueStack().set("findAllType", findAllType);
		return "addGoodsPage";
		
	}
	
	

	@Override
	public Good getModel() {
		// TODO Auto-generated method stub
		return goods;
	}

	
	/**
	 * 前台查找商品（ypf+）
	 * @return
	 */
	public String shopSearchGood() {	
		List<Good> GoodList = goodService.findSomeGood(goods.getGname());
		ActionContext.getContext().getValueStack().set("GoodList", GoodList);
		return "shopSearchGood";
	}
	
	
	
	
	/**
	 * 前台遍历所有商品(ypf+)
	 * @return
	 */
	public String findAllShopGoods() {
		
		List<Good> GoodList = goodService.findAllGoods();
		List<Type> findAllType = typeService.findAllType();
		
		ActionContext.getContext().getValueStack().set("GoodList", GoodList);
		ActionContext.getContext().getValueStack().set("findAllType", findAllType);
			
		return "findAllShopGoods";
	}

}
