package com.sdey.api.po;

import java.util.Date;

public class WxSucai {
	/**
	 * 表字段 : wx_sucai.id
	 */
	private Integer id;

	/**
	 * 图片地址 表字段 : wx_sucai.imgpath
	 */
	private String imgpath;

	/**
	 * 标题 表字段 : wx_sucai.title
	 */
	private String title;

	/**
	 * 简介 表字段 : wx_sucai.jianjie
	 */
	private String jianjie;

	/**
	 * 表字段 : wx_sucai.linkurl
	 */
	private String linkurl;

	/**
	 * 表字段 : wx_sucai.createdata
	 */
	private Date createdata;

	/**
	 * 关联的按钮id 表字段 : wx_sucai.menukey
	 */
	private String menukey;

	/**
	 * 获取 字段:wx_sucai.id
	 * 
	 * @return wx_sucai.id,
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 字段:wx_sucai.id
	 * 
	 * @param id
	 *            the value for wx_sucai.id,
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 图片地址 字段:wx_sucai.imgpath
	 * 
	 * @return wx_sucai.imgpath, 图片地址
	 */
	public String getImgpath() {
		return imgpath;
	}

	/**
	 * 设置 图片地址 字段:wx_sucai.imgpath
	 * 
	 * @param imgpath
	 *            the value for wx_sucai.imgpath, 图片地址
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath == null ? null : imgpath.trim();
	}

	/**
	 * 获取 标题 字段:wx_sucai.title
	 * 
	 * @return wx_sucai.title, 标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置 标题 字段:wx_sucai.title
	 * 
	 * @param title
	 *            the value for wx_sucai.title, 标题
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * 获取 简介 字段:wx_sucai.jianjie
	 * 
	 * @return wx_sucai.jianjie, 简介
	 */
	public String getJianjie() {
		return jianjie;
	}

	/**
	 * 设置 简介 字段:wx_sucai.jianjie
	 * 
	 * @param jianjie
	 *            the value for wx_sucai.jianjie, 简介
	 */
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie == null ? null : jianjie.trim();
	}

	/**
	 * 获取 字段:wx_sucai.linkurl
	 * 
	 * @return wx_sucai.linkurl,
	 */
	public String getLinkurl() {
		return linkurl;
	}

	/**
	 * 设置 字段:wx_sucai.linkurl
	 * 
	 * @param linkurl
	 *            the value for wx_sucai.linkurl,
	 */
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl == null ? null : linkurl.trim();
	}

	/**
	 * 获取 字段:wx_sucai.createdata
	 * 
	 * @return wx_sucai.createdata,
	 */
	public Date getCreatedata() {
		return createdata;
	}

	/**
	 * 设置 字段:wx_sucai.createdata
	 * 
	 * @param createdata
	 *            the value for wx_sucai.createdata,
	 */
	public void setCreatedata(Date createdata) {
		this.createdata = createdata;
	}

	/**
	 * 获取 关联的按钮id 字段:wx_sucai.menukey
	 * 
	 * @return wx_sucai.menukey, 关联的按钮id
	 */
	public String getMenukey() {
		return menukey;
	}

	/**
	 * 设置 关联的按钮id 字段:wx_sucai.menukey
	 * 
	 * @param menukey
	 *            the value for wx_sucai.menukey, 关联的按钮id
	 */
	public void setMenukey(String menukey) {
		this.menukey = menukey == null ? null : menukey.trim();
	}

	@Override
	public String toString() {
		return "WxSucai [id=" + id + ", imgpath=" + imgpath + ", title=" + title + ", jianjie=" + jianjie + ", linkurl="
				+ linkurl + ", createdata=" + createdata + ", menukey=" + menukey + "]";
	}

}