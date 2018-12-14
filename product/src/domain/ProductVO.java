package domain;

public class ProductVO {
	private int prcode;
	private String prname;
	private int price;
	private String manufacture;
	
	@Override
	public String toString() {
		return "ProductVO [prcode=" + prcode + ", prname=" + prname + ", price=" + price + ", manufacture="
				+ manufacture + "]";
	}
	
	public int getPrcode() {
		return prcode;
	}
	public void setPrcode(int prcode) {
		this.prcode = prcode;
	}
	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	
	
}
