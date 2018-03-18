<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Lambada Template by WowThemes.net</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="assets/img/favicon.png" />
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'
	type='text/css' media='all' />
<link rel='stylesheet' href='assets/css/edd.css' type='text/css'
	media='all' />
<link rel='stylesheet' href='assets/css/bootstrap.min.css'
	type='text/css' media='all' />
<link rel='stylesheet' href='style.css' type='text/css' media='all' />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Covered+By+Your+Grace' />
<script type="text/javascript">
	function memberList() {
		f.action = "member_list.do";
		f.submit();
	}

	function memberList() {
		document.f.action = "member_list";
		document.f.method = "POST";
		document.f.submit();
	}
	function memberModify() {
		document.f.action = "member_modify_form";
		document.f.method = "POST";
		document.f.submit();
	}
	function memberRemove() {
		a = window.prompt("비밀번호를 입력하세요");
		window.document.f.m_pw.value = a;
		window.document.f.method = "POST";
		window.document.f.action = "member_remove_action";
		window.document.f.submit();
	}
	
	
</script>
</head>
<body>

	<jsp:include page="common_top.jsp"></jsp:include>


	<!-- PAGE HEADER
		==========================================-->
	<div class="headertitle">
		<div class="headercontent">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>User Account</h1>
						<span class="wtnbreadcrumbs"><a href="index.jsp">Home</a> <span
							class="separator"></span> <span class="actual">User
								Account</span></span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- START CONTAINER
		==========================================-->
	<div class="templatemyaccount">
		<div class="container">
			<div class="whiteboxed whiteboxeborder">
				<div class="row">

					<div class="col-md-6">
						<span class="smalltitle">User My Info</span>
						<c:if test="${member.m_manager == 1 || member.m_manager == 2}">
							<font color="red">관리자 입니다.</font>
							</c:if>
						<form name="f" id="edd_profile_editor_form" class="edd_form"
							method="post">
							<input type="hidden" name="m_no" value="${member.m_no}" /> <input
								type="hidden" name="m_id" value="${member.m_id}" /> <input
								type="hidden" id="m_pw" name="m_pw" value="${member.m_pw}" />

							<legend id="edd_profile_name_label">User My Info</legend>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">NAME</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_name}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">ID</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${sId}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">GENDER</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_gender}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">BIRTH</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_birth}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">Kind Food</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${ckind}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">POINT</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_point}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">GRADE</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${grade}</td>
							</p>
							<font color="red">${MSG}</font>

						</form>
						<!-- #edd_profile_editor_form -->

						<a class="button logout" onClick="memberModify();"><i
							class="fa fa-sign-out"></i> Update</a> <a class="button logout"
							onclick="memberRemove();"><i class="fa fa-sign-out"></i>
							Remove</a>
							<c:if test="${member.m_manager == 1 || member.m_manager == 2}">
						<class="fa fa-sign-out"></i> </a> <a class="button logout"
							onclick="memberList();"><i class="fa fa-sign-out"></i>
							MemberList</a>
							</c:if>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!-- / END CONTAINER
		==========================================-->
	<!-- end /.wrapcontent -->
	<!-- CALL TO ACTION
		==========================================-->
	
	
	
	<jsp:include page="common_bottom.jsp"></jsp:include>
	
</body>
</html>
