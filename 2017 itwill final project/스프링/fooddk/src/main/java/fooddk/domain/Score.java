package fooddk.domain;

public class Score {
	private int s_no;
	private int t_no;
	private int m_no;
	private int s_star;
	
	public Score() {
		// TODO Auto-generated constructor stub
	}
	
	public Score(int s_no) {
		// TODO Auto-generated constructor stub
		this.s_no = s_no;
	}
	
	public Score(int t_no, int m_no, int s_star) {
		// TODO Auto-generated constructor stub
		this.t_no = t_no;
		this.m_no = m_no;
		this.s_star = s_star;
	}
	
	public Score(int s_no, int t_no, int m_no, int s_star) {
		super();
		this.s_no = s_no;
		this.t_no = t_no;
		this.m_no = m_no;
		this.s_star = s_star;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public int getT_no() {
		return t_no;
	}

	public void setT_no(int t_no) {
		this.t_no = t_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getS_star() {
		return s_star;
	}

	public void setS_star(int s_star) {
		this.s_star = s_star;
	}

	@Override
	public String toString() {
		return "Score [s_no=" + s_no + ", t_no=" + t_no + ", m_no=" + m_no + ", s_star=" + s_star + "]";
	}
	
	
	
	
}
