package fooddk.service.score;

import java.util.List;

import fooddk.domain.Score;

public interface ScoreService {
	int insertScore(Score score);
	int updateScore(Score score);
	int deleteScore(int s_no);
	Score selectOneScore(int s_no);
	List<Score> selectAll();
}
