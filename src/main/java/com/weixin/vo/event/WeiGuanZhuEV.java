package com.weixin.vo.event;

import com.weixin.constant.WeixinConstant;
import com.weixin.util.WX_Util;

public class WeiGuanZhuEV extends WXEventBase {
	private String EventKey;
	private String Ticket;

	public WeiGuanZhuEV(String msg) {
		super(msg);
		this.EventKey = WX_Util.getXMLCDATA(msg, WeixinConstant.EVENT_XML_EventKey);
		this.Ticket = WX_Util.getXMLCDATA(msg, WeixinConstant.EVENT_XML_Ticket);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	@Override
	public String toString() {
		return super.toString()+"    WeiGuanZhuEV [EventKey=" + EventKey + ", Ticket=" + Ticket + "]";
	}

}
