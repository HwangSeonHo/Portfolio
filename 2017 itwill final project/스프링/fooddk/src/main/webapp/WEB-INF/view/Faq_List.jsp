<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Faq"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript">
   function FaqWrite() {

      document.z.action = "Faq_Write_form";
      document.z.method = "get";
      document.z.submit();

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



	<!--**********************************************************************************************************--!>
		<!-- START CONTAINER
		==========================================-->
		<form name="z" method="post">
		<div class="container container-boxed">
			<div class="panel-group" id="accordion">
			        <c:forEach var="faq" items="${FaqList}" varStatus="status">
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <!-- <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"> -->
			        <a class="accordion-toggle"  data-parent="#accordion" href="#collapseOne">
			          ${faq.f_title}
			        </a>
			      </h4>
			    </div>
			    <div id="collapseOne" class="panel-collapse collapse in">
			      <div class="panel-body">	
			      <c:if test="${sId=='admin'}">		        	
			        <a href="Faq_Modify_form?f_no=${faq.f_no}">${faq.f_content}</a>
			        </c:if> 		
			      <c:if test="${sId!='admin'}">		        	
			        ${faq.f_content}
			        </c:if> 		
			        	           			        
			      </div>
			    </div>
			  </div>
			  </c:forEach>
			  
			  
			  <!-- <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
			          Question no #2
			        </a>
			      </h4>
			    </div>
			    <div id="collapseTwo" class="panel-collapse collapse">
			      <div class="panel-body">
			        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
			      </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
			          Question no #3
			        </a>
			      </h4>
			    </div>
			    <div id="collapseThree" class="panel-collapse collapse">
			      <div class="panel-body">
			        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
			      </div>
			    </div>
			  </div> --> 
			   
			</div>
			  
		</div>
		<!-- / END CONTAINER
		==========================================-->
	</div>
	</form>		
		
	
	
	
	
	<jsp:include page="common_bottom.jsp"></jsp:include>
	
	<!--**********************************************************************************************************--!>
	
	
	
	
	
	
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
