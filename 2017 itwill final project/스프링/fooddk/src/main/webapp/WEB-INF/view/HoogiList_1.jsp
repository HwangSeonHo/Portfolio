<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Hoogi"%>
<%@page import="fooddk.paging.ListResultBean"%>
<%@page import="fooddk.paging.ListPageConfigBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	//HoogiService hoogservice = new HoogiService();
	/* HoogiServiceImpl hoogiServiceImpl = new HoogiServiceImpl();
	
	List<Hoogi> hoogiList = hoogiServiceImpl.selectAll(); */
	request.setCharacterEncoding("EUC-KR");

	/*    //1.요청페이지번호   
	   String pageno = request.getParameter("pageno");//페이징번호
	   if (pageno == null || pageno.equals("")) {
	      pageno = "1";
	   }
	   //2.한페이지에표시할 게시물수 
	   int rowCountPerPage = 7;
	   //3.한페이지에보여줄 페이지번호갯수(<< 1 2 3 4 5 >>)
	   int pageCountPerPage = 3;
	   //페이징(계산)을위한DTO
	   ListPageConfigBean pageConfig = new ListPageConfigBean(rowCountPerPage, pageCountPerPage, pageno, "", "");
	   //게시물조회
	   ListResultBean HoogiListPage = HoogiService.
	
	 */
%>
<!DOCTYPE html>
<html lang="en">
<!-- 아작스 -->
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
	function sendKeyWord() {
		var keyword = document.searchF.keyword.value;
		//alert(keyword); 
		if (keyword == null || keyword == '') {
			hideSuggestDiv();
			return;
		}

		keyword = window.encodeURI(keyword);
		/* sendRequest("09.suggest.jsp", "keyword=" + keyword, displaySuggest,
				'GET'); */
		var r = new ajax.xhr.Request("Hoogi_title_json", "h_title=" + keyword,
				displaySuggest, 'GET');
		
	}

	function displaySuggest(xhr) {
		if (xhr.readyState == 4) {
			/*
			CSV형식
			3|AJAX,AJAX 실전 프로그래밍,AJA
			 */
			//responseText로 받아온걸 JSON 객체로 만들어야함
			
			var resultCSV = xhr.responseText;
			
			
			
			//alert(resultCSV);
			//resultCSV JSON객체로 받아오기
			var resultJson = JSON.parse(resultCSV);

			var length = Object.keys(resultJson).length;
			//alert(length);
			var html= "";
			for (var i=0; i<length; i++) {
				var keywordObject = resultJson[i]; //객체 한개
			
				var keywordvalue = keywordObject.h_title; //한 객체의 키로 꺼낸 값
				var h_no=keywordObject.h_no;
				//alert(h_no);
				html += "<a href=HoogiView_1?h_no=" + h_no + ">" + keywordvalue
						+ "</a><br/>";
				//alert(h_no);
			}
			document.getElementById('suggestList').innerHTML = html;
		}

	}
			
			
			/* 
			var resultCSVArray = resultCSV.split("|");
			if (resultCSVArray[0] == 0) {
				hideSuggestDiv();
				return;
			}
			var keywordArray = resultCSVArray[1].split(",");
			var html = "";
			for (var i = 0; i < keywordArray.length; i++) {
				html += "<a href=\"javascript:select('" + keywordArray[i]
						+ "');\">" + keywordArray[i] + "</a><br/>";
			}
			document.getElementById('suggestList').innerHTML = html;
			showSuggestDiv(); */
	
	/* 	function select(selectKeyword) {
	 document.searchF.keyword.value = selectKeyword;
	 hideSuggestDiv();
	 //document.searchF.submit();

	 }
	 function showSuggestDiv() {
	 document.getElementById('suggest').style.display = 'block';
	 }
	 function hideSuggestDiv() {
	 document.getElementById('suggest').style.display = 'none';
	 }
	 */
	function HoogiWrite() {

		document.z.action = "Hoogi_Write_form_1";
		document.z.method = "post";
		document.z.submit();

	}
	function HoogiListsearch() {
		document.y.action = "HoogiList_search";
		document.y.method = "post";
		document.y.submit();

	}
</script>
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
	<div class="headertitle">
		<div class="headercontent">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>Review List</h1>
						<span class="wtnbreadcrumbs"><a href="index.jsp"></a> <span
							class="separator">The best Review</span> <span class="actual"></span></span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- START CONTAINER==========================================-->

	<form name="z" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div id="primary" class="content-area">
						<div class="wowitemboxlist">
							<c:forEach var="hoogi" items="${ListPage.list}"
								varStatus="status">
								<div class="wowitembox col-md-6">
									<div class="wowitemboxinner">
										<div class="imagearea">
											<img src="${hoogi.getH_img()}"
												style="width: 100%; height: 220px;">
											<div class="caption">
												<div class="blur"></div>
												<div class="caption-text">
													<div class="captionbuttons">
														<a href="HoogiView_1?h_no=${hoogi.h_no}"
															class="captiondetails"><i class="fa fa-link"></i></a>
													</div>
												</div>
											</div>
										</div>
										<div class="notesarea">
											<a href="HoogiView_1?h_no=${hoogi.h_no}"
												title="Learning Marketing">
												<h2>${hoogi.h_title}</h2> <br />
											</a>


											<div class="col-md-10">
												<a class="readmore" href="HoogiView_1?h_no=${hoogi.h_no}">Read
													More</a>
											</div>
											<div class="col-md-2">${hoogi.h_count}</div>
											<%-- 
                                  <a class="readmore" href="HoogiView_1?h_no=${hoogi.h_no}">Read
                                    More</a>

                                 <div style="text-align: right;">${hoogi.h_count}</div>
 --%>
											<%--    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${hoogi.h_count} --%>


										</div>

									</div>
								</div>
							</c:forEach>
							<!-- .wowitembox-->
						</div>



						<div class="row">
							<div class="col-md-12 pagination">
								<div class="col-md-10">
									<c:if test="${ListPage.isShowFirst()}">
										<a href="HoogiList_1?selectPage=1">first</a>&nbsp;
                                    </c:if>
									<c:if test="${ListPage.isShowPreviousGroup()}">
										<a
											href="HoogiList_1?selectPage=${ListPage.previousGroupStartPageNo}">prev</a> &nbsp;              
                                    </c:if>

									<c:forEach begin="${ListPage.startPageNo}"
										end="${ListPage.endPageNo}" varStatus="status">
										<c:if test="${status.index==ListPage.selectPageNo}">
											<span class="current">${status.index}</span>
										</c:if>
										<c:if test="${status.index !=ListPage.selectPageNo}">
											<a href="HoogiList_1?selectPage=${status.index}"
												class="inactive">${status.index}</a> &nbsp; </c:if>
									</c:forEach>

									<c:if test="${ListPage.isShowNextGroup()}">
										<a
											href="HoogiList_1?selectPage=${ListPage.nextGroupStartPageNo}">next</a>&nbsp;
                                  </c:if>
									<c:if test="${ListPage.showLast}">
										<a href="HoogiList_1?selectPage=${ListPage.totalPageCount}">last</a>&nbsp;
                                    </c:if>
								</div>
								<div class="col-md-2">

									<input type="button" onclick="HoogiWrite();" value="Write">
	</form>
	</div>
	</div>
	</div>
	</div>
	</form>
	<!-- #primary -->
	</div>



	<%-- <!-- 오른쪽 검색 및 요약게시판 include하기 -->
   <jsp:include page="common_hoogi_right.jsp"></jsp:include> --%>

	<div class="col-md-4">
		<div id="secondary" class="widget-area q2w3-fixed-widget-container"
			role="complementary">
			<aside class="widget widget_search">
			<!--별로 안이뻐서 지움 <h4>Search</h4> -->
				<!-- <form ="search" method="get" class="search-form" action="#"> -->
				<!--       <form name="y" method="post" class="search-form" action="HoogiSearchAction"> -->

				<!-- 검색 폼 -->
				
				<!-- <hr /> -->
				<form  action="HoogiList_search" name="searchF"method="post">
					<input type="search" name="keyword" onkeyup="sendKeyWord();"placeholder="Type and hit click..." name="h_title"><!-- &nbsp;<input
						type="submit" value="검색"> -->
					<div id="suggest" class="suggest"></div>
				</form>
				<div id="suggestList"></div>		
				<!-- 연관검색어 뜨는 list 둘 중 뭐할까 하다가 메인-->
			

			<!-- 	<form class="search-form" action="HoogiList_search" method="post">
					<input type="search" class="search-field"
						placeholder="Type and hit enter..." name="h_title">
				</form> 

		 -->
			</aside>
			<aside class="widget widget_recent_entries">
				<h2 class="widget-title section-title">
					<span><a href="TastyList">Recent Posts</a></span>
				</h2>


				<!-- ******************************오른쪽 리스트************************************* -->

				<c:forEach var="tasty" items="${tastyList}" begin="1" end="7"
					varStatus="status">
					<%--   <a href="TastyList?t_no=${tasty.t_no}">${tasty.t_title}</a><br> --%>
					<a href="TastyView?t_no=${tasty.t_no}"> ${tasty.t_title}</a>
					<br>

				</c:forEach>

				<!-- ******************************************************************************** -->
			</aside>
			<!-- fixed widget -->
			<aside id="categories-2" class="widget widget_categories">
				<h2 class="widget-title section-title">
					<span>Recipe Category</span>
				</h2>

				<a href="recipe_list?c_no=0&&selectpage=1">전체</a>
				(${recipecount1+recipecount2+recipecount3+recipecount4+recipecount5})<br />
				<a href="recipe_list?c_no=1&&selectpage=1">한식</a> (${recipecount1})<br />
				<a href="recipe_list?c_no=2&&selectpage=1">일식</a> (${recipecount2})<br />
				<a href="recipe_list?c_no=3&&selectpage=1">중식</a> (${recipecount3})<br />
				<a href="recipe_list?c_no=4&&selectpage=1">양식</a> (${recipecount4})<br />
				<a href="recipe_list?c_no=4&&selectpage=1">기타</a> (${recipecount5})<br />
				<%-- <a href="recipe_list?c_no=5&&selectpage=1">기타</a>${recipecount1}<br/> --%>


			</aside>
		</div>
		<!-- #secondary -->
	</div>
	<!--  테스트 이미지 지워도 상관없어
   <h1>이미지</h1> -->
	<!-- <img alt="" src="images\male.jpg"> -->
	<%-- <img alt="" src="${hoogi.getH_img()}"> --%>
	<<%-- h1>${path}</h1> --%>
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