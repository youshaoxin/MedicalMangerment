package com.itcast.DaoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.UserDao;
import com.itcast.entity.User;
/**
 * ypf
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao{

	/**
	 * 得到HibernateTemplate对象
	 */
	
	//在Dao中注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

	/**
	 * 查询所有会员数
	 */
	@Override
	public List<User> findAllUserList() {
		List<User> userlist = (List<User>) hibernateTemplate.find("from User");
		return userlist;
	}


	/**
	 * 添加会员
	 */
	@Override
	public void addUser(User user) {
		hibernateTemplate.save(user);
	}


	/**
	 * 根据id去查询会员的方法
	 */
	@Override
	public User finById(Integer uid) {
		return hibernateTemplate.get(User.class, uid);
	}


	/**
	 * 删除会员
	 */
	@Override
	public void deleteUser(User user) {

		hibernateTemplate.delete(user);
	}


	/**
	 * 修改会员
	 */
	@Override
	public void updateUser(User user) {
		hibernateTemplate.update(user);
	}


	/**
	 * 根据手机号码查询会员
	 */
	@Override
	public List<User> searchUser(String phone) {
		List<User> userlist = (List<User>) hibernateTemplate.find("from User u where u.phone=?", phone);
		return userlist;
	}


	/**
	 * 会员登录
	 */
	@Override
	public User login(User user) {
		List<User> list = (List<User>) hibernateTemplate.find("from User u where u.username=? and phone=?", user.getUsername(),user.getPhone());
		if(list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}
}
