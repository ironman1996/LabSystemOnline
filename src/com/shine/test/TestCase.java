package com.shine.test;

import java.sql.Connection;

import org.junit.Test;

import com.mathworks.toolbox.javabuilder.MWException;
import com.shine.dao.user.UserDao;
import com.shine.dao.user.UserDaoImpl;
import com.shine.entity.User;
import com.shine.util.DBUtil;

import plotTest.PlotClass;

public class TestCase {
	
	@Test
	public void test() throws Exception{
		PlotClass p=new PlotClass();
		System.out.println(PlotClass.class.getPackage().getName());
	}

	
	/**
	 * 测试数据库连接是否成功
	 */
	@Test
	public void test2(){
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
	}
	/**
	 * dao
	 *findByName 
	 */
	@Test
	public void test3(){
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findByUsername("wangbaoqiang");
		System.out.println(user);
	}
	

}
