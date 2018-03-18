package fooddk.domain;

import java.util.Date;

public class Recipe {
	private int r_no;
	private String r_title;
	private int m_no;
	private String r_content;
	private Date r_date;
	private String r_img;
	private int c_no;
	private int r_count;
	
	public Recipe() {
	}

	public Recipe(int r_no, String r_title, int m_no, String r_content, Date r_date, String r_img, int c_no,
			int r_count) {
		this.r_no = r_no;
		this.r_title = r_title;
		this.m_no = m_no;
		this.r_content = r_content;
		this.r_date = r_date;
		this.r_img = r_img;
		this.c_no = c_no;
		this.r_count = r_count;
	}
	
	public Recipe (int r_no, String r_title, int m_no, String r_content, String r_img, int c_no) {
		this.r_no = r_no;
		this.r_title = r_title;
		this.m_no = m_no;
		this.r_content = r_content;
		this.r_img = r_img;
		this.c_no = c_no;

	}
	
	public Recipe(int r_no, String r_title,String r_content, String r_img, int c_no) {
		this.r_no = r_no;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_img = r_img;
		this.c_no = c_no;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public String getR_img() {
		return r_img;
	}

	public void setR_img(String r_img) {
		this.r_img = r_img;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getR_count() {
		return r_count;
	}

	public void setR_count(int r_count) {
		this.r_count = r_count;
	}

}
