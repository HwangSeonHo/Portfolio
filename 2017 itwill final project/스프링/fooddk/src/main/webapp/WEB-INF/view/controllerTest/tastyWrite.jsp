
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
   function TastyWrite(){
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
      document.t.action="tastyWriteAction";
      document.t.method="post";
      document.t.submit();
   }



   </script>

</head>
<body>
	<form name="t" method="post">
		<h1>맛집 게시판 만들기</h1>
			제목: <input type="text" name="t_title"> <br> 
			내용: <input type="text" name="t_content"> <br> 
			이미지:<input type="text" name="t_img"> <br>
			번호:<input type="text" name="t_phone"> <br>
			영업시간:<input type="text" name="t_time"> <br>
			주소:<input type="text" name="t_address"> <br>
			위치:<input type="text" name="t_location"> <br>
			분류:<input type="text" name="c_no"> <br>
	

		<input type="button" onClick="TastyWrite()" value="작성">

</form>
</body>
</html>