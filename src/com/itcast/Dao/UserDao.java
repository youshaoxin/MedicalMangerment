package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.User;

public interface UserDao {

	//查询所有会员
	public List<User> findAllUserList();

	//添加会员
	public void addUser(User user);

	//根据id去查询会员的方法
	public User finById(Integer uid);

	//删除会员
	public void deleteUser(User user);

	//修改会员信息
	public void updateUser(User user);

	//根据手机号查询会员方法
	public List<User> searchUser(String phone);

	//会员登录
	public User login(User user);

}
