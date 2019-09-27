<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<!-- <script type="text/javascript">
	function check(){//onsubmit:return true 正常提交 return false 不提交
		var sno = $("sno").val();
		var sname = $("sname").val();
		var sage = $("sage").val();
		var saddress = $("saddress").val();
		if(!(sno>0&&sno<101)){
			alert("学号有误，必须是1-100");
		}
		if(!(sname.lenth>1&&sname.lenth<5)){
			alert("姓名长度有误，必须是2-4位");
		}
		if(!(sage>0&&sage<100)){
			alert("年龄必须在1-99");
		}
		return true;
	}

	$(document).ready(function(){
		
		
		
	});

</script> -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudentServlet" >
		学号：<input type="text" name="sno" id="sno"><br/>
		姓名：<input type="text" name="sname" id="sname"><br/>
		年龄：<input type="text" name="sage" id="sage"><br/>
		地址：<input type="text" name="saddress" id="saddress"/><br/>
	<input type="submit" value="新增"><br/>
	</form>
</body>
</html>