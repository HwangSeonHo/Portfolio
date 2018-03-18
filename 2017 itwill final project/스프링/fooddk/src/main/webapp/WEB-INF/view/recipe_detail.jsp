<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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




function recipeList(){
	r.action="recipe_list?c_no=0";
	r.submit();
}
 function recipeRemove(){
	 alert("삭제하시겠습니까?");
	r.method="POST";
	r.action="recipe_remove_action";
	r.submit();
}
 function recipeModify(){
	r.method="POST";
	r.action="recipe_modify_form";
	r.submit();
}

/* recipeRemove()
recipeModify()
recipeList()
 */
</script>

<!-- 댓글 list insert delete 추가 한 부분! -->
<script type="text/javascript" src='assets/js/httpRequest.js'></script>
<script type="text/javascript">
	function getdatgleList(page) {
		document.getElementById('datgleList').innerHTML = '';
		document.getElementById('datglePage').innerHTML = '';
		//alert(page);
		var pageCountPerPage = 5;
		var rowCountPerPage = 10;
		var d_filter = "recipe";
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
		
		  if('${modify==1}'){
			 
				alert('${point}');
			}else{
				return
			}
		getdatgleList(1);
	};
</script>


</head>
<body>
<jsp:include page="common_top.jsp"></jsp:include>

		<!-- PAGE HEADER
		==========================================-->
		<form name="r" method="POST">
		<div class="headertitle">
				<div class="headercontent">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								  <h1><span>Recipe Detail</span></h1>
								  <h3><span>${recipe.r_title}</span></h3>
								  <input type="hidden" name="r_no" value="${recipe.r_no}">
								<input type="hidden" name="point" value="${m_point}">
								
							 </div>
						</div>
					</div>
				</div>
			</div>
			

		<!-- START CONTAINER
		==========================================-->


		<div class="container">
			<div class="whiteboxed whiteboxeborder">

			<div class="row">
				<!--Main Content-->
				<div class="col-md-8">
					<div id="primary" class="content-area">
						<article id="post-30">
						<img src="${recipe.getR_img()}" style="width:100%; height:400px;">
					
						
						<div class="contentdownloadphp">
						<br/>
						<input type="hidden" name="r_no" value="${recipe.r_no}">
						<div class="wowmetaposts entry-meta">
												<span class="wowmetadate"><i class="fa fa-clock-o"></i>${recipe.r_date.toString().substring(0,10)}</span>
												
												<span class="wowmetaauthor"><i class="fa fa-user"></i>
													<a href="#">${m_id}</a></span> <span class="wowmetacats"><i
													class="fa fa-folder-open"></i> <a href="#">13
														(count)</a></span> <span class="wowmetacommentnumber"><i
													class="fa fa-comments"></i> <a href="#">${recipe.r_count}</a></span><br/>
						</div>
						<br/>
								${recipe.r_content}
						<br/><br/><br/>
				
								<div class="tagcloud">
									<c:if test="${m_id==sId}">
										 <input type="button" onClick="recipeRemove();" rel="tag" value="delete" class="edd-submit button blue"> 
										<input type="button" onClick="recipeModify();" rel="tag" value="modify" class="edd-submit button blue"> 
									</c:if>
									<input type="button" onClick="recipeList();" rel="tag" value="List" class="edd-submit button blue">
								</div>
							</form>
							
							<!-- <div id="comments" class="comments-area">
								<div id="respond" class="comment-respond">
									<h3 id="reply-title" class="comment-reply-title">Questions &amp; Feedback <small><a rel="nofollow" id="cancel-comment-reply-link" href="/demo-lambada/downloads/image-file/#respond" style="display:none;">Cancel Reply</a></small></h3>
									<form action="#" method="post" id="commentform" class="comment-form">
										<p class="comment-notes">
										</p>
										<div class="row commentrow comment-form-comment">
											<div class="col-md-12">
												<label for="comment">Comment</label><textarea id="comment" name="comment" rows="5" aria-required="true"></textarea>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4 comment-form-author">
												<label for="author">Name</label><input id="author" name="author" type="text" value="" size="30" aria-required="true">
											</div>
											<div class="col-md-4 comment-form-email">
												<label for="email">E-mail</label><input id="email" name="email" type="text" value="" size="30" aria-required="true">
											</div>
											<div class="col-md-4 comment-form-url">
												<label for="url">Website</label><input id="url" name="url" type="text" value="" size="30">
											</div>
										</div>
										<p class="form-submit">
											<input name="submit" type="submit" id="submit" class="submit" value="Submit"><input type="hidden" name="comment_post_ID" value="30" id="comment_post_ID">
										</p>
										<noscript>
										</noscript>
									</form>
								</div>
								#respond
							</div> -->
						</div>
						</article>
					</div>
				</div>
				
				

					<!-- Sidebar (Buy Button)-->
					<div class="col-md-4 stickthis is_stuck">
					
						<div class="sidebar-singledownload" align="left">
						
						
				<!-- 댓글 리스트 부분, uix-pb-price의 주석을 지우면 o대신 v모양으로 뜨는데 리스트가 밀림 -->
						<p class="comment-notes"></p>
						<div class="container">
							<!-- <div class="uix-pb-price"> -->
								<div class="uix-pb-row">
									<div class="uix-pb-price-bg-hover uix-pb-price-init-height" >
										<div class="uix-pb-price-detail" id="datgleList"> 
											<ul>
												<li>아직 이 게시물에 댓글이 없어요</li>
											</ul>
										</div>
									</div>
								</div>
							<!-- </div> -->
						</div>
						<!--  -->
						
						<div class="row" id="datglePage">	
						<a href="#;" onClick='getdatgleList(1);'>1</a>
						<a href="#;" onClick='getdatgleList(2);'>2</a>
						<a href="#;" onClick='getdatgleList(3);'>3</a>
						<a href="#;" onClick='getdatgleList(4);'>4</a>
						<a href="#;" onClick='getdatgleList(5);'>5</a>				
						</div>
							
					<div id="comments" class="comments-area">
								<div id="respond" class="comment-respond">
									<!-- <h3 id="reply-title" class="comment-reply-title" align="left">Questions &amp; Feedback <small><a rel="nofollow" id="cancel-comment-reply-link" href="/demo-lambada/downloads/image-file/#respond" style="display:none;">Cancel Reply</a></small></h3> -->
									<form method="post" id="commentform" class="comment-form" name="commentform">
										<p class="comment-notes">
										</p>
										<div class="row commentrow comment-form-comment">
										<div class="col-md-6" align="left">
											<label for="comment" ><font size="5px">Comment</font></label>
											<!-- <label for="author">id</label><input id="author" name="author" type="text" value=""  size="15" aria-required="true"> -->
										</div>
											<div class="col-md-12" align="left">
												
												<textarea id="comment" name="comment" rows="5" aria-required="true"></textarea>
											
											</div>
											
										</div>
										<!-- <div class="row">
											<div class="col-md-4 comment-form-author">
												<label for="author">Name</label><input id="author" name="author" type="text" value="" size="30" aria-required="true">
											</div>
											<div class="col-md-4 comment-form-email">
												<label for="email">E-mail</label><input id="email" name="email" type="text" value="" size="30" aria-required="true">
											</div>
											
										</div> -->
										
							<!-- 댓글 insert 바꾼 부분! -->
										<p class="form-submit">
											<input name="submit" type=button id="submit" class="submit" value="Submit"
												   onClick='datgleInsert();'>
											<input type="hidden" name="comment_post_ID" value="43" id="comment_post_ID">
											<input type="hidden" name="comment_parent" id="comment_parent"
												value="0">
										
										</p>
											<input type="hidden" name="d_groupno" id="d_groupno" value="${recipe.r_no}">
											<input type="hidden" name="d_title" id="d_title" value="제목 없음">
											<input type="hidden" name="d_step" id="d_step" value="0">
											<input type="hidden" name="d_filter" id="d_filter" value="recipe">
											<input type="hidden" name="d_no" id="d_no" value="0">
											<input type="hidden" name="sId" id="sId" value="${sId}">
										<noscript></noscript>
							<!--  -->
									</form>
									
								</div>
								<!-- #respond -->
							</div>
						</div>
					</div>
					<!-- End Sidebar-->

				</div> <!-- /.row-->

			<!-- Related Items-->
				<section class="lambada homepopularproducts">
				
					<div class="clear text-center">
						<a href="recipe_list?c_no=0" class="view-all">
						<h2 class="maintitle">
						popular Post <span>Browse all</span>
						</h2>
						</a>
					</div>
					
					<div class="sectionpopularitems clear">
					<c:forEach var="list" items="${listByCount}" varStatus="status">
						<div class="wowitemboxinner" align="center">
							<div class="imagearea">
								<img src="${list.r_img}" alt="">
								<div class="caption">
									<div class="blur">
									</div>
									<div class="caption-text">
										<div class="captionbuttons">
											<a href="recipe_detail?r_no=${list.r_no}" class="captiondetails"><i class="fa fa-link"></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="notesarea">
								<a href="recipe_detail?r_no=${list.r_no}" title="City Photo">
								<h2>${list.r_title}</h2>
								</a>
								<div class="description">
									<p>
										${list.r_date.toString().substring(0,10)} 
									</p>
								</div>
							
							<!-- 	<div class="notesbottom variable">
									<div class="price fleft">
										 $3.99 - $19.99
									</div>
									<div class="cart fright">
										<a href="#" class="edd-submit button green">Purchase</a>
									</div>
										<div class="clearfix">
										</div>
									</div> -->
								</div>
							</div>
						</c:forEach>
						
						<!-- .wowitemboxinner-->
						<!-- <div class="wowitemboxinner">
							<div class="imagearea">
								<img src="assets/img/demo/d7-1.jpg" alt="">
								<div class="caption">
									<div class="blur">
									</div>
									<div class="caption-text">
										<div class="captionbuttons">
											<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="notesarea">
								<a href="product.jsp" title="Some Plugin">
								<h2>Some Plugin</h2>
								</a>
								<div class="description">
									<p>
										 This is a short excerpt to generally describe what the item is about.
									</p>
								</div>
								<div class="notesbottom">
									<div class="price fleft">
										 $45.00
									</div>
									<div class="cart fright">
										<a href="#" class="edd-submit button green">Purchase</a>
									</div>
									<div class="clearfix">
									</div>
								</div>
							</div>
						</div>
						.wowitemboxinner
						<div class="wowitemboxinner">
							<div class="imagearea">
								<img src="assets/img/demo/d4-1.jpg" alt="">
								<div class="caption">
									<div class="blur">
									</div>
									<div class="caption-text">
										<div class="captionbuttons">
											<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="notesarea">
								<a href="product.jsp" title="Digital Flyer">
								<h2>Digital Flyer</h2>
								</a>
								<div class="description">
									<p>
										 This is a short excerpt to generally describe what the item is about.
									</p>
								</div>
								<div class="notesbottom variable">
									<div class="price fleft">
										 $14.99 - $19.99
									</div>
									<div class="cart fright">
										<a href="#" class="edd-submit button green">Purchase</a>
									</div>
									<div class="clearfix">
									</div>
								</div>
							</div>
						</div>
						.wowitemboxinner
						<div class="wowitemboxinner">
							<div class="imagearea">
								<img src="assets/img/demo/d3-1-1.jpg" alt="">
								<div class="caption">
									<div class="blur">
									</div>
									<div class="caption-text">
										<div class="captionbuttons">
											<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="notesarea">
								<a href="product.jsp" title="Astrology E-book">
								<h2>Astrology E-book</h2>
								</a>
								<div class="description">
									<p>
										 This is a short excerpt to generally describe what the item is about.
									</p>
								</div>
								<div class="notesbottom variable">
									<div class="price fleft">
										 $11.99 - $19.99
									</div>
									<div class="cart fright">
										<a href="#" class="edd-submit button green">Purchase</a>
									</div>
									<div class="clearfix">
									</div>
								</div>
							</div>
						</div>
						.wowitemboxinner
						<div class="wowitemboxinner">
							<div class="imagearea">
								<img src="assets/img/demo/d5-3.jpg" alt="">
								<div class="caption">
									<div class="blur">
									</div>
									<div class="caption-text">
										<div class="captionbuttons">
											<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="notesarea">
								<a href="product.jsp" title="Menu Brochure">
								<h2>Menu Brochure</h2>
								</a>
								<div class="description">
									<p>
										 This is a short excerpt to generally describe what the item is about.
									</p>
								</div>
								<div class="notesbottom">
									<div class="price fleft">
										 $18.00
									</div>
									<div class="cart fright">
										<a href="#" class="edd-submit button green">Purchase</a>
									</div>
									<div class="clearfix">
									</div>
								</div>
							</div>
						</div>
						end wowitemboxinner
						.wowitemboxinner
						<div class="wowitemboxinner">
							<div class="imagearea">
								<img src="assets/img/demo/d3-4.jpg" alt=""/>
								<div class="caption">
									<div class="blur">
									</div>
									<div class="caption-text">
										<div class="captionbuttons">
											<a href="product.jsp" class="captiondetails"><i class="fa fa-link"></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="notesarea">
								<a href="product.jsp" title="Image File">
								<h2>Image File</h2>
								</a>
								<div class="description">
									<p>
										 This is a short excerpt to generally describe what the item is about.
									</p>
								</div>
								<div class="notesbottom variable">
									<div class="price fleft">
										 $5.00 - $19.99
									</div>
									<div class="cart fright">
										<a href="#" class="edd-submit button green">Purchase</a>
									</div>
									<div class="clearfix">
									</div>
								</div>
							</div>
						</div> -->
						<!-- .wowitemboxinner-->
					
					</div>
					<!-- .wowitemboxlist-->
					</section>

			


		</div> <!-- /.container-->

		<!-- / END CONTAINER
		==========================================-->

	 </div> <!-- end /.wrapcontent -->

	<!-- CALL TO ACTION
		==========================================-->
	
	<!-- FOOTER
		==========================================-->
<jsp:include page="common_bottom.jsp"></jsp:include>
<!-- end /.wrapall -->
</body>
</html>
