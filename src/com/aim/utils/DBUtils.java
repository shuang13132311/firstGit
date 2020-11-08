package com.aim.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {
	private static final String DB_USERNAME = "scott";
	private static final String DB_PASSWORD = "admin";
	private static final String DB_URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String DB_DRIVER="oracle.jdbc.OracleDriver";
	
	
	//获取数据库连接
	public static Connection  getConn(){		
		Connection conn = null;
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭所有数据库相关连接
	public static void closeAll(ResultSet rs, PreparedStatement pstm, Connection conn){
		
		try {
			if(rs != null){
				rs.close();
			}else if(pstm != null){
				pstm.close();
			}else if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
