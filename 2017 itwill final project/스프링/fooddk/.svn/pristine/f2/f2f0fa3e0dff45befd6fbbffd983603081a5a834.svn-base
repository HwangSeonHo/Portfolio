<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
function TastyWrite(){
   document.z.action="TastyWrite";
   document.z.method="post";
   document.z.submit();
}
function HoogiListsearch() {
    document.y.action = "HoogiSearchAction";
    document.y.method = "post";
    document.y.submit();
 }
</script>
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
<div id="wrapall">
   <div class="wrapcontent">
   <jsp:include page="common_top.jsp"></jsp:include>

      <!-- PAGE HEADER==========================================-->
      <div class="headertitle">
         <div class="headercontent">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <h1>Restaurant</h1>
                      <span class="wtnbreadcrumbs"><a href="index.jsp">Home</a> <span class="separator">��</span> <span class="actual">Blog</span></span>
                  </div>
               </div>
            </div>
         </div>
      </div>

      <!-- START CONTAINER==========================================-->
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div id="primary" class="content-area">
                  <div class="wowitemboxlist">
                  
                     <c:forEach var="tasty" items="${ListPage.list}" varStatus="status">
                           <div class="wowitembox col-md-6">
                              <div class="wowitemboxinner">
                                 <div class="imagearea">
                               <!--      <img src="assets/img/demo/b3.jpg" alt=""> -->
                               	<img src="${tasty.t_img}" style="width:100%; height:400px;">
                                    <div class="caption">
                                       <div class="blur"></div>
                                       <div class="caption-text">
                                          <div class="captionbuttons">
                                             <a href="TastyView?t_no=${tasty.t_no}"
                                                class="captiondetails"><i class="fa fa-link"></i></a>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                                 <div class="col-md-12 notesarea">
                                    <a href="TastyView?t_no=${tasty.t_no}"
                                       title="Learning Marketing">
                                       <h2>${tasty.t_title}</h2> <br/>
                                    </a> 
                                    <div class="col-md-10">
                                       <a class="readmore"
                                       href="TastyView?t_no=${tasty.t_no}">Read More</a>
                                    </div>
                                    <div class="col-md-2">${tasty.t_count}</div>
                                 </div>
                              </div>
                           </div>
                        </c:forEach>
                  </div>
                     <div class="row">
                        <div class="col-md-12 pagination">
                           <div class="col-md-10">
                              <c:if test="${ListPage.isShowFirst()}">
                                 <a href="SearchList?selectPage=1&s_val=${s_val}">first</a>&nbsp;
                                    </c:if>
                              <c:if test="${ListPage.isShowPreviousGroup()}">
                                 <a
                                    href="SearchList?selectPage=${ListPage.previousGroupStartPageNo}&s_val=${s_val}">prev</a> &nbsp;              
                                    </c:if>
      
                              <c:forEach begin="${ListPage.startPageNo}"
                                 end="${ListPage.endPageNo}" varStatus="status">
                                 <c:if test="${status.index==ListPage.selectPageNo}">
                                    <span class="current">${status.index}</span>
                                 </c:if>
                                 <c:if test="${status.index !=ListPage.selectPageNo}">
                                    <a href="SearchList?selectPage=${status.index}&s_val=${s_val}"
                                       class="inactive">${status.index}</a> &nbsp; </c:if>
                              </c:forEach>
      
                              <c:if test="${ListPage.isShowNextGroup()}">
                                 <a href="SearchList?selectPage=${ListPage.nextGroupStartPageNo}&s_val=${s_val}">next</a>&nbsp;
                                  </c:if>
                              <c:if test="${ListPage.showLast}">
                                 <a href="SearchList?selectPage=${ListPage.totalPageCount}&s_val=${s_val}">last</a>&nbsp;
                                    </c:if>
                                 </div>
                                 <div class="col-md-2">
                                    <form action="TastyWrite">
                                 <input name="submit" type="submit" id="submit" class="submit" value="Write">
                              </form>
                           </div>
                        </div>
                     </div>
                  </div>
               <!-- #primary -->
            </div>
            <jsp:include page="common_tasty_right.jsp"></jsp:include>
         </div>
      </div>
      <!-- / END CONTAINER==========================================-->
   </div>
   <!-- end /.wrapcontent -->
   <!-- CALL TO ACTION
      ==========================================-->
   <jsp:include page="common_bottom.jsp"></jsp:include>
<!-- end /.wrapall -->
</body>
</html>