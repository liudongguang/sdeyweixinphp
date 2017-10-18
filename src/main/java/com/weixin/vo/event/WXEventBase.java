package com.weixin.vo.event;

import com.weixin.constant.WeixinConstant;
import com.weixin.util.WX_Util;

public abstract class WXEventBase {
	private String ToUserName; // 开发者微信号
	private String FromUserName; // 发送方帐号（一个OpenID）
	private Integer CreateTime; // 消息创建时间 （整型）
	private String MsgType;// 信息类型
	private String Event; // 事件名称

	public WXEventBase(String msg) {
		super();
		this.ToUserName = WX_Util.getXMLCDATA(msg, WeixinConstant.IN_COMM_ToUserName);
		this.FromUserName = WX_Util.getXMLCDATA(msg, WeixinConstant.IN_COMM_FromUserName);
		this.CreateTime = Integer.valueOf(WX_Util.getXMLCDATA(msg, WeixinConstant.IN_COMM_CreateTime));
		this.MsgType = WX_Util.getXMLCDATA(msg, WeixinConstant.IN_COMM_MsgType);
		this.Event = WX_Util.getXMLCDATA(msg, WeixinConstant.IN_COMM_Event);
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Integer getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Integer createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	@Override
	public String toString() {
		return "WXEventBase [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + ", Event=" + Event + "]";
	}

}
