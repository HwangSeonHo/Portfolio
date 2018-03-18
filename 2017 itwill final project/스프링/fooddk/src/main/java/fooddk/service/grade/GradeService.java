package fooddk.service.grade;

import java.util.List;

import fooddk.domain.Grade;

public interface GradeService {
	
	int insertGrade(Grade grade);
	int updateGrade(Grade grade);
	
	Grade selectGradeOne(int g_no);
	List<Grade> selectGradeAll();
	int deleteGrade(int g_no);
}
