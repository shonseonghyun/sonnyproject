package webprj.dto.board;


import java.sql.Date;

public class BoardReplyDTO {
	private int id;
	private int no;
	private String content;
	private String writer_id;
	private Date regdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
		return "BoardRelpyDTO [id=" + id + ", no=" + no + ", content=" + content + ", writer_id=" + writer_id
				+ ", regdate=" + regdate + "]";
	}

	
}
