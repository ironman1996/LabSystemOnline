package com.shine.dao.Matlab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shine.entity.Emp;
import com.shine.entity.Matlab;
import com.shine.entity.User;
import com.shine.entity.youkexinxi;
import com.shine.util.DBUtil;

public class MatlabDaoImpl implements Matlabdao{
	public List<Matlab> findAll() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from matlab";
		List<Matlab> list = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				Matlab e = new Matlab();
				e.setMatNum(rs.getInt("matNum"));
				System.out.println(e.getMatNum());
				e.setMatPackageName(rs.getString("matPackageName"));
				e.setMatDesc(rs.getString("matDesc"));
				e.setMatClass(rs.getString("matClass"));
				e.setMatMethod(rs.getString("matMethod"));
				
				list.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
		return list;
	}

	public void addMatlab(Matlab e) {
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="insert into Matlab(matNum,matPackageName,matDesc,matClass,matMethod)" + 
				"values(Matlab_seq.nextval,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			
			prep.setString(2, e.getMatPackageName());
			prep.setString(3, e.getMatDesc());
			prep.setString(4, e.getMatClass());
			prep.setString(5, e.getMatMethod());
			
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	public void deleteMatlab(int matNum) {
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="delete  Matlab where matNum =?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, matNum);
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	public Matlab findById(int matNum) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from Matlab where matNum =?";
		Matlab e = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, matNum);
			rs = prep.executeQuery();
			if(rs.next()) {
				e = new Matlab();
				
				e.setMatNum(rs.getInt("matNum"));
				e.setMatPackageName(rs.getString("matPackageName"));
				e.setMatDesc(rs.getString("matDesc"));
				e.setMatClass(rs.getString("matClass"));
				e.setMatMethod(rs.getString("matMethod"));
				
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
		
		return e;
	}

	public void updateMatlab(Matlab e) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="update Matlab set matPackageName=?,matDesc=?,matClass=?,matMethod=?  where matNum=?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, e.getMatPackageName());
			System.out.println(e.getMatPackageName());
			prep.setString(2, e.getMatDesc());
			prep.setString(3, e.getMatClass());
			prep.setString(4, e.getMatMethod());
			
			prep.setInt(5, e.getMatNum());
			System.out.println(e.getMatPackageName());
			prep.executeUpdate();
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
	}
	public Matlab findByMatPackageName(String matPackageName) {
		Connection conn =  null;
		PreparedStatement prep =null;
		ResultSet rs = null;
		Matlab user = null;
		String sql ="select * from Matlab where matPackageName =?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, matPackageName);
			/*
			 * 查询语句用executeQuery（）
			 * 修改，删除用 executeUpdate（）
			 */
			rs = prep.executeQuery();
			
			/*
			 * 把数据库里面查询出来的数据通过javaBean进行封装
			 */
			if(rs.next()){
				user  = new Matlab();
				user.setMatNum(rs.getInt("matNum"));
				user.setMatPackageName(rs.getString("matPackageName"));
				System.out.println(user.getMatPackageName()+"DI1");
				user.setMatDesc(rs.getString("matDesc"));
				user.setMatClass(rs.getString("matClass"));
				user.setMatMethod(rs.getString("matMethod"));
				
				System.out.println(user.getMatMethod()+"DI2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return user;
	}

}
