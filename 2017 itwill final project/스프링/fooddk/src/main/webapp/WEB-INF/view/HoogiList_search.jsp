<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Hoogi"%>
<%@page import="fooddk.paging.ListResultBean"%>
<%@page import="fooddk.paging.ListPageConfigBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script type="text/javascript">
	function HoogiWrite() {

		document.z.action = "Hoogi_Write_form_1";
		document.z.method = "post";
		document.z.submit();

	}
	function HoogiList() {

		document.z.action = "HoogiList_1";
		document.z.method = "post";
		document.z.submit();

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
	<div id="wrapall">
		<div class="wrapcontent">

			<jsp:include page="common_top.jsp"></jsp:include>
			<!-- PAGE HEADER
		==========================================-->
			<div class="headertitle">
				<div class="headercontent">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<h1>Search Review Title</h1>
								<span class="wtnbreadcrumbs"><a href="index.jsp"></a> <span
									class="separator">��</span> <span class="actual">Blog</span></span>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- START CONTAINER
		==========================================-->

			<form name="z" method="post">
				<div class="container">
					<div class="row">
						<div class="col-md-8">
							<div id="primary" class="content-area">
								<!-- 시작 -->
								<div class="wowitemboxlist">
									<c:forEach var="hoogi" items="${hoogiListTitle}"
										varStatus="status">
										<div class="wowitembox col-md-6">
											<div class="wowitemboxinner">
												<div class="imagearea">
														<img src="${hoogi.getH_img()}"  style="width:100%; height:220px;">
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
												
												<!-- 검색한 리스트 정보 보여줌 -->
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
												<%-- <div class="notesarea">
													<a href="HoogiView_1?h_no=${hoogi.h_no}"
														title="Learning Marketing"> 	<h2>${hoogi.h_no}</h2>
														<h2>${hoogi.h_title}</h2> <!-- 			<span class="description">Hello</span> -->
														<br />
													</a> <a class="readmore" href="HoogiView_1?h_no=${hoogi.h_no}">Read
														More</a>
														<div class="col-md-2">${hoogi.h_count}</div>
												</div> --%>
											</div>
										</div>
									</c:forEach>
									<!-- .wowitembox-->
								</div>


								<!-- 검색 결과 후 페이징 필요없을 것 같아서, 그냥 Write List 폼 생기게함 -->

								<div id="lambadacalltoaction"
									class="actionbeforefooter text-center">
									<div class="container">
										<div class="row">
											<div class="col-md-12">
												<%--  <c:if test="${ListPage.isShowFirst()}">
                  <a href="HoogiList_1?selectPage=1">firt prev</a>&nbsp;
                  
               </c:if> 
               
               
               <c:if test="${ListPage.isShowPreviousGroup()}">
                  <a
                     href="HoogiList_1?selectPage=${ListPage.previousGroupStartPageNo}">prev</a> &nbsp;
               
                  
               </c:if> 
                  <c:forEach  begin="${ListPage.startPageNo}" end="${ListPage.endPageNo}" varStatus="status">
                     <a href ="HoogiList_1?selectPage=${status.index}">${status.index}</a> &nbsp;
  
                  </c:forEach> 
                  
                  
               <c:if test="${ListPage.isShowNextGroup()}">
                  <a href="HoogiList_1?selectPage=${ListPage.nextGroupStartPageNo}">next</a>&nbsp;
               
               </c:if> <c:if test="${ListPage.showLast}">
                  <a href="HoogiList_1?selectPage=${ListPage.totalPageCount}">last next</a>&nbsp;
                  
               </c:if> --%>
												<!--  <a target="_blank" class="actionbutton" href="Hoogi_Write_form_1"><i class="fa fa-send-o"></i> Write </a> -->
												<input type="button" onClick="HoogiWrite();" rel="tag"
													value="Write"> <input type="button"
													onClick="HoogiList();" rel="tag" value="List">
											</div>
										</div>
									</div>
								</div>
			</form>
			<!-- 	<div class="pagination">
							<span class="current">1</span><a href="#" class="inactive">2</a>
						</div> -->
		</div>
		<!-- #primary -->
	</div>
	<%-- 	<!-- 오른쪽 검색 및 요약게시판 include하기 -->
	<jsp:include page="common_hoogi_right.jsp"></jsp:include> --%>
	<!-- 검색하기 엔터키말고 클릭만 먹음 고쳐야함 검색하고 또 검색이 안됨-->
	<div class="col-md-4">
		<div id="secondary" class="widget-area q2w3-fixed-widget-container"
			role="complementary">
			<aside class="widget widget_search"> <!-- <form ="search" method="get" class="search-form" action="#"> -->
			<!-- 		<form name="y" method="post" class="search-form" action="HoogiSearchAction"> -->

			<!-- 검색 폼 -->
			<form class="search-form" action="HoogiList_search" method="post">
				<input type="search" class="search-field"
					placeholder="Type and hit enter..." name="h_title">
			</form>

			</aside>
			<aside class="widget widget_recent_entries">
			<h2 class="widget-title section-title">
				<span><a href="TastyList">Recent Posts</a></span>
			</h2>
			<!-- 컨트롤러에서 값줘야함 --> <%-- <ul>
					<c:forEach var="hoogi" items="${ListPage.list}" varStatus="status">

						<a href="HoogiView_1?h_no=${hoogi.h_no}">${hoogi.h_title}</a>
						<br />
					</c:forEach>
				</ul> --%> <!-- ******************************오른쪽 리스트************************************* -->

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
			<a href="recipe_list?c_no=5&&selectpage=1">기타</a> (${recipecount5})<br />
			<%-- <a href="recipe_list?c_no=5&&selectpage=1">기타</a>${recipecount1}<br/> --%>


			</aside>
		</div>
		<!-- #secondary -->
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
