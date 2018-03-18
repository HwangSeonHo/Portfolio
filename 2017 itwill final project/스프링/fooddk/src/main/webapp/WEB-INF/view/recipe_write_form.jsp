<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Hoogi"%>
<%@page import="fooddk.paging.ListResultBean"%>
<%@page import="fooddk.paging.ListPageConfigBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
#map {
	height: 400px;
	width: 100%;
}
</style>

 <script src="assets/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.validate.js" type="text/javascript"></script>
<script src="assets/js/messages_ko.js" type="text/javascript"></script>
<script type="text/javascript" src='assets/js/httpRequest.js'></script>
<script type="text/javascript" src="assets/js/ajax.js"></script>
<script type="text/javascript">
			function sendKeyWord(){
				var keyword = document.searchF.keyword.value;
			//	alert(keyword);
				if(keyword==null || keyword==''){
					hideSuggestDiv();
					return;
				}
				keyword=window.encodeURI(keyword);
				
				var r=new ajax.xhr.Request(
							"recipe_title_json", 
							"r_title="+keyword, 
							displaySuggest, 
							'GET');
				
				
			}
			function displaySuggest(xhr){
				
				if(xhr.readyState==4){
					/*
					CSV형식
					3|AJAX,AJAX 실전 프로그래밍,AJA
					*/
					var resultCSV = xhr.responseText;
					//alert(resultCSV);
					//Json객체로 만들기
					var resultJson = JSON.parse(resultCSV);
					//Object의 길이 구하기
					var length = Object.keys(resultJson).length;
					var html="";
					
					for(var i=0; i<length; i++){
						var keywordObject= resultJson[i]; //객체 한개
						var keywordvalue =  keywordObject.r_title; //한 객체의 키로 꺼낸 값
						var r_no=keywordObject.r_no;
						//html+=keywordvalue+"<br/>";
					//	alert(r_no);
						html+="<a href=recipe_detail?r_no="+r_no+">"+keywordvalue+"</a><br/>";
					}
			
					document.getElementById('suggestList').innerHTML=html;
					 showSuggestDiv(); 
				
				}
			}
			 function select(selectKeyword){
				document.searchF.keyword.value=selectKeyword;
				hideSuggestDiv();
				//document.searchF.submit();
				
			}
			function showSuggestDiv(){
				document.getElementById('suggest').style.display='block';
			}
			function hideSuggestDiv(){
				document.getElementById('suggest').style.display='none';
			} 
	
	$(function() {
		$('#commentform').validate({
			rules : {
				r_title : {
					required : true,
					minlength : 2,
					maxlength : 20
				},
				r_content : {
					required : true,
					minlength : 2,
					maxlength : 100
				},
			c_no : {
				required : true
			}
			},
			messages : {
				r_title : {
					required : "제목을 입력해 주세요",
					minlength : "{0} 글자이상 입력해주세요",
					maxlength : "{0} 글자 이하 입력해 주세요"
				},
				r_content : {
					required : "내용을 입력해 주세요",
					minlength : "{0} 글자이상 입력해주세요",
					maxlength : "{0} 글자 이하 입력해 주세요"
				},
				c_no : {
					required : "좋아하는 음식을 입력해 주세요"
				}
			
				},
			
			onsubmit : true,
			submitHandler : function(form) {
				form.action = "recipe_write_form_action";
				form.method = "POST";
				form.submit();
				
			}
		});
	});

/* 	 function recipeWrite() {
		if(z.r_title.value==""){
			alert("제목을 입력해 주세요");
			z.r_title.focus();
			return false;
		}
		if(z.r_content.value==""){
			alert("내용을 입력해 주세요");
			z.r_content.focus();
			return false;
		}
		
		if(z.c_no.value==6){
			alert("종류를 선택해 주세요");
			z.c_no.focus();
			return false;
		} 
		
	 	if (window.confirm("등록하시겠습니까?"))  
		document.z.action = "recipe_write_form_action";
		document.z.method = "post";
		document.z.submit();
	}  */
</script>

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

	<!-- PAGE HEADER
		==========================================-->
	<div class="headertitle">
		<div class="headercontent">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>Recipe Write Form</h1>
						<span class="wtnbreadcrumbs"><a href="index.jsp"></a> <span
							class="separator"></span> <!-- 	 <span class="wtnbreadcrumbs"><a href="recipe_list?c_no=0">Back List /</a> </span>
									 <span class="wtnbreadcrumbs"><a href="recipe_write_form_action">Write</a> </span> -->

							<!-- 	<a class="brcat"href="#">back list /</a> 
									<a class="brcat" href="#">write</a> 
									<a class="brcat" href="#"></a>
									 <a class="brcat" href="#"></a><span class="separator"></span>  -->
							<span class="actual">Recipe Write Form</span></span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- START CONTAINER
		==========================================-->
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div id="primary" class="content-area">
					<main id="main" class="site-main whiteboxed" role="main">
					<div class="wrapindexcerpt">
						<div class="contenttext">
							<div class="post-content">

								<div id="comments" class="comments-area">

									<div id="respond" class="comment-respond">
										<div align="left">
											<h2 id="reply-title" class="comment-reply-title">write
												form</h2>
										</div>
										<!-- <small>	<a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display: none;">Cancel Reply</a></small> -->
										<form name="z" method="post" id="commentform"	class="comment-form" enctype="multipart/form-data">
											<!-- <input type="hidden" name="m_no" value=""> -->
											<p class="comment-notes"></p>
											<div class="row commentrow comment-form-comment">
												<div class="row">


													<div class="col-md-8 comment-form-author" align="left">

														<label for="r_title">Title</label> 
														<input type="text" name="r_title"> <br>
													</div>
													
													<div class="col-md-4 comment-form-email">
														<label for="c_no">c_no</label> <select name="c_no"
															id="data">
															<option value="">종류를 선택해 주세요</option>
															<option value="1">한</option>
															<option value="2">일</option>
															<option value="3">중</option>
															<option value="4">양</option>
															<option value="5">기타</option>

														</select>
														<noscript>
															<input type="submit" value="Submit">
														</noscript>

													</div>

												</div>



												<div class="col-md-12">
													<label for="r_content">Content</label>
													<textarea wrap="soft" style="width: 700px" rows="10"
														name="r_content"></textarea>
													<br>

												</div>
												<div class="col-md-4 comment-form-email">
													<!-- <label for="r_img">IMG</label>  -->
													 <input type="hidden"	name="r_img" value=" "> 
												File upload	<input type="file" name="file"> <br />
												</div>

												<br />
											</div>
											<div>
												<input type="submit" rel="tag" value="Write">
												<input type="reset" rel="tag" value="Reset" class="button">
											</div>



										
										</form>
									</div>
									<!-- #respond -->
								</div>

						
							</div>
							<div class="clearfix"></div>
						</div>
					</div>

					<!-- <div class="clearfix"></div>
						嶺�占썲��占� <a href="#" rel="prev">Create a monetized blog</a> &nbsp;
						&nbsp; <a href="#" rel="next">Live, Love &amp; Hope</a> 勇�琉���
						<div class="clearfix"></div> --> <%-- <div id="comments" class="comments-area">
							<div id="respond" class="comment-respond">
								<h3 id="reply-title" class="comment-reply-title">Questions &amp; Feedback <small><a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Cancel Reply</a></small></h3>
								<form action="#" method="post" id="commentform" class="comment-form">
									<p class="comment-notes">
									</p>
									<div class="row commentrow comment-form-comment">
									<div class="row">
										<div class="col-md-4 comment-form-author">
											<label for="author">Name</label><input id="author" name="author" type="text" value="" size="30" aria-required="true">
											${hoogi.getH_title()}
										</div>
										<div class="col-md-4 comment-form-email">
											<label for="email">IMG</label><input id="email" name="email" type="text" value="" size="30" aria-required="true">
											${hoogi.getH_img()}
										</div>
										<!-- <div class="col-md-4 comment-form-url">
											<label for="url">Website</label><input id="url" name="url" type="text" value="" size="30">
										</div> -->
									</div>
										<div class="col-md-12">
											<label for="comment">Comment</label><textarea id="comment" name="comment" rows="5" aria-required="true">
											${hoogi.getH_content()}
											</textarea>
										</div>
									</div>
									
									<p class="form-submit">
										<input name="submit" type="submit" id="submit" class="submit" value="Submit"><input type="hidden" name="comment_post_ID" value="43" id="comment_post_ID">
										<input type="hidden" name="comment_parent" id="comment_parent" value="0">
									</p>
									<noscript>
									</noscript>
								</form>
							</div>
							<!-- #respond -->
						</div> --%> </main>
					<!-- #main -->
				</div>
				
				<!-- #primary -->
			</div>
			
		
			
			<h5>search</h5><hr/>
				<form action="search_result.jsp" name="searchF" class="col-md-4" >
					<input type="text" name="keyword" onkeyup="sendKeyWord();" placeholder="Type and click..."  >&nbsp;<!-- <input type="submit" value="search"> -->
					<div id="suggest" class="suggest">
					</div>
				</form>
						<div id="suggestList"  class="col-md-2">
							
						</div>
				
				
		<!-- 	<div class="col-md-4">
				<h3>My Google Maps Demo</h3>
				<div id="map">111</div>
				<script type="text/javascript">
					function initMap() {
						var uluru =  {lat: 37.555445, lng: 126.929166};
				        var map = new google.maps.Map(document.getElementById('map'), {
				          zoom: 15,
				          center: uluru
				        });

				        var contentString = '<div>'+'<h2>강남역</h2>'+'<p>강남역입니당</p>'+'</div>';

				        var infowindow = new google.maps.InfoWindow({
				          content: contentString
				        });

				        var marker = new google.maps.Marker({
				          position: uluru,
				          map: map,
				          title: 'Uluru (Ayers Rock)'
				        });
				        marker.addListener('click', function() {
				          infowindow.open(map, marker);
				          location.href="member_main";
				        });
				      }
				</script>


				<script async defer
					src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCe79ndtoPiG3-yXC3Jjqj-ZST7IvU8f9o&callback=initMap">
					
				</script> -->
</body>
<!-- <div id="secondary" class="widget-area q2w3-fixed-widget-container"
	role="complementary">
	<aside class="widget widget_search">
		<form role="search" method="get" class="search-form" action="#">
			<input type="search" class="search-field"
				placeholder="Type and hit enter..." value="" name="s" title="">
			<input type="hidden" name="post_type" value="post">
		</form>
	</aside>
	<aside class="widget widget_recent_entries">
							<h2 class="widget-title section-title">
								<span>Recent Posts</span>
							</h2>
							<ul>
								<li><a href="article.jsp">Learning Marketing</a></li>
								<li><a href="article.jsp">Only Sky is the Limit</a></li>
								<li><a href="article.jsp">Be cool, love nature</a></li>
								<li><a href="article.jsp">Live, Love &amp; Hope</a></li>
								<li><a href="article.jsp">Confidence is Key</a></li>
							</ul>
						</aside>
	fixed widget
	<aside id="categories-2" class="widget widget_categories">
							<h2 class="widget-title section-title">
								<span>Topics</span>
							</h2>
							<ul>
								<li><a href="#">Business</a> (4)</li>
								<li><a href="#">Life</a> (3)</li>
								<li><a href="#">Marketing</a> (5)</li>
								<li><a href="#">Media</a> (2)</li>
								<li><a href="#">News</a> (12)</li>
								<li><a href="#">Psychology</a> (3)</li>
								<li><a href="#">Stories</a> (6)</li>
								<li><a href="#">Travel</a> (4)</li>
							</ul>
						</aside>
					</div>
	#secondary
</div> -->
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
		</div>
	</div>
</div>
<!-- FOOTER
		==========================================-->
<jsp:include page="common_bottom.jsp"></jsp:include>
</body>
</html>
