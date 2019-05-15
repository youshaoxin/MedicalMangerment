package com.itcast.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.Good;
import com.itcast.entity.OrderDetial;
import com.itcast.entity.Repertory;
import com.itcast.service.RepertoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RepertoryAction extends ActionSupport implements ModelDriven<Repertory> {

	// 创建模型封装的对象
	private Repertory repertory = new Repertory();

	@Override
	public Repertory getModel() {
		// TODO Auto-generated method stub
		return repertory;
	}

	public Repertory getRepertory() {
		return repertory;
	}

	public void setRepertory(Repertory repertory) {
		this.repertory = repertory;
	}

	/*
	 * public static String getOrderdetial() { return OrderDetial; }
	 */

	
	// 这里在action注入 service
	private RepertoryService repertoryService;

	public RepertoryService getRepertoryService() {
		return repertoryService;
	}

	public void setRepertoryService(RepertoryService repertoryService) {
		this.repertoryService = repertoryService;
	}

	// 查询仓库的所有
	public String repertoryall2() {

		System.out.println("findrepertoryall_Action进....");

		List<Repertory> repertoryall = repertoryService.repertoryall2();

		System.out.println("findrepertoryall_Action出....");

		ActionContext.getContext().getValueStack().set("repertoryall", repertoryall);

		for (Repertory repertoryallfind : repertoryall) {
			System.out.println("shang");
			// System.out.println("库存名：" + repertoryallfind.getGname() +
			// repertoryallfind.getRepertory().getRname());
			System.out.println("查询仓库Action出");
		}

		return "repertoryall2";
	}

//  查询 入库所有信息   和good 的级联         暂时没用        
	/*
	 * public String findrepertoryall() {
	 * System.out.println("findrepertoryall_Action进...."); List<Good>
	 * findrepertoryall = repertoryService.findrepertoryall();
	 * System.out.println("findrepertoryall_Action出....");
	 * 
	 * ActionContext.getContext().getValueStack().set("findrepertoryall",
	 * findrepertoryall);
	 * 
	 * for (Good good : findrepertoryall) { System.out.println("shang");
	 * System.out.println("库存名：" + good.getGname() +
	 * good.getRepertory().getRname());
	 * 
	 * }
	 * 
	 * return "repertoryall";
	 * 
	 * }
	 */

	// 查询是否存在 订单编号
	public String selectorder() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		// PrintWriter out= response.getWriter();
		/*
		 * response.encodeRedirectURL("utf-8"); request.setCharacterEncoding("utf-8");
		 */
		// String ordernumber = request.getParameter("ordernumber");
		String ordernumberr = request.getParameter("ordernumber") == null ? "" : request.getParameter("ordernumber");
		System.out.println("前台传过来的值" + ordernumberr);
//OrderDetial 需要返回list 因为  你里面 主键 不是订单标号不能判断唯一

		if (!ordernumberr.equals("")) {
			System.out.println("进入循环");

			List<OrderDetial> Orderdetial = (List<OrderDetial>) repertoryService.selectorder2(ordernumberr);
			ActionContext.getContext().getValueStack().set("Orderdetial", Orderdetial);
			System.out.println("值栈出......");

			for (OrderDetial orderDetial2 : Orderdetial) {
				if (orderDetial2.getOrdernumber().equals(ordernumberr)) {

					return "selectorder";
				}
			}

			return "selectorderfase";
		} else {
			return "selectorderfase";
		}

	}

	// 商品信息入库//往仓库中加入数据
	public String increasedate() {

		System.out.println("进action.............");
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 多态
		// 2017-04-19 星期三 下午 20:17:38

		String format = bf.format(date);// 格式化 bf.format(date);
		System.out.println(format);
		// 往repertory添加时间
		repertory.setRdate(format);
		System.out.println(repertory);
		
		repertoryService.increasedate2(repertory);
		
		System.out.println("出action.............");

		return "increasedate";
	}

	// 根据时间模糊查询
	public String mohuselect() {
		System.out.println("进入action");
		HttpServletRequest request = ServletActionContext.getRequest();
		String begintime = request.getParameter("begintime") == null ? "" : request.getParameter("begintime");
		String endtime = request.getParameter("endtime") == null ? "" : request.getParameter("endtime");

		String begintime2 = endtime.replaceAll("T"," ");//将时间 中产生的T给替换成 空格
		String endtime2 = endtime.replaceAll("T"," ");//将时间 中产生的T给替换成 空格
		
		System.out.println(begintime);
		System.out.println(endtime);

		List<Repertory> mohuselect = repertoryService.mohuselectService(begintime, endtime);

		ActionContext.getContext().getValueStack().set("mohuselect", mohuselect);
		ActionContext.getContext().getValueStack().set("begintime2", begintime2);
		ActionContext.getContext().getValueStack().set("endtime2", endtime2);

		System.out.println("Action出");

		return "mohuselect";
	}

	
	
	

}
