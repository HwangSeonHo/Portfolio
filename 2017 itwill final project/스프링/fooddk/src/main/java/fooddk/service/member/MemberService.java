package fooddk.service.member;

import java.util.List;

import fooddk.dao.member.MemberDao;
import fooddk.dao.member.MemberNotFoundException;
import fooddk.dao.member.PasswordNotFoundException;
import fooddk.domain.Member;

public interface MemberService {

	void setMemberDao(MemberDao memberDao);

	/*
	 * 회원가입 ID중복체크
	 */
	String insertMember(Member member);

	/*
	 * 로그인
	 */
	String loginMember(Member member) throws MemberNotFoundException, PasswordNotFoundException;

	/*
	 * 탈퇴,삭제
	 */
	String deleteMember(Member member) throws PasswordNotFoundException;
	/*
	 * 수정
	 */

	int updateMember(Member member);
	int updateManagerByno(Member member);
	/*
	 * 회원 전체 보기
	 */
	List<Member> selectMemberAll();

	/*
	 * 내정보 보기
	 */
	Member selectMemberMyInfo(Member member);

	/*
	 * 아이디 찾기
	 */
	Member selectMemberById(String name);

	/*
	 * 비밀번호 찾기
	 */
	Member selectMemberByPw(Member member);

	/*
	 * 아이디로 찾기
	 */
	Member selectMemberCheckId(String m_id);
	
	Member selectMemberMyNo(int no);
	
	Boolean selectMemberIDCheck(String m_id);
	/*
	 * 글 등록할때 포인트 update
	 */
	int updatePointByno(int mNo);
	
	/*
	 * 포인트에 따른 등급 
	 */
	int updateGradeBypoint1();
	int updateGradeBypoint2();
	int updateGradeBypoint3();
	int updateGradeBypoint4();
	int updateGradeBypoint5();

}