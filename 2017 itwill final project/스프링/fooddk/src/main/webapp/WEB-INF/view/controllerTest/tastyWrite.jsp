
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
         alert("������ �Է����ּ���");
         z.v_title.focus();
         return false;         
      }
      if(z.v_name.value ==""){
         alert("�̸��� �Է����ּ���");
         z.v_name.focus();
         return false;         
      }
      if(z.v_email.value ==""){
         alert("�̸����� �Է����ּ���");
         z.v_email.focus();
         return false;         
      }
      if(z.v_sns.value ==""){
         alert("sns�� �Է����ּ���");
         z.v_sns.focus();
         return false;         
      }
      if(z.v_content.value ==""){
         alert("������ �Է����ּ���");
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
		<h1>���� �Խ��� �����</h1>
			����: <input type="text" name="t_title"> <br> 
			����: <input type="text" name="t_content"> <br> 
			�̹���:<input type="text" name="t_img"> <br>
			��ȣ:<input type="text" name="t_phone"> <br>
			�����ð�:<input type="text" name="t_time"> <br>
			�ּ�:<input type="text" name="t_address"> <br>
			��ġ:<input type="text" name="t_location"> <br>
			�з�:<input type="text" name="c_no"> <br>
	

		<input type="button" onClick="TastyWrite()" value="�ۼ�">

</form>
</body>
</html>