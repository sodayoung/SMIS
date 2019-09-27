package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age =Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		
		Student student = new Student(no,name,age,address);
		
		//接口x = new 实现类 多态
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.addStudent(student);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		/*
		 * if (result) { //out.print("添加成功");
		 * 
		 * }else { out.print("添加失败");
		 * 
		 * }
		 */
		
		if (!result) {
			request.setAttribute("error", "adderror");
		}else {
			request.setAttribute("error", "noadderror");
		}
		//response.sendRedirect("QueryAllStudentsServlet");
		request.getRequestDispatcher("QueryAllStudentsServlet").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
