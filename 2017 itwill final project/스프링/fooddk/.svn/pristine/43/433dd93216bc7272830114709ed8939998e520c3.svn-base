package fooddk.dao.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Member;

public class MemberDaoImpl implements MemberDao{

	public static final String namespace = "com.fooddk.mapper.MemberMapper.";
private SqlSession sqlSession;
	
	public MemberDaoImpl() {
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/*
	회원 가입
	 */
	@Override
	public int insertMember(Member member) {
		
		return sqlSession.insert(namespace+"insertMember", member);
	}

	/*
	맴버 수정
	 */
	@Override
	public int updateMember(Member member) {

		return sqlSession.update(namespace+"updateMember", member);
	}
	@Override
	public int updateManagerByno(Member member) {
		return sqlSession.update(namespace +"updateManagerByno", member);
	}

	/*
	맴버 삭제
	 */
	@Override
	public int deleteMemberByNo(int mNo) {
		return sqlSession.delete(namespace+"deleteMemberByNo", mNo);
	}

	/*
	전체 회원 보기
	 */
	@Override
	public List<Member> selectAllMember() {

		return sqlSession.selectList(namespace+"selectAllMember");
	}

	/*
	내정보 보기
	 */
	@Override
	public Member selectMemberMyInfo(int mNo) {
		return sqlSession.selectOne(namespace+"selectMemberMyInfo", mNo);
	}
	
	
	/*
	이름으로 아이디 찾기
	 */
	@Override
	public Member selectMemberById(String name) {
		return sqlSession.selectOne(namespace+"selectMemberById", name);
	}

	/*
	비밀번호 찾기
	 */
	@Override
	public Member selectMemberByPw(Member member) {
		return sqlSession.selectOne(namespace+"selectMemberByPw", member);
	}

	
	/*
	생일로 찾기
	 */
	@Override
	public Member selectMemberByBirth(String Birth) {
		return sqlSession.selectOne(namespace+"selectMemberByBirth", Birth);
	}
	
	/*
	아이디 중복 체크
	 */
	
	@Override
	public Member selectMemberCheckId(String mId) {
		return sqlSession.selectOne(namespace+"selectMemberCheckId", mId);
	}
	
	/*
	 * 글 등록할때 포인트 추가
	 * */
	@Override
	public int updatePointByno(int mNo) {
		return sqlSession.update(namespace+"updatePointByno", mNo);
	}
	
	/*
	 * 포인트에 따른 등급변경
	 * 	
	 */
	
	@Override
	public int updateGradeBypoint1() {
		return sqlSession.update(namespace+"updateGradeBypoint1");
	}
	@Override
	public int updateGradeBypoint2() {
		return sqlSession.update(namespace+"updateGradeBypoint2");
	}
	@Override
	public int updateGradeBypoint3() {
		return sqlSession.update(namespace+"updateGradeBypoint3");
		
	}
	@Override
	public int updateGradeBypoint4() {
		return sqlSession.update(namespace+"updateGradeBypoint4");
	
	}
	@Override
	public int updateGradeBypoint5() {
		return sqlSession.update(namespace+"updateGradeBypoint5");
		
	}
	
}
