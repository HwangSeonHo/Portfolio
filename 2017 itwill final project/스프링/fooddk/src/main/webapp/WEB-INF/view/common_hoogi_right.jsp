<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- �˻��ϱ� ����Ű���� Ŭ���� ���� ���ľ��� �˻��ϰ� �� �˻��� �ȵ�-->
	<div class="col-md-4">
		<div id="secondary" class="widget-area q2w3-fixed-widget-container"
			role="complementary">
			<aside class="widget widget_search"> <!-- <form ="search" method="get" class="search-form" action="#"> -->
			<!-- 		<form name="y" method="post" class="search-form" action="HoogiSearchAction"> -->

			<!-- �˻� �� -->
			<form class="search-form" action="HoogiList_search" method="post">
				<input type="search" class="search-field"
					placeholder="Type and hit enter..." name="h_title">
			</form>

			</aside>
			<aside class="widget widget_recent_entries">
			<h2 class="widget-title section-title">
				<span><a href="TastyList">Recent Posts</a></span>
			</h2>
			<!-- ��Ʈ�ѷ����� ������� --> <%-- <ul>
					<c:forEach var="hoogi" items="${ListPage.list}" varStatus="status">

						<a href="HoogiView_1?h_no=${hoogi.h_no}">${hoogi.h_title}</a>
						<br />
					</c:forEach>
				</ul> --%> <!-- ******************************������ ����Ʈ************************************* -->

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

			<a href="recipe_list?c_no=0&&selectpage=1">��ü</a>
			(${recipecount1+recipecount2+recipecount3+recipecount4+recipecount5})<br />
			<a href="recipe_list?c_no=1&&selectpage=1">�ѽ�</a> (${recipecount1})<br />
			<a href="recipe_list?c_no=2&&selectpage=1">�Ͻ�</a> (${recipecount2})<br />
			<a href="recipe_list?c_no=3&&selectpage=1">�߽�</a> (${recipecount3})<br />
			<a href="recipe_list?c_no=4&&selectpage=1">���</a> (${recipecount4})<br />
			<a href="recipe_list?c_no=5&&selectpage=1">��Ÿ</a> (${recipecount5})<br />
			<%-- <a href="recipe_list?c_no=5&&selectpage=1">��Ÿ</a>${recipecount1}<br/> --%>


			</aside>
		</div>
		<!-- #secondary -->
	</div>
</body>
</html>