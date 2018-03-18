/**
 * 
 */

function memberCreateForm() {

	document.f.method = "GET";
	document.f.action = "member_write_form.do";
	document.f.submit();
}
function memberModifyAction() {
	if (f.member_name.value == "") {
		alert("이름을 입력하십시요.");
		f.guest_name.focus();
		return false;
	}
	if (f.member_email.value == "") {
		alert("이메일을 입력하십시요.");
		f.guest_email.focus();
		return false;
	}
	if (f.guest_homepage.value == "") {
		alert("홈페이지를 입력하십시요.");
		f.guest_homepage.focus();
		return false;
	}

	if (f.guest_title.value == "") {
		alert("제목을 입력하십시요.");
		f.guest_title.focus();
		return false;
	}
	if (f.guest_content.value == "") {
		alert("내용을 입력하십시요.");
		f.guest_content.focus();
		return false;
	}
	document.f.method = "POST";
	document.f.action = "guest_modify_action.do";
	document.f.submit();
}

function memberList() {
	f.action = "member_list.do";
	f.submit();
}

function guestModify() {
	document.f.action = "guest_modify_form.do";
	document.f.method = "GET";
	document.f.submit();
}
function guestRemove() {
	if (window.confirm("정말 삭제하시겠습니까?")) {
		window.document.f.method = "POST";
		window.document.f.action = "guest_remove_action.do";
		window.document.f.submit();
	}
}
function memberCreate() {
/*	if (f.guest_name.value == "") {
		alert("이름을 입력하십시요.");
		f.guest_name.focus();
		return false;
	}
	if (f.guest_email.value == "") {
		alert("이메일을 입력하십시요.");
		f.guest_email.focus();
		return false;
	}
	if (f.guest_homepage.value == "") {
		alert("홈페이지를 입력하십시요.");
		f.guest_homepage.focus();
		return false;
	}

	if (f.guest_title.value == "") {
		alert("제목을 입력하십시요.");
		f.guest_title.focus();
		return false;
	}
	if (f.guest_content.value == "") {
		alert("내용을 입력하십시요.");
		f.guest_content.focus();
		return false;
	}*/
	f.method = "POST";
	f.action = "member_write_action.do";
	f.submit();
}
