<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Tasty"%>
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
	height: 200px;
	width: 50%;
}
</style>
<script type="text/javascript">
function initMap() {
	
	var uluru =  {lat: ${lat}, lng: ${lng}};
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: 15,
		center: uluru
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
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCe79ndtoPiG3-yXC3Jjqj-ZST7IvU8f9o&callback=initMap"></script>
<script type="text/javascript">
   function TastyRemove(){
      if(window.confirm("방명록을 삭제하시겠습니까?"));
      location.href="TastyRemoveAction?t_no="+${tasty.getT_no()};
   }
   
   


   	function TastyList() {
   		
   location.href="TastyList_Count";
   	}

</script>

<script type="text/javascript" src='assets/js/httpRequest.js'></script>
<script type="text/javascript">
	function getdatgleList(page) {
		document.getElementById('datgleList').innerHTML = '';
		document.getElementById('datglePage').innerHTML = '';
		//alert(page);
		var pageCountPerPage = 5;
		var rowCountPerPage = 10;
		var d_filter = "tasty";
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
								<h1>${tasty.getT_title()}</h1>
								<span class="wtnbreadcrumbs"><a href="#m_article">글</a> </span>&nbsp;
								<span class="wtnbreadcrumbs"><a href="#reply-title">/
										후기</a> </span>
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
										<img class="attachment-post-thumbnail"
											src="${tasty.getT_img()}"
											style="width: 500px; height: 400px;" alt="">
										<div class="wowmetaposts entry-meta" id="m_article">
											<span class="wowmetadate"><i class="fa fa-clock-o"></i>${tasty.getT_date()}</span>
											<!-- a href 누르면 나의 페이지 들어가기 -->
											<c:if test="${sId == null}">
												<span class="wowmetaauthor"><i class="fa fa-user"></i>
													<a href="#">guest </a></span>
											</c:if>
											<c:if test="${sId != null}">
												<span class="wowmetaauthor"><i class="fa fa-user"></i>
													<a href="#">${sId } </a></span>
											</c:if>
											<span class="wowmetacats"><i class="fa fa-folder-open"></i>
												<a href="#">${tasty.getT_count()}</a></span> <span
												class="wowmetacommentnumber"><i
												class="fa fa-comments"></i> <a href="#">${datgleCount}</a></span>
										</div>
										<!-- .wowmetaposts -->
										<input type="hidden" id="A" name="t_no"
											value="${tasty.getT_no()}" />

										<h4>${tasty.getT_title()}</h4>
										<p>
											<Strong>${tasty.getT_content()}</Strong>
										</p>
										<p>
											<Strong>${tasty.getT_address()}</Strong>
										</p>
										<div id="map"></div>
										<c:if test="${sId=='admin'}">
											<div class="tagcloud">
												<input type="button" onClick="TastyRemove();" rel="tag"
													value="delete"> <input type="button"
													onClick="location.href ='TastyUpdate?t_no='+${tasty.getT_no()}"
													rel="tag" value="modify"> <input type="button"
													onClick="TastyList();" rel="tag" value="List">
											</div>
										</c:if>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="clearfix"></div>
							<div id="comments" class="comments-area">
								<div id="respond" class="comment-respond">
									<h3 id="reply-title" class="comment-reply-title">
										Questions &amp; Feedback <small><a rel="nofollow"
											id="cancel-comment-reply-link" href="#"
											style="display: none;">Cancel Reply</a></small>
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

										<!--    <div class="row commentrow comment-form-comment">
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
											<input name="submit" type="button" id="submit" class="submit"
												value="Submit" onClick='datgleInsert();'> <input
												type="hidden" name="comment_post_ID" value="43"
												id="comment_post_ID"> <input type="hidden"
												name="comment_parent" id="comment_parent" value="0">
										</p>
										<input type="hidden" name="d_groupno" id="d_groupno"
											value="${tasty.getT_no()}"> <input type="hidden"
											name="d_title" id="d_title" value="제목 없음"> <input
											type="hidden" name="d_step" id="d_step" value="0"> <input
											type="hidden" name="d_filter" id="d_filter" value="tasty">
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
					<jsp:include page="common_tasty_right.jsp"></jsp:include>
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