<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript" src='assets/js/httpRequest.js'></script>
<script type="text/javascript">
	function requestJumon(){
		sendRequest('jumon_list' ,null, printJumonList, 'POST');
	}
	function printJumonList(){
		if(xhr.readyState==4){
			var receiveJumonListText = xhr.responseText;
			var receiveJumonListJson = JSON.parse(receiveJumonListText);
			//alert(receiveJumonListText);
			/*
				[
					jumon0: {
					seat_no: 1,
					i_name: "커피"
					}, ..
				]
			*/
			
			var length = Object.keys(receiveJumonListJson).length;
			//alert(length);
			if(length==0){
				return;
			}
			var html="<ol>";
			for(var i=0; i<length-1; i++){
				html += "<li>"+receiveJumonListJson[i].i_name+" "+receiveJumonListJson[i].i_price+"원</li>"; 
			 } 
			html += "</ol>"
			html += "<p>total : "+receiveJumonListJson[9999].price+"원</p>"; 
			 
			document.getElementById('updateJumon').innerHTML=html; 
		}
			
		
			
		
	}
			
			
 	window.onload = function(){
		window.setInterval(requestJumon, 2000);
	}
	
	
	

</script>
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
</head>
<body>
<jsp:include page="common_top.jsp"></jsp:include>

		<!-- START CONTAINER
		==========================================-->
		<div class="templatemyaccount">
			<div class="container">
				<div class="whiteboxed whiteboxeborder">
					<div class="row">
						<div class="col-md-12">
							<div class="wraplogin">
							<c:forEach var="item" items="${itemList}" varStatus="status">
								<form id="edd_login_form" class="edd_form" action="#" method="post">
									<fieldset>
										<legend>menu</legend>
										<p class="edd-login-username">
											<label for="edd_user_login">number</label>
											<label for="edd_user_login" >${item.i_no }</label>											
										</p>
										<p class="edd-login-password">
											<label for="edd_user_pass">name</label>
											<label for="edd_user_login">${item.i_name }</label>
										</p>
										<p class="edd-login-password">
											<label for="edd_user_pass">money</label>
											<label for="edd_user_login">${item.i_price }</label>
										</p>										
									</fieldset>
								</form>
								</c:forEach>
							</div>
							<span class="or">or</span>
							<div class="wrapregister">
							<%-- <c:forEach var="jumon" items="${jumonList}" varStatus="status"> --%>
								<form id="edd_register_form" class="edd_form" action="#" method="post">
									
									<fieldset>
										<legend>jumon list</legend>
										<%-- <p>
											<label for="edd_user_login">number</label>
											<label for="edd_user_login">${jumon.j_no }</label>	
										</p> --%>
										<p>
											<label for="edd_user_login">seat</label>
											<label for="edd_user_login">1번 테이블</label>
										</p>
										<p>
											<label for="edd_user_login">item</label>
											<label for="edd_user_login" id="updateJumon"></label>
										</p>										
									</fieldset>
									
								</form>
							<%-- </c:forEach> --%>
							</div>
						</div>
					</div>
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
