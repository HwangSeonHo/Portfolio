<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="assets/js/jquery.validate.js" type="text/javascript"></script>
<script src="assets/js/messages_ko.js" type="text/javascript"></script>
<style type="text/css">
label.error {
	color: red;
}
</style>
<script type="text/javascript">
	/* function memberCreateAction() {
	
	 document.f2.method = "POST";
	 document.f2.action = "member_write_action";
	 document.f2.submit();
	
	 } */

	$(function() {
		$('#edd_login_form').validate({
			rules : {
				m_id : {
					required : true,

				},

				m_pw : {
					required : true,

				}
			},
			messages : {
				m_id : {
					required : "아이디를 입력하세요.",

				/* remote:$.validator.format('{0} 은 이미 사용중인 아이디입니다') */
				},
				m_pw : {
					required : "패스워드를 입력하세요.",

				}
			},
			onsubmit : true,
			submitHandler : function(form) {
				form.action = "login_action";
				form.submit();
			}
		});
	});
	$(function() {
		$('#edd_register_form').validate({
			rules : {
				m_id : {
					required : true,
					minlength : 2,
					maxlength : 10,
					remote : "member_id_check"
				},

				m_pw : {
					required : true,
					minlength : 2,
					maxlength : 10
				}

			},

			messages : {
				m_id : {
					required : "아이디를 입력하세요.",
					minlength : '{0} 글자이상 입력해하세요!!',
					maxlength : '{0} 글자이하 입력해하세요!!',
					remote : $.validator.format('{0} 은 이미 사용중인 아이디입니다')
				},
				m_pw : {
					required : "패스워드를 입력하세요.",
					minlength : '{0} 글자이상 입력해하세요!!',
					maxlength : '{0} 글자이하 입력해하세요!!'
				}

			},

			onsubmit : true,
			submitHandler : function(form) {
				form.action = "member_write_action";
				form.submit();
			}
		});
	});
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
						<h1>My Account</h1>
						<span class="wtnbreadcrumbs"><a href="index.jsp">Home</a> <span
							class="separator"></span> <span class="actual">My Account</span></span>
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
					<div class="col-md-12">
						<div class="wraplogin">
							<form name="f" id="edd_login_form" class="edd_form"
								action="login_action" method="post">
								<fieldset>
									<legend>Log into Your Account</legend>
									<p class="edd-login-username">
										<label for="edd_user_login">User ID</label> <input name="m_id"
											id="edd_user_login" class="edd-required edd-input"
											type="text"><br /> <font color="red">${MSG1}</font>
									</p>
									<p class="edd-login-password">
										<label for="edd_user_pass">Password</label> <input name="m_pw"
											id="edd_user_pass"
											class="edd-password edd-required edd-input" type="password"><br />
										<font color="red">${MSG2}</font>
									</p>
									<div id="msg"></div>

									<p class="edd-login-submit">
										<input id="edd_login_submit" type="submit"
											class="edd_submit edd-submit" value="Log In">
									</p>
									<p class="edd-lost-password">
										<a href="member_find_id_pass_form"> Lost Id and Pass? </a>
									</p>
								</fieldset>
							</form>
						</div>
						<span class="or">or</span>
						<div class="wrapregister">
							<form name="f2" id="edd_register_form" class="edd_form"
								method="post">
								<fieldset>
									<legend>Register New Account</legend>
									<p>
										<label for="m_name">Username</label> <input id="m_name"
											class="required edd-input" type="text" name="m_name">
									</p>
									<p>
										<label for="m_id">ID</label> <input id="m_id"
											class="required edd-input" type="text" name="m_id">
									</p>
									<p>
										<label for="m_pw">Password</label> <input id="m_pw"
											class="password required edd-input" type="password"
											name="m_pw">
									</p>
									<p>
										<label for="m_birth">BIRTH</label> <input id="m_birth"
											class="required edd-input" type="text" name="m_birth">
									</p>

									<p>
										<label for="m_gender">GENDER</label> Man<input type="radio"
											name="m_gender" value="Man" checked="checked"> Womon<input
											type="radio" name="m_gender" value="Women">

									</p>
									<p>
										<label for="m_gender">Like Food</label> <select name="c_no">
											<option value="1" selected="selected">한</option>
											<option value="2">일</option>
											<option value="3">중</option>
											<option value="4">양</option>
											<option value="5">기타</option>
										</select>

									</p>
									<p>
										<input class="button" name="edd_register_submit" type="submit"
											value="Register">
									</p>
								</fieldset>
							</form>
						</div>
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
</body>
</html>
