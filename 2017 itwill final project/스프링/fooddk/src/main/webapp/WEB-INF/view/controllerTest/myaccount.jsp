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

function logout(){
	/* 
	document.f.method = "POST";
	document.f.action = "member_login_action.do" */
	
	
}

</script>
</head>
<body>
<div id="wrapall">
	<div class="wrapcontent">
		<!-- Branding
    ==========================================-->
		<div class="headerimage text-center">
			<div class="headercontent big">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1>
							<!-- Logo -->
							<a class="navbar-brand-middle" href='index.jsp' rel='home'>
							<img alt="Lambada Pro - Easy Digital Downloads" src="assets/img/logo.png"/></a>
							</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Navigation
    ==========================================-->
		<nav id="wow-menu" class="navbar navbar-default">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</button>
			</div>
			<!-- Menu -->
			<div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
				<ul id="menu-main-nav" class="nav navbar-nav">
					<li class="current_page_item active"><a href="index.jsp">Home</a></li>
					<li class="menu-item-has-children dropdown"><a href="shop.jsp" class="dropdown-toggle" data-hover="dropdown">Shop <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="shop.jsp">All</a></li>
						<li><a href="category-pdf.jsp">pdf</a></li>
						<li><a href="category-book.jsp">book</a></li>
						<li><a href="category-logos.jsp">logos</a></li>
						<li><a href="category-photos.jsp">photos</a></li>
					</ul>
					</li>
					<li><a href="pricing.jsp">Pricing</a></li>
					<li><a href="product.jsp">Item</a></li>
					<li class="menu-item-has-children dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown">Pages <b class="caret"></b></a>
					<ul class="dropdown-menu depth_0">
						<li><a href="faq.jsp">FAQ</a></li>
						<li><a href="testimonials.jsp">Testimonials</a></li>
						<li><a href="columns.jsp">Columns & Buttons</a></li>
						<li class="dropdown menu-item-has-children dropdown-submenu">
						<a href="#" class="dropdown-toggle" data-hover="dropdown">Special</a>
						<ul class="dropdown-menu sub-menu">
							<li><a href="purchase-history.jsp">Purchase History</a></li>
							<li><a href="purchase-confirmation.jsp">Purchase Confirmation</a></li>
							<li><a href="user-account.jsp">User Account</a></li>
							<li><a href="license.jsp">License</a></li>
							<li><a href="tos.jsp">Terms of Use</a></li>
							<li><a href="privacy.jsp">Privacy Policy</a></li>
						</ul>
						</li>
					</ul>
					</li>
					<li><a href="blog.jsp">Blog</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a href="login_form.do">My Account</a></li>
					<li class="checkoutmenu"><a href="checkout.jsp"><i class="fa fa-shopping-cart"></i> (<span class="edd-cart-quantity">0)</span></a></li>
				</ul>
			</div>
		</div>
		</nav>

		<!-- PAGE HEADER
		==========================================-->
		<div class="headertitle">
			<div class="headercontent">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1>My Account</h1>
						    <span class="wtnbreadcrumbs"><a href="index.jsp">Home</a> <span class="separator">占쏙옙</span> <span class="actual">My Account</span></span>
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
										<legend>Log into Your Account</legend>
										<p class="edd-login-username">
											<label for="edd_user_login">User ID</label>
											<input name="m_id" id="edd_user_login" class="edd-required edd-input" type="text">
										</p>
										<p class="edd-login-password">
											<label for="edd_user_pass">Password</label>
											<input name="m_pw" id="edd_user_pass" class="edd-password edd-required edd-input" type="password">
										</p>
										<p class="edd-login-remember">
											<label><input name="rememberme" type="checkbox" id="rememberme" value="forever"> Remember Me</label>
										</p>
										<p class="edd-login-submit">
											<input id="edd_login_submit" type="submit" class="edd_submit edd-submit"  value="Log In">
										</p>
										<p class="edd-lost-password">
											<a href="#">
											Lost Id? </a>
										</p>
										<p class="edd-lost-password">
											<a href="#">
											Lost Password? </a>
										</p>
									</fieldset>
								</form>
							</div>
							<span class="or">or</span>
							<div class="wrapregister">
								<form id="edd_register_form" class="edd_form" action="#" method="post">
									<fieldset>
										<legend>Register New Account</legend>
										<p>
											<label for="edd-user-login">Username</label>
											<input id="edd-user-login" class="required edd-input" type="text" name="edd_user_login">
										</p>
										<p>
											<label for="edd-user-email">Email</label>
											<input id="edd-user-email" class="required edd-input" type="email" name="edd_user_email">
										</p>
										<p>
											<label for="edd-user-pass">Password</label>
											<input id="edd-user-pass" class="password required edd-input" type="password" name="edd_user_pass">
										</p>
										<p>
											<label for="edd-user-pass2">Confirm Password</label>
											<input id="edd-user-pass2" class="password required edd-input" type="password" name="edd_user_pass2">
										</p>
										<p>
											<input class="button" name="edd_register_submit" type="button" value="Register">
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
					2017 吏� All Rights Reserved, WowThemes.net </span>
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
