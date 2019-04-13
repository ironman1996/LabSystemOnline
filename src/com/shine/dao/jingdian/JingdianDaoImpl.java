package com.shine.dao.jingdian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shine.entity.EmpJingdian;
import com.shine.util.DBUtil;

public class JingdianDaoImpl implements JingdianDao {

	@Override
	public List<EmpJingdian> findAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from jingdian";
		List<EmpJingdian> list = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				EmpJingdian e = new EmpJingdian();
				System.out.println(rs.getInt("jdnum")+rs.getString("jdaddress"));
				e.setJdnum(rs.getInt("jdnum"));
				e.setJdname(rs.getString("jdname"));
				e.setJdtel(rs.getString("jdtel"));
				e.setJdpj(rs.getString("jdpj"));
				e.setJdaddress(rs.getString("jdaddress"));
				e.setJdprice(rs.getInt("jdprice"));
				list.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public void addEmpJingdian(EmpJingdian e) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="insert into jingdian(jdnum,jdname,jdtel,jdpj,jdprice,jdaddress)" + 
				"values(jd_seq.nextval,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, e.getJdname());
			prep.setString(2, e.getJdtel());
			prep.setString(3, e.getJdpj());
			prep.setInt(4,e.getJdprice());
			prep.setString(5, e.getJdaddress());
			prep.executeUpdate();
		}catch (Exception e1){
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void deleteEmpJingdian(int jdnum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		String sql = "delete jingdian where jdnum =?";
		try{
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, jdnum);
			prep.executeUpdate();
			
		}catch(Exception e1){
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public EmpJingdian findById(int jdnum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql = "select * from jingdian where jdnum =?";
		EmpJingdian e = null;
		try{
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, jdnum);
			rs = prep.executeQuery();
			if(rs.next()){
				e = new EmpJingdian();
				e.setJdnum(rs.getInt("jdnum"));
				e.setJdname(rs.getString("jdname"));
				e.setJdtel(rs.getString("jdtel"));
				e.setJdpj(rs.getString("jdpj"));
				e.setJdprice(rs.getInt("jdprice"));
				e.setJdaddress(rs.getString("jdaddress"));
			}
		}catch (Exception e1){
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return e;
	}

	@Override
	public void updateEmpJingdian(EmpJingdian e) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="update jingdian set jdname=?,jdtel=?,jdpj=?,jdprice=?,jdaddress=? "
				+ " where jdnum=?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, e.getJdname());
			prep.setString(2, e.getJdtel());
			prep.setString(3, e.getJdpj());
			prep.setInt(4,e.getJdprice());
			prep.setString(5, e.getJdaddress());
			prep.setInt(6, e.getJdnum());
			prep.executeUpdate();
		}catch(Exception e1){
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
	
}
