<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
</head>
<body>


	<jsp:include page="common_top.jsp"></jsp:include>

	<!-- START CONTAINER
		==========================================-->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Section Recent Products
					==========================================-->
				<section class="lambada homerecentproducts">
					<div class="clear text-center">
						<div class="separatr">
							<h2 class="maintitle">
								Our Best Restaurent <a href="TastyList_Count" class="view-all">
								<span>Browseall</span></a>
							</h2>
						</div>
					</div>
					<div class="sectionlatestitems clear">
					 <c:forEach var="tasty" items="${ListPage.list}" varStatus="status">							
						<div class="wowitemboxinner">
							<div class="imagearea">
								<img src="${tasty.getT_img()}" style="width:100%; height:300px;">
								<div class="caption">
									<div class="blur"></div>
									<div class="caption-text">
										<div class="captionbuttons">
											<a href="TastyView?t_no=${tasty.t_no}"
												class="fa fa-link"></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="notesarea">
								<a href="TastyView?t_no=${tasty.t_no}" title="Learning Marketing">
									<h2>${tasty.t_title}</h2> <br/>
								</a>
								<div class="description">
									<p>${tasty.t_content }</p>
								</div>
								<!-- <div class="notesbottom variable">
									<div class="price fleft">$5.00 - $19.99</div>
									<div class="cart fright">
										<a href="#" class="edd-submit button green">Purchase</a>
									</div>
									<div class="clearfix"></div>
								</div> -->
							</div>
						</div>
							</c:forEach>
						
						
					
					<!-- .wowitemboxlist-->
				</section>
				<!-- Section Features
					==========================================-->
				
				<!-- Section Popular Products
					==========================================-->
				<section class="lambada homepopularproducts">
					<div class="clear text-center">
						<a href="recipe_list?c_no=0&&selectpage=1" class="view-all">
							<h2 class="maintitle">
								Our Best Recipe <span>Browse all</span>
							</h2>
						</a>
					</div>
					<div class="sectionpopularitems clear">
					<c:forEach var="hoogi" items="${ListPage1.list}" varStatus="status">
						<div class="wowitemboxinner">
							<div class="imagearea">
								<img src="${hoogi.getH_img()}"  style="width:100%; height:300px;" >
								<div class="caption">
									<div class="blur"></div>
									<div class="caption-text">
										<div class="captionbuttons">
											<a href="HoogiView_1?h_no=${hoogi.h_no}"
												class="fa fa-link"></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="notesarea">
								<a href="HoogiView_1?h_no=${hoogi.h_no}" title="Learning Marketing">
									<h2>${hoogi.h_title}</h2> <br/>
								</a>
								<div class="description">
									<p>${hoogi.h_content }</p>
								</div>
								<!-- <div class="notesbottom variable">
									<div class="price fleft">$3.99 - $19.99</div>
									<div class="cart fright">
										<a href="#" class="edd-submit button green">Purchase</a>
									</div>
									<div class="clearfix"></div>
								</div> -->
							</div>
						</div>
						</c:forEach>
						
						
				</section>
				<!-- Section Testimonials
					==========================================-->
				
				<!-- end Section Testimonials -->
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
