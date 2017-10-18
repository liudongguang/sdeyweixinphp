package com.weixin.vo.ewm;

public class RsTicket {
	private String ticket;
	private String url;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "RsTicket [ticket=" + ticket + ", url=" + url + "]";
	}

}
