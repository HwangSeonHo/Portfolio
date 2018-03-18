package fooddk.domain;

public class Porce {

	private int p_no;
	private int j_no;
	private int t_no;
	
	public Porce() {
		super();
	}
	
	public Porce(int p_no, int j_no, int t_no) {
		super();
		this.p_no = p_no;
		this.j_no = j_no;
		this.t_no = t_no;
	}
	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getJ_no() {
		return j_no;
	}
	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	
}
