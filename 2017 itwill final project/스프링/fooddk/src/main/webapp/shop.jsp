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
					<li><a href="myaccount.jsp">My Account</a></li>
					<li class="checkoutmenu"><a href="checkout.jsp"><i class="fa fa-shopping-cart"></i> (<span class="edd-cart-quantity">0)</span></a></li>
				</ul>
			</div>
		</div>
		</nav>
		<!-- START CONTAINER
		==========================================-->
		<div class="container">
			<div class="row padtop40 padbot20">
				<div class="col-md-12">
					<span class="pagesit fleft">
					<span class="wtnbreadcrumbs"><a href="index.jsp">Home</a> <span class="separator">��</span> <span class="actual">Shop</span></span>
					</span>
					<div class="sortitemsarea fright">
						<form method="GET" class="wowsortitems">
							<select name="data" id="data" onchange="this.form.submit()">
								<option value="1">Sort by newest</option>
								<option value="2">Sort by price: low to high</option>
								<option value="3">Sort by price: high to low</option>
								<option value="4">Sort by popularity</option>
								<option value="5">Sort by oldest</option>
								<option value="6">Sort by comments</option>
								<option value="7">Sort alphabetically</option>
							</select>
							<noscript>
							 &lt;input type="submit" value="Submit"&gt;
							</noscript>
						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="wowitemboxlist">
						<div class="wowitembox col-md-4">
							<div class="wowitemboxinner">
								<div class="imagearea">
									<img src="assets/img/demo/d3-4.jpg" alt="">
									<div class="caption">
										<div class="blur">
										</div>
										<div class="caption-text">
											<div class="captionbuttons">
												<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="notesarea">
									<a href="product.jsp" title="Image File">
									<h2>Image File</h2>
									</a>
									<div class="description">
										<p>
											This is a short excerpt to generally describe what the item is about.
										</p>
									</div>
									<div class="notesbottom variable">
										<div class="price fleft">
											 $5.00 - $19.99
										</div>
										<div class="cart fright">
											<a href="#" class="edd-submit button green">Purchase</a>
										</div>
										<div class="clearfix">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- .wowitembox-->
						<div class="wowitembox col-md-4">
							<div class="wowitemboxinner">
								<div class="imagearea">
									<img src="assets/img/demo/d5-3.jpg" alt="">
									<div class="caption">
										<div class="blur">
										</div>
										<div class="caption-text">
											<div class="captionbuttons">
												<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="notesarea">
									<a href="product.jsp" title="Menu Brochure">
									<h2>Menu Brochure</h2>
									</a>
									<div class="description">
										<p>
											This is a short excerpt to generally describe what the item is about.
										</p>
									</div>
									<div class="notesbottom">
										<div class="price fleft">
											 $18.00
										</div>
										<div class="cart fright">
											<a href="#" class="edd-submit button green">Purchase</a>
										</div>
										<div class="clearfix">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- .wowitembox-->
						<div class="wowitembox col-md-4">
							<div class="wowitemboxinner">
								<div class="imagearea">
									<img src="assets/img/demo/d6-1.jpg" alt="">
									<div class="caption">
										<div class="blur">
										</div>
										<div class="caption-text">
											<div class="captionbuttons">
												<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="notesarea">
									<a href="product.jsp" title="Learning Ebook">
									<h2>Learning Ebook</h2>
									</a>
									<div class="description">
										<p>
											This is a short excerpt to generally describe what the item is about.
										</p>
									</div>
									<div class="notesbottom variable">
										<div class="price fleft">
											 $23.00 - $54.50
										</div>
										<div class="cart fright">
											<a href="#" class="edd-submit button green">Purchase</a>
										</div>
										<div class="clearfix">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- .wowitembox-->
						<div class="wowitembox col-md-4">
							<div class="wowitemboxinner">
								<div class="imagearea">
									<img src="assets/img/demo/d7-1.jpg" alt="">
									<div class="caption">
										<div class="blur">
										</div>
										<div class="caption-text">
											<div class="captionbuttons">
												<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="notesarea">
									<a href="product.jsp" title="Some Plugin">
									<h2>Some Plugin</h2>
									</a>
									<div class="description">
										<p>
											This is a short excerpt to generally describe what the item is about.
										</p>
									</div>
									<div class="notesbottom">
										<div class="price fleft">
											 $45.00
										</div>
										<div class="cart fright">
											<a href="#" class="edd-submit button green">Purchase</a>
										</div>
										<div class="clearfix">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- .wowitembox-->
						<div class="wowitembox col-md-4">
							<div class="wowitemboxinner">
								<div class="imagearea">
									<img src="assets/img/demo/d3-1-1.jpg" alt="">
									<div class="caption">
										<div class="blur">
										</div>
										<div class="caption-text">
											<div class="captionbuttons">
												<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="notesarea">
									<a href="product.jsp" title="Astrology E-book">
									<h2>Astrology E-book</h2>
									</a>
									<div class="description">
										<p>
											This is a short excerpt to generally describe what the item is about.
										</p>
									</div>
									<div class="notesbottom variable">
										<div class="price fleft">
											 $11.99 - $19.99
										</div>
										<div class="cart fright">
											<a href="#" class="edd-submit button green">Purchase</a>
										</div>
										<div class="clearfix">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- .wowitembox-->
						<div class="wowitembox col-md-4">
							<div class="wowitemboxinner">
								<div class="imagearea">
									<img src="assets/img/demo/d9.jpg" alt="">
									<div class="caption">
										<div class="blur">
										</div>
										<div class="caption-text">
											<div class="captionbuttons">
												<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
											</div>
										</div>
									</div>
								</div>
								<div class="notesarea">
									<a href="product.jsp" title="City Photo">
									<h2>City Photo</h2>
									</a>
									<div class="description">
										<p>
											This is a short excerpt to generally describe what the item is about.
										</p>
									</div>
									<div class="notesbottom variable">
										<div class="price fleft">
											 $3.99 - $19.99
										</div>
										<div class="cart fright">
											<a href="#" class="edd-submit button green">Purchase</a>
										</div>
										<div class="clearfix">
										</div>
									</div>
								</div>
							</div>
							<!-- .wowitemboxinner-->
						</div>
						<!-- .wowitembox-->
					</div>
					<div class="clear">
					</div>
					<div class="pagination">
						<span class="current">1</span><a href="#" class="inactive">2</a>
					</div>
					<div class="clear">
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
					2017 짤 All Rights Reserved, WowThemes.net </span>
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
