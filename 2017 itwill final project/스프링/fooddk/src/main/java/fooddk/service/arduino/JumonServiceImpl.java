package fooddk.service.arduino;

import java.util.List;

import fooddk.dao.arduino.JumonDao;
import fooddk.domain.Jumon;

public class JumonServiceImpl implements JumonService {

	JumonDao jumonDao;

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.JumonService#setJumonDao(fooddk.dao.arduino.JumonDao)
	 */
	@Override
	public void setJumonDao(JumonDao jumonDao) {
		this.jumonDao = jumonDao;
	}

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.JumonService#selectAll()
	 */
	@Override
	public List<Jumon> selectAll(){
		return jumonDao.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.arduino.JumonService#selectBySeatNo(fooddk.domain.Jumon)
	 */
	@Override
	public List<Jumon> selectBySeatNo(Jumon jumon){
		return jumonDao.selectBySeatNo(jumon);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.JumonService#insert(fooddk.domain.Jumon)
	 */
	@Override
	public int insert(Jumon jumon){
		return jumonDao.insert(jumon);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.JumonService#update(fooddk.domain.Jumon)
	 */
	@Override
	public int update(Jumon jumon){
		return jumonDao.update(jumon);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.JumonService#delete(int)
	 */
	@Override
	public int delete(int j_no){
		return jumonDao.delete(j_no);
	}
}
