<%@page import="java.util.List"%>
<%@page import="com.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("tr:odd").css("background-color","lightgray");
		
		
	});

</script>

<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body>
<%
	String error = (String)request.getAttribute("error");
	if(error!=null){
	if(error.equals("adderror")){
		out.print("增加失败");
	}else if(error.equals("noadderror")){
		out.print("增加成功");
	}
	}
%>
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>删除</th>
		</tr>
		
		<%
		List<Student> students = (List<Student>)request.getAttribute("students") ;
		if(students!=null){
			for(Student student:students){
	
		%>
		<tr>
			<td><a href="QueryStudentByNoServlet?sno=<%=student.getSno() %>"><%=student.getSno() %></a></td>
			<td><%=student.getSname() %></td>
			<td><%=student.getSage() %></td>
			<td><a href="DeleteStudentServlet?sno=<%=student.getSno() %>">删除</a></td>
		</tr>
		
		<% 
		}
		}
		%>
	</table>
	<a href="add.jsp"></a>
</body>
</html>