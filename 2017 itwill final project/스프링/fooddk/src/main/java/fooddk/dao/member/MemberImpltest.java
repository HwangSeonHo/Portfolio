package fooddk.dao.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Member;

public class MemberImpltest {

	public static void main(String[] args) {

		System.out.println("-------appication context[bean factory]초기화 전-------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml"); 
		System.out.println("-------appication context[bean factory]초기화 후-------");
		
		MemberDaoImpl mdi = (MemberDaoImpl)applicationContext.getBean("memberDao");
	
		/*Member insertMember = new Member(123,"윤효성", "dbsgytjd", "비밀번호", "19900516", "남자", 1234, 1);
		
		
		mdi.insertMember(insertMember);*/
		/*
		Member updateMember = new Member(10, "비밀", "1992131", "여자", 4444, 2);
		int update = mdi.updateMember(updateMember);
		System.out.println("update : " +update);
		 */
		//mdi.deleteMemberByNo(9);
		/*
		List<Member> memberList = mdi.selectAllMember();
		
		System.out.println(memberList);*/
		//System.out.println(mdi.selectMemberById("윤효성"));
		
		//System.out.println(mdi.selectMemberByPw(new Member("dbsgytjd", "19900516")));;
		
		//System.out.println(mdi.selectMemberMyInfo(10));	
		
		/*Member checkId = mdi.selectMemberCheckId("qwer");
		System.out.println("id : "+checkId);
		*/
		/*Member birth = mdi.selectMemberByBirth("11231");
		System.out.println(birth);*/
		
		/*List<Member> name = mdi.selectMemberById("윤효성");*/
		/*System.out.println(name);*/
	/*	Member id = mdi.selectMemberCheckId("dbsgytjd");
		System.out.println(id);*/
		
		/*System.out.println("updateByNo");
		int count = mdi.updatePointByno(2);
		System.out.println("count>>>>>>>>>>>"+count);*/
		
		System.out.println("point grade");
		int count1 = mdi.updateGradeBypoint1();
		System.out.println("count>>>>>>>>>>>"+count1);
		int count2 = mdi.updateGradeBypoint2();
		System.out.println("count>>>>>>>>>>>"+count2);
		int count3 = mdi.updateGradeBypoint3();
		System.out.println("count>>>>>>>>>>>"+count3);
		int count4 = mdi.updateGradeBypoint4();
		System.out.println("count>>>>>>>>>>>"+count4);
		int count5 = mdi.updateGradeBypoint5();
		System.out.println("count>>>>>>>>>>>"+count5);
	}

}
