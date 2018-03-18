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

   /*    //1.��û��������ȣ   
      String pageno = request.getParameter("pageno");//����¡��ȣ
      if (pageno == null || pageno.equals("")) {
         pageno = "1";
      }
      //2.����������ǥ���� �Խù��� 
      int rowCountPerPage = 7;
      //3.���������������� ��������ȣ����(<< 1 2 3 4 5 >>)
      int pageCountPerPage = 3;
      //����¡(���)������DTO
      ListPageConfigBean pageConfig = new ListPageConfigBean(rowCountPerPage, pageCountPerPage, pageno, "", "");
      //�Խù���ȸ
      ListResultBean HoogiListPage = HoogiService.
   
    */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>���� �����</title>
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
         <td height=25><b>�ı�Խ���</b></td>
      </tr>
   </table>
   <form name="z" method="post">
      <table border="1" cellpadding="0" cellspacing="1">
         <tr>
            <th>�ı�۹�ȣ</th>
            <th>�ı������</th>
            <th>�ı��������</th>
            <th>�ı�۳�¥</th>
            <th>�ı���̹���</th>
            <th>������ȸ��</th>
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
               <a href="./visitor_list.do?pageno=<%=VisitorListPage.getPreviousGroupStartPageNo()%>">��</a>
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
                <a   href="./visitor_list.do?pageno=<%=VisitorListPage.getNextGroupStartPageNo()%>">��</a>
               <%}%> <%
                if (VisitorListPage.isShowLast()) {
                %> <a href="./visitor_list.do?pageno=<%=VisitorListPage.getTotalPageCount()%>">����</a>
               <%}%> --%>

             </td>
         </tr> 

         <tr>
            <td align="right"> <input type="button" onClick=writeform();
               value="���Ͼ���" />
            </td>
         </tr>
         
         
            <c:if test="${ListPage.isShowFirst()}">
                  <a href="HoogiList?selectPage=1">����</a>&nbsp;
                  
               </c:if> 
               
               
               <c:if test="${ListPage.isShowPreviousGroup()}">
                  <a
                     href="HoogiList?selectPage=${ListPage.previousGroupStartPageNo}">��</a> &nbsp;
               
                  
               </c:if> 
                  <c:forEach  begin="${ListPage.startPageNo}" end="${ListPage.endPageNo}" varStatus="status">
                     <a href ="HoogiList?selectPage=${status.index}">${status.index}</a> &nbsp;
  
                  </c:forEach> 
                  
                  
               <c:if test="${ListPage.isShowNextGroup()}">
                  <a href="HoogiList?selectPage=${ListPage.nextGroupStartPageNo}">��</a>&nbsp;
               
               </c:if> <c:if test="${ListPage.showLast}">
                  <a href="HoogiList?selectPage=${ListPage.totalPageCount}">����</a>&nbsp;
                  
               </c:if>
               
      </table>
   </form>
</body>
</html>