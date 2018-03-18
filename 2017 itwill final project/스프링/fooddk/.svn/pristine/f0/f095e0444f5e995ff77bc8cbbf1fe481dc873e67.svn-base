<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script type="text/javascript">
	
	function memberCreateForm() {
		
		document.f.method = "GET";
		document.f.action = "member_write_form.do";
		document.f.submit();
		
	}
	function memberList() {
		f.action = "member_list.do";
		f.submit();
	}
	function memberlogout(){
		f.action = "logout_action.do"
		f.submit();
		
	}
</script>
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN FORM</h1><hr/>
	<form name="f" action="login_action.do" method="post">
<%if(session.getAttribute("sId")==null){ %>
	아이디 : <input type="text" name="m_id"><br/>
	비밀번호 : <input type="password" name="m_pw"><br/>
	<input type="submit" value="로그인">
	<input type="button" value="회원가입" onclick="memberCreateForm();">
	
	<%} else{%>
		<input type="button" value="리스트보기" onclick="memberList();">
		${sId}님 로그인중
		<input type="button" value="로그아웃" onclick="memberlogout();">
	<%} %>
	</form>
</body>
</html>