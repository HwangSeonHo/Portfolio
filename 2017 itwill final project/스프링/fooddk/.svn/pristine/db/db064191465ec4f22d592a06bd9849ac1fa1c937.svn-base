package fooddk.paging;

public class PageCounter_tasty{	
	public static ListResultBean_tasty getPagingInfo(	int selectPage,
												int rowCountPerPage,
												int pageCountPerPage, 
												int totalRecordCount)throws Exception{
		ListResultBean_tasty resultBean = new ListResultBean_tasty();
		int totalPageCount = 1;    			
		int startPageNo = 1;        		
		int endPageNo = 1;         			
		int selectPageNo = 1;      			
		int previousGroupStartPageNo = 1;  	
		int nextGroupStartPageNo = 1;       
		int groupNo = 0;           			
		
		int startRow = 0; 
		int endRow   = 0; 
		
		int modula = 0;
		if (totalRecordCount > 1){ 
			modula = (totalRecordCount) % rowCountPerPage;
			if (modula != 0){
				modula = 1;
			}else{
				modula = 0;
			}		
			totalPageCount = (totalRecordCount)/rowCountPerPage + modula;
		}else{
			totalPageCount = 1;
		}		
		
		if(selectPage > totalPageCount){
			throw new Exception("��������ȣ�� �̻��ؿ�!!!");
			
		}
		
		selectPageNo = selectPage;		
		groupNo = (selectPageNo-1)/pageCountPerPage;
		
		startPageNo = groupNo*pageCountPerPage + 1;
		endPageNo   = groupNo*pageCountPerPage+pageCountPerPage;
	
		previousGroupStartPageNo = startPageNo - pageCountPerPage;		
		if(previousGroupStartPageNo < 0){
			previousGroupStartPageNo = 0;
		}
		nextGroupStartPageNo = startPageNo + pageCountPerPage;
		
		if (startPageNo > totalPageCount)   startPageNo = startPageNo - pageCountPerPage + 1;
		if (endPageNo > totalPageCount)     endPageNo = totalPageCount;
		
		if (selectPageNo == 1 && selectPageNo == totalPageCount){
			startRow=1;
			endRow = totalRecordCount;
		}else if (selectPageNo < totalPageCount){
			startRow=rowCountPerPage*selectPageNo-rowCountPerPage + 1;
			endRow = rowCountPerPage*selectPageNo-rowCountPerPage + rowCountPerPage;
		}else if ( selectPageNo == totalPageCount){ // ���������ΰ��..
			startRow=rowCountPerPage * selectPageNo - rowCountPerPage + 1;
			endRow = totalRecordCount;
		}

		resultBean.setStartPageNo(startPageNo);
		resultBean.setEndPageNo(endPageNo);
		resultBean.setSelectPageNo(selectPageNo);
		resultBean.setTotalRecordCount(totalRecordCount);
		resultBean.setTotalPageCountCount(totalPageCount);
		resultBean.setPreviousGroupStartPageNo(previousGroupStartPageNo);
		resultBean.setNextGroupStartPageNo(nextGroupStartPageNo);
		resultBean.setStartRowNum(startRow);
		resultBean.setEndRowNum(endRow);
		
	
		
		resultBean.setShowPreviousGroup(isShowPreviousMoreIcon(groupNo,totalPageCount));
		resultBean.setShowNextGroup(isShowNextMoreIcon(endPageNo,totalPageCount));
		resultBean.setShowFirst(isShowFirstIcon(groupNo,totalPageCount));
		resultBean.setShowLast(isShowLastIcon(endPageNo,totalPageCount));
		System.out.println("***************����������***************");
		System.out.println("01.selectPage:\t\t\t"+resultBean.getSelectPageNo());
		System.out.println("02.rowCountPerPage:\t\t"+rowCountPerPage);
		System.out.println("03.pageCountPerPage:\t\t"+pageCountPerPage);
		System.out.println("02.totalRecordCount:\t\t"+resultBean.getTotalRecordCount());
		System.out.println("03.totalPageCount:\t\t"+resultBean.getTotalPageCount());
		System.out.println("04.pagegroupNo:\t\t\t"+groupNo);
		System.out.println("05.startPageNo:\t\t\t"+resultBean.getStartPageNo());
		System.out.println("06.endPageNo:\t\t\t"+resultBean.getEndPageNo());
		System.out.println("07.startRowNum:\t\t\t"+resultBean.getStartRowNum());
		System.out.println("08.endRowNum:\t\t\t"+resultBean.getEndRowNum());
		System.out.println("09.previousGroupStartPageNo:\t"+resultBean.getPreviousGroupStartPageNo());
		System.out.println("10.nextGroupStartPageNo:\t"+resultBean.getNextGroupStartPageNo());
		System.out.println("11.isShowPreviousGroup:\t\t"+resultBean.isShowPreviousGroup());
		System.out.println("12.isShowNextGroup:\t\t"+resultBean.isShowNextGroup()); 		
		System.out.println("13.isShowFirst:\t\t\t"+resultBean.isShowFirst());
		System.out.println("14.isShowLast:\t\t\t"+resultBean.isShowLast()); 				
		System.out.println("**************************************");
		return resultBean;				
	}
	
	  public  static boolean isShowPreviousMoreIcon(int groupNo,int totalPageCount) {
		   boolean isShow = false;
		  int modula = 0;
		  modula = groupNo % totalPageCount;
		  if (modula !=0 ) modula = 1;		  
		  if ((groupNo / totalPageCount + modula) >0) {
			  isShow =true;
		  }else{
			  isShow = false;
		  }
		 		  
		  return isShow;
	  }
	  

	  
	  public  static boolean isShowNextMoreIcon(int endPageNo,int totalPageCount) {
		  if (endPageNo < totalPageCount) 
				return true;
			else 
				return false;
	  }
	  
	  public  static boolean isShowFirstIcon(int groupNo,int totalPageCount){
			int modula = 0;
			modula = groupNo % totalPageCount;
			if (modula!=0) modula = 1;
			if ((groupNo / totalPageCount + modula) > 0) 
				return true;
			else 
				return false;
			  
	  }  

	  public  static boolean isShowLastIcon(int endPageNo,int totalPageCount) {
			if (endPageNo < totalPageCount)
				return true;
			else 
				return false;
	  } 
	
	  public static void main(String[] args) throws Exception{
	
		  int selectPage =8;
		  int rowCountPerPage=10;
		  int pageCountPerPage=5;
		  int totalRecordCount=563;
		  ListResultBean_tasty resultBean = PageCounter_tasty.getPagingInfo(selectPage,rowCountPerPage,pageCountPerPage,totalRecordCount);
		  System.out.println("***************����������***************");
			System.out.println("01.selectPage:\t\t\t"+resultBean.getSelectPageNo());
			System.out.println("02.rowCountPerPage:\t\t"+rowCountPerPage);
			System.out.println("03.pageCountPerPage:\t\t"+pageCountPerPage);
			System.out.println("02.totalRecordCount:\t\t"+resultBean.getTotalRecordCount());
			System.out.println("03.totalPageCount:\t\t"+resultBean.getTotalPageCount());
			System.out.println("04.pagegroupNo:\t\t\t"+(resultBean.getTotalPageCount()/pageCountPerPage==0?resultBean.getTotalPageCount()/pageCountPerPage-1 :resultBean.getTotalPageCount()/pageCountPerPage));
			System.out.println("05.startPageNo:\t\t\t"+resultBean.getStartPageNo());
			System.out.println("06.endPageNo:\t\t\t"+resultBean.getEndPageNo());
			System.out.println("07.startRowNum:\t\t\t"+resultBean.getStartRowNum());
			System.out.println("08.endRowNum:\t\t\t"+resultBean.getEndRowNum());
			System.out.println("09.previousGroupStartPageNo:\t"+resultBean.getPreviousGroupStartPageNo());
			System.out.println("10.nextGroupStartPageNo:\t"+resultBean.getNextGroupStartPageNo());
			System.out.println("11.isShowPreviousGroup:\t\t"+resultBean.isShowPreviousGroup());
			System.out.println("12.isShowNextGroup:\t\t"+resultBean.isShowNextGroup()); 		
			System.out.println("13.isShowFirst:\t\t\t"+resultBean.isShowFirst());
			System.out.println("14.isShowLast:\t\t\t"+resultBean.isShowLast()); 		
		
			System.out.println("**************************************");
	}
	  
	  
 }