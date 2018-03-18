<%@page import="java.util.List"%>
<%@page import="fooddk.paging.ListResultBean"%>
<%@page import="fooddk.paging.ListPageConfigBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Lambada Template by WowThemes.net</title>
<script type="text/javascript">
	function TastyModifyAction(){
		/* if(z.v_title.value ==""){
			alert("제목을 입력해주세요");
			z.v_title.focus();
			return false;			
		}
		if(z.v_name.value ==""){
			alert("이름을 입력해주세요");
			z.v_name.focus();
			return false;			
		}
		if(z.v_email.value ==""){
			alert("이메일을 입력해주세요");
			z.v_email.focus();
			return false;			
		}
		if(z.v_sns.value ==""){
			alert("sns을 입력해주세요");
			z.v_sns.focus();
			return false;			
		}
		if(z.v_content.value ==""){
			alert("내용을 입력해주세요");
			z.v_content.focus();
			return false;			
		}
		 */
		document.z.action="TastyUpdateAction";
		document.z.method="post";
		document.z.submit();
	}



	</script>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="assets/img/favicon.png"/>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css' type='text/css' media='all'/>
<link rel='stylesheet' href='assets/css/edd.css' type='text/css' media='all'/>
<link rel='stylesheet' href='assets/css/bootstrap.min.css' type='text/css' media='all'/>
<link rel='stylesheet' href='style.css' type='text/css' media='all'/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Covered+By+Your+Grace'/>
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
							<h1>Restaurant Modify</h1>
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
										<!-- a href ��瑜대㈃ ���� ���댁� �ㅼ�닿�湲� -->
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
								<h3 id="reply-title" class="comment-reply-title">Questions &amp; Feedback <small
								><a rel="nofollow" id="cancel-comment-reply-link" href="TastyUpdateAction" style="display:none;">Cancel Reply</a></small></h3>
								<form name="z" method="post" id="commentform" class="comment-form"enctype="multipart/form-data">
									<p class="comment-notes">
									</p>
									<div class="row commentrow comment-form-comment">
									<div class="row">
									<input type ="hidden" name =t_no value="${tasty.t_no}">
										<div class="col-md-5 comment-form-author">
											<label for="t_title">Title</label>
											<input  id="t_title" name="t_title" type="text" value="${tasty.t_title}" size="30" aria-required="true">
										</div>
										
											File to upload:	 <input type="file" name="file" value="${tasty.t_img}">
										<%-- 현재 올린 사진 : ${hoogiselect.h_img} --%>
										수정 시 사진은 초기회되니 다시 올려주시길 바랍니다.^^
										
										<div class="col-md-5 comment-form-author">
											<label for="t_time">Time</label>
											<input  id="t_time" name="t_time" type="text" value="${tasty.t_time}" size="30" aria-required="true">
										</div>
										<div class="col-md-4 comment-form-author">
											<label for="t_phone">Phone</label>
											<input  id="t_phone" name="t_phone" type="text" value="${tasty.t_phone}" size="30" aria-required="true">
										</div>
										<div class="col-md-12 comment-form-email">
											<label for="t_address">Address</label>
											<input  id="t_address" name="t_address" type="text" value="${tasty.t_address}" size="30" aria-required="true">
										</div>
										<div class="col-md-12">
											<label for="t_content">Content</label>
											<textarea id="t_content" name="t_content"  rows="50" cols="50">${tasty.t_content}</textarea>
										</div>
									<div class="col-md-4 comment-form-email">
											<label for="c_no">Category</label>
											<input  id="c_no" name="c_no" type="text" value="${tasty.c_no}" size="30" aria-required="true">
									</div>
									</div>
									</div>
									
									<input type = "button" onClick="TastyModifyAction()" value ="Modify">
									
									
								<!-- 	<p class="form-submit">
										<input name="Modify" type="submit" id="submit" class="submit" value="Submit">
										<input type="hidden" name="comment_post_ID" value="43" id="comment_post_ID">
										<input type="hidden" name="comment_parent" id="comment_parent" value="0">
								
									</p> -->
									<noscript>
									</noscript>
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
									<div class="tagcloud">
									
							
									
										<!-- <a href="" rel="tag">delete</a>
										<a href="HoogiModify_1" rel="tag">modify</a> -->
										<a href="TastyList" rel="tag">list</a>
									</div>
								</div>
								<div class="clearfix">
								</div>
							</div>
						</div>
						<div class="clearfix">
						</div>
						 筌�占� <a href="#" rel="prev">Create a monetized blog</a> &nbsp; &nbsp; <a href="#" rel="next">Live, Love &amp; Hope</a> 鸚뤄옙
						<div class="clearfix">
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
						</div> --%>
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
