<%@page import="fooddk.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
/*
	3.출력(응답)
*/
	Member member=(Member)request.getAttribute("member");	
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">
<script type="text/javascript">

function memberList() {
	f.action = "member_list.do";
	f.submit();
}

function memberModify() {
	document.f.action = "member_modify_form.do";
	document.f.method = "POST";
	document.f.submit();
}
function memberRemove() {
	a = window.prompt("비밀번호를 입력하세요");
		window.document.f.m_pw.value= a;
		window.document.f.method = "POST";
		window.document.f.action = "member_remove_action.do";
		window.document.f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
		<!-- include_common_top.jsp start-->
		<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper content start -->
		<div id="wrapper">
			



<div id="content">
	<table border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td>
				<!--contents--> <br />
				<table style="padding-left: 10px" border=0 cellpadding=0
					cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
								방명록 상세보기</b></td>
					</tr>
				</table> <!-- view Form  -->
				<form name="f" method="post">
					<input type="hidden" name="m_no" value="${member.m_no}" />
					<input type="hidden" name="m_id" value="${member.m_id}" />
					<input type="hidden" id="m_pw" name="m_pw" value="${member.m_pw}" />
			
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">번호</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${member.m_no}</td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${member.m_name}</td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${member.m_id}</td>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">성별</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${member.m_gender}</td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">생일</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${member.m_birth}</td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="110">패스워드</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${member.m_pw}</td>
						</tr>
					</table>
				</form> <br />
				<table width=590 border=0 cellpadding=0 cellspacing=0>
				<%if(session.getAttribute("sId").equals(member.getM_id())){%>
					<tr>
						<td align=center>
						<input type="button" value="수정" onClick="memberModify();"> &nbsp; 
						<input type="button" value="삭제" onclick="memberRemove();"> &nbsp; 
						<input type="button" value="목록" onClick="memberList();"></td>
						<%}else{ %>
						<input type="button" value="목록" onClick="memberList();"></td>
						<%} %>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>


		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<!-- include_common_bottom.jsp end-->
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>