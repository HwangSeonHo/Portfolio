<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Faq"%>
<%@page import="fooddk.service.faq.FaqService"%>
<%@page import="fooddk.paging.ListResultBean"%>
<%@page import="fooddk.paging.ListPageConfigBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="assets/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.validate.js" type="text/javascript"></script>
<script src="assets/js/messages_ko.js" type="text/javascript"></script>
<script type="text/javascript">

$(function() {
	$('#commentform').validate({
		rules : {
			f_title : {
				required : true,
				minlength : 2,
				maxlength : 4000
			},
			f_content : {
				required : true,
				minlength : 2,
				maxlength : 4000
			}		
		},
		messages : {
			f_title : {
				required : "제목을 입력해 주세요",
				minlength : "{0} 글자이상 입력해주세요",
				maxlength : "{0} 글자 이하 입력해 주세요"
			},
			f_content : {
				required : "내용을 입력해 주세요",
				minlength : "{0} 글자이상 입력해주세요",
				maxlength : "{0} 글자 이하 입력해 주세요"
			}
		},
		onsubmit : true,
		submitHandler : function(form) {
			form.action = "Faq_Write_Action";
			form.method = "POST";
			form.submit();
		}
	});
});


///이렇게 입력해도 상관없는데 Jquery로 바꿈
	/* function HoogiWrite() {

		if (window.confirm("are u sure?")) {

			if (z.h_title.value == "") {
				alert("제목을 입력해주세요");
				z.h_title.focus();
				return false;
			}

			//이미지는 넣어도 되고 안넣으면 기본 사진으로 가도록 해 볼 계획
			//체크박스 이어서 "" -> null로 수정
			//중복 하면 안되게 해야함
			if (z.c_no.value == null) {
				alert("좋아하는 음식 종류를 선택, 한 가지만 선택해주세요");
				z.c_no.focus();
				return false;
			}

			if (z.h_content.value == "") {
				alert("내용을 입력해주세요");
				z.h_content.focus();
				return false;
			}

			document.z.action = "HoogiWriteAction1";
			document.z.method = "post";
			document.z.submit();
		}
	} */
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
								<h1>FAQ MANAGER MOD</h1>
								
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
										<%-- <img class="attachment-post-thumbnail" src="assets/img/demo/b3.jpg" alt="">
									<div class="wowmetaposts entry-meta">
										<span class="wowmetadate"><i class="fa fa-clock-o"></i>${hoogi.getH_date()}</span>
										<!-- a href 占쏙옙������ 占쏙옙占쏙옙 占쏙옙占쎈��占� 占썬�쇽옙�울옙疫뀐옙 -->
										<span class="wowmetaauthor"><i class="fa fa-user"></i> <a href="#">Session ID </a></span>
										<span class="wowmetacats"><i class="fa fa-folder-open"></i>	<a href="#">${hoogi.getH_count()} (count)</a></span>
										<span class="wowmetacommentnumber"><i class="fa fa-comments"></i> <a href="#">${hoogi.getH_count()}</a></span>
									</div>
									<!-- .wowmetaposts -->
									<input type="hidden" id="A" name="h_no" value ="${hoogi.getH_no()}"/>
									
									<h4>${hoogi.getH_title()}</h4>
									<p>
									
										${hoogi.getH_content()}
									</p>
									<p>
									</p> --%>
										<div id="comments" class="comments-area">
											<div id="respond" class="comment-respond">
												<h3 id="reply-title" class="comment-reply-title">
													Questions &amp; Feedback <small><a rel="nofollow"
														id="cancel-comment-reply-link" href="#"
														style="display: none;">Cancel Reply</a></small>
												</h3>
												<form name="z" method="post" id="commentform"
													class="comment-form">
													<input type="hidden" name="h_img" value=" "> <input
														type="hidden" name="m_name" value="1">
													<p class="comment-notes"></p>
													<div class="row commentrow comment-form-comment">
														<div class="row">
															<%-- 	<input type="hidden" name=h_no value="${hoogi.getH_no}">
															<input type="hidden" name=h_count
																value="${hoogi.getH_count}"> --%>
															<div class="col-md-4 comment-form-author">
																<label for="f_title">Title</label>
																<%-- <input id="h_title"
																	name="h_title" type="text"
																	value="${hoogi.getH_title}" size="30"
																	aria-required="true"> ${hoogi.getH_title()} --%>
																<input type="text" name="f_title"> <br>
															</div>

															<%-- <h2>이름 : ${m_name.getM_name()}</h2> --%>
															<%-- <div class="col-md-4 comment-form-email">
																<label for="hhh_img">IMG</label> <input type="file"
																	name="hhh_img">file<br>
																	<input id="h_img"
																	name="h_img" type="text" value="${hoogi.getH_img()}"
																	size="30" aria-required="true"> <input
																	type="text" name="h_content"> <br>
															</div> --%>

															
															<!-- <div class="col-md-4 comment-form-email">
																<label for="c_no">Category</label>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dropdownMenu1">
																	
																	<li role="presentation"><a role="menuitem"
																		tabindex="-1" name="c_no" value="1">korea</a></li>
																		
																	<li role="presentation"><a role="menuitem"
																		tabindex="-1" name="c_no" value="2">japan</a></li>
																		
																	<li role="presentation"><a role="menuitem"
																		`tabindex="-1" name="c_no" value="3">china</a></li>
																		
																	<li role="presentation"><a role="menuitem"
																		tabindex="-1" name="c_no" value="4">west</a></li>
																		
																		
																	<li role="presentation"><a role="menuitem"
																		tabindex="-1" name="c_no" value="5">ETC</a></li>
																</ul>


															</div> -->

															<!-- <div class="col-md-4 comment-form-url">
																<label for="url">Website</label><input id="url"
																	name="url" type="text" value="" size="30">
															</div> -->
														</div>

														<!-- 		<div class="dropdown">
															<button class="btn btn-default dropdown-toggle"
																type="button" id="dropdownMenu1" data-toggle="dropdown"
																aria-expanded="true">
																Dropdown <span class="caret"></span>
															</button>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dropdownMenu1">
																<li role="presentation"><a role="menuitem"
																	tabindex="-1" name="c_no" value="1">한</li>
																<li role="presentation"><a role="menuitem"
																	tabindex="-1" name="c_no" value="2">중</li>
																<li role="presentation"><a role="menuitem"
																	tabindex="-1" name="c_no" value="3">일</li>
																<li role="presentation"><a role="menuitem"
																	tabindex="-1" name="c_no" value="4">양</li>
															</ul>
														</div> -->


														<!-- <input type="checkbox" name="c_no" value="1"> 한식<br>
														<input type="checkbox" name="c_no" value="2"> 일식<br>
														<input type="checkbox" name="c_no" value="3"> 중식<br>
														<input type="checkbox" name="c_no" value="4"> 양식<br>
														<input type="checkbox" name="c_no" value="5"> 기타<br>
 -->
														<!-- 
														 <input type="submit" value="전송">
														 <input type="reset" value="취소">-->
														<div class="col-md-12">
															<label for="f_content">Comment</label>
															<textarea wrap="soft" style="width: 700px" rows="10"
																name="f_content"></textarea>
														</div>
														<%-- <input
																id="h_content" name="h_content"
																value="${hoogiselect.h_content}" size="30" row="5"
																aria-required="true"> ${hoogi.getH_content()} </input> --%>
													</div>
													<div>
														<input type="submit"  rel="tag"
															value="Write">
													</div>


													<!-- 	<p class="form-submit">
														<input name="Modify" type="submit" id="submit"
															class="submit" value="Submit"> <input
															type="hidden" name="comment_post_ID" value="43"
															id="comment_post_ID"> 
															<input type="hidden"
															name="comment_parent" id="comment_parent" value="0">

													</p>
													<noscript></noscript> -->
												</form>
											</div>
											<!-- #respond -->
										</div>
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
										<!-- <div class="tagcloud">



											<a href="" rel="tag">delete</a> <a href="HoogiModify_1"
												rel="tag">modify</a> <a href="HoogiList_1" rel="tag">list</a>
										</div> -->
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<%-- <div id="comments" class="comments-area">
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
					<%-- 					<!-- 오른쪽 검색 및 요약게시판 include하기 -->
	<jsp:include page="common_hoogi_right.jsp"></jsp:include> --%>
					<!-- 검색하기 엔터키말고 클릭만 먹음 고쳐야함 검색하고 또 검색이 안됨-->

								<!-- 컨트롤러에서 값줘야함 -->
								<%-- <ul>
					<c:forEach var="hoogi" items="${ListPage.list}" varStatus="status">

						<a href="HoogiView_1?h_no=${hoogi.h_no}">${hoogi.h_title}</a>
						<br />
					</c:forEach>
				</ul> --%>
								<!-- ******************************오른쪽 리스트************************************* -->

						</div>
						<!-- #secondary -->
					</div>
				</div>
			</div>
			<!-- / END CONTAINER
		==========================================-->
		</div>
		<!-- end /.wrapcontent -->
		<jsp:include page="common_bottom.jsp"></jsp:include>
</body>
</html>
