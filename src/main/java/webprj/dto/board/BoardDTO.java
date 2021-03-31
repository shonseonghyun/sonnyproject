package webprj.dto.board;


import java.sql.Date;

public class BoardDTO {
	private int id;
	private String name;
	private String title;
	private String writer_id;
	private String content;
	private Date regdate;
	private int hit;
	private String files;
	private int pub;
	
	private int prev;
	private int next;
	
	
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date date) {
		this.regdate = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPub() {
		return pub;
	}
	public void setPub(int pub) {
		this.pub = pub;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", name=" + name + ", title=" + title + ", writer_id=" + writer_id + ", content="
				+ content + ", regdate=" + regdate + ", hit=" + hit + ", files=" + files + ", pub=" + pub + ", prev="
				+ prev + ", next=" + next + "]";
	}
}

