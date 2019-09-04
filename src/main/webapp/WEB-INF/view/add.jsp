<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电影增加</title>

<link style="text/css" href="/resource/css/index_work.css"
	rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js">
</script>
<script type="text/javascript">
var orderMethod ='${movieVO.orderMethod=='asc'?'desc':'asc'}';


function myOrder(orderColumn){
	
//	location.href="/selects?orderColumn="+orderColumn+"&orderMethod="+orderMethod;
	$("#form1").append("<input type='hidden' name='orderColumn' value='"+orderColumn+"'> ")
	$("#form1").append("<input type='hidden' name='orderMethod' value='"+orderMethod+"'> ")
	
	
	$("#form1").submit();	
}



</script>
</head>
<body>

	<form action="">
		<table>
			<tr>

				<td>电影名称:<input type="text" name="name"></td>
			</tr>
			<tr>
				<td>导演:<input type="text" name="actor"></td>
			</tr>
			<tr>
				<td>发行日期:<input type="date" name="pdate"></td>
			</tr>
			<tr>
				<td>描述:<input type="text" name="about"></td>
			</tr>
			<tr>
				<td><c:forEach items="${types }" var="t">
						<input type="checkbox" name="tids" value="${t.id }">${t.type }
				</c:forEach></td>
			</tr>

			<tr>

				<td><button type="button" onclick="add()">提交</button></td>
			</tr>


		</table>

	</form>
	
	<script type="text/javascript">
	
	function add(){
		$.post("/add",$("form").serialize(),function(flag){
			if(flag){
				alert("保存成功")
				location.href="/selects";
			}else{
				alert("保存失败")
			}
		})
		
		
		
	}
	
	</script>
</body>
</html>