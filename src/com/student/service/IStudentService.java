package com.student.service;

import java.util.List;

import com.student.entity.Student;

/** 
* @author:YK;
* @date:2019年9月26日 下午3:28:10;
* @Description:
*/
public interface IStudentService {
	//根据学号查询
	public Student queryStudentByNo(int sno);
	
	//查询全部学生
	public List<Student> queryAllStudents();
	
	public List<Student> queryStudentByPage(int currentPage,int pageSize);
	
	public int getTotalCount();
	
	//先判断是否存在此学生，再修改
	public boolean updateStudentByNo(int sno,Student student);
	
	//根据学号删除学生
	public boolean deleteStudentByNo(int sno);
	
	//添加学生
	public boolean addStudent(Student student);
}
