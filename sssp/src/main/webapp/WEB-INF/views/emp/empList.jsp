<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>雇员列表</title>
</head>
<body>

	<h1>雇员列表</h1>
	<br/>
	<table border="1" align="center" cellpadding="5" cellspacing="0">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
				<th>birthday</th>
				<th>createTime</th>
				<th>department</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="emp" varStatus="s">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.age}</td>
					<td><fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${emp.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${emp.department.deptName}</td>
					<td><a href="${pageContext.request.contextPath}/emp/${emp.id}">update</a></td>
					<td><a href="javascript:deleteEmp(${emp.id}, '${emp.name}');">delete</a></td>
				</tr>				
			</c:forEach>
			<tr>
				<td colspan="8">
					当前第${page.number + 1}页/${page.totalPages}页，每页${page.size}条/${page.totalElements}条，<a href="/emp/empList?pageNo=${page.number}">上一页</a><a href="/emp/empList?pageNo=${page.number + 2}">下一页</a>
				</td>
			</tr>
		</tbody>
	</table>
	<form id="submitForm" action="" method="post">
		<input type="hidden" name="_method">
	</form>
	<script type="text/javascript" src="/js/jquery-latest.min.js"></script>
	<script type="text/javascript">
		function deleteEmp(id, name){
			if(confirm("您确定要删除" + name + "的信息吗？")){
				var form = $("#submitForm");
				form.attr("action", "${pageContext.request.contextPath}/emp/" + id);
				form.find("input[name='_method']").val("DELETE");
				form.submit();
			}
		}
	</script>
</body>
</html>