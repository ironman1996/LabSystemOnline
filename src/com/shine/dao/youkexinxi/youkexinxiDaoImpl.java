package com.shine.dao.youkexinxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shine.entity.Emp;
import com.shine.entity.User;
import com.shine.entity.youkexinxi;
import com.shine.util.DBUtil;

public class youkexinxiDaoImpl implements youkexinxidao{
	public List<youkexinxi> findAll() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from youkexinxi";
		List<youkexinxi> list = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				youkexinxi e = new youkexinxi();
				e.setyoukebianhao(rs.getInt("youkebianhao"));
				System.out.println(e.getyoukebianhao());
				e.setyoukexingming(rs.getString("youkexingming"));
				e.setxingbie(rs.getString("xingbie"));
				e.setshenfengzhenghao(rs.getString("shenfengzhenghao"));
				e.setlianxifangshi(rs.getString("lianxifangshi"));
				e.setyoukemima(rs.getString("youkemima"));
				list.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
		return list;
	}

	public void addyoukexinxi(youkexinxi e) {
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="insert into youkexinxi(youkebianhao,youkexingming,xingbie,shenfengzhenghao,lianxifangshi,youkemima)" + 
				"values(youkebianhao_seq.nextval,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			
			prep.setString(1, e.getyoukexingming());
			prep.setString(2, e.getxingbie());
			prep.setString(3, e.getshenfengzhenghao());
			prep.setString(4, e.getlianxifangshi());
			prep.setString(5, e.getyoukemima());
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	public void deleteyoukexinxi(int youkebianhao) {
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="delete  youkexinxi where youkebianhao =?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, youkebianhao);
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	public youkexinxi findById(int youkebianhao) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from youkexinxi where youkebianhao =?";
		youkexinxi e = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, youkebianhao);
			rs = prep.executeQuery();
			if(rs.next()) {
				e = new youkexinxi();
				
				e.setyoukebianhao(rs.getInt("youkebianhao"));
				e.setyoukexingming(rs.getString("youkexingming"));
				e.setxingbie(rs.getString("xingbie"));
				e.setshenfengzhenghao(rs.getString("shenfengzhenghao"));
				e.setlianxifangshi(rs.getString("lianxifangshi"));
				e.setyoukemima(rs.getString("youkemima"));
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
		
		return e;
	}

	public void updateyoukexinxi(youkexinxi e) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="update youkexinxi set youkexingming=?,xingbie=?,shenfengzhenghao=?,lianxifangshi=?,youkemima=?  where youkebianhao=?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, e.getyoukexingming());
			System.out.println(e.getyoukexingming());
			prep.setString(2, e.getxingbie());
			prep.setString(3, e.getshenfengzhenghao());
			prep.setString(4, e.getlianxifangshi());
			prep.setString(5, e.getyoukemima());
			prep.setInt(6, e.getyoukebianhao());
			System.out.println(e.getyoukexingming());
			prep.executeUpdate();
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
	}
	public youkexinxi findByyoukexingming(String youkexingming) {
		Connection conn =  null;
		PreparedStatement prep =null;
		ResultSet rs = null;
		youkexinxi user = null;
		String sql ="select * from youkexinxi where youkexingming =?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, youkexingming);
			/*
			 * 查询语句用executeQuery（）
			 * 修改，删除用 executeUpdate（）
			 */
			rs = prep.executeQuery();
			
			/*
			 * 把数据库里面查询出来的数据通过javaBean进行封装
			 */
			if(rs.next()){
				user  = new youkexinxi();
				user.setyoukebianhao(rs.getInt("youkebianhao"));
				user.setyoukexingming(rs.getString("youkexingming"));
				System.out.println(user.getyoukexingming()+"DI1");
				user.setxingbie(rs.getString("xingbie"));
				user.setshenfengzhenghao(rs.getString("shenfengzhenghao"));
				user.setlianxifangshi(rs.getString("lianxifangshi"));
				user.setyoukemima(rs.getString("youkemima"));
				System.out.println(user.getyoukemima()+"DI2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return user;
	}



}
