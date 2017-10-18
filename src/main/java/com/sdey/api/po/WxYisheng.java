package com.sdey.api.po;

import java.util.Date;

public class WxYisheng {
	/**
	 * 表字段 : wx_yisheng.id
	 */
	private Integer id;

	/**
	 * 医生姓名 表字段 : wx_yisheng.name
	 */
	private String name;

	/**
	 * 职称 表字段 : wx_yisheng.zhicheng
	 */
	private String zhicheng;

	/**
	 * 职务 表字段 : wx_yisheng.zhiwu
	 */
	private String zhiwu;

	/**
	 * 所属科室id 表字段 : wx_yisheng.ssksid
	 */
	private Integer ssksid;

	/**
	 * 头像地址 表字段 : wx_yisheng.headimg
	 */
	private String headimg;

	/**
	 * 社会兼职 表字段 : wx_yisheng.shjz
	 */
	private String shjz;

	/**
	 * 职业特长 表字段 : wx_yisheng.zysc
	 */
	private String zysc;

	/**
	 * 详细内容 表字段 : wx_yisheng.xxnr
	 */
	private String xxnr;

	/**
	 * 所属医院 表字段 : wx_yisheng.hospitalid
	 */
	private Integer hospitalid;

	/**
	 * 拼音 表字段 : wx_yisheng.pinyin
	 */
	private String pinyin;

	/**
	 * 创建时间 表字段 : wx_yisheng.createtime
	 */
	private Date createtime;

	/**
	 * 操作员 表字段 : wx_yisheng.czyid
	 */
	private Integer czyid;

	/**
	 * 工号 表字段 : wx_yisheng.gonghao
	 */
	private String gonghao;

	/**
	 * 获取 字段:wx_yisheng.id
	 * 
	 * @return wx_yisheng.id,
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 字段:wx_yisheng.id
	 * 
	 * @param id
	 *            the value for wx_yisheng.id,
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 医生姓名 字段:wx_yisheng.name
	 * 
	 * @return wx_yisheng.name, 医生姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 医生姓名 字段:wx_yisheng.name
	 * 
	 * @param name
	 *            the value for wx_yisheng.name, 医生姓名
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取 职称 字段:wx_yisheng.zhicheng
	 * 
	 * @return wx_yisheng.zhicheng, 职称
	 */
	public String getZhicheng() {
		return zhicheng;
	}

	/**
	 * 设置 职称 字段:wx_yisheng.zhicheng
	 * 
	 * @param zhicheng
	 *            the value for wx_yisheng.zhicheng, 职称
	 */
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng == null ? null : zhicheng.trim();
	}

	/**
	 * 获取 职务 字段:wx_yisheng.zhiwu
	 * 
	 * @return wx_yisheng.zhiwu, 职务
	 */
	public String getZhiwu() {
		return zhiwu;
	}

	/**
	 * 设置 职务 字段:wx_yisheng.zhiwu
	 * 
	 * @param zhiwu
	 *            the value for wx_yisheng.zhiwu, 职务
	 */
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu == null ? null : zhiwu.trim();
	}

	/**
	 * 获取 所属科室id 字段:wx_yisheng.ssksid
	 * 
	 * @return wx_yisheng.ssksid, 所属科室id
	 */
	public Integer getSsksid() {
		return ssksid;
	}

	/**
	 * 设置 所属科室id 字段:wx_yisheng.ssksid
	 * 
	 * @param ssksid
	 *            the value for wx_yisheng.ssksid, 所属科室id
	 */
	public void setSsksid(Integer ssksid) {
		this.ssksid = ssksid;
	}

	/**
	 * 获取 头像地址 字段:wx_yisheng.headimg
	 * 
	 * @return wx_yisheng.headimg, 头像地址
	 */
	public String getHeadimg() {
		return headimg;
	}

	/**
	 * 设置 头像地址 字段:wx_yisheng.headimg
	 * 
	 * @param headimg
	 *            the value for wx_yisheng.headimg, 头像地址
	 */
	public void setHeadimg(String headimg) {
		this.headimg = headimg == null ? null : headimg.trim();
	}

	/**
	 * 获取 社会兼职 字段:wx_yisheng.shjz
	 * 
	 * @return wx_yisheng.shjz, 社会兼职
	 */
	public String getShjz() {
		return shjz;
	}

	/**
	 * 设置 社会兼职 字段:wx_yisheng.shjz
	 * 
	 * @param shjz
	 *            the value for wx_yisheng.shjz, 社会兼职
	 */
	public void setShjz(String shjz) {
		this.shjz = shjz == null ? null : shjz.trim();
	}

	/**
	 * 获取 职业特长 字段:wx_yisheng.zysc
	 * 
	 * @return wx_yisheng.zysc, 职业特长
	 */
	public String getZysc() {
		return zysc;
	}

	/**
	 * 设置 职业特长 字段:wx_yisheng.zysc
	 * 
	 * @param zysc
	 *            the value for wx_yisheng.zysc, 职业特长
	 */
	public void setZysc(String zysc) {
		this.zysc = zysc == null ? null : zysc.trim();
	}

	/**
	 * 获取 详细内容 字段:wx_yisheng.xxnr
	 * 
	 * @return wx_yisheng.xxnr, 详细内容
	 */
	public String getXxnr() {
		return xxnr;
	}

	/**
	 * 设置 详细内容 字段:wx_yisheng.xxnr
	 * 
	 * @param xxnr
	 *            the value for wx_yisheng.xxnr, 详细内容
	 */
	public void setXxnr(String xxnr) {
		this.xxnr = xxnr == null ? null : xxnr.trim();
	}

	/**
	 * 获取 所属医院 字段:wx_yisheng.hospitalid
	 * 
	 * @return wx_yisheng.hospitalid, 所属医院
	 */
	public Integer getHospitalid() {
		return hospitalid;
	}

	/**
	 * 设置 所属医院 字段:wx_yisheng.hospitalid
	 * 
	 * @param hospitalid
	 *            the value for wx_yisheng.hospitalid, 所属医院
	 */
	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}

	/**
	 * 获取 拼音 字段:wx_yisheng.pinyin
	 * 
	 * @return wx_yisheng.pinyin, 拼音
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * 设置 拼音 字段:wx_yisheng.pinyin
	 * 
	 * @param pinyin
	 *            the value for wx_yisheng.pinyin, 拼音
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin == null ? null : pinyin.trim();
	}

	/**
	 * 获取 创建时间 字段:wx_yisheng.createtime
	 * 
	 * @return wx_yisheng.createtime, 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 设置 创建时间 字段:wx_yisheng.createtime
	 * 
	 * @param createtime
	 *            the value for wx_yisheng.createtime, 创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取 操作员 字段:wx_yisheng.czyid
	 * 
	 * @return wx_yisheng.czyid, 操作员
	 */
	public Integer getCzyid() {
		return czyid;
	}

	/**
	 * 设置 操作员 字段:wx_yisheng.czyid
	 * 
	 * @param czyid
	 *            the value for wx_yisheng.czyid, 操作员
	 */
	public void setCzyid(Integer czyid) {
		this.czyid = czyid;
	}

	/**
	 * 获取 工号 字段:wx_yisheng.gonghao
	 * 
	 * @return wx_yisheng.gonghao, 工号
	 */
	public String getGonghao() {
		return gonghao;
	}

	/**
	 * 设置 工号 字段:wx_yisheng.gonghao
	 * 
	 * @param gonghao
	 *            the value for wx_yisheng.gonghao, 工号
	 */
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao == null ? null : gonghao.trim();
	}

	@Override
	public String toString() {
		return "WxYisheng [id=" + id + ", name=" + name + ", zhicheng=" + zhicheng + ", zhiwu=" + zhiwu + ", ssksid="
				+ ssksid + ", headimg=" + headimg + ", shjz=" + shjz + ", zysc=" + zysc + ", xxnr=" + xxnr
				+ ", hospitalid=" + hospitalid + ", pinyin=" + pinyin + ", createtime=" + createtime + ", czyid="
				+ czyid + ", gonghao=" + gonghao + "]";
	}

}