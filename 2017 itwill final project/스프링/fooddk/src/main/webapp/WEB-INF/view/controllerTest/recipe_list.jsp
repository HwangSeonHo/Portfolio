
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���� ����</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">

<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">



<script	src="js/recipe.js"></script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
		<!-- include_common_top.jsp start-->
		<jsp:include page="include_common_top.jsp"></jsp:include>	
		<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"></jsp:include>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		
		
		
		<!-- wrapper content start -->
<div id="wrapper">
	<div id="content">	
	<table border=0 cellpadding=0 cellspacing=0>
	<tr>
		<td><br />
			<table style="padding-left: 10px" border=0 cellpadding=0
				cellspacing=0>
				<tr>
					<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>������ ���� -
							����Ʈ</b></td>
				</tr>
			</table>
			
			<form name="f" method="post">
				
				<table border="0" cellpadding="0" cellspacing="1" width="590"
					bgcolor="BBBBBB">
					<tr>
						<td width=50 align=center bgcolor="E6ECDE" height="22">��ȣ</td>
						<td width=300 align=center bgcolor="E6ECDE">����</td>
						<td width=120 align=center bgcolor="E6ECDE">�̸�</td>
						<td width=120 align=center bgcolor="E6ECDE">��¥</td>
						<td width=120 align=center bgcolor="E6ECDE">��ȸ��</td>
					</tr>
					
					<c:forEach var="recipeList"   items="${listResultBean.list}" varStatus="status">
					<tr>
		
						<td width=50 align=center bgcolor="ffffff" height="20">${recipeList.r_no}</td>
						<td width=300 bgcolor="ffffff" style="padding-left: 10">
						<a href="recipe_view?r_no=${recipeList.r_no}" class="user">
								${recipeList.r_title}
						</a>
						</td>
						<td width=120 align=center bgcolor="ffffff">${recipeList.m_no}</td>
						<td width=120 align=center bgcolor="ffffff">${recipeList.r_date}</td>
						<td width=120 align=center bgcolor="ffffff">${recipeList.r_count}</td>
				</tr>
				</c:forEach>
				
				
							</table>
								</form> 
	
				
<c:if test="${listResultBean.isShowFirst()}">
					<a href="/recipe_list?selectPage=1">����</a>
</c:if>
<!-- ${listResultBean.isShowFirst()} �� ���õ� �������� 1���� �ƴ��� �Ǵ�����. ���࿡ ���õ� �������� 1�̶��  ������ �����ش�.-->
				
				<c:if test="${listResultBean.isShowPreviousGroup()}"> <!-- ${listResultBean.isShowPreviousGroup()}�� �����׷����������� �����ٰ������� ����-->
				 <a href="/recipe_list?selectPage="${listResultBean.previousGroupStartPageNo}></a>��</c:if>
				
				
				<c:forEach var="pageNo" begin="${listResultBean.startPageNo }" end="${listResultBean.endPageNo}"  varStatus="status">
					<c:if test="${listResultBean.selectPageNo==status.index}"><!-- ���õ� �������� �ε����� ���ٸ� ��Ʈ���� red -->
							<font color='red'>
								<a href="recipe_list?selectPage=${status.index}">${status.index}</a>
							</font>
							</c:if>
							<c:if test="${listResultBean.selectPageNo!=status.index}">
								<a href="recipe_list?selectPage=${status.index}">${status.index}</a>
							</c:if>
				</c:forEach>
				
				<c:if test="${listResultBean.isShowNextGroup() }">
					<a href="/recipe_list?selectPage="${listResultBean.nextGroupStartPageNo}></a>��
				</c:if>
				
				<c:if test="${listResultBean.isShowLast()}">
					<a href="/recipe_list?selectPage=${listResultBean.totalPageCount}">����</a>
				</c:if>
				
			<table border="0" cellpadding="0" cellspacing="1" width="590">
				<tr>
					<td align="right"><input type="button" onclick="recipeCreateForm();" value="���� ����" /></td>
				</tr>
			</table></td>
			</tr>
</table>
</div>

		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"></jsp:include>
			<!-- include_common_bottom.jsp end-->
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>