package com.sdey.api.po;

import java.util.Date;

public class WxKeshi {
    /**
	 * 表字段 : wx_keshi.id
	 */
	private Integer id;

	/**
	 * 科室名称 表字段 : wx_keshi.name
	 */
	private String name;

	/**
	 * 图片 表字段 : wx_keshi.photo
	 */
	private String photo;

	/**
	 * 详情 表字段 : wx_keshi.xq
	 */
	private String xq;

	/**
	 * 医院id 表字段 : wx_keshi.hospitalid
	 */
	private Integer hospitalid;

	/**
	 * 拼音 表字段 : wx_keshi.pinyin
	 */
	private String pinyin;

	/**
	 * 创建时间 表字段 : wx_keshi.createtime
	 */
	private Date createtime;

	/**
	 * 操作员id 表字段 : wx_keshi.czyid
	 */
	private Integer czyid;

	/**
	 * 科室二维码 表字段 : wx_keshi.wxkserweima
	 */
	private String wxkserweima;

	/**
	 * 获取  字段:wx_keshi.id
	 * @return  wx_keshi.id, 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置  字段:wx_keshi.id
	 * @param id  the value for wx_keshi.id, 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 科室名称 字段:wx_keshi.name
	 * @return  wx_keshi.name, 科室名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 科室名称 字段:wx_keshi.name
	 * @param name  the value for wx_keshi.name, 科室名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取 图片 字段:wx_keshi.photo
	 * @return  wx_keshi.photo, 图片
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 设置 图片 字段:wx_keshi.photo
	 * @param photo  the value for wx_keshi.photo, 图片
	 */
	public void setPhoto(String photo) {
		this.photo = photo == null ? null : photo.trim();
	}

	/**
	 * 获取 详情 字段:wx_keshi.xq
	 * @return  wx_keshi.xq, 详情
	 */
	public String getXq() {
		return xq;
	}

	/**
	 * 设置 详情 字段:wx_keshi.xq
	 * @param xq  the value for wx_keshi.xq, 详情
	 */
	public void setXq(String xq) {
		this.xq = xq == null ? null : xq.trim();
	}

	/**
	 * 获取 医院id 字段:wx_keshi.hospitalid
	 * @return  wx_keshi.hospitalid, 医院id
	 */
	public Integer getHospitalid() {
		return hospitalid;
	}

	/**
	 * 设置 医院id 字段:wx_keshi.hospitalid
	 * @param hospitalid  the value for wx_keshi.hospitalid, 医院id
	 */
	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}

	/**
	 * 获取 拼音 字段:wx_keshi.pinyin
	 * @return  wx_keshi.pinyin, 拼音
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * 设置 拼音 字段:wx_keshi.pinyin
	 * @param pinyin  the value for wx_keshi.pinyin, 拼音
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin == null ? null : pinyin.trim();
	}

	/**
	 * 获取 创建时间 字段:wx_keshi.createtime
	 * @return  wx_keshi.createtime, 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 设置 创建时间 字段:wx_keshi.createtime
	 * @param createtime  the value for wx_keshi.createtime, 创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取 操作员id 字段:wx_keshi.czyid
	 * @return  wx_keshi.czyid, 操作员id
	 */
	public Integer getCzyid() {
		return czyid;
	}

	/**
	 * 设置 操作员id 字段:wx_keshi.czyid
	 * @param czyid  the value for wx_keshi.czyid, 操作员id
	 */
	public void setCzyid(Integer czyid) {
		this.czyid = czyid;
	}

	/**
	 * 获取 科室二维码 字段:wx_keshi.wxkserweima
	 * @return  wx_keshi.wxkserweima, 科室二维码
	 */
	public String getWxkserweima() {
		return wxkserweima;
	}

	/**
	 * 设置 科室二维码 字段:wx_keshi.wxkserweima
	 * @param wxkserweima  the value for wx_keshi.wxkserweima, 科室二维码
	 */
	public void setWxkserweima(String wxkserweima) {
		this.wxkserweima = wxkserweima == null ? null : wxkserweima.trim();
	}

	@Override
	public String toString() {
		return "WxKeshi [id=" + id + ", name=" + name + ", photo=" + photo + ", xq=" + xq + ", hospitalid=" + hospitalid
				+ ", pinyin=" + pinyin + ", createtime=" + createtime + ", czyid=" + czyid + ", wxkserweima="
				+ wxkserweima + "]";
	}

	
}