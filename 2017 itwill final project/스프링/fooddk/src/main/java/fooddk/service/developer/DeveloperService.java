package fooddk.service.developer;

import java.util.List;

import fooddk.domain.Developer;

public interface DeveloperService {
	List<Developer> All();
	Developer selectByNo(int d_no);
}
