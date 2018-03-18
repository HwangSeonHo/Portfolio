package fooddk.service.member;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Member;

public class MemberServiceTest {

	public static void main(String[] args) {

		System.out.println("-------appication context[bean factory]초기화 전-------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		System.out.println("-------appication context[bean factory]초기화 후-------");

		MemberServiceImpl msi = (MemberServiceImpl) applicationContext.getBean("memberService");
	/*	
		String insertMember = msi
				.insertMember(new Member("윤효성", "dbsgytjd1", "dbsgytjd", "11231", "12313", 123123, 1, 1, 1));
		
		System.out.println("boolean : " + insertMember);*/
		System.out.println("123213"+msi.selectMemberIDCheck("1234"));
		
		/*String login = msi.loginMember(new Member("qwer", "qwer"));
		System.out.println(login);
		 */
		/*String delete = msi.deleteMember(new Member(0, null, "dbsgytjd", "비밀", null, null, 0, 0, 0, 0));
		System.out.println(delete);*/
/*		
		
		Member d = msi.selectMemberMyNo(2);
		System.out.println(d);*/
		/*Member sele = msi.selectMemberMyInfo(new Member("dbsgytjd","비밀"));
		System.out.println(sele);*/
		
		Member m = msi.selectMemberById("회원1");
		System.out.println(m);
		
		/*Member b = msi.selectMemberByPw(new Member("윤1효성","dbsgytjd" , "1992131"));
			System.out.println(b);*/
		}

}
