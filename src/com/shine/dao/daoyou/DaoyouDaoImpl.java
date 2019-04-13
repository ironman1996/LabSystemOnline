package com.shine.dao.daoyou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shine.entity.EmpDaoyou;
import com.shine.util.DBUtil;


public class DaoyouDaoImpl implements DaoyouDao{
	
	
	@Override
	public List<EmpDaoyou> findAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from daoyou";
		List<EmpDaoyou> list = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				EmpDaoyou e = new EmpDaoyou();
				e.setDynum(rs.getInt("dynum"));
				e.setDyname(rs.getString("dyname"));
				e.setDytel(rs.getString("dytel"));
				e.setDygender(rs.getString("dygender"));
				list.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public void addEmpDaoyou(EmpDaoyou e) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		String sql = "insert into daoyou(dynum,dyname,dytel,dygender)" + 
				"values(dy_seq.nextval,?,?,?)";
		try{
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1,e.getDyname());
			prep.setString(2, e.getDytel());
			prep.setString(3, e.getDygender());
			prep.executeUpdate();
		}catch(Exception e1){
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	
	

	@Override
	public void deleteEmpDaoyou(int dynum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="delete  daoyou where dynum =?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, dynum);
			prep.executeUpdate();
		}catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public EmpDaoyou findById(int dynum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from daoyou where dynum =?";
		EmpDaoyou e = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, dynum);
			rs = prep.executeQuery();
			if(rs.next()) {
				e = new EmpDaoyou();
				e.setDynum(rs.getInt("dynum"));
				e.setDyname(rs.getString("dyname"));
				e.setDytel(rs.getString("dytel"));
				e.setDygender(rs.getString("dygender"));
			}  }catch(Exception e1){
				e1.printStackTrace();
			}finally {
				DBUtil.close(conn);
			}
			
		
		return e;
	}

	@Override
	public void updateEmpDaoyou(EmpDaoyou e) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="update daoyou set dyname=?,dytel=?,dygender=?  where dynum=?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, e.getDyname());
			prep.setString(2, e.getDytel());
			prep.setString(3, e.getDygender());
			prep.setInt(4, e.getDynum());
			prep.executeUpdate();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}

	}

}
