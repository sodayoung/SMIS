package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.service.impl.StudentServiceImpl;

public class DeleteStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除功能
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno")); 
		StudentServiceImpl studentService = new StudentServiceImpl();
		boolean result = studentService.deleteStudentByNo(no);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		if (result) {
			response.sendRedirect("QueryAllStudentsServlet");//重新查询所有学生
		}else {
			response.getWriter().print("删除失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
