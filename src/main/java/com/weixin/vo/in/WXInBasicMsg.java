package com.weixin.vo.in;

import com.weixin.constant.WeixinConstant;
import com.weixin.util.WX_Util;

public class WXInBasicMsg {
	private String ToUserName; // 开发者微信号
	private String FromUserName; // 发送方帐号（一个OpenID）
	private Integer CreateTime; // 消息创建时间 （整型）
	private String MsgType;// text
	private Long MsgId; // 消息id，64位整型

	public WXInBasicMsg() {
	}

	public WXInBasicMsg(String text) {
		super();
		this.ToUserName = WX_Util.getXMLCDATA(text, WeixinConstant.IN_COMM_ToUserName);
		this.FromUserName = WX_Util.getXMLCDATA(text, WeixinConstant.IN_COMM_FromUserName);
		this.CreateTime = Integer.valueOf(WX_Util.getXMLCDATA(text, WeixinConstant.IN_COMM_CreateTime));
		this.MsgType = WX_Util.getXMLCDATA(text, WeixinConstant.IN_COMM_MsgType);
		this.MsgId = Long.valueOf(WX_Util.getXMLCDATA(text, WeixinConstant.IN_COMM_MsgId));
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

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

	@Override
	public String toString() {
		return "WXBasicMsg [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + ", MsgId=" + MsgId + "]";
	}

}
