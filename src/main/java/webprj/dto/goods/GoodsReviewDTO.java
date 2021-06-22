package webprj.dto.goods;

import java.sql.Date;

public class GoodsReviewDTO {
	private int id;  //pk
	private int gds_id;  //상품번호
	private String content; //리뷰 내용
	private String writer_id; //리뷰 작성자
	private Date regdate;   //리뷰 등록기간
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGds_id() {
		return gds_id;
	}
	public void setGds_id(int gds_id) {
		this.gds_id = gds_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "BoardRelpyDTO [id=" + id + ", gds_id=" + gds_id + ", content=" + content + ", writer_id=" + writer_id
				+ ", regdate=" + regdate + "]";
	}
}
