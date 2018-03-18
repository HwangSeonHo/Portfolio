<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<script src="js/recipe.js"></script>
<style type="text/css">
.suggest {
	border: 1px dotted blue;
	width: 160px;
	display: none;
}
</style>
<script type="text/javascript" src='assets/js/httpRequest.js'></script>
<script type="text/javascript" src="assets/js/ajax.js"></script>
<script type="text/javascript">
	/* function sendKeyWord(){
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
	} */
	/* function select(selectKeyword){
		document.searchF.keyword.value=selectKeyword;
		hideSuggestDiv();
		//document.searchF.submit();
		
	}
	function showSuggestDiv(){
		document.getElementById('suggest').style.display='block';
	}
	function hideSuggestDiv(){
		document.getElementById('suggest').style.display='none';
	} */
</script>
</head>
<body>

	<jsp:include page="common_top.jsp"></jsp:include>
	<!-- PAGE HEADER
		==========================================-->

	<div class="headertitle">
		<div class="headercontent" class="col-md-8">
			<c:if test="${c_no==0}">
				<h1>Recipe All Category</h1>
				<br />
			</c:if>
			<c:if test="${c_no==1}">
				<h1>Korean Food Recipe</h1>
				<br />
			</c:if>
			<c:if test="${c_no==2}">
				<h1>Japanese Food Recipe</h1>
				<br />
			</c:if>
			<c:if test="${c_no==3}">
				<h1>Chinese Food Recipe</h1>
				<br />
			</c:if>
			<c:if test="${c_no==4}">
				<h1>Western Food Recipe</h1>
				<br />
			</c:if>
			<c:if test="${c_no==5}">
				<h1>ETC.</h1>
			</c:if>



		</div>




	</div>
	</div>
	</div>



	<!-- START CONTAINER
		==========================================-->
	<form name="r" method="post" action="recipe_write_form">
		<div class="taxonomydownloadcategoryphp">
			<div class="container">
				<div class="row">

					<div class="col-md-12">
						<div class="wowitemboxlist">
							<c:forEach var="dlist" items="${DList}"
								varStatus="status">

								<div class="wowitembox col-md-4">
									<div class="wowitemboxinner">
										<div >
											<img src="${dlist.developer_profil}"
												style="width: 100%; height: 400px;">

											<div class="caption">
												<div class="blur"></div>
												<div class="caption-text">
													<div class="captionbuttons">

														<a href="developer_view?developer_no=${dlist.developer_no}"
															class="captiondetails"><i class="fa fa-link"></i></a>
													</div>
												</div>
											</div>
										</div>
										<div class="notesarea">
											
											<a href="developer_view?developer_no=${dlist.developer_no}"
												title="${dlist.developer_name}">
												<h2>${dlist.developer_name}
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2>
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

					</div>

					<!-- 	<input type="submit" value="Write"> -->

					<div class="cart fright" align="center">

						<h1>
							<a href="recipe_write_form" class="edd-submit button blue">Write</a>
						</h1>

					</div>







				</div>
			</div>
		</div>
	</form>

	<!-- / END CONTAINER
		==========================================-->


	<!-- end /.wrapcontent -->
	<!-- CALL TO ACTION
		==========================================-->
	<jsp:include page="common_bottom.jsp"></jsp:include>

</body>
</html>
