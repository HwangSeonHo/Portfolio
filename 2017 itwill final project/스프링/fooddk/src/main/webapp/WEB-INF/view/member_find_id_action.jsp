<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)request.getAttribute("id");
	String method=request.getMethod();
	System.out.println(">> ajax "+method+" request --> id ="+id);
	if(id==null || id.equals("")){
		return;
	}
	String msg="";
	if(!(id.equals(""))){
		msg=id+"사용가능";
	}else{
		msg=id+"사용불가능";
	}
%>
<%=msg%>    
    