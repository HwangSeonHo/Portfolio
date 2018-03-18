/**
 * 
 */



function recipeModifyAction() {
	if (f.m_no.value == "") {
		alert("이름을 입력하십시요.");
		f.m_no.focus();
		return false;
	}
	if (f.c_no.value == "") {
		alert("종류를 입력하세요");
		f.c_no.focus();
		return false;
	}
	if (f.r_title.value == "") {
		alert("제목을 입력하세요.");
		f.r_title.focus();
		return false;
	}
	
	document.f.method="POST";
	document.f.action = "recipe_modify_action";
	document.f.submit();
}

function recipeList() {
	f.action = "recipe_list";
	f.submit();
}

function recipeModify() {
	document.f.action = "recipe_modify_form";
	document.f.method="POST";
	document.f.submit();
}
function recipeRemove() {
	if (window.confirm("정말 삭제하시겠습니까?")) {
		window.document.f.method="POST";
		window.document.f.action = "recipe_remove_action";
		window.document.f.submit();
	}
}
function recipeCreate() {
	if (f.m_no.value == "") {
		alert("이름을 입력하십시요.");
		f.m_no.focus();
		return false;
	}
	if (f.c_no.value == "") {
		alert("종류를 입력하세요");
		f.c_no.focus();
		return false;
	}
	if (f.r_title.value == "") {
		alert("제목을 입력하세요.");
		f.r_title.focus();
		return false;
	}

	if (f.r_content.value == "") {
		alert("내용을 입력하십시요.");
		f.r_content.focus();
		return false;
	}
	
	f.method='POST';
	f.action ='recipe_write_form_action';
	f.submit();
}
