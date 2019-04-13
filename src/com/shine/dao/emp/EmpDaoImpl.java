package com.shine.dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shine.entity.Emp;
import com.shine.util.DBUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from emp";
		List<Emp> list = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getDouble("salary"));
				e.setGender(rs.getString("gender"));
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
	public void addEmp(Emp e) {
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="insert into emp(id,name,salary,gender)" + 
				"values(emp_seq.nextval,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, e.getName());
			prep.setDouble(2, e.getSalary());
			prep.setString(3, e.getGender());
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void deleteEmp(int id) {
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="delete  emp where id =?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public Emp findById(int id) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from emp where id =?";
		Emp e = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			rs = prep.executeQuery();
			if(rs.next()) {
				e = new Emp();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getDouble("salary"));
				e.setGender(rs.getString("gender"));
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
		
		return e;
	}

	@Override
	public void updateEmp(Emp e) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="update emp set name=?,salary=?,gender=?  where id=?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, e.getName());
			prep.setDouble(2, e.getSalary());
			prep.setString(3, e.getGender());
			prep.setInt(4, e.getId());
			prep.executeUpdate();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
	}

}
