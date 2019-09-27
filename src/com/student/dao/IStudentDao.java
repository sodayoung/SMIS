package com.student.dao;

import java.util.List;

import com.student.entity.Student;

/** 
* @author:YK;
* @date:2019年9月26日 下午3:27:36;
* @Description:
*/
public interface IStudentDao {
	//判断此人是否存在
	public boolean isExist(int sno) ;
	
	//增加学生
	public boolean addStudent(Student student);
	
	//删除学生
	public boolean deleteStudentByNo(int sno) ;
	
	//根据学号查学生
	public Student queryStudentByNo(int sno);
	//根据学号修改学生信息
	public boolean updateStudentByNo(int sno,Student student);

	//查询全部学生
	public List<Student> queryAllStudents();
}
