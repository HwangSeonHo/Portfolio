package fooddk.paging;

import java.util.*;

import fooddk.domain.Recipe;

public class ListResultBean {
	private List<Recipe> list; 		
	private int startPageNo; 		
	private int endPageNo; 			
	private int selectPageNo; 		
	private int totalRecordCount; 	
	private int totalPageCount; 	
	private int previousGroupStartPageNo;
	private int nextGroupStartPageNo;
	private boolean showPrevious; 	
	private boolean showNext; 		
	private boolean showPreviousGroup;
	private boolean showNextGroup; 
	private boolean showFirst; 		
	private boolean showLast; 		

	private int startRowNum;
	private int endRowNum;
	

	public ListResultBean() {
	}

	public ListResultBean(List<Recipe> list, int startPageNo, int endPageNo,
			int selectPageNo, int totalRecordCount, int totalPageCount,
			int previousGroupStartPageNo, int nextGroupStartPageNo,
			boolean showPrevious, boolean showNext, boolean showPreviousGroup,
			boolean showNextGroup, boolean showFirst, boolean showLast,
			int startRowNum, int endRowNum) {
		this.list = list;
		this.startPageNo = startPageNo;
		this.endPageNo = endPageNo;
		this.selectPageNo = selectPageNo;
		this.totalRecordCount = totalRecordCount;
		this.totalPageCount = totalPageCount;
		this.previousGroupStartPageNo = previousGroupStartPageNo;
		this.nextGroupStartPageNo = nextGroupStartPageNo;
		this.showPrevious = showPrevious;
		this.showNext = showNext;
		this.showPreviousGroup = showPreviousGroup;
		this.showNextGroup = showNextGroup;
		this.showFirst = showFirst;
		this.showLast = showLast;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
	
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public List<Recipe> getList() {
		return list;
	}

	public void setList(List<Recipe> list) {
		this.list = list;
	}

	public int getNextGroupStartPageNo() {
		return nextGroupStartPageNo;
	}

	public void setNextGroupStartPageNo(int nextGroupStartPageNo) {
		this.nextGroupStartPageNo = nextGroupStartPageNo;
	}
	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCountCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPreviousGroupStartPageNo() {
		return previousGroupStartPageNo;
	}

	public void setPreviousGroupStartPageNo(int previousGroupStartPageNo) {
		this.previousGroupStartPageNo = previousGroupStartPageNo;
	}

	


	public int getSelectPageNo() {
		return selectPageNo;
	}

	public void setSelectPageNo(int selectPageNo) {
		this.selectPageNo = selectPageNo;
	}

	public boolean isShowFirst() {
		return showFirst;
	}

	public void setShowFirst(boolean showFirst) {
		this.showFirst = showFirst;
	}

	public boolean isShowLast() {
		return showLast;
	}

	public void setShowLast(boolean showLast) {
		this.showLast = showLast;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	public boolean isShowNextGroup() {
		return showNextGroup;
	}

	public void setShowNextGroup(boolean showNextGroup) {
		this.showNextGroup = showNextGroup;
	}

	public boolean isShowPrevious() {
		return showPrevious;
	}

	public void setShowPrevious(boolean showPrevious) {
		this.showPrevious = showPrevious;
	}

	public boolean isShowPreviousGroup() {
		return showPreviousGroup;
	}

	public void setShowPreviousGroup(boolean showPreviousGroup) {
		this.showPreviousGroup = showPreviousGroup;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

}
