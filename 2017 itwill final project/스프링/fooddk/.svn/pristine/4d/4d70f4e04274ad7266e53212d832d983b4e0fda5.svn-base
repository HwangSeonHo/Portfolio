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
<!-- <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCe79ndtoPiG3-yXC3Jjqj-ZST7IvU8f9o&callback=initMap"></script>
<script async defer src=https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyBiMawWtjLplmWOgnp7nEY_vOdMp3OdFXw></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true"></script> -->
<!-- <script type="text/javascript">
var geocoder;
function tastyWrite() {
	alert("1");
    var address = document.getElementById('t_address').value;
    geocoder = new google.maps.Geocoder();
    alert(geocoder);
    geocoder.geocode({'address':address}, function(results,status) {
	alert("2");
      if (status == 'OK') {
        var latlng = results[0].geometry.location;
        var strLatlng = latlng+"";
        document.z.strLocation.value = strLatlng;
        alert(strLocation);
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
    document.z.submit();
  }
</script> -->
<script src="assets/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.validate.js" type="text/javascript"></script>
<script src="assets/js/messages_ko.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('#commentform').validate({
		rules : {
			t_title : {
				required: true,
				minlength : 2,
				maxlength : 20
			},
			t_content : {
				required : true,
				minlength : 2,
				maxlength : 1000
			},
			t_address : {
				required : true,
				minlength : 5
			},
			t_time : {
				required : true
			},
			t_phone : {
				required : true
			}
		},
		messages : {
			t_title : {
				requeired: "제목을 입력해 주세요",
				minlength : "{0} 글자 이상 입력해 주세요",
				maxlength : "{0} 글자 이하 입력해 주세요"
			},
			t_content : {
				required : "내용을 입력해 주세요",
				minlength : "{0} 글자 이상 입력해 주세요",
				maxlength : "{0} 글자 이하 입력해 주세요"
			},
			t_address : {
				required : "주소을 입력해 주세요",
				minlength : "{0} 글자 이상 입력해 주세요",
			},
			t_time : {
				required : "영업시간을 입력해 주세요"
			},
			t_phone : {
				required : "전화번호를 입력해 주세요"
			}
		},
		onsubmit : true,
		submitHandler : function(form){
			form.action = "TastyWriteAction";
			form.method = "POST";
			form.submit();
		}
	});
});
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
								<h1>Restaurant Write</h1>
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
										<div id="comments" class="comments-area">
											<div id="respond" class="comment-respond">
												<h3 id="reply-title" class="comment-reply-title">
													Questions &amp; Feedback <small><a rel="nofollow"
														id="cancel-comment-reply-link" href="#"
														style="display: none;">Cancel Reply</a></small>
												</h3>
												<form name="z" method="post" id="commentform"
													class="comment-form" enctype="multipart/form-data">
													<input type="hidden" id="strLocation" name="strLocation"> 
													<p class="comment-notes"></p>
													<div class="row commentrow comment-form-comment">
														<div class="row">
															<div class="col-md-5 comment-form-author">
																<label for="t_title">Title</label> <input id="t_title"
																	name="t_title" type="text" size="30" 
																	aria-required="true">
															</div>
															<div class="col-md-6 comment-form-email">
																<label for="t_img">IMG</label><input  type="file" id="file" name="file" size="30" aria-required="true"> 
															</div>
															<div class="col-md-12 comment-form-author">
																<label for="t_time">Time</label> <input id="t_time"
																	name="t_time" type="text" size="30" 
																	aria-required="true">
															</div>
															<div class="col-md-6 comment-form-author">
																<label for="t_phone">Phone</label> <input id="t_phone"
																	name="t_phone" type="text" size="30"
																	aria-required="true">
															</div>
															<div class="col-md-12 comment-form-email">
																<label for="t_address">Address</label> <input
																	id="t_address" name="t_address" type="text" size="30" 
																	aria-required="true">
															</div>
															<div class="col-md-12">
																<label for="t_content">Content</label>
																<textarea id="t_content" name="t_content" rows="50" 
																	cols="50"></textarea>
															</div>
															<!-- <div class="col-md-12">
																<label for="c_no">Category</label>
																<textarea id="c_no" name="c_no" rows="50"
																	cols="50"></textarea>
															</div> -->
															<div class="col-md-4 comment-form-email">
																<label for="c_no">Category</label> <select name="c_no"
																	id="data">
																	<option value="1">한</option>
																	<option value="2">일</option>
																	<option value="3">중</option>
																	<option value="4">양</option>
																	<option value="5">기타</option>

																</select>
																

															</div>
														</div>
													</div>
													<p class="edd-login-submit">
														<input id="edd_login_submit" type="submit"
															class="edd_submit edd-submit" value="Write">
													</p>
												</form>
											</div>
											</div>
											<!-- #respond -->
										</div>
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
										<div class="clearfix"></div>
									</div>
								<div class="clearfix"></div>
								嶺�占썲��占� <a href="#" rel="prev">Create a monetized blog</a>
								&nbsp; &nbsp; <a href="#" rel="next">Live, Love &amp; Hope</a>
								勇�琉���
								<div class="clearfix"></div>
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
