package com.student.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.dao.IStudentDao;
import com.student.entity.Student;
import com.student.util.DBUtil;

/** 
* @author:YK;
* @date:2019年9月25日 下午4:44:59;
* @Description:数据访问层
*/
public class StudentDaoImpl implements IStudentDao{
	private final String URL = "jdbc:mysql://localhost:3306/user?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
	private final String USERNAME = "root";
	private final String PASSWORD = "123456";
	
	//判断此人是否存在
	public boolean isExist(int sno) {
		return queryStudentByNo(sno)==null?false:true;
	}
	
	//增加学生
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO student VALUES(?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//删除学生
	public boolean deleteStudentByNo(int sno) {
		String sql = "DELETE FROM student WHERE sno=?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号查学生
	public Student queryStudentByNo(int sno) {
		Student student = null;
		Connection connection  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql = "SELECT * FROM student WHERE sno =?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
				
			}
			return student;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
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

	//根据学号修改学生信息
	public boolean updateStudentByNo(int sno,Student student) {
		String sql = "UPDATE student SET sname=?,sage=?,saddress=? WHERE sno=?";
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
		return DBUtil.executeUpdate(sql, params);
	}

	//查询全部学生
	public List<Student> queryAllStudents() {
		PreparedStatement pstmt = null;
		Student student = null;
		List<Student> students = new ArrayList<>();
		ResultSet rs = null ;
		try {
			
			rs = DBUtil.executeQuery( "SELECT * FROM student", null);
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
				students.add(student);
			}
			return students;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}

	//查询学生总数
	@Override
	public int getTotalCount() {
		String sql = "SELECT COUNT(1) FROM student";
		return DBUtil.getTotalCount(sql);
	}

	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		String sql = "select * from student limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,pageSize};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List<Student> students = new ArrayList<>();
		try {
			while (rs.next()) {
				Student student = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				students.add(student);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	/*
	 * @Override public List<Student> queryStudentByPage() {
	 * 
	 * DBUtil.executeQuery(sql, params); return null; }
	 */
}
