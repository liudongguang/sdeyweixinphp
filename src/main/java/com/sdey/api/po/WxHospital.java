package com.sdey.api.po;

import java.util.Date;

public class WxHospital {
    /**
	 * 表字段 : wx_hospital.id
	 */
	private Integer id;

	/**
	 * 医院名称 表字段 : wx_hospital.name
	 */
	private String name;

	/**
	 * 医院等级 表字段 : wx_hospital.dj
	 */
	private String dj;

	/**
	 * 电话 表字段 : wx_hospital.tel
	 */
	private String tel;

	/**
	 * 机构网址 表字段 : wx_hospital.webaddr
	 */
	private String webaddr;

	/**
	 * 所在城市 表字段 : wx_hospital.city
	 */
	private String city;

	/**
	 * 机构地址 表字段 : wx_hospital.address
	 */
	private String address;

	/**
	 * 交通路线 表字段 : wx_hospital.jtlx
	 */
	private String jtlx;

	/**
	 * 机构简介 表字段 : wx_hospital.jgjj
	 */
	private String jgjj;

	/**
	 * 创建时间 表字段 : wx_hospital.createtime
	 */
	private Date createtime;

	/**
	 * 操作员id 表字段 : wx_hospital.czyid
	 */
	private Integer czyid;

	/**
	 * 拼音 表字段 : wx_hospital.pinyin
	 */
	private String pinyin;

	/**
	 * 二维码 表字段 : wx_hospital.erweima
	 */
	private String erweima;

	/**
	 * 获取  字段:wx_hospital.id
	 * @return  wx_hospital.id, 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置  字段:wx_hospital.id
	 * @param id  the value for wx_hospital.id, 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 医院名称 字段:wx_hospital.name
	 * @return  wx_hospital.name, 医院名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 医院名称 字段:wx_hospital.name
	 * @param name  the value for wx_hospital.name, 医院名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取 医院等级 字段:wx_hospital.dj
	 * @return  wx_hospital.dj, 医院等级
	 */
	public String getDj() {
		return dj;
	}

	/**
	 * 设置 医院等级 字段:wx_hospital.dj
	 * @param dj  the value for wx_hospital.dj, 医院等级
	 */
	public void setDj(String dj) {
		this.dj = dj == null ? null : dj.trim();
	}

	/**
	 * 获取 电话 字段:wx_hospital.tel
	 * @return  wx_hospital.tel, 电话
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置 电话 字段:wx_hospital.tel
	 * @param tel  the value for wx_hospital.tel, 电话
	 */
	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	/**
	 * 获取 机构网址 字段:wx_hospital.webaddr
	 * @return  wx_hospital.webaddr, 机构网址
	 */
	public String getWebaddr() {
		return webaddr;
	}

	/**
	 * 设置 机构网址 字段:wx_hospital.webaddr
	 * @param webaddr  the value for wx_hospital.webaddr, 机构网址
	 */
	public void setWebaddr(String webaddr) {
		this.webaddr = webaddr == null ? null : webaddr.trim();
	}

	/**
	 * 获取 所在城市 字段:wx_hospital.city
	 * @return  wx_hospital.city, 所在城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置 所在城市 字段:wx_hospital.city
	 * @param city  the value for wx_hospital.city, 所在城市
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * 获取 机构地址 字段:wx_hospital.address
	 * @return  wx_hospital.address, 机构地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置 机构地址 字段:wx_hospital.address
	 * @param address  the value for wx_hospital.address, 机构地址
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * 获取 交通路线 字段:wx_hospital.jtlx
	 * @return  wx_hospital.jtlx, 交通路线
	 */
	public String getJtlx() {
		return jtlx;
	}

	/**
	 * 设置 交通路线 字段:wx_hospital.jtlx
	 * @param jtlx  the value for wx_hospital.jtlx, 交通路线
	 */
	public void setJtlx(String jtlx) {
		this.jtlx = jtlx == null ? null : jtlx.trim();
	}

	/**
	 * 获取 机构简介 字段:wx_hospital.jgjj
	 * @return  wx_hospital.jgjj, 机构简介
	 */
	public String getJgjj() {
		return jgjj;
	}

	/**
	 * 设置 机构简介 字段:wx_hospital.jgjj
	 * @param jgjj  the value for wx_hospital.jgjj, 机构简介
	 */
	public void setJgjj(String jgjj) {
		this.jgjj = jgjj == null ? null : jgjj.trim();
	}

	/**
	 * 获取 创建时间 字段:wx_hospital.createtime
	 * @return  wx_hospital.createtime, 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 设置 创建时间 字段:wx_hospital.createtime
	 * @param createtime  the value for wx_hospital.createtime, 创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取 操作员id 字段:wx_hospital.czyid
	 * @return  wx_hospital.czyid, 操作员id
	 */
	public Integer getCzyid() {
		return czyid;
	}

	/**
	 * 设置 操作员id 字段:wx_hospital.czyid
	 * @param czyid  the value for wx_hospital.czyid, 操作员id
	 */
	public void setCzyid(Integer czyid) {
		this.czyid = czyid;
	}

	/**
	 * 获取 拼音 字段:wx_hospital.pinyin
	 * @return  wx_hospital.pinyin, 拼音
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * 设置 拼音 字段:wx_hospital.pinyin
	 * @param pinyin  the value for wx_hospital.pinyin, 拼音
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin == null ? null : pinyin.trim();
	}

	/**
	 * 获取 二维码 字段:wx_hospital.erweima
	 * @return  wx_hospital.erweima, 二维码
	 */
	public String getErweima() {
		return erweima;
	}

	/**
	 * 设置 二维码 字段:wx_hospital.erweima
	 * @param erweima  the value for wx_hospital.erweima, 二维码
	 */
	public void setErweima(String erweima) {
		this.erweima = erweima == null ? null : erweima.trim();
	}

	
	@Override
	public String toString() {
		return "WxHospital [id=" + id + ", name=" + name + ", dj=" + dj + ", tel=" + tel + ", webaddr=" + webaddr
				+ ", city=" + city + ", address=" + address + ", jtlx=" + jtlx + ", jgjj=" + jgjj + ", createtime="
				+ createtime + ", czyid=" + czyid + ", pinyin=" + pinyin + "]";
	}
    
}