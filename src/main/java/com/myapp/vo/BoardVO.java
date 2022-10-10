package com.myapp.vo;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class BoardVO {
 
    private int seq;
    
    @Length(min=1, max=5, message="제목은 2자이상, 5자 미만으로 입력해주세요.")
    private String title;
    
    @NotEmpty(message = "내용을 입력하세요.")
    private String content;
    
    @NotEmpty(message = "작성자를 입력하세요.")
    private String writer;
    
    @NotEmpty(message = "내용을 입력하세요.")
    @Pattern(regexp = "^[0-9]+$", message="비밀번호는 숫자만 가능합니다.")
    private String password;
    
    private Timestamp regDate;
    
    private int count;
    
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
    
}

