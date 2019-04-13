package com.shine.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shine.entity.User;
import com.shine.util.DBUtil;

/**
 * ͨ��jdbcʵ�����ݿ�����
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
			 * ��ѯ�����executeQuery����
			 * �޸ģ�ɾ���� executeUpdate����
			 */
			rs = prep.executeQuery();
			
			/*
			 * �����ݿ������ѯ����������ͨ��javaBean���з�װ
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
