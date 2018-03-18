package fooddk.domain;


/*CREATE TABLE FAQ(
		f_no NUMBER(10) PRIMARY KEY,
		f_title VARCHAR2(20) NOT NULL,
		m_no NUMBER(10),
		f_content VARCHAR2(200),		
		f_count NUMBER(10) DEFAULT 0 NOT NULL
);*/
public class Faq {
	private int f_no;
	private String f_title;
	private int m_no;
	private String f_content;
	
	
	public Faq(int f_no, String f_title, int m_no, String f_content ) {
		super();
		this.f_no = f_no;
		this.f_title = f_title;
		this.m_no = m_no;
		this.f_content = f_content;
		
	}
	
	public Faq() {
		// TODO Auto-generated constructor stub
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public String getF_title() {
		return f_title;
	}

	public void setF_title(String f_titie) {
		this.f_title = f_titie;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getF_content() {
		return f_content;
	}

	public void setF_content(String f_content) {
		this.f_content = f_content;
	}


	@Override
	public String toString() {
		return "Faq [f_no=" + f_no + ", f_title=" + f_title + ", m_no=" + m_no + ", f_content=" + f_content
				+ "]\n";
	}
}
