<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-4">
		<div id="secondary" class="widget-area q2w3-fixed-widget-container"
			role="complementary">
			<aside class="widget widget_search">
			<form role="search" method="get" class="search-form"
				action="SearchList">
				<input type="search" class="search-field"
					placeholder="Type and hit enter..." value="" name="s_val" title="">
				<!-- <input type="hidden" name="post_type" value="post"> -->
			</form>
			</aside>
			<aside class="widget widget_recent_entries">
			<h2 class="widget-title section-title">
				<span>Relevant Posts</span>
			</h2>


			<!-- ******************************오른쪽 리스트 위 위젯************************************* -->
			<ul>
				<c:forEach var="hoogi" items="${hoogiList}" varStatus="status">

					<li><a href="HoogiView_1?h_no=${hoogi.h_no}">${hoogi.h_title}</a></li>
				</c:forEach>
			</ul>
			<!-- ******************************************************************************** -->

			</aside>
			<!-- fixed widget -->


			<!-- ******************************오른쪽 리스트 아래 위젯************************************* -->
			<aside id="categories-2" class="widget widget_categories">
			<h2 class="widget-title section-title">
				<span>Recipes</span>
			</h2>
			<ul>
				<li><a href="recipe_list?c_no=0&&selectpage=1">All Recipe</a>
					(4)</li>
				<li><a href="recipe_list?c_no=1&&selectpage=1">Korean
						Recipe</a> (3)</li>
				<li><a href="recipe_list?c_no=2&&selectpage=1">Japan Recipe</a>
					(5)</li>
				<li><a href="recipe_list?c_no=3&&selectpage=1">China Recipe</a>
					(2)</li>
				<li><a href="recipe_list?c_no=4&&selectpage=1">Western
						Recipe</a> (12)</li>
				<li><a href="recipe_list?c_no=5&&selectpage=1">Etc</a> (3)</li>
			</ul>
			</aside>
			<!-- ******************************************************************************** -->


		</div>
		<!-- #secondary -->
	</div>
</body>
</html>