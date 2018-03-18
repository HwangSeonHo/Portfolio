package fooddk.dao.faq;


import java.util.List;

import fooddk.domain.Faq;

public interface FaqDao {
	/*
	 * create
	 */
	int writeFaq(Faq faq);
	
	/*
	 * read
	 */
	Faq selectFaq(int f_no);
	
	/*
	 * update
	 */
	int modifyFaq(Faq faq);
	
	/*
	 * delete
	 */
	int removeFaq(int f_no);
	
	/*
	 * readall
	 */
	List<Faq> selectAllFaq();
	
	
}
