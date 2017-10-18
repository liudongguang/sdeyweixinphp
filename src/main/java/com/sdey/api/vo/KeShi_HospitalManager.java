package com.sdey.api.vo;

import java.util.Date;

public class KeShi_HospitalManager {
	private Integer id; // 新闻id
	private String title;// 新闻标题
	private Date createtime;// 新闻创建时间
	private String ksname;// 科室名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getKsname() {
		return ksname;
	}
	public void setKsname(String ksname) {
		this.ksname = ksname;
	}
	@Override
	public String toString() {
		return "KeShi_HospitalManager [id=" + id + ", title=" + title + ", createtime=" + createtime + ", ksname="
				+ ksname + "]";
	}
	
}
