<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Hoogi"%>
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
	function recipeModifyAction(){
		
		document.z.action="recipe_modify_action";
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
<jsp:include page="common_top.jsp"></jsp:include>

	

		<!-- PAGE HEADER
		==========================================-->
		<div class="headertitle">
			<div class="headercontent">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1>Recipe Modify Form</h1>
						    <span class="wtnbreadcrumbs">recipe modify form </span>
						   <!--  <span class="separator"></span> <a class="brcat" href="#"></a> <a class="brcat" href="#"></a> 
						    <a class="brcat" href="#"></a> <a class="brcat" href="#"></a>  <span class="separator"></span> <span class="actual">Confidence is Key</span> -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- START CONTAINER
		==========================================-->
		<form name="z" method="POST" enctype="multipart/form-data" >
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div id="primary" class="content-area">
						<main id="main" class="site-main whiteboxed" role="main">
						<div class="wrapindexcerpt">
							<div class="contenttext">
								<div class="post-content">
									
						<div id="comments" class="comments-area">
							<div id="respond" class="comment-respond">
								<h3 id="reply-title" class="comment-reply-title">modify <small>
								<a rel="nofollow" id="cancel-comment-reply-link" href="Hoogi_Modify_Action" style="display:none;">Cancel Reply</a></small></h3>
								<form name="z" method="post" id="commentform" class="comment-form" enctype="multipart/form-data" >
									<p class="comment-notes">
									</p>
									<div class="row commentrow comment-form-comment">
									<div class="row">
									<input type ="hidden" name =r_no value="${recipe.r_no}">
									<input type="hidden" name="c_no" value="${recipe.c_no}">
										<div class="col-md-8 comment-form-author">
											<label for="r_title">Title</label>
											<input  id="r_title" name="r_title" type="text" value="${recipe.r_title}" size="30" aria-required="true">
										</div>
										<input type="hidden" name="m_no" value="1">
										
											<div class="col-md-4 comment-form-email" >
													<label for="c_no">c_no</label>
												
														<select name="c_no" id="data" >
															<%-- <option selected="selected" value="${c_no}"> --%>
															<!-- <option value="6">종류를 선택해 주세요</option> -->
															<option value="1">한</option>
															<option value="2">일</option>
															<option value="3">중</option>
															<option value="4">양</option>
															<option value="5">기타</option>
															
														</select>
														<noscript>
															<input type="submit" value="Submit">
														</noscript>
											
											</div>
									
										
									</div><!-- row end -->
									<div class="col-md-12">
												<label for="r_content">Content</label>
												<textarea wrap="soft" style="width:700px" rows="10" name="r_content" >${recipe.r_content}</textarea>
												 <br>
									</div> 
									<div class="col-md-4">
													<!-- <label for="r_img">IMG</label>  -->
													 <input type="hidden"	name="r_img" value=""> 
												File upload	<input type="file" name="file"> <br />
												<br/>
										<input type = "button" onClick="recipeModifyAction()" value ="Modify"> 
									</div>
					
									
									</div>
								
						
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
										<!-- <a href="HoogiList_1" rel="tag">list</a> -->
									</div>
								</div>
								<div class="clearfix">
								</div>
							</div>
						</div>
						<div class="clearfix">
						</div>
						<!--  筌�占� <a href="#" rel="prev">Create a monetized blog</a> &nbsp; &nbsp; <a href="#" rel="next">Live, Love &amp; Hope</a> 鸚뤄옙 -->
						<div class="clearfix">
						</div>
					
						</main>
						<!-- #main -->
					</div>
					<!-- #primary -->
				</div>
				<div class="col-md-4">
					<div id="secondary" class="widget-area q2w3-fixed-widget-container" role="complementary">
						<aside class="widget widget_search">
						<form role="search" method="get" class="search-form" action="#">
							<input type="search" class="search-field" placeholder="Type and hit enter..." value="" name="s" title="">
							<input type="hidden" name="post_type" value="post">
						</form>
						</aside>
					<aside class="widget widget_recent_entries">
						<h2 class="widget-title section-title"><span>BAROGAGI</span></h2>
						<ul>
							<li>
							<a href="HoogiList_1">BestReview</a>
							</li>
							<li>
							<a href="TastyList_Count">Popular Restaurant</a>
							</li>
							<li>
							<a href="TastyList_Date">Resent Restaurant</a>
							</li>
						
						</ul>
						</aside> 
						<!-- fixed widget -->
					
					</div>
					<!-- #secondary -->
				</div>
			</div>
		</div>
		</form>
		<!-- / END CONTAINER
		==========================================-->
	</div>
	<!-- end /.wrapcontent -->
	<!-- CALL TO ACTION
		==========================================-->
	<jsp:include page="common_bottom.jsp"></jsp:include>
</body>
</html>
