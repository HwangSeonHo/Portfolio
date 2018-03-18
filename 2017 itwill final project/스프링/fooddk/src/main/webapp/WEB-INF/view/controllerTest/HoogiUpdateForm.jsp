<%@page import="fooddk.domain.Hoogi"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
  <%
  request.setCharacterEncoding("EUC-KR");
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function HoogiUpdateAction(){
		/* if(z.v_title.value ==""){
			alert("제목을 입력해주세요");
			z.v_title.focus();
			return false;			
		}
		if(z.v_name.value ==""){
			alert("이름을 입력해주세요");
			z.v_name.focus();
			return false;			
		}
		if(z.v_email.value ==""){
			alert("이메일을 입력해주세요");
			z.v_email.focus();
			return false;			
		}
		if(z.v_sns.value ==""){
			alert("sns을 입력해주세요");
			z.v_sns.focus();
			return false;			
		}
		if(z.v_content.value ==""){
			alert("내용을 입력해주세요");
			z.v_content.focus();
			return false;			
		}
		 */
		document.z.action="HoogiUpdateAction";
		document.z.method="post";
		document.z.submit();
	}



	</script>

</head>
<body>
<form name ="z" method="post">
<h1>후기 게시판 업데이트 </h1>
<input type ="hidden" name =h_no value="${hoogiselect.h_no}">
후기 게시판 제목: <input type="text" name="h_title" value="${hoogiselect.h_title}"> <br>
후기 게시판 내용: <input type="text" name="h_content" value="${hoogiselect.h_content}"> <br>
후기 게시판 이미지: <input type="text" name="h_img" value="${hoogiselect.h_img}"> <br>


<to align="center">
<input type = "button" onClick="HoogiUpdateAction()" value ="게시판작성">

</body>

</form>
</html>