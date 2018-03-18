<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
   function tastyRemove(){
	  alert("지우기");
      document.t.action="tastyRemove";
      document.t.method="get";
      document.t.submit();
   }
   
   function tastyUpdate(){
	  alert("수정하기");
      document.t.action="tastyUpdate";
      document.t.method="get";
      document.t.submit();
   }



   </script>
</head>
<body>
<form name="t" method="post">
	<input type="hidden" name="t_no" value="${tasty.t_no}">
		<table border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
			<tr>
				<td align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
				<td align=center bgcolor="E6ECDE">이름</td>
				<td align=center bgcolor="E6ECDE">메뉴</td>
				<td align=center bgcolor="E6ECDE">날짜</td>
				<td align=center bgcolor="E6ECDE">조회수</td>
			</tr>
			<tr>
				<td>${tasty.t_no}</td>
				<td>${tasty.t_title}</td>
				<td>${tasty.t_content}</td>
				<td>${tasty.t_date}</td>
				<td align="center">${tasty.t_count}</td>
			</tr>
		</table>
		<input type="button" onclick="tastyRemove()" value="삭제">
		<input type="button" onclick="tastyUpdate()" value="수정">
	</form>
</body>
</html>