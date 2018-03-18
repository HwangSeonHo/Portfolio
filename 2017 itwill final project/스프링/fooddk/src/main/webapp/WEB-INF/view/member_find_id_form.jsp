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


function memberFindIdAction() {
	
	document.f.method = "POST";
	document.f.action = "member_find_id_action";
	document.f.submit();
	
}
	
function memberFindPassAction() {
	
	document.f2.method = "POST";
	document.f2.action = "member_find_pass_action";
	document.f2.submit();
	
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
							<h1>My Account</h1>
						    <span class="wtnbreadcrumbs"><a href="index.jsp">Home</a> <span class="separator">������������������</span> <span class="actual">My Account</span></span>
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
								<form name="f" id="edd_login_form" class="edd_form" action="login_action" method="post">
									<fieldset>
										<legend>Find Member ID</legend>
										<p class="edd-login-username">
											<label for="edd_user_login">ID</label>
											<input name="m_name" id="edd_user_login" class="edd-required edd-input" type="text" value="${m_id}">
										</p>
										
										<p class="edd-login-submit">
											<input id="edd_login_submit" onclick="memberFindIdAction();" type="submit" class="edd_submit edd-submit"  value="FIND ID">
										</p>
										
									</fieldset>
								</form>
							</div>
							<span class="or">or</span>
							<div class="wrapregister">
								<form name="f2" id="edd_register_form" class="edd_form" method="post">
									<fieldset>
										<legend>Find Member PASS</legend>
										<p>
											<label for="m_name">ID</label>
											<input id="m_name" class="required edd-input" type="text" name="m_name">
										</p>
										<p>
											<label for="m_id">NAME</label>
											<input id="m_id" class="required edd-input" type="text" name="m_id">
										</p>
										<p>
											<label for="m_birth">BIRTH</label>
											<input id="m_birth" class="required edd-input" type="text" name="m_birth">
										</p>
										
									<p class="edd-login-submit">
											<input id="edd_login_submit" onclick="memberFindIdAction();" type="submit" class="edd_submit edd-submit"  value="FIND PASS">
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
	<div id="lambadacalltoaction" class="actionbeforefooter text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					 This optional area appears before footer. Use it for discounts, messages, or anything else! <a target="_blank" class="actionbutton" href="index.jsp"><i class="fa fa-send-o"></i> Call to Action </a>
				</div>
			</div>
		</div>
	</div>
	<!-- FOOTER
		==========================================-->
	<footer id="lambadafooter" class="themefooter section medium-padding bg-graphite">
	<div class="container">
		<div class="section-inner row">
			<div class="column column-1 col-sm-3 rightbd">
				<div class="widgets">
					<div class="widget widget_text" id="text-2">
						<div class="widget-content">
							<div class="textwidget">
								<h2><a target="_blank" class="navbar-brand-middle" href="index.jsp">Lambada</a></h2>
								<p>
									 &nbsp;
								</p>
								<p>
									 You're currently viewing Lambada demo, an ecommerce HTML template created by <a href="https://www.wowthemes.net/">WowThemes.net.</a>
								</p>
							</div>
						</div>
						<div class="clear">
						</div>
					</div>
				</div>
			</div>
			<!-- /footer-a -->
			<div class="column column-1 col-sm-3 rightbd">
				<div class="widgets">
					<div class="widget widget_edd_categories_tags_widget">
						<div class="widget-content">
							<h3 class="widget-title">Products</h3>
							<ul class="edd-taxonomy-widget">
								<li><a href="category-book.jsp">book</a> (3) </li>
								<li><a href="category-logos.jsp">logos</a> (6) </li>
								<li><a href="category-pdf.jsp">pdf</a> (6) </li>
								<li><a href="category-photos.jsp">photos</a> (3) </li>
							</ul>
						</div>
						<div class="clear">
						</div>
					</div>
				</div>
			</div>
			<!-- /footer-b -->
			<div class="column column-1 col-sm-3">
				<div class="widgets">
					<div class="widget widget_recent_comments">
						<div class="widget-content">
							<h3 class="widget-title">Comments</h3>
							<ul id="recentcomments">
								<li>Wandikbo BL on <a href="#">Be cool, love nature</a></li>
								<li>Laura on <a href="#">Be cool, love nature</a></li>
								<li>Maria on <a href="#">Women & Charity</a></li>
							</ul>
						</div>
						<div class="clear">
						</div>
					</div>
				</div>
			</div>
			<!-- /footer-c -->
			<div class="column column-1 col-sm-3">
				<div class="widgets">
					<div class="widget widget_text" id="text-3">
						<div class="widget-content">
							<h3 class="widget-title">Follow Us</h3>
							<div class="textwidget">
								<p>
									<a href="#"><i class="fa fa-facebook"></i> Like us on Facebook</a>
								</p>
								<p>
									<a href="#"><i class="fa fa-twitter"></i> Follow us on Twitter</a>
								</p>
								<p>
									<a href="#"><i class="fa fa-google-plus"></i> Visit on Google Plus</a>
								</p>
							</div>
						</div>
						<div class="clear">
						</div>
					</div>
				</div>
			</div>
			<!-- /footer-d -->
			<div class="clearfix">
			</div>
		</div>
		<!-- /section-inner -->
	</div>
	<!-- /container -->
	</footer>
	<!-- /footer -->
	<div class="sectioncredits">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<span class="credits-left fleft">
					2017 癲ワ옙���뀐옙占썲��占� All Rights Reserved, WowThemes.net </span>
					<ul class="footermenu fright">
						<li class="current-menu-item"><a href="index.jsp">Home</a></li>
						<li><a href="shop.jsp">Shop</a></li>
						<li><a href="blog.jsp">Blog</a></li>
						<li><a href="contact.jsp">Contact</a></li>
					</ul>
				</div>
				<div class="clear">
				</div>
			</div>
		</div>
	</div>
	<!-- scripts -->
	<script type='text/javascript' src='assets/js/jquery.js'></script>
	<script type='text/javascript' src='assets/js/bootstrap.min.js'></script>
	<script type='text/javascript' src='assets/js/masonry.js'></script>
	<script type='text/javascript' src='assets/js/carousel.js'></script>
	<script type='text/javascript' src='assets/js/init.js'></script>
	<!-- end scripts -->
</div>
<!-- end /.wrapall -->
</body>
</html>
