package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.UserDao;
import com.itcast.DaoImpl.UserDaoImpl;
import com.itcast.entity.User;
/**
 * ypf
 * @author Administrator
 *
 */

//事务的注解
@Transactional
public class UserService {
	//注入userDao
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	//查询所有会员
	public List<User> findAllUserList() {
		
		
		return userDao.findAllUserList();
	}

	
	//添加会员
	public void addUser(User user) {

		 userDao.addUser(user);
	}

	
	//根据id去查询会员的方法
	public User finById(Integer uid) {
		return userDao.finById(uid);
	}


	//删除会员
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}


	//修改会员信息
	public void updateUser(User user) {
		userDao.updateUser(user);
	}


	//根据手机号去查询会员的方法
	public List<User> searchUser(String phone) {
		 return userDao.searchUser(phone);
	}


	//会员登录
	public User login(User user) {
		return userDao.login(user);
	}


	
	

}
