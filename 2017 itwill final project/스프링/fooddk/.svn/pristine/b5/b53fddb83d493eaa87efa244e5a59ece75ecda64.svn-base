package fooddk.dao.faq;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Faq;

public class FaqDaoImpl implements FaqDao{
	public static final String namespace= "com.itwill.mapper.FaqMapper.";
	private SqlSession sqlSession;
	
	public FaqDaoImpl() {
		System.out.println("1.### FaqDaoImpl()생성자");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2.### FaqDaoImpl.setSqlSession("+sqlSession+")");
		this.sqlSession = sqlSession;
	}

	@Override
	public int writeFaq(Faq faq) {
		// TODO Auto-generated method stub
		int writeFaq = sqlSession.insert(namespace+"writeFaq",faq);
		return writeFaq;
	}

	@Override
	public Faq selectFaq(int f_no) {
		// TODO Auto-generated method stub
		Faq selectFaq = sqlSession.selectOne(namespace+"selectFaq",f_no);
		return selectFaq;
	}

	@Override
	public int modifyFaq(Faq faq) {
		// TODO Auto-generated method stub
		int modifyFaq = sqlSession.update(namespace+"modifyFaq",faq);
		return modifyFaq;
	}

	@Override
	public int removeFaq(int f_no) {
		// TODO Auto-generated method stub
		int removeFaq = sqlSession.delete(namespace+"removeFaq",f_no);
		return removeFaq;
	}

	@Override
	public List<Faq> selectAllFaq() {
		// TODO Auto-generated method stub
		List selectAllFaq = sqlSession.selectList(namespace+"selectAllFaq");
		return selectAllFaq;
	}

}
