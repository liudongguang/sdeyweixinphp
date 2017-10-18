package com.sdey.api.vo;

import java.util.Date;

public class Yisheng_HospitalManger {
	private Integer id; // 医生id
	private String ysname;// 医生姓名
	private String ksname; // 科室名称
	private String gonghao;// 医生工号
	private Date createtime;// 医生的创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYsname() {
		return ysname;
	}

	public void setYsname(String ysname) {
		this.ysname = ysname;
	}

	public String getKsname() {
		return ksname;
	}

	public void setKsname(String ksname) {
		this.ksname = ksname;
	}

	public String getGonghao() {
		return gonghao;
	}

	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Yisheng_HospitalManger [id=" + id + ", ysname=" + ysname + ", ksname=" + ksname + ", gonghao=" + gonghao
				+ ", createtime=" + createtime + "]";
	}

}
