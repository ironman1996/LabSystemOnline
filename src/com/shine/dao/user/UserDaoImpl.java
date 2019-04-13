package com.shine.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shine.entity.User;
import com.shine.util.DBUtil;

/**
 * 通过jdbc实现数据库连接
 * @author xyd
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public User findByUsername(String username) {
		Connection conn =  null;
		PreparedStatement prep =null;
		ResultSet rs = null;
		User user = null;
		String sql ="select * from user_info where username =?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, username);
			/*
			 * 查询语句用executeQuery（）
			 * 修改，删除用 executeUpdate（）
			 */
			rs = prep.executeQuery();
			
			/*
			 * 把数据库里面查询出来的数据通过javaBean进行封装
			 */
			if(rs.next()){
				user  = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setRealName(rs.getString("realname"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return user;
	}

}
