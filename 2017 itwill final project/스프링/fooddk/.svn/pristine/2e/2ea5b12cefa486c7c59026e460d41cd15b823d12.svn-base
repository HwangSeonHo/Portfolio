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
<script src="assets/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
	
	$(function() {
		$('#savebutton').click(function() {
		
			$.ajax({
				url : 'member_modify_action2',
				method : 'POST',
				data : $('#edd_profile_editor_form').serialize(),
				success : function(){
					window.opener.refresh();
					window.close();
				}
			});
		});	
	});
	
	
	
	
</script>
</head>
<body>
	<div class="templatemyaccount">
		<div class="container">
			<div class="row">

				<div class="col-md-6">
					<form name="f" id="edd_profile_editor_form" class="edd_form"
						method="post">
						<input type="hidden" name="m_no" value="${member.m_no}"> <input
							type="hidden" name="m_id" value="${member.m_id}">
						<fieldset id="edd_profile_personal_fieldset">
							<legend id="edd_profile_name_label">MEMBER INFO</legend>

							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">NAME</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_name}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">ID</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_id}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">BIRTH</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_birth}</td>
							</p>

							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">PASSWORD</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_pw}</td>
							</p>

							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">GENDER</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${member.m_gender}</td>
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
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">KIND FOOD</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${ckind}</td>
							</p>
							<p id="edd_profile_first_name_wrap">
								<label for="edd_first_name">MANAGE</label>
								<td width=490 bgcolor="ffffff" align="left"
									style="padding-left: 10px">${manager}</td>
							</p>

							<p>
								<label for="m_manager">Change manager</label> <select
									name="m_manager" id="m_manager">
									<option value="0" selected="selected">일반회원</option>
									<option value="1">매니저</option>
									<option value="2">운영자</option>
								</select>

							</p>


							<fieldset id="edd_profile_submit_fieldset">
								<p id="edd_profile_submit_wrap">
									<input type="button" id="savebutton" value="SaveChanges">
									<!-- <input name="edd_profile_editor_submit"
										 id="edd_profile_editor_submit"
										type="button" class="edd_submit edd-submit"
										value="Save Changes"> -->
								</p>
							</fieldset>
					</form>
					<!-- #edd_profile_editor_form -->

				</div>
			</div>

		</div>
	</div>


</body>
</html>
