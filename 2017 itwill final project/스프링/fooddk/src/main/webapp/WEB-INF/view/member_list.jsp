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
	function memberRemove(no, id, pass) {
		param = "m_no=" + no + "&m_id=" + id + "&m_pw=" + pass
		window.document.f.method = "POST";
		window.document.f.action = "member_remove_action2?" + param;
		window.document.f.submit();
	}

	function dd(val) {


		var flag;
		var theURL = "member_view1?m_id=" + val;
		var winName = "이름";

		flag = "left=300, "; //창뜨는위치
		flag += "top=300, "; //창뜨는위치
		flag += "width=600, "; //창크기
		flag += "height=650"; //창크기
		window.open(theURL, winName, flag);
		return;

	}
	function refresh() {
		window.location.reload();
	}
</script>
</head>
<body>

	<jsp:include page="common_top.jsp"></jsp:include>
	<div id="xxx"></div>

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
						<form name="f" id="edd_register_form" class="edd_form"
							method="post">

							<fieldset style="width: 1100px;">
								<legend>User List</legend>
								<div style="height: 500px; overflow: scroll;">
									<table border="0" style="height: 10px;">
										<tr>
											<td width="250" align=center bgcolor="E6ECDE" height="22">등급</td>
											<td width="250" align=center bgcolor="E6ECDE" height="22">User
												ID</td>
											<td width="250" align=center bgcolor="E6ECDE">NAME</td>
											<td width="350" align=center bgcolor="E6ECDE">PASSWORD</td>
											<td width="150" align=center bgcolor="E6ECDE">탈퇴</td>
											<td width="100" align=center bgcolor="E6ECDE">정보</td>
										</tr>
										<tr>


											<c:forEach var="memberList" items="${memberList}"
												varStatus="status">


													<c:if test="${memberList.m_manager == 2}">
														<td width=250 align=center bgcolor="ffffff" height="20">
															<font color="red">${manager1}</font></td>
													</c:if>
													<c:if test="${memberList.m_manager == 1}">
														<td width=250 align=center bgcolor="ffffff" height="20">
															<font color="blue">${manager2}</font></td>
													</c:if>
													<c:if test="${memberList.m_manager == 0}">
														<td width=250 align=center bgcolor="ffffff" height="20">
														${manager3}</td>
													</c:if>
													<td width=250 align=center bgcolor="ffffff" height="20">
														${memberList.m_id}</td>
													<td width=250 align="center" bgcolor="ffffff"
														style="padding-left: 10">${memberList.m_name}</td>
													<td width=350 align="center" bgcolor="ffffff"
														style="padding-left: 10">${memberList.m_pw}</td>
													<%-- <td width=150 align="center" bgcolor="ffffff"
														style="padding-left: 10">
														<a class="button logout" href="member_remove_action2?m_no=${memberList.m_no}&m_id=${memberList.m_id}&m_pw=${memberList.m_pw}"><i
														 class="fa fa-sign-out" ></i> 추방!!</a></td> --%>
													<td width="100" align="center" style="padding-left: 10">
														<input class="button" type="image"
														onclick="memberRemove('${memberList.m_no}','${memberList.m_id}','${memberList.m_pw}');" src="assets/img/kick.png" >
													</td>
													<td width="100" align="center" style="padding-left: 10">
														<input class="button" type="image"
														onclick="dd('${memberList.m_id}');"
														src="assets/img/ser.png">
													</td>
										</tr>
										</c:forEach>
									</table>
								</div>
							</fieldset>
						</form>

					</div>
				</div>
			</div>
		</div>
		<!-- / END CONTAINER
		==========================================-->
	</div>
	<!-- end /.wrapcontent -->
	<!-- CALL TO ACTION
		==========================================-->
	<jsp:include page="common_bottom.jsp"></jsp:include>

</body>
</html>
