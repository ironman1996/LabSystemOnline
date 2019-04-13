package com.shine.dao.cheliangxinxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shine.entity.cheliangxinxi;
import com.shine.entity.youkexinxi;
import com.shine.util.DBUtil;

public class cheliangxinxiDaoImpl implements cheliangxinxidao{

	@Override
	public List<cheliangxinxi> findAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from cheliangxinxi";
		List<cheliangxinxi> list = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				cheliangxinxi e = new cheliangxinxi();
				e.setCheliangbianhao(rs.getInt("cheliangbianhao"));
				System.out.println(e.getCheliangbianhao());
				e.setChepaihao(rs.getString("chepaihao"));
				e.setJinrushijian(rs.getString("Jinrushijian"));
				e.setLikaishijian(rs.getString("Likaishijian"));
				
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
	public void addcheliangxinxi(cheliangxinxi e) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="insert into cheliangxinxi(cheliangbianhao,chepaihao,jinrushijian,likaishijian)" + 
				"values(youkebianhao_seq.nextval,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			
			prep.setString(1, e.getChepaihao());
			prep.setString(2, e.getJinrushijian());
			prep.setString(3, e.getLikaishijian());
			
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deletecheliangxinxi(int cheliangbianhao) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		String sql ="delete  cheliangxinxi where cheliangbianhao =?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, cheliangbianhao);
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public cheliangxinxi findById(int cheliangbianhao) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="select * from cheliangxinxi where cheliangbianhao =?";
		cheliangxinxi e = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setInt(1, cheliangbianhao);
			rs = prep.executeQuery();
			if(rs.next()) {
				e = new cheliangxinxi();
				
				e.setCheliangbianhao(rs.getInt("cheliangbianhao"));
				e.setChepaihao(rs.getString("chepaihao"));
				e.setJinrushijian(rs.getString("jinrushijian"));
				e.setLikaishijian(rs.getString("likaishijian"));
				
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return e;
		
	}

	@Override
	public void updatecheliangxinxi(cheliangxinxi e) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql ="update cheliangxinxi set chepaihao=?,jinrushijian=?,likaishijian=?  where cheliangbianhao=?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, e.getChepaihao());
			System.out.println(e.getChepaihao());
			prep.setString(2, e.getJinrushijian());
			prep.setString(3, e.getLikaishijian());
			prep.setInt(4, e.getCheliangbianhao());
			System.out.println(e.getCheliangbianhao()+"DI");
			prep.executeUpdate();
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
	

}
