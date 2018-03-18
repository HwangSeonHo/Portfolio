package fooddk.dao.hoogi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Hoogi;
import fooddk.domain.Tasty;
import fooddk.paging.ListResultBean;
import fooddk.paging.ListResultBean_hoogi;

public class HoogiDaoImpl implements HoogiDao {
	public static final String namespace= "com.itwill.mapper.HoogiMapper.";
	private SqlSession sqlSession;
	
	public HoogiDaoImpl() {
		System.out.println("1.### HoogiDaoImpl()생성자");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2.### HoogiDaoImpl.setSqlSession("+sqlSession+")");
		this.sqlSession = sqlSession;
	}

		//후기글 작성  --확인
		@Override
		public int insertHoogi(Hoogi hoogi) {
			int insertRow=sqlSession.insert(namespace+"insertHoogi",hoogi);
			return insertRow;
		}
		//후기글삭제  - 확인
		@Override
		public int deleteByNo(int h_no) {
			int deleteRow=sqlSession.delete(namespace+"deleteByNo",h_no);
			return deleteRow;
		}
		//후기글업데이트 -- 확인
		@Override
		public int updateByNo(Hoogi hoogi) {
			int updateRow=sqlSession.update(namespace+"updateByNo",hoogi);
			return updateRow;
		}
		//모든 리스트 뽑아오기 --확인
		@Override
		public List<Hoogi> selectAll() {
			return sqlSession.selectList(namespace+"selectAll");
		}
		//후기글 번호로찾기--확인
		@Override
		public Hoogi selectByNo(int h_no) {
			//int selectByNoRow = sqlSession.selectL(namespace+"selectByNo",h_no);
			Hoogi selectByNoRow = sqlSession.selectOne(namespace+"selectByNo",h_no);
			//int selectByNoRow = sqlSession.selectList(namespace+"selectByNo",h_no);
			return selectByNoRow;
		}
		//후기글 이미지로 찾기--확인
		@Override
		public Hoogi selectImgByNo(int h_no) {
			Hoogi selectImgByNo = sqlSession.selectOne(namespace+"selectImgByNo",h_no);
			return selectImgByNo;
		}
		//조회 수로 리스트 뽑기--확인
		@Override
		public List<Hoogi> selectByCount() {
			return sqlSession.selectList(namespace+"selectByCount");
		}
		//날짜로 리스토 뽑기--확인
		@Override
		public List<Hoogi> selectByDate() {
			return sqlSession.selectList(namespace+"selectByDate");
		}
		//제목으로 찾기 --확인
		@Override
		public List<Hoogi> selectByTitle(String h_title) {
			return sqlSession.selectList(namespace+"selectByTitle",h_title);
		}
		//맛집 이름 리스트로 가져요기 --확인해야함
		@Override
		public Hoogi selectTNo(int t_no) {
			Hoogi selectTNo=sqlSession.selectOne(namespace+"selectTNo",t_no);
			return selectTNo;
		}
		//맛집 클락하면 조회수 올리기
		@Override
		public int updateByCountNo(int h_no) {
			int updateByCountNo=sqlSession.update(namespace+"updateByCountNo",h_no);
			return updateByCountNo;
		}

		//총 글 개시수 뽑기
		@Override
		public int selectcount() {
			int selectcount=sqlSession.selectOne(namespace+"selectcount");
			return selectcount;
		}	
		//페이징할 게시판 리스트 (시작번호, 끝번호)
		@Override
		public List<Hoogi> findHoogi(int start, int last) {
			ListResultBean listresultbean = new ListResultBean();
			listresultbean.setStartRowNum(start);
			listresultbean.setEndRowNum(last);
			return sqlSession.selectList(namespace+"findHoogi",listresultbean);
		}

		@Override
		public Hoogi selectByt_no(int t_no) {
			return sqlSession.selectOne(namespace+"selectByt_no",t_no);
		}
		
		@Override
		public List<Hoogi> selectDate(int start,int end) {
			ListResultBean_hoogi listResult = new ListResultBean_hoogi();
			listResult.setStartRowNum(start);
			listResult.setEndRowNum(end);
			return sqlSession.selectList(namespace+"selectDate", listResult);
		}

		@Override
		public List<Hoogi> findHoogi1(int start, int last) {
			ListResultBean listresultbean = new ListResultBean();
			listresultbean.setStartRowNum(start);
			listresultbean.setEndRowNum(last);
			return sqlSession.selectList(namespace+"findHoogi1",listresultbean);
		}
}
