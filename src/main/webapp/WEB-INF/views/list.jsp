<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<form action="/">
		关键字<input type="text" name="mh1" value="${mh1 }"> 排序<select
			name="mh2">
			<option value="">--请选择--</option>
			<option value="score" ${mh2=='score'?'selected':'' }>权重</option>
			<option value="created" ${mh2=='created'?'selected':'' }>时间</option>
		</select> <select name="mh3">
			<option value="">--请选择--</option>
			<option value="asc" ${mh3=='asc'?'selected':'' }>正序</option>
			<option value="desc" ${mh3=='desc'?'selected':'' }>倒序</option>
		</select> <input type="submit" value="查询">
	</form>
	<table>
		<tr>
			<td>ID</td>
			<td>新闻标题</td>
			<td>链接地址</td>
			<td>权重</td>
			<td>发布时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.records }" var="n">
			<tr>
				<td>${n.id }</td>
				<td>${n.title }</td>
				<td>${n.url }</td>
				<td>${n.score }</td>
				<td>${n.created }</td>
				<td><a href="home?id=${n.id }">更新</a></td>
			</tr>

		</c:forEach>
		<tr>
			<td colspan="6">
				<center>
					<a
						href="/?currentPage=${page.getCurrent()==1?1:page.getCurrent()-1 }<c:if test="${mh1!=null && mh1!='' }">&mh1=${mh1 }</c:if>
			<c:if test="${mh2!=null && mh2!='' }">&mh2=${mh2 }</c:if>
			<c:if test="${mh3!=null && mh3!='' }">&mh3=${mh3 }</c:if>">&lt;&lt;</a>
					<c:forEach begin="1" end="${page.getPages() }" var="p">
						<c:choose>
							<c:when test="${page.getCurrent()==p }">${p }</c:when>
							<c:otherwise>
								<a
									href="/?currentPage=${p }<c:if test="${mh1!=null && mh1!='' }">&mh1=${mh1 }</c:if>
			<c:if test="${mh2!=null && mh2!='' }">&mh2=${mh2 }</c:if>
			<c:if test="${mh3!=null && mh3!='' }">&mh3=${mh3 }</c:if>">${p }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<a
						href="/?currentPage=${page.getCurrent()==page.getPages()?page.getPages():page.getCurrent()+1 }<c:if test="${mh1!=null && mh1!='' }">&mh1=${mh1 }</c:if>
			<c:if test="${mh2!=null && mh2!='' }">&mh2=${mh2 }</c:if>
			<c:if test="${mh3!=null && mh3!='' }">&mh3=${mh3 }</c:if>">&gt;&gt;</a>
					<center>
			</td>
		</tr>
	</table>
</body>
</html>