package fooddk.service.arduino;

import java.util.List;

import fooddk.dao.arduino.JumonDao;
import fooddk.domain.Jumon;

public interface JumonService {

	void setJumonDao(JumonDao jumonDao);

	List<Jumon> selectAll();

	List<Jumon> selectBySeatNo(Jumon jumon);

	int insert(Jumon jumon);

	int update(Jumon jumon);

	int delete(int j_no);

}