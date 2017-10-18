package com.sdey.api.po;

public class ServicePhpQr {
	/**
	 * 表字段 : service_php_qr.id
	 */
	private Integer id;

	/**
	 * 医院id 表字段 : service_php_qr.hospitalid
	 */
	private String hospitalid;

	/**
	 * 科室id 表字段 : service_php_qr.officeid
	 */
	private String officeid;

	/**
	 * 二维码地址 表字段 : service_php_qr.qr_code
	 */
	private String qrCode;

	/**
	 * 1 医院 2.科室 表字段 : service_php_qr.state
	 */
	private Integer state;

	/**
	 * 获取 字段:service_php_qr.id
	 * 
	 * @return service_php_qr.id,
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 字段:service_php_qr.id
	 * 
	 * @param id
	 *            the value for service_php_qr.id,
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 医院id 字段:service_php_qr.hospitalid
	 * 
	 * @return service_php_qr.hospitalid, 医院id
	 */
	public String getHospitalid() {
		return hospitalid;
	}

	/**
	 * 设置 医院id 字段:service_php_qr.hospitalid
	 * 
	 * @param hospitalid
	 *            the value for service_php_qr.hospitalid, 医院id
	 */
	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid == null ? null : hospitalid.trim();
	}

	/**
	 * 获取 科室id 字段:service_php_qr.officeid
	 * 
	 * @return service_php_qr.officeid, 科室id
	 */
	public String getOfficeid() {
		return officeid;
	}

	/**
	 * 设置 科室id 字段:service_php_qr.officeid
	 * 
	 * @param officeid
	 *            the value for service_php_qr.officeid, 科室id
	 */
	public void setOfficeid(String officeid) {
		this.officeid = officeid == null ? null : officeid.trim();
	}

	/**
	 * 获取 二维码地址 字段:service_php_qr.qr_code
	 * 
	 * @return service_php_qr.qr_code, 二维码地址
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * 设置 二维码地址 字段:service_php_qr.qr_code
	 * 
	 * @param qrCode
	 *            the value for service_php_qr.qr_code, 二维码地址
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode == null ? null : qrCode.trim();
	}

	/**
	 * 获取 1 医院 2.科室 字段:service_php_qr.state
	 * 
	 * @return service_php_qr.state, 1 医院 2.科室
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 设置 1 医院 2.科室 字段:service_php_qr.state
	 * 
	 * @param state
	 *            the value for service_php_qr.state, 1 医院 2.科室
	 */
	public void setState(Integer state) {
		this.state = state;
	}

}