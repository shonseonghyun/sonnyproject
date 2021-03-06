package webprj.dto.member;


import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class MemberDTO {
	@Pattern(regexp ="[a-z0-9]{4,12}")
	private String id;
	
	@Pattern(regexp = "[A-Za-z0-9!@]{4,12}")
	private String pwd;
	
	@Email
	private String email;
	
	@Pattern(regexp = "[가-힣]{2,6}")
	private String name;
	
	private Date date ;
	private String autologin;
	
	
	
	public String getAutologin() {
		return autologin;
	}
	public void setAutologin(String autologin) {
		this.autologin = autologin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", date=" + date
				+  ", autologin=" + autologin + "]";
	}

}

