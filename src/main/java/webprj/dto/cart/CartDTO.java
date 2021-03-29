package webprj.dto.cart;

public class CartDTO {
	private int cart_id;
	private String id;
	private int gds_id;
	private int amount;
	
	private String gds_name;
	private int gds_price;
	private String picture_url;
	
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	private int money;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGds_id() {
		return gds_id;
	}
	public void setGds_id(int gds_id) {
		this.gds_id = gds_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getGds_name() {
		return gds_name;
	}
	public void setGds_name(String gds_name) {
		this.gds_name = gds_name;
	}
	public int getGds_price() {
		return gds_price;
	}
	public void setGds_price(int gds_price) {
		this.gds_price = gds_price;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	} 
	@Override
	public String toString() {
		return "CartDTO [cart_id=" + cart_id + ", id=" + id + ", gds_id=" + gds_id + ", amount=" + amount
				+ ", gds_name=" + gds_name + ", gds_price=" + gds_price + ", money=" + money + "]";
	}
	

}
