package com.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.PageC;
import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

public class QueryStudentByPage extends HttpServlet {
    public QueryStudentByPage() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService studentService = new StudentServiceImpl();
		int count = studentService.getTotalCount();//数据总数
		PageC pageC = new PageC();
		String cpage = request.getParameter("currentPage");
		if (cpage==null) {
			cpage="1";
		}
		int currentPage = Integer.parseInt(cpage); 
		pageC.setCurrentPage(currentPage);
		
		int totalCount = studentService.getTotalCount();
		pageC.setTotalCount(totalCount);
		
		
		
		
		String stringPageSize = request.getParameter("pageSize");
		if (stringPageSize==null) {
			stringPageSize="5";
		}
		int pageSize = Integer.parseInt(stringPageSize);
		pageC.setPageSize(pageSize);
		
		List<Student> students = studentService.queryStudentByPage(currentPage, pageSize);
		pageC.setStudents(students);
		
		request.setAttribute("pageC", pageC);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
