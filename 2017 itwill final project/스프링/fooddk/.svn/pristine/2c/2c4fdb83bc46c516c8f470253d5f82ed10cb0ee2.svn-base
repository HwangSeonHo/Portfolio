<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
   function tastyUpdate(){
	  alert("수정하기");
      document.t.action="tastyUpdateAction";
      document.t.method="post";
      document.t.submit();
   }
</script>
</head>
<body>
<body>
	<form name="t" method="post">

		<input type="hidden" name="t_no" value="${tasty.t_no}">
		<table border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
			
			
				
			<tr align=center bgcolor="E6ECDE">
				<td>제목</td>
				<td><input type="text" name="t_title" value="${tasty.t_title}"></td>
			</tr>
				
			<tr align=center bgcolor="E6ECDE">
				<td>메뉴</td>
				<td><input type="text" name="t_content" value="${tasty.t_content}"></td>
			</tr>
			
			<tr align=center bgcolor="E6ECDE">
				<td>이미지</td>
				<td><input type="text" name="t_img" value="${tasty.t_img}"></td>
			</tr>
			
			<tr align=center bgcolor="E6ECDE">
				<td>번호</td>
				<td><input type="text" name="t_phone" value="${tasty.t_phone}"></td>
			</tr>
			<tr align=center bgcolor="E6ECDE">
				<td>영업시간</td>
				<td><input type="text" name="t_time" value="${tasty.t_time}"></td>
			</tr>
			<tr align=center bgcolor="E6ECDE">
				<td>주소</td>
				<td><input type="text" name="t_address" value="${tasty.t_address}"></td>
			</tr>
			<tr align=center bgcolor="E6ECDE">
				<td>위치</td>
				<td><input type="text" name="t_location" value="${tasty.t_location}"></td>
			</tr>
				
			<tr align=center bgcolor="E6ECDE">
				<td>분류</td>
				<td><input type="text" name="c_no" value="${tasty.c_no}"></td>
			</tr>
				
			
			
			
		</table>
		<input type="button" onclick="tastyUpdate()" value="수정">
	</form>
</body>
</body>
</html>