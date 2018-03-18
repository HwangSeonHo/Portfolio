
<%@page import="fooddk.domain.Hoogi"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script type="text/javascript">
	function HoogiList(){
		document.z.action="HoogiList";
		document.z.method="post";
		document.z.submit();
	}

	function HoogiRemove(){
		
		if(window.confirm("방명록을 삭제하시겠습니까?"))
		alert(document.z.A.value);
		
		//document.z.action="HoogiRemoveAction?h_no="+${hoogi.getH_no()};
		document.z.action="HoogiRemoveAction";
		document.z.method="post";
		document.z.submit();

	}
	
	
	function HoogiUpdate(){
		document.z.action="HoogiUpdateForm?h_no="+${hoogi.getH_no()};
		//document.z.action="HoogiUpdateForm";
		document.z.method="post";
		document.z.submit();
	}
/* 	function visitorReply(){
		document.z.action="visitor_reply_form.do?v_no="+${visitor.getV_no()};
		document.z.mehtod="post";
		document.z.submit(); 
	}  */
 
</script>

<title>Insert title here</title>
</head>
<body>
<form name ="z" method="post">
	<!-- 삭제할 번호를 가져와야 되므로 hidden을 불러온다 -->
	<input type="hidden" id="A" name="h_no" value ="${hoogi.getH_no()}"/>
	
	후기 게시팜 주제 : ${hoogi.getH_title()} <br/>
	후기 게시팜 내용 : ${hoogi.getH_content()}<br/>
	후기 게시팜 날짜 : ${hoogi.getH_date()}<br/>
	후기 게시팜 이미지경로 : ${hoogi.getH_img()}<br/>
	후기 게시팜 조회수 : ${hoogi.getH_count()} <br/>

<tr>
	<to align="right">
	<input type="button" onClick="HoogiUpdate();" value="수정"/>
	<input type="button" onClick="HoogiRemove();" value="삭제"/> 
	<input type="button" onClick="HoogiList();" value="목록"/>
	
</tr>
</body>
</form>

</html>