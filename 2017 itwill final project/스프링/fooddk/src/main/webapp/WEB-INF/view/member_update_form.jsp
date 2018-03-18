<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Lambada Template by WowThemes.net</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="assets/img/favicon.png"/>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css' type='text/css' media='all'/>
<link rel='stylesheet' href='assets/css/edd.css' type='text/css' media='all'/>
<link rel='stylesheet' href='assets/css/bootstrap.min.css' type='text/css' media='all'/>
<link rel='stylesheet' href='style.css' type='text/css' media='all'/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Covered+By+Your+Grace'/>
<script type="text/javascript">
function memberModifyAction() {

	document.f.method = "POST";
	document.f.action = "member_modify_action";
	document.f.submit();
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
						    <span class="wtnbreadcrumbs"><a href="index.jsp">Home</a> <span class="separator">������</span> <span class="actual">User Account</span></span>
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
							<span class="smalltitle">Profile Editor</span>
							<form name="f" id="edd_profile_editor_form" class="edd_form" action="#" method="post">
								<input type="hidden" name="m_no" value="${member.m_no}">
								<fieldset id="edd_profile_personal_fieldset">
									<legend id="edd_profile_name_label">Change your INFO</legend>
									<p id="edd_profile_first_name_wrap">
										<label for="m_name">NAME</label>
										<input name="m_name" id="edd_first_name" class="text edd-input" type="text" value="${member.m_name}">
									</p>
									<p id="edd_profile_first_name_wrap">
										<label for="edd_first_name">ID</label>
											<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${member.m_id}</td>
									</p>
									
									<p id="edd_profile_first_name_wrap">
										<label for="m_birth">BIRTH</label>
										<input name="m_birth" id="edd_first_name" class="text edd-input" type="text" value="${member.m_birth}">
									</p>
									
								<fieldset id="edd_profile_password_fieldset">
									<legend id="edd_profile_password_label">Change your Password</legend>
									<p id="edd_profile_password_wrap">
										<label for="m_pw">New Password</label>
										<input name="m_pw" id="edd_new_user_pass1" class="password edd-input" type="password">
									</p>
									
								</fieldset>
								<fieldset id="edd_profile_submit_fieldset">
									<p id="edd_profile_submit_wrap">
										<input name="edd_profile_editor_submit" onclick="memberModifyAction();" id="edd_profile_editor_submit" type="submit" class="edd_submit edd-submit" value="Save Changes">
									</p>
								</fieldset>
							</form>
							<!-- #edd_profile_editor_form -->
							
						</div>
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
<!-- end /.wrapall -->
</body>
</html>
