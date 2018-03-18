<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<script	src="js/recipe.js"></script>

</head>
<body>

<jsp:include page="common_top.jsp"></jsp:include>
		<!-- PAGE HEADER
		==========================================-->
		
			<div class="headertitle">
				<div class="headercontent">
							
							<h1>Search Recipe List</h1>
					<div class="container">
						<div class="row">
							<!-- <h1>Recipe All Category</h1> -->
							<div class="col-md-12">
								 <span class="separator"></span>
								 <a href="recipe_list?c_no=1&&selectpage=${listResultBean.selectPageNo}">korea / </a>
								<span class="separator"></span>
								 <a href="recipe_list?c_no=2&&selectpage=${listResultBean.selectPageNo}">japan / </a>
								<span class="separator"></span>
								 <a href="recipe_list?c_no=3&&selectpage=${listResultBean.selectPageNo}">china / </a> 
								<span class="separator"></span>
								 <a href="recipe_list?c_no=4&&selectpage=${listResultBean.selectPageNo}">western / </a>
								<span class="separator"></span> 
								<a href="recipe_list?c_no=5&&selectpage=${listResultBean.selectPageNo}">etc  </a>
							</div>
				<div class="cart fright" align="center">
					<h1><a href="recipe_write_form" class="edd-submit button blue">Write</a></h1>
				</div>
						</div>
					</div>
				</div>
			</div>
			
		
		<!-- START CONTAINER
		==========================================-->
		<form name="r" method="post">
		<div class="taxonomydownloadcategoryphp">
			<div class="container">
				<div class="row">
				
					<div class="col-md-12">
						<div class="wowitemboxlist" >					
						<c:forEach var="recipelist" items="${searchList}" varStatus="status">
							
							<div class="wowitembox col-md-4">
								<div class="wowitemboxinner">
									<div class="imagearea">
										<img src="${recipelist.r_img}" style="width:100%; height:400px;">
										
										<div class="caption">
											<div class="blur">
											</div>
											<div class="caption-text">
												<div class="captionbuttons">
													
													<a href="recipe_detail?r_no=${recipelist.r_no}"  class="captiondetails"><i class="fa fa-link"></i></a>
												</div>
											</div>
										</div>
									</div>
									<div class="notesarea">
										
										<a href="recipe_detail?r_no=${recipelist.r_no}"  title="${recipelist.r_title}" >
										<h2>${recipelist.r_title}
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${recipelist.r_date.toString().substring(0,10)}</h2>
										</a>
									
										
												
											
									<%-- 	<div class="description">
											
											<p>
											<c:if test="${recipelist.r_content.length()>=10}">
												${recipelist.r_content.substring(0, 10)} ... &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
											</c:if>
											
											<c:if test="${recipelist.r_content.length()<10}">
												${recipelist.r_content}  &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
											</c:if>
											
											
												<a class="readmore" href="recipe_detail?r_no=${recipelist.r_no}">Read More</a>
												
											</p>
										</div> --%>
										 <%-- <div class="notesbottom">
											<div class="price fleft">
												 ${recipelist.r_count}
											</div>
											<div class="cart fright">
												${recipelist.r_date}
											</div>
											<div class="clearfix">
											</div>
										</div>  --%>
									</div>
								</div>
								<!-- .wowitemboxinner-->
							</div>
							</c:forEach>
									
						</div>
				
				<!-- 	<div class="c12">
					</div> -->
				
	<%-- 			<div class="row" align="center">
			<div class="col-md-12 pagination">
				<div class="col-md-12">
				<c:if test="${listResultBean.isShowFirst()}">
					<a href="recipe_list?c_no=${c_no}&&selectPage=1">first </a>&nbsp;
				</c:if>
				<c:if test="${listResultBean.isShowPreviousGroup()}"> 
				 <a href="recipe_list?c_no=${c_no}&&selectPage="${listResultBean.previousGroupStartPageNo}></a>prev</c:if>
				
				
				<c:forEach begin="${listResultBean.startPageNo }" end="${listResultBean.endPageNo}"  varStatus="status">
					<c:if test="${listResultBean.selectPageNo==status.index}">
					<span class="current">${status.index}</span>
							<font color='red'>
								<a href="recipe_list?c_no=${c_no}&&selectPage=${status.index}">${status.index}</a>
							</font>
							</c:if>
							<c:if test="${listResultBean.selectPageNo!=status.index}">
							<a href="recipe_list?c_no=${c_no}&&selectPage=${status.index}"
												class="inactive">${status.index}</a> &nbsp; 
								<a href="recipe_list?c_no=${c_no}&&selectPage=${status.index}"> ${status.index} </a>
							</c:if>
				</c:forEach>
				
				<c:if test="${listResultBean.isShowNextGroup()}">
					<a href="recipe_list?c_no=${c_no}&&selectPage="${listResultBean.nextGroupStartPageNo}></a>next
				</c:if>
				
				<c:if test="${listResultBean.isShowLast()}">
					<a href="recipe_list?c_no=${c_no}&&selectPage=${listResultBean.totalPageCount}">last</a>
				</c:if>
			</div>
		</div>
				
	</div>  --%>
		</div>
				
				
				
				
				
				
				
				
				</div>
			</div>
		</div>
		 </form>
		<!-- / END CONTAINER
		
		
		==========================================-->
		<%-- <div class="row" align="center">
			<div class="col-md-12 pagination">
				<div class="col-md-12">
				<c:if test="${listResultBean.isShowFirst()}">
					<a href="/recipe_list?selectPage=1">first </a>&nbsp;
				</c:if>
				<c:if test="${listResultBean.isShowPreviousGroup()}"> 
				 <a href="/recipe_list?selectPage="${listResultBean.previousGroupStartPageNo}></a>◀</c:if>
				
				
				<c:forEach var="pageNo" begin="${listResultBean.startPageNo }" end="${listResultBean.endPageNo}"  varStatus="status">
					<c:if test="${listResultBean.selectPageNo==status.index}">
							<font color='red'>
								<a href="recipe_list?c_no=${c_no}&&selectPage=${status.index}">${status.index}</a>
							</font>
							</c:if>
							<c:if test="${listResultBean.selectPageNo!=status.index}">
								<a href="recipe_list?c_no=${c_no}&&selectPage=${status.index}"> ${status.index} </a>
							</c:if>
				</c:forEach>
				
				<c:if test="${listResultBean.isShowNextGroup() }">
					<a href="/recipe_list?selectPage="${listResultBean.nextGroupStartPageNo}></a>▶
				</c:if>
				
				<c:if test="${listResultBean.isShowLast()}">
					<a href="/recipe_list?selectPage=${listResultBean.totalPageCount}">▶▶</a>
				</c:if>
			</div>
		</div>
				
	</div> --%>
		
	
	<!-- end /.wrapcontent -->
	<!-- CALL TO ACTION
		==========================================-->
	<jsp:include page="common_bottom.jsp"></jsp:include>
</body>
</html>
