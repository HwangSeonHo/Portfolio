<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Hoogi"%>
<%@page import="fooddk.paging.ListResultBean"%>
<%@page import="fooddk.paging.ListPageConfigBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   //HoogiService hoogservice = new HoogiService();
   /* HoogiServiceImpl hoogiServiceImpl = new HoogiServiceImpl();
   
   List<Hoogi> hoogiList = hoogiServiceImpl.selectAll(); */

   request.setCharacterEncoding("EUC-KR");

   /*    //1.요청페이지번호   
      String pageno = request.getParameter("pageno");//페이징번호
      if (pageno == null || pageno.equals("")) {
         pageno = "1";
      }
      //2.한페이지에표시할 게시물수 
      int rowCountPerPage = 7;
      //3.한페이지에보여줄 페이지번호갯수(<< 1 2 3 4 5 >>)
      int pageCountPerPage = 3;
      //페이징(계산)을위한DTO
      ListPageConfigBean pageConfig = new ListPageConfigBean(rowCountPerPage, pageCountPerPage, pageno, "", "");
      //게시물조회
      ListResultBean HoogiListPage = HoogiService.
   
    */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>방명록 만들기</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script type="text/javascript">
   function writeform() {
      document.z.action = "HoogiWriteForm";
      document.z.method = "post";
      document.z.submit();
   }
</script>
</head>

<body>

   <table border=0>
      <tr>
         <td height=25><b>후기게시판</b></td>
      </tr>
   </table>
   <form name="z" method="post">
      <table border="1" cellpadding="0" cellspacing="1">
         <tr>
            <th>후기글번호</th>
            <th>후기글주제</th>
            <th>후기글컨텐츠</th>
            <th>후기글날짜</th>
            <th>후기글이미지</th>
            <th>방명록조회수</th>
         </tr>
         <c:forEach var="hoogi" items="${ListPage.list}" varStatus="status">
            <tr>
               <td>${hoogi.h_no}</td>
               <%--    <td><a href="visitor_view.do?v_no=<%=visitor.getV_no()%>">
                  <%=visitor.getV_title()%></a></td>  --%>
               <td><a href="HoogiView?h_no=${hoogi.h_no}">${hoogi.h_title}</a></td>

               <td>${hoogi.h_content}</td>
               <td>${hoogi.h_date}</td>
               <td>${hoogi.h_img}</td>
               <td>${hoogi.h_count}</td>
            </tr>

         </c:forEach>


        <tr>
            <td align="center">
         

         <%--  <c:if test="{hoogiList.isSHowPreviousGroup()}"
         <%-- <%if (hoogiList.isShowPreviousGroup()=hoogiList.getgetPreviousGroupStartPageNo()) {%> 
               <a href="./visitor_list.do?pageno=<%=VisitorListPage.getPreviousGroupStartPageNo()%>">◀</a>
               <%}% --%>
         <%-- </c:if> --%>
         <%-- <%
                for (int i = VisitorListPage.getStartPageNo(); i <= VisitorListPage.getEndPageNo(); i++) {
                if (VisitorListPage.getSelectPageNo() == i) {%>
                 <font color='blue'><strong><%=i%></strong></font><%
                } else {
                %> 
                <a href="./visitor_list.do?pageno=<%=i%>"> <strong><%=i%></strong></a>
               <%}   }%> 
               <%if (VisitorListPage.isShowNextGroup()) {%> 
                <a   href="./visitor_list.do?pageno=<%=VisitorListPage.getNextGroupStartPageNo()%>">▶</a>
               <%}%> <%
                if (VisitorListPage.isShowLast()) {
                %> <a href="./visitor_list.do?pageno=<%=VisitorListPage.getTotalPageCount()%>">▶▶</a>
               <%}%> --%>

             </td>
         </tr> 

         <tr>
            <td align="right"> <input type="button" onClick=writeform();
               value="방명록쓰기" />
            </td>
         </tr>
         
         
            <c:if test="${ListPage.isShowFirst()}">
                  <a href="HoogiList?selectPage=1">◀◀</a>&nbsp;
                  
               </c:if> 
               
               
               <c:if test="${ListPage.isShowPreviousGroup()}">
                  <a
                     href="HoogiList?selectPage=${ListPage.previousGroupStartPageNo}">◀</a> &nbsp;
               
                  
               </c:if> 
                  <c:forEach  begin="${ListPage.startPageNo}" end="${ListPage.endPageNo}" varStatus="status">
                     <a href ="HoogiList?selectPage=${status.index}">${status.index}</a> &nbsp;
  
                  </c:forEach> 
                  
                  
               <c:if test="${ListPage.isShowNextGroup()}">
                  <a href="HoogiList?selectPage=${ListPage.nextGroupStartPageNo}">▶</a>&nbsp;
               
               </c:if> <c:if test="${ListPage.showLast}">
                  <a href="HoogiList?selectPage=${ListPage.totalPageCount}">▶▶</a>&nbsp;
                  
               </c:if>
               
      </table>
   </form>
</body>
</html>