package com.weixin.jssdk;

public class JsonToTicket {
	private Integer errcode;
	private String errmsg;
	private String ticket;
	private Integer expires_in;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "JsonToTicket [errcode=" + errcode + ", errmsg=" + errmsg + ", ticket=" + ticket + ", expires_in="
				+ expires_in + "]";
	}

}
