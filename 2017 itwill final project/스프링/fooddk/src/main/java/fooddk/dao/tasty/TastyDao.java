package fooddk.dao.tasty;

import java.util.ArrayList;
import java.util.List;

import fooddk.domain.Tasty;
import fooddk.paging.ListPageConfigBean;

public interface TastyDao {
/*
insert
updateByNo
deleteByNo
selectAll
selectByNo
selectCount (조회 정렬)
selectDate (날짜 정렬)
selectImgByNo(번호로 이미지 찾기)
selectAddressByNo (식당좌표)
selectByTitle (검색해서찾기)
 */
	int insert(Tasty tasty);
	int updateByNo(Tasty tasty);
	int updateCount(int t_no);
	int deleteByNo(int t_no);
	List<Tasty> selectAll();
	Tasty selectByNo(int t_no);
	List<Tasty> selectList(int start, int end);
	List<Tasty> selectCount(int start, int end);
	List<Tasty> selectDate(int start, int end);
	int countAll();
	String selectImgByNo(int t_no);
	String selectAddressByNo(int t_no);
	List<Tasty> selectByTitle(String t_title);
	
	
}
