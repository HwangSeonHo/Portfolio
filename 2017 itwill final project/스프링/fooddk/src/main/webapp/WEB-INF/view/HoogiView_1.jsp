<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Hoogi"%>
<%@page import="fooddk.paging.ListResultBean"%>
<%@page import="fooddk.paging.ListPageConfigBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<script type="text/javascript">
	/* var img = ${hoogi.getH_img()}; */

	function HoogiList() {
		document.z.action = "HoogiList_1";
		document.z.method = "post";
		document.z.submit();
	}
	function HoogiRemove() {

		if (window.confirm("방명록을 삭제하시겠습니까?"))
			/* alert(document.z.A.value); */

			//document.z.action="HoogiRemoveAction?h_no="+${hoogi.getH_no()};
			document.z.action = "HoogiRemoveAction";
		document.z.method = "post";
		document.z.submit();

	}

	function HoogiModify() {
		/* 	document.z.action="HoogiUpdateForm?h_no="+${hoogi.getH_no()}; */
		document.z.action = "Hoogi_Modify_form_1.?h_no=" + ${hoogi.getH_no()};
		//document.z.action="HoogiUpdateForm";
		document.z.method = "post";
		document.z.submit();
	}
	/* 	function visitorReply(){
	 document.z.action="visitor_reply_form.do?v_no="+${visitor.getV_no()};
	 document.z.mehtod="post";
	 document.z.submit(); 
	 }  */
</script>
<script type="text/javascript" src='assets/js/httpRequest.js'></script>
<script type="text/javascript">
	function getdatgleList(page) {
		document.getElementById('datgleList').innerHTML = '';
		document.getElementById('datglePage').innerHTML = '';
		//alert(page);
		var pageCountPerPage = 5;
		var rowCountPerPage = 10;
		var d_filter = "hoogi";
		var selectPage = page + "";
		var d_groupno = commentform.d_groupno.value;

		var params = "pageCountPerPage=" + pageCountPerPage
				+ "&rowCountPerPage=" + rowCountPerPage + "&d_filter="
				+ d_filter + "&selectPage=" + selectPage + "" + "&d_groupno="
				+ d_groupno;

		sendRequest('datgleListJson', params, datgleListDisplay, 'POST');

	}
	function datgleListDisplay() {
		if (xhr.readyState == 4) {
			var datgleListJSONText = xhr.responseText;
			var datgleListJSONObject = JSON.parse(datgleListJSONText);
			//alert(datgleListJSONText);
			/* 이중 맵		
			{
				"0": {
						"m_no": "1",
						"m_name": "회원3",
						"d_date": "2017-08-17",
						"d_content": "서비스가 좋네요"
					 },
				"1": {
						"m_name": "회원1",
						"d_date": "2017-08-17",
						"d_content": "짬뽕 국물이 맛있는 곳"
					 },
			}
			 */

			//자바스크립트 오브젝트 length 구하는 법
			var length = Object.keys(datgleListJSONObject).length;
			if (length == 1) {
				return;
			}

			var html = "<ul>";
			for (var i = 0; i < length - 1; i++) { //마지막 9999:resultbean은 빼줌
				html += "<li>작성자: "
						+ datgleListJSONObject[i].m_name
						+ " 　　　내용: "
						+ datgleListJSONObject[i].d_content
						+ " 　　　작성일: "
						+ datgleListJSONObject[i].d_date;
						if(document.commentform.sId.value==datgleListJSONObject[i].m_id){
				html += "<input align=\"middle\" name=\"delete\"  type=\"image\" src=\"assets/img/remove.png\" width=\"37\" height=\"37\" id=\"delete\" class=\"delete\" value=\"delete\" onClick='datgleDelete("
						+ datgleListJSONObject[i].d_no + ");'>"
						+ "<input align=\"middle\" name=\"update\"  type=\"image\" src=\"assets/img/modify.png\" width=\"37\" height=\"37\" id=\"update\" class=\"update\" value=\"update\" onClick='datgleUpdateForm("
						+ datgleListJSONObject[i].d_no + ");'>"; 
						}
				html +=	"</li>";
			}
			html += "</ul>";

			document.getElementById('datgleList').innerHTML = html;

			var page = "<div class=\"col-md-12 pagination\"><div class=\"col-md-12\">";

			if (datgleListJSONObject[9999].isShowFirst) {
				page += "<a href=\"#;\" onClick='getdatgleList(1);'>first</a>&nbsp;";
			}
			if (datgleListJSONObject[9999].isShowPreviousGroup) {
				page += "<a href=\"#;\" onClick='getdatgleList("
						+ datgleListJSONObject[9999].PreviousGroupStartPageNo
						+ ");'>◀</a>";
			}

			for (i = datgleListJSONObject[9999].StartPageNo; i <= datgleListJSONObject[9999].EndPageNo; i++) {

				page += "<a href=\"#;\" onClick='getdatgleList(" + i + ");'>"
						+ i + "</a>" + "</font>";

			}

			if (datgleListJSONObject[9999].isShowNextGroup) {
				page += "<a href=\"#;\" onClick='getdatgleList("
						+ datgleListJSONObject[9999].NextGroupStartPageNo
						+ ");'>▶</a>";
			}
			if (datgleListJSONObject[9999].isShowLast) {
				page += "<a href=\"#;\" onClick='getdatgleList("
						+ datgleListJSONObject[9999].TotalPageCount
						+ ");'>last</a>&nbsp;";
			}
			page += "</div></div>";

			document.getElementById('datglePage').innerHTML = page;

			/* showNewsDiv(); */
		}
	}
	function datgleInsertForm() {
		document.getElementById('datgleList').innerHTML = '';
		document.getElementById('datglePage').innerHTML = '';
		document.commentform.comment.value='';
		document.getElementById('submit').value="Submit";
		document.commentform.d_no.value = 0;
	}
	function datgleUpdateForm(d_no) {
		document.getElementById('datgleList').innerHTML = '';
		document.getElementById('datglePage').innerHTML = '';
		document.commentform.comment.value='';
		document.getElementById('submit').value="update";
		document.commentform.d_no.value = d_no;
		
		/* document.getElementById('submit').onClick='datgleUpdate('+d_no+');'; //물어볼 부분 */
	}
	function datgleInsert() {
		
		var d_no = document.commentform.d_no.value;
		var d_title = document.commentform.d_title.value;
		var d_comment = document.commentform.comment.value;
		var d_groupno = document.commentform.d_groupno.value;
		var d_step = document.commentform.d_step.value;
		var d_filter = document.commentform.d_filter.value;
		
		//댓글 글자수 제한
		if (d_comment.length >= 20) {
			alert("댓글은 20글자 내외로 작성이 가능합니다.");
			return;
		}
		
		
		var params = "d_no=" + d_no + "&d_title=" + d_title + "&d_content=" + d_comment
				+ "&d_groupno=" + d_groupno + "&d_step=" + d_step
				+ "&d_filter=" + d_filter;
		
		if(document.getElementById('submit').value=="update"){
			sendRequest('datgleUpdate', params, null, 'POST');
			datgleInsertForm();
			getdatgleList(1);		
		}else if(document.getElementById('submit').value=="Submit"){
			sendRequest('datgleInsert', params, null, 'POST');
			datgleInsertForm();
			getdatgleList(1);
		}

	}
	function datgleDelete(d_no) {
		var params = "d_no=" + d_no;
		document.getElementById('datgleList').innerHTML = '';
		sendRequest('datgleDelete', params, null, 'POST');
		getdatgleList(1);
	}

	window.onload = function() {
		getdatgleList(1);
	};
</script>


</head>
<body>
	<!-- <input type="button" src="" size="100"> -->
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
									class="separator"></span> <span class="actual">View</span></span>
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
								<main id="main" class="site-main whiteboxed" role="main">
								<div class="wrapindexcerpt">
									<div class="contenttext">
										<div class="post-content">
											<img class="attachment-post-thumbnail"
												src="${hoogi.getH_img()}" style="width:100%; height:400px;">
											<div class="wowmetaposts entry-meta">
												<span class="wowmetadate"><i class="fa fa-clock-o"></i>  ${hoogi.getH_date().toString().substring(0,10)}</span>
												<!-- a href 누르면 나의 페이지 들어가기 -->
												<span class="wowmetaauthor"><i class="fa fa-user"></i>
													<a href="#">Writer : ${name.getM_name()}</a></span> <span
													class="wowmetacats"><i class="fa fa-folder-open"></i>
													<a href="#">${hoogi.getH_count()} (count)</a></span> 
													<%-- <span class="wowmetacommentnumber"><i
													class="fa fa-comments"></i> <a href="#">${hoogi.getH_count()}</a></span> --%>
											</div>
											<!-- .wowmetaposts -->
											<input type="hidden" id="A" name="h_no"
												value="${hoogi.getH_no()}" />
											<!-- 	<h1> 이미지 </h1>
												<img src="images/uploadfile/Lighthouse.jpg"/> -->
											<h4>${hoogi.getH_title()}</h4>
											<p>${hoogi.getH_content()}</p>
											<p></p>
											<!-- 	<p>
										The pain and shame had faded and faded. The thing that gave him this sick feeling, as he sat here in his study at midnight, was not the fact that he had sinned; it was the memory of how he had suffered for his sin. <em><strong>The sin itself, now, was too remote</strong></em>, too separate from himself for any more repentance; it had ceased to be real. But the suffering! he could not bear to think of that.
									</p>
									<h4>Confidence is everything</h4>
									<p>
										How mad this is! he said to himself, with a curious terror lest the old anguish should come back: the horror a man might feel who sees the surgeon s knife under which he has once agonized. For very fear of memory, William West drove his thoughts back to the question of his duty to Amy; that was plain reasoning, and had nothing to do with this nightmare.
									</p>
									<blockquote>
										<p>
											He lighted another match, but held it absently, until it scorched his fingers, then flung it down with an angry exclamation. It seemed as though the pain burned through all this fog of the past, and showed him the facts which he must judge, and the folly of his uncertainty.
										</p>
									</blockquote>
									<p>
										For, after all, what was this matter he was trying to decide? Was it not merely the question of what was best for Amy, not what was most comfortable for himself? It was that abstraction called Honor, as applied to Amy s happiness.
									</p> -->
											<div class="tagcloud">
											
												<c:if test="${sId ==name.getM_id() || sId == 'admin'}">
													<input type="button" onClick="HoogiRemove();" rel="tag"
														value="delete">
													<input type="button" onClick="HoogiModify();" rel="tag"
														value="modify">
												</c:if>
												<%--<c:if test="${sId !=name.getM_name()}"> --%>
												<input type="button" onClick="HoogiList();" rel="tag"
													value="List">

												<%-- </c:if>
												 --%>
												<%-- <a href="Hoogi_Modify_form_1.?h_no=${hoogi.getH_no()}" rel="tag">modify</a> --%>
												<!-- 	<a href="HoogiList_1" rel="tag">list</a> -->
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
			</form>
			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<div id="comments" class="comments-area">
				<div id="respond" class="comment-respond">
					<h3 id="reply-title" class="comment-reply-title">
						Questions &amp; Feedback <small><a rel="nofollow"
							id="cancel-comment-reply-link" href="#" style="display: none;">Cancel
								Reply</a></small>
					</h3>


					<form method="post" id="commentform" name="commentform"
						class="comment-form">
						<input type="hidden" name="" value="">
						<p class="comment-notes"></p>
						<div class="container">
							<div class="uix-pb-price">
								<div class="uix-pb-row">
									<div class="uix-pb-price-bg-hover uix-pb-price-init-height">
										<div class="uix-pb-price-detail" id="datgleList">
											<ul>
												<li>아직 이 게시물에 댓글이 없어요</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row" id="datglePage">
							<a href="#;" onClick='getdatgleList(1);'>1</a> <a href="#;"
								onClick='getdatgleList(2);'>2</a> <a href="#;"
								onClick='getdatgleList(3);'>3</a> <a href="#;"
								onClick='getdatgleList(4);'>4</a> <a href="#;"
								onClick='getdatgleList(5);'>5</a>
						</div>

						<!-- 	<div class="row commentrow comment-form-comment">
										<div class="col-md-12">
												<blockquote>
										<p>
											He lighted another match, but held it absently, until it scorched his fingers,
										</p>
									</blockquote>
										</div>
									</div> -->
						<div class="row commentrow comment-form-comment">
							<div class="col-md-12">
								<label for="comment">Comment</label>
								<textarea id="comment" name="d_content" rows="5"
									aria-required="true"></textarea>
							</div>
						</div>
						<!-- <div class="row">
										<div class="col-md-4 comment-form-author">
											<label for="author">Name</label><input id="author" name="author" type="text" value="" size="30" aria-required="true">
										</div>
										<div class="col-md-4 comment-form-email">
											<label for="email">E-mail</label><input id="email" name="email" type="text" value="" size="30" aria-required="true">
										</div>
										<div class="col-md-4 comment-form-url">
											<label for="url">Website</label><input id="url" name="url" type="text" value="" size="30">
										</div>
									</div> -->
						<p class="form-submit">
							<input name="submit" type=button id="submit" class="submit"
								value="Submit" onClick='datgleInsert();'> <input
								type="hidden" name="comment_post_ID" value="43"
								id="comment_post_ID"> <input type="hidden"
								name="comment_parent" id="comment_parent" value="0">

						</p>
						<input type="hidden" name="d_groupno" id="d_groupno" value="${hoogi.getH_no()}"> 
						<input type="hidden" name="d_title" id="d_title" value="제목 없음"> 
						<input type="hidden" name="d_step" id="d_step" value="0"> 
						<input type="hidden" name="d_filter" id="d_filter" value="hoogi">
						<input type="hidden" name="d_no" id="d_no" value="0">
						<input type="hidden" name="sId" id="sId" value="${sId}">						
						<noscript></noscript>
					</form>
				</div>
				<!-- #respond -->
			</div>
			</main>
			<!-- #main -->
		</div>
		<!-- #primary -->
	</div>
	<%-- 	<!-- 오른쪽 검색 및 요약게시판 include하기 -->
	<jsp:include page="common_hoogi_right.jsp"></jsp:include> --%>
	<!-- 검색하기 엔터키말고 클릭만 먹음 고쳐야함 검색하고 또 검색이 안됨-->
	<div class="col-md-4">
		<div id="secondary" class="widget-area q2w3-fixed-widget-container"
			role="complementary">
			<aside class="widget widget_search">
				<!-- <form ="search" method="get" class="search-form" action="#"> -->
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
				<!-- 컨트롤러에서 값줘야함 -->
				<%-- <ul>
					<c:forEach var="hoogi" items="${ListPage.list}" varStatus="status">

						<a href="HoogiView_1?h_no=${hoogi.h_no}">${hoogi.h_title}</a>
						<br />
					</c:forEach>
				</ul> --%>
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
	<div id="lambadacalltoaction" class="actionbeforefooter text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					This optional area appears before footer. Use it for discounts,
					messages, or anything else! <a target="_blank" class="actionbutton"
						href="index.jsp"><i class="fa fa-send-o"></i> Call to Action </a>
				</div>
			</div>
		</div>
	</div>
	<!-- FOOTER
		==========================================-->
	<footer id="lambadafooter"
		class="themefooter section medium-padding bg-graphite">
		<div class="container">
			<div class="section-inner row">
				<div class="column column-1 col-sm-3 rightbd">
					<div class="widgets">
						<div class="widget widget_text" id="text-2">
							<div class="widget-content">
								<div class="textwidget">
									<h2>
										<a target="_blank" class="navbar-brand-middle"
											href="index.jsp">Lambada</a>
									</h2>
									<p>&nbsp;</p>
									<p>
										You're currently viewing Lambada demo, an ecommerce HTML
										template created by <a href="https://www.wowthemes.net/">WowThemes.net.</a>
									</p>
								</div>
							</div>
							<div class="clear"></div>
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
									<li><a href="category-book.jsp">book</a> (3)</li>
									<li><a href="category-logos.jsp">logos</a> (6)</li>
									<li><a href="category-pdf.jsp">pdf</a> (6)</li>
									<li><a href="category-photos.jsp">photos</a> (3)</li>
								</ul>
							</div>
							<div class="clear"></div>
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
							<div class="clear"></div>
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
										<a href="#"><i class="fa fa-facebook"></i> Like us on
											Facebook</a>
									</p>
									<p>
										<a href="#"><i class="fa fa-twitter"></i> Follow us on
											Twitter</a>
									</p>
									<p>
										<a href="#"><i class="fa fa-google-plus"></i> Visit on
											Google Plus</a>
									</p>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<!-- /footer-d -->
				<div class="clearfix"></div>
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
					<span class="credits-left fleft"> 2017 All Rights Reserved,
						WowThemes.net </span>
					<ul class="footermenu fright">
						<li class="current-menu-item"><a href="index.jsp">Home</a></li>
						<li><a href="shop.jsp">Shop</a></li>
						<li><a href="blog.jsp">Blog</a></li>
						<li><a href="contact.jsp">Contact</a></li>
					</ul>
				</div>
				<div class="clear"></div>
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
