
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="f" method="get">
		<table border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
			<tr>
				<td align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
				<td align=center bgcolor="E6ECDE">이름</td>
				<td align=center bgcolor="E6ECDE">메뉴</td>
				<td align=center bgcolor="E6ECDE">날짜</td>
				<td align=center bgcolor="E6ECDE">조회수</td>
			</tr>
			<c:forEach var="tasty" items="${paging.list}" varStatus="status" >
				<tr>
					<td>${tasty.t_no}</td>
					<td><a href="tastyView?t_no=${tasty.t_no}">${tasty.t_title}</a></td>
					<td>${tasty.t_content}</td>
					<td>${tasty.t_date}</td>
					<td align="center">${tasty.t_count}</td>
				</tr>
			</c:forEach>
			

		</table>
	</form>
			<c:if test="${paging.showFirst}">
				<a href="tastyList?selectPage=1">◀◀</a> &nbsp;
			</c:if>
			<c:if test="${paging.showPreviousGroup}">
				<a href="tastyList?selectPage=${paging.previousGroupStartPageNo}">◀</a> &nbsp;
			</c:if>
			<c:forEach var="no" begin="${paging.startPageNo}" end="${paging.endPageNo}">
				<a href="tastyList?selectPage=${no}">${no}</a> &nbsp;
			</c:forEach>
			<c:if test="${paging.showNextGroup}">
				<a href="tastyList?selectPage=${paging.nextGroupStartPageNo}">▶</a> &nbsp;
			</c:if>
			<c:if test="${paging.showLast}">
				<a href="tastyList?selectPage=${paging.totalPageCount}">▶▶</a> &nbsp;
			</c:if>
</body>
</html>