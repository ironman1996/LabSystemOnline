package com.shine.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
	/**
	 * �������ݿ�
	 * ����java.Sql��
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			/*Class.forName("oracle.jdbc.mysqlDriver");
		
			
			//conn = DriverManager.getConnection(
			//		"jdbc:oracle:thin:@localhost:1521:xe",
			//		"xyb","xyb");*/
			  
			
			Class.forName("com.mysql.jdbc.Driver");
		    conn
		    =	
				    DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","0025");
			
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�Ͻ���jar����");
		}
		return conn;
		
	}
	/**�ر�����
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�����ʧ��");
			}
		}
		
	}
	
}