<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>