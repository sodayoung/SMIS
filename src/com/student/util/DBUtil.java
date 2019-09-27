package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.entity.Student;

/** 
* @author:YK;
* @date:2019年9月26日 下午3:42:56;
* @Description:数据库工具类
*/
//通用的数据库操作
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/user?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static String USERNAME = "root";
	private static String PASSWORD = "123456";
	public static Connection connection  = null;
	public  static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if (params!=null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	//通用的更新
	public static boolean executeUpdate(String sql,Object[] params) {
		Connection connection  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			//String sql = "DELETE FROM student WHERE sno=?";
			//pstmt.setInt(1, sno);
			pstmt = createPreparedStatement(sql, params);
			
			int count = pstmt.executeUpdate();
			if (count>0) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

	//通用的查询,返回结果集
	public static ResultSet executeQuery(String sql,Object[] params) {
		Student student = null;
		List<Student> students = new ArrayList<>();
		try {
			
			//String sql = "SELECT * FROM student";
			pstmt = createPreparedStatement(sql, params);
			
			/*
			 * if (params!=null) { for (int i = 0; i < params.length; i++) {
			 * pstmt.setObject(i+1, params[i]); } }
			 */
			rs = pstmt.executeQuery();
			return rs;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection) {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)connection.close();
		} catch (SQLException e) {																																																																											
			e.printStackTrace();																																																																																																																																																																																																					
		} 
	}
}
