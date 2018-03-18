package fooddk.domain;

public class Member {

	private int m_no;
	private String m_name;
	private String m_id;
	private String m_pw;
	private String m_birth;
	private String m_gender;
	private int m_point;
	private int m_manager;
	private int c_no;
	private int g_no;

	public Member() {
	}

	public Member(String m_id, String m_pw) {
		this.m_id = m_id;
		this.m_pw = m_pw;
	}

	public Member(String m_name,String m_id, String m_birth) {
		this.m_name = m_name;
		this.m_id = m_id;
		this.m_birth = m_birth;
	}

	public Member(int m_no, String m_pw, String m_birth, String m_gender, int m_point, int m_manager) {
		super();
		this.m_no = m_no;
		this.m_pw = m_pw;
		this.m_birth = m_birth;
		this.m_gender = m_gender;
		this.m_point = m_point;
		this.m_manager = m_manager;
	}

	public Member(String m_name, String m_id, String m_pw, String m_birth, String m_gender, int m_point, int m_manager,
			int c_no, int g_no) {

		this.m_name = m_name;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_birth = m_birth;
		this.m_gender = m_gender;
		this.m_point = m_point;
		this.m_manager = m_manager;
		this.c_no = c_no;
		this.g_no = g_no;
	}

	public Member(int m_no, String m_name, String m_id, String m_pw, String m_birth, String m_gender, int m_point,
			int m_manager, int c_no, int g_no) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_birth = m_birth;
		this.m_gender = m_gender;
		this.m_point = m_point;
		this.m_manager = m_manager;
		this.c_no = c_no;
		this.g_no = g_no;
	}

	@Override
	public String toString() {

		return "이름 : " + m_name + "아이디 : " + m_id + "비밀번호 : " + m_pw + "생일 : " + m_birth + "성별 : " + m_gender + "포인트 : "
				+ m_point + "매니저" + m_manager + "카테고리"+ c_no + "등급 " + g_no +"\n";
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_gender() {
		return m_gender;
	}

	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}

	public int getM_point() {
		return m_point;
	}

	public void setM_point(int m_point) {
		this.m_point = m_point;
	}

	public int getM_manager() {
		return m_manager;
	}

	public void setM_manager(int m_manager) {
		this.m_manager = m_manager;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	
	public Boolean isPassMath(String pass){
		boolean istrue = false;
		
		if (getM_pw().equals(pass)) {
			istrue = true;
			
		}else{
			istrue = false;
		}
		return istrue;
		
		
	}
}
