package webprj.dto.goods;

import java.sql.Date;

public class GoodsDTO {

	private int gds_id;
	private String gds_name;
	private String gds_writer_id;
	private int gds_price;
	private String gds_descr;
	private Date regDate;
	private String picture_url;
	private int quantity;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getGds_id() {
		return gds_id;
	}
	public void setGds_id(int gds_id) {
		this.gds_id = gds_id;
	}
	public String getGds_name() {
		return gds_name;
	}
	public void setGds_name(String gds_name) {
		this.gds_name = gds_name;
	}
	public String getGds_writer_id() {
		return gds_writer_id;
	}
	public void setGds_writer_id(String gds_writer_id) {
		this.gds_writer_id = gds_writer_id;
	}
	public int getGds_price() {
		return gds_price;
	}
	public void setGds_price(int gds_price) {
		this.gds_price = gds_price;
	}
	public String getGds_descr() {
		return gds_descr;
	}
	public void setGds_descr(String gds_descr) {
		this.gds_descr = gds_descr;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	
	@Override
	public String toString() {
		return "GoodsDTO [gds_id=" + gds_id + ", gds_name=" + gds_name + ", gds_writer_id=" + gds_writer_id
				+ ", gds_price=" + gds_price + ", gds_descr=" + gds_descr + ", regDate=" + regDate + ", picture_url="
				+ picture_url + ", quantity=" + quantity + "]";
	}
}
