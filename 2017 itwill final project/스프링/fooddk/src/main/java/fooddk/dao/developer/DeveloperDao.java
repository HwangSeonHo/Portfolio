package fooddk.dao.developer;

import java.util.List;

import fooddk.domain.Developer;

public interface DeveloperDao {
	List<Developer> All();
	Developer selectByNo(int d_no);
}
