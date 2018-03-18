package fooddk.service.developer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.dao.developer.DeveloperDao;
import fooddk.dao.faq.FaqDao;
import fooddk.domain.Developer;
import fooddk.domain.Faq;

public class DeveloperServiceImpl implements DeveloperService{
	
	DeveloperDao developerDao;

	@Override
	public List<Developer> All() {
		// TODO Auto-generated method stub
		
		return developerDao.All();
	}
	
	public void setDeveloperDao(DeveloperDao developerDao) {
		this.developerDao = developerDao;
	}

	@Override
	public Developer selectByNo(int d_no) {
		// TODO Auto-generated method stub
		return developerDao.selectByNo(d_no);
	}

}
