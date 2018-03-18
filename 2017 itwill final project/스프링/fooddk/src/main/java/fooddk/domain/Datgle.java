package fooddk.domain;

import java.sql.Date;
/*
	D_NO	NUMBER(10,0)
	D_GROUPNO	NUMBER(10,0)
	D_STEP	NUMBER(10,0)
	D_FILTER	VARCHAR2(20 BYTE)
	D_CONTENT	VARCHAR2(100 BYTE)
	M_NO	NUMBER(10,0)
	D_TITLE	VARCHAR2(30 BYTE)
	D_DATE	DATE
 */
public class Datgle {
	private int d_no;
	private int m_no;			//글쓴이 p.k.
	private String d_title;
	private String d_content;
	private Date d_date;
	private int d_groupno;
	private int d_step;
	private String d_filter;	//댓글의 분류(tasty, hoogi, recipe)
	
	//default constructor
	public Datgle() {
	}
	public Datgle(int d_no, int m_no, String d_title, String d_content, 
				  Date d_date, int d_groupno, int d_step, String d_filter) {
		this.d_no = d_no;
		this.m_no = m_no;
		this.d_title = d_title;
		this.d_content = d_content;
		this.d_date = d_date;
		this.d_groupno = d_groupno;
		this.d_step = d_step;
		this.d_filter = d_filter;
	}
	
	//insert constructor
	public Datgle(int m_no, String d_title, String d_content, 
				  int d_groupno, int d_step, String d_filter) {
		this.m_no = m_no;
		this.d_title = d_title;
		this.d_content = d_content;
		this.d_groupno = d_groupno;
		this.d_step = d_step;
		this.d_filter = d_filter;
	}

	//update constructor
	public Datgle(int d_no, String d_title, String d_content) {
		this.d_no = d_no;
		this.d_title = d_title;
		this.d_content = d_content;
	}
	
	//search constructor
	public Datgle(String d_title, String d_filter) {
		this.d_title = d_title;
		this.d_filter = d_filter;
	}

	//count constructor
	public Datgle(String d_filter, int d_groupno){
		this.d_groupno = d_groupno;
		this.d_filter = d_filter;
	}

	public int getD_no() {
		return d_no;
	}
	public void setD_no(int d_no) {
		this.d_no = d_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getD_title() {
		return d_title;
	}
	public void setD_title(String d_title) {
		this.d_title = d_title;
	}
	public String getD_content() {
		return d_content;
	}
	public void setD_content(String d_content) {
		this.d_content = d_content;
	}
	public Date getD_date() {
		return d_date;
	}
	public void setD_date(Date d_date) {
		this.d_date = d_date;
	}
	public int getD_groupno() {
		return d_groupno;
	}
	public void setD_groupno(int d_groupno) {
		this.d_groupno = d_groupno;
	}
	public int getD_step() {
		return d_step;
	}
	public void setD_step(int d_step) {
		this.d_step = d_step;
	}
	public String getD_filter() {
		return d_filter;
	}
	public void setD_filter(String d_filter) {
		this.d_filter = d_filter;
	}
	
}
