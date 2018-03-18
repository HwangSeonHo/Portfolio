<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>병만족 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">






<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">

<script type="text/javascript">
function memberCreate() {
	/*	if (f.guest_name.value == "") {
			alert("이름을 입력하십시요.");
			f.guest_name.focus();
			return false;
		}
		if (f.guest_email.value == "") {
			alert("이메일을 입력하십시요.");
			f.guest_email.focus();
			return false;
		}
		if (f.guest_homepage.value == "") {
			alert("홈페이지를 입력하십시요.");
			f.guest_homepage.focus();
			return false;
		}

		if (f.guest_title.value == "") {
			alert("제목을 입력하십시요.");
			f.guest_title.focus();
			return false;
		}
		if (f.guest_content.value == "") {
			alert("내용을 입력하십시요.");
			f.guest_content.focus();
			return false;
		}*/
		f.method = "POST";
		f.action = "member_write_action.do";
		f.submit();
	}

function memberList() {
	f.action = "member_list.do";
	f.submit();
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
	<table width=0 border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td>
				<!--contents--> <br />
				<table style="padding-left: 10px" border=0 cellpadding=0
					cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
								방명록 쓰기</b></td>
					</tr>
				</table> <!-- guest write Form  -->
				<form name="f" method="post">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="m_name"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="m_id"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">패스워드</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="password"
								style="width: 150" name="m_pw"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">생일</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 240" name="m_birth"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">성별</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 240" name="m_gender"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">포인트</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 240" name="m_point"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">매니저</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 240" name="m_manager"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">등급</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 240" name="g_no"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">카테고리</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 240" name="c_no"></td>
						</tr>
					</table>
				</form> <br />
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center><input type="button" value="방명록쓰기"
							onClick="memberCreate();"> &nbsp; <input type="button"
							value="방명록목록" onClick="memberList()"></td>
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
	</div>
	<!--container end-->
</body>
</html>