package fooddk.domain;

public class Category  {
	private int c_no;
	private String c_kind;
	
	
	
	public Category(int c_no, String c_kind) {
		super();
		this.c_no = c_no;
		this.c_kind = c_kind;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int c_no) {
		this.c_no = c_no;
		// TODO Auto-generated constructor stub
	}
	public Category(String c_kind) {
		this.c_kind = c_kind;
		// TODO Auto-generated constructor stub
	}
	
	

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getC_kind() {
		return c_kind;
	}

	public void setC_kind(String c_kind) {
		this.c_kind = c_kind;
	}

	@Override
	public String toString() {
		return "Cotegory [c_no=" + c_no + ", c_kind=" + c_kind + "]";
	}	
}
