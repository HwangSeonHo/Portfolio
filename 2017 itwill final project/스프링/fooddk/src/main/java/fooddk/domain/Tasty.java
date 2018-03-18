package fooddk.domain;

import java.sql.Date;

public class Tasty {
	private int t_no;
	private String t_title;
	private String t_content;
	private Date t_date;
	private String t_img;
	private String t_phone;
	private String t_time;
	private String t_address;
	private String t_location;
	private int t_count;
	private int c_no;
		
	public Tasty() {
		// TODO Auto-generated constructor stub
	}

	public Tasty(int t_no, String t_title, String t_content, Date t_date, String t_img, String t_phone, String t_time,
			String t_address, String t_location, int t_count, int c_no) {
		super();
		this.t_no = t_no;
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_date = t_date;
		this.t_img = t_img;
		this.t_phone = t_phone;
		this.t_time = t_time;
		this.t_address = t_address;
		this.t_location = t_location;
		this.t_count = t_count;
		this.c_no = c_no;
	}
	public Tasty(int t_no, String t_title, String t_content,  String t_img, String t_phone, String t_time,
			String t_address,  int c_no) {
		super();
		this.t_no = t_no;
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_img = t_img;
		this.t_phone = t_phone;
		this.t_time = t_time;
		this.t_address = t_address;
		this.c_no = c_no;
	}
	public Tasty(int t_no, String t_title, String t_content,  String t_phone, String t_time,
            String t_address ) {
	   super();
	   this.t_no = t_no;
	   this.t_title = t_title;
	   this.t_content = t_content;
	   this.t_phone = t_phone;
	   this.t_time = t_time;
	   this.t_address = t_address;
	}
	public Tasty(int t_no, String t_title, String t_content,  String t_phone, String t_time,
			String t_address,int c_no ) {
		super();
		this.t_no = t_no;
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_phone = t_phone;
		this.t_time = t_time;
		this.t_address = t_address;
		this.c_no = c_no;
	}
	public Tasty(int t_no, String t_title, String t_content,  String t_img, String t_phone, String t_time,
			String t_address) {
		super();
		this.t_no = t_no;
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_img = t_img;
		this.t_phone = t_phone;
		this.t_time = t_time;
		this.t_address = t_address;
	}
	



	public Tasty(String t_title, String t_content, String t_img, String t_phone, String t_time, String t_address,
			int c_no) {
		super();
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_img = t_img;
		this.t_phone = t_phone;
		this.t_time = t_time;
		this.t_address = t_address;
		this.c_no = c_no;
	}
	public Tasty(String t_title, String t_content, String t_phone, String t_time, String t_address,
			int c_no) {
		super();
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_phone = t_phone;
		this.t_time = t_time;
		this.t_address = t_address;
		this.c_no = c_no;
	}
	public Tasty(int t_no,String t_title, String t_content, String t_img, String t_phone, String t_time, String t_address,
			String t_location,int c_no) {
		super();
		this.t_no = t_no;
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_img = t_img;
		this.t_phone = t_phone;
		this.t_time = t_time;
		this.t_address = t_address;
		this.t_location = t_location;
		this.c_no = c_no;
	}

	public int getT_no() {
		return t_no;
	}

	public void setT_no(int t_no) {
		this.t_no = t_no;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public String getT_content() {
		return t_content;
	}

	public void setT_content(String t_content) {
		this.t_content = t_content;
	}

	public Date getT_date() {
		return t_date;
	}

	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}

	public String getT_img() {
		return t_img;
	}

	public void setT_img(String t_img) {
		this.t_img = t_img;
	}

	public String getT_phone() {
		return t_phone;
	}

	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}

	public String getT_time() {
		return t_time;
	}

	public void setT_time(String t_time) {
		this.t_time = t_time;
	}

	public String getT_address() {
		return t_address;
	}

	public void setT_address(String t_address) {
		this.t_address = t_address;
	}

	public String getT_location() {
		return t_location;
	}

	public void setT_location(String t_location) {
		this.t_location = t_location;
	}

	public int getT_count() {
		return t_count;
	}

	public void setT_count(int t_count) {
		this.t_count = t_count;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	
	@Override
	public String toString() {
		return this.t_no +"  "+ this.t_title+"  "+this.t_content+"  "+this.t_date+"  "+this.t_img+"  "+this.t_phone+"  "+this.t_time+"  "+this.t_address + "  "+this.t_count;
	}
	
	
}
