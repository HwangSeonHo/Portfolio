package fooddk.service.arduino;

import java.util.List;

import fooddk.dao.arduino.PorceDao;
import fooddk.domain.Porce;

public class PorceServiceImpl implements PorceService {

	PorceDao porceDao;

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.PorceService#setPorceDao(fooddk.dao.arduino.PorceDao)
	 */
	@Override
	public void setPorceDao(PorceDao porceDao) {
		this.porceDao = porceDao;
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.arduino.PorceService#selectAll()
	 */
	@Override
	public List<Porce> selectAll(){
		return porceDao.selectAll();
	}

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.PorceService#insert(fooddk.domain.Porce)
	 */
	@Override
	public int insert(Porce porce){
		return porceDao.insert(porce);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.PorceService#update(fooddk.domain.Porce)
	 */
	@Override
	public int update(Porce porce){
		return porceDao.update(porce);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.PorceService#delete(int)
	 */
	@Override
	public int delete(int p_no){
		return porceDao.delete(p_no);
	}
}
