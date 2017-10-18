package com.sdey.api.po;

import java.util.Date;

public class WxManager {
	/**
	 * 表字段 : wx_manager.id
	 */
	private Integer id;

	/**
	 * 管理员名字 表字段 : wx_manager.name
	 */
	private String name;

	/**
	 * 登陆名 表字段 : wx_manager.username
	 */
	private String username;

	/**
	 * 登陆密码 表字段 : wx_manager.psd
	 */
	private String psd;

	/**
	 * 所关联的医院id 表字段 : wx_manager.hospitalid
	 */
	private Integer hospitalid;

	/**
	 * 权限 3 sys管理员 2医院管理员 1科室管理员 表字段 : wx_manager.quanxian
	 */
	private Integer quanxian;

	/**
	 * 创建时间 表字段 : wx_manager.createtime
	 */
	private Date createtime;

	/**
	 * 管理的科室id 表字段 : wx_manager.ksofficeid
	 */
	private Integer ksofficeid;

	/**
	 * 获取 字段:wx_manager.id
	 * 
	 * @return wx_manager.id,
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 字段:wx_manager.id
	 * 
	 * @param id
	 *            the value for wx_manager.id,
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 管理员名字 字段:wx_manager.name
	 * 
	 * @return wx_manager.name, 管理员名字
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 管理员名字 字段:wx_manager.name
	 * 
	 * @param name
	 *            the value for wx_manager.name, 管理员名字
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取 登陆名 字段:wx_manager.username
	 * 
	 * @return wx_manager.username, 登陆名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置 登陆名 字段:wx_manager.username
	 * 
	 * @param username
	 *            the value for wx_manager.username, 登陆名
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * 获取 登陆密码 字段:wx_manager.psd
	 * 
	 * @return wx_manager.psd, 登陆密码
	 */
	public String getPsd() {
		return psd;
	}

	/**
	 * 设置 登陆密码 字段:wx_manager.psd
	 * 
	 * @param psd
	 *            the value for wx_manager.psd, 登陆密码
	 */
	public void setPsd(String psd) {
		this.psd = psd == null ? null : psd.trim();
	}

	/**
	 * 获取 所关联的医院id 字段:wx_manager.hospitalid
	 * 
	 * @return wx_manager.hospitalid, 所关联的医院id
	 */
	public Integer getHospitalid() {
		return hospitalid;
	}

	/**
	 * 设置 所关联的医院id 字段:wx_manager.hospitalid
	 * 
	 * @param hospitalid
	 *            the value for wx_manager.hospitalid, 所关联的医院id
	 */
	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}

	/**
	 * 获取 权限 3 sys管理员 2医院管理员 1科室管理员 字段:wx_manager.quanxian
	 * 
	 * @return wx_manager.quanxian, 权限 3 sys管理员 2医院管理员 1科室管理员
	 */
	public Integer getQuanxian() {
		return quanxian;
	}

	/**
	 * 设置 权限 3 sys管理员 2医院管理员 1科室管理员 字段:wx_manager.quanxian
	 * 
	 * @param quanxian
	 *            the value for wx_manager.quanxian, 权限 3 sys管理员 2医院管理员 1科室管理员
	 */
	public void setQuanxian(Integer quanxian) {
		this.quanxian = quanxian;
	}

	/**
	 * 获取 创建时间 字段:wx_manager.createtime
	 * 
	 * @return wx_manager.createtime, 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 设置 创建时间 字段:wx_manager.createtime
	 * 
	 * @param createtime
	 *            the value for wx_manager.createtime, 创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取 管理的科室id 字段:wx_manager.ksofficeid
	 * 
	 * @return wx_manager.ksofficeid, 管理的科室id
	 */
	public Integer getKsofficeid() {
		return ksofficeid;
	}

	/**
	 * 设置 管理的科室id 字段:wx_manager.ksofficeid
	 * 
	 * @param ksofficeid
	 *            the value for wx_manager.ksofficeid, 管理的科室id
	 */
	public void setKsofficeid(Integer ksofficeid) {
		this.ksofficeid = ksofficeid;
	}

	@Override
	public String toString() {
		return "WxManager [id=" + id + ", name=" + name + ", username=" + username + ", psd=" + psd + ", hospitalid="
				+ hospitalid + ", quanxian=" + quanxian + ", createtime=" + createtime + ", ksofficeid=" + ksofficeid
				+ "]";
	}

}