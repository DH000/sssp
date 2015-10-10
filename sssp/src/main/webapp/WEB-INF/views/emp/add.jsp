<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加雇员</title>
<script type="text/javascript" src="/js/jquery-latest.min.js"></script>
</head>
<body>
	<input type="hidden" name="old_name" id="old_name" value="${employee.name}">
	<c:choose>
		<c:when test="${empty employee.id}">
			<c:set var="url" value="${pageContext.request.contextPath}/emp/add"></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="url" value="${pageContext.request.contextPath}/emp/${employee.id}"></c:set>
		</c:otherwise>
	</c:choose>
	<form:form action="${url}" method="post" modelAttribute="employee">
		<c:if test="${!empty employee.id}">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="put">
		</c:if>
		name: <form:input path="name" id="employee_name" /><br/>
		age: <form:input path="age" /><br/>
		birthday: <form:input path="birthday" /><br/>
		department: <form:select path="department.id" items="${departments}" itemLabel="deptName" itemValue="id"></form:select><br/>
		<input type="submit" value="添加">
	</form:form>
	<script type="text/javascript">
	$(function(){
		$("#employee_name").on("change", function(){
			var _this = $(this);
			var name = $.trim(_this.val());
			_this.val(name);
			
			var oldName = $.trim($("#old_name").val());
			if(oldName && oldName === name){
				return;
			}
			
			if(name){
				$.get("/emp/empNameIsExist", {"name" : name}, function(data){
					if('1' === data){
						alert("名字已存在!");
					}else if('0' === data){
						alert("名字可用!");
					}
				});
			}
		});
	});
</script>
</body>
</html>