package fooddk.domain;

public class Developer {
	/*DEVELROPER_NO	NUMBER(10,0)	No		1	
	DEVELROPER_NAME	VARCHAR2(20 BYTE)	No		2	
	DEVELROPER_INFOMATION	VARCHAR2(20 BYTE)	No		3	
	DEVELROPER_PROFILIMG	VARCHAR2(20 BYTE)	No		4	*/
	
	private int developer_no;
	private String developer_name;
	private String developer_infomation;
	private String developer_profil;
	

	public Developer() {
		
	}


	public Developer(int developer_no, String developer_name, String developer_infomation, String developer_profil) {
		super();
		this.developer_no = developer_no;
		this.developer_name = developer_name;
		this.developer_infomation = developer_infomation;
		this.developer_profil = developer_profil;
	}


	public int getDeveloper_no() {
		return developer_no;
	}


	public void setDeveloper_no(int developer_no) {
		this.developer_no = developer_no;
	}


	public String getDeveloper_name() {
		return developer_name;
	}


	public void setDeveloper_name(String developer_name) {
		this.developer_name = developer_name;
	}


	public String getDeveloper_infomation() {
		return developer_infomation;
	}


	public void setDeveloper_infomation(String developer_infomation) {
		this.developer_infomation = developer_infomation;
	}


	public String getDeveloper_profil() {
		return developer_profil;
	}


	public void setDeveloper_profil(String developer_profil) {
		this.developer_profil = developer_profil;
	}


	@Override
	public String toString() {
		// System.out.println(h_no+"/t"+h_title+"/t"+h_content+"/t"+h_date+"+"+h_img+"/t"+h_count);
		return developer_no + "\t" + developer_name + "\t" + developer_infomation + "\t" + developer_profil+"\n" ;
	}
	
	
	
	

}
