package fooddk.service.grade;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import fooddk.dao.grade.GradeDao;
import fooddk.domain.Grade;

public class GradeServiceImpl implements GradeService{

	private GradeDao gradeDao;
	
	public void setGradeDao(GradeDao gradeDao) {
		System.out.println("GradeServiceImpl.setGradeDao()생성자 호출"+gradeDao);
		this.gradeDao = gradeDao;
	}

	@Override
	   public int insertGrade(Grade grade) {
	      // TODO Auto-generated method stub
	      return gradeDao.insertGrade(grade);
	   }

	   @Override
	   public int updateGrade(Grade grade) {
	      // TODO Auto-generated method stub
	      return gradeDao.updateGrade(grade);
	   }

	   @Override
	   public int deleteGrade(int g_no) {
	      // TODO Auto-generated method stub
	      return gradeDao.deleteGrade(g_no);
	   }

	   @Override
	   public Grade selectGradeOne(int g_no) {
	      // TODO Auto-generated method stub
	      return gradeDao.selectGradeOne(g_no);
	   }

	   @Override
	   public List<Grade> selectGradeAll() {
	      // TODO Auto-generated method stub
	      return gradeDao.selectGradeAll();
	   }
	
	

	

}
