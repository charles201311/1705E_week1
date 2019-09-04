<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电影列表</title>

<link style="text/css" href="/resource/css/index_work.css" rel="stylesheet">
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


	<table>
		<tr>

			<td>序号</td>
			<td>电影名称</td>
			<td>导演</td>
			<td>发行日期</td>
			<td>描述</td>
			<td>类型</td>
			<td>操作|<a href="/add" >增加</td>
		</tr>

		<c:forEach items="${ movies}" var="m" varStatus="id">
			<tr> 
				<td>${id.index+1 }</td>
				<td>${m.name }</td>
				<td>${m.actor }</td>
				<td>${m.pdate }</td>
				<td>${m.about }</td>
				<td>${m.type }</td>
				<td><a href="update?id=${m.id}">修改</a>|删除</td>
			</tr>
		</c:forEach>

	</table>
	
	${page }
</body>
</html>