package com.weixin.vo.event;

import com.weixin.constant.WeixinConstant;
import com.weixin.util.WX_Util;

public class ClickEV extends WXEventBase {
	private String EventKey;

	public ClickEV(String msg) {
		super(msg);
		this.EventKey = WX_Util.getXMLCDATA(msg, WeixinConstant.EVENT_XML_EventKey);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	@Override
	public String toString() {
		return super.toString() + "   ClickEV [EventKey=" + EventKey + "]";
	}

}
