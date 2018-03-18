package fooddk.domain;

public class Item {

	private int i_no;
	private String i_name;
	private int i_price;
	
	public Item() {
	}
	
	public Item(int i_no, String i_name, int i_price) {
		this.i_no = i_no;
		this.i_name = i_name;
		this.i_price = i_price;
	}
	
	public int getI_no() {
		return i_no;
	}
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public int getI_price() {
		return i_price;
	}
	public void setI_price(int i_price) {
		this.i_price = i_price;
	}
	
}
