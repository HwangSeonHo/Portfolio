package fooddk.dao.developer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Developer;
import fooddk.domain.Faq;

public class DeveloperDaoImpl implements DeveloperDao{
	
	public static final String namespace= "com.itwill.mapper.DeveloperMapper.";
	private SqlSession sqlSession;
	
	public DeveloperDaoImpl() {
		System.out.println("1.### DeveloperDaoImpl()생성자");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2.### DeveloperDaoImpl.setSqlSession("+sqlSession+")");
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Developer> All() {
		// TODO Auto-generated method stub
		List All = sqlSession.selectList(namespace+"All");
		return All;
	}

	@Override
	public Developer selectByNo(int d_no) {
		// TODO Auto-generated method stub
		Developer sd = sqlSession.selectOne(namespace+"selectByNo",d_no);
		return sd;
	}

}
