package fooddk.service.faq;

import java.util.List;

import fooddk.dao.faq.FaqDao;
import fooddk.dao.hoogi.HoogiDao;
import fooddk.domain.Faq;

public class FaqServiceImpl implements FaqService {
	
	FaqDao faqDao; 
	
	public void setFaqDao(FaqDao faqDao) {
		this.faqDao = faqDao;
	}

	@Override
	public int writeFaq(Faq faq) {
		// TODO Auto-generated method stub
		return faqDao.writeFaq(faq);
	}

	@Override
	public Faq selectFaq(int f_no) {
		// TODO Auto-generated method stub
		return faqDao.selectFaq(f_no);
	}

	@Override
	public int modifyFaq(Faq faq) {
		// TODO Auto-generated method stub
		return faqDao.modifyFaq(faq);
	}

	@Override
	public int removeFaq(int f_no) {
		// TODO Auto-generated method stub
		return faqDao.removeFaq(f_no);
	}

	@Override
	public List<Faq> selectAllFaq() {
		// TODO Auto-generated method stub
		return faqDao.selectAllFaq();
	}

}
