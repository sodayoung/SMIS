package com.student.service.impl;

import java.util.List;

import com.student.dao.IStudentDao;
import com.student.dao.impl.StudentDaoImpl;
import com.student.entity.Student;
import com.student.service.IStudentService;

/** 
* @author:YK;
* @date:2019年9月25日 下午5:09:48;
* @Description:业务逻辑层
*/
public class StudentServiceImpl implements IStudentService{
	//多态
	IStudentDao studentDao = new StudentDaoImpl();
	
	//根据学号查询
	public Student queryStudentByNo(int sno) {
		return studentDao.queryStudentByNo(sno);
	}
	
	//查询全部学生
	public List<Student> queryAllStudents() {
		return studentDao.queryAllStudents();
	}
	
	//先判断是否存在此学生，再修改
	public boolean updateStudentByNo(int sno,Student student) {
		if (studentDao.isExist(sno)) {
			return studentDao.updateStudentByNo(sno, student);
		}
		return false;
	}
	
	//根据学号删除学生
	public boolean deleteStudentByNo(int sno) {
		if (studentDao.isExist(sno)) {//如果学生存在执行删除返回结果
			return studentDao.deleteStudentByNo(sno);
		}
		return false;
	}
	
	//添加学生
	public boolean addStudent(Student student) {
		if (!studentDao.isExist(student.getSno())) {
			return studentDao.addStudent(student);
			
		}else {
			System.out.println("已存在");
			return false;
		}
	}

	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		
		return studentDao.queryStudentByPage(currentPage, pageSize);
	}

	@Override
	public int getTotalCount( ) {
		return studentDao.getTotalCount();
	}


}
