package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Student;
import com.student.service.impl.StudentServiceImpl;

public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		StudentServiceImpl studentService = new StudentServiceImpl();
		Student student  = new Student(no,name,age,address);
		boolean result = studentService.updateStudentByNo(no, student);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		if (result) {
			response.getWriter().print("更新成功");
			response.sendRedirect("QueryAllStudentsServlet");
		}else {
			response.getWriter().print("更新失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
