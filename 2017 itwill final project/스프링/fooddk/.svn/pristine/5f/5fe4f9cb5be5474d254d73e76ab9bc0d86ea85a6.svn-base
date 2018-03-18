<%@page import="java.util.List"%>
<%@page import="fooddk.domain.Hoogi"%>
<%@page import="fooddk.paging.ListResultBean"%>
<%@page import="fooddk.paging.ListPageConfigBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.suggest{
		border: 1px dotted blue;
		width: 160px;
	 	display: none;
	}
</style>
<script type="text/javascript" src="assets/js/httpRequest.js"></script>
<script type="text/javascript">
	function sendKeyWord(){
		var keyword = document.searchF.keyword.value;
		if(keyword==null || keyword==''){
			hideSuggestDiv();
			return;
		}
		keyword=window.encodeURI(keyword);
		
		var r=new ajax.xhr.Request(
					"09.suggest.jsp", 
					"keyword="+keyword, 
					displaySuggest, 
					'POST');
		
		
	}
	function displaySuggest(xhr){
		
		if(xhr.readyState==4){
			/*
			CSV형식
			3|AJAX,AJAX 실전 프로그래밍,AJA
			*/
			var resultCSV = xhr.responseText;
			var resultCSVArray = resultCSV.split("|");
			if(resultCSVArray[0]==0){
				hideSuggestDiv();
				return;
			}
			var keywordArray= resultCSVArray[1].split(",");
			var html="";
			for(var i=0;i<keywordArray.length;i++){
				html+="<a href=\"javascript:select('"+keywordArray[i]+"');\">"+keywordArray[i]+"</a><br/>";
			}
			document.getElementById('suggestList').innerHTML=html;
			showSuggestDiv();
		}
	}
	function select(selectKeyword){
		document.searchF.keyword.value=selectKeyword;
		hideSuggestDiv();
		//document.searchF.submit();
		
	}
	function showSuggestDiv(){
		document.getElementById('suggest').style.display='block';
	}
	function hideSuggestDiv(){
		document.getElementById('suggest').style.display='none';
	}
</script>
</head>
<body>
<h1>제시어[ajax.js]</h1><hr/>
<form action="search_result.jsp" name="searchF" >
	<input type="text" name="keyword" onkeyup="sendKeyWord();">&nbsp;<input type="submit" value="검색">
	<div id="suggest" class="suggest">
		<div id="suggestList">
			
		</div>
	</div>
</form>
</body>
</html>










