package com.weixin.util;

import java.text.MessageFormat;

import com.ldg.api.util.JsonUtil;
import com.weixin.constant.WeixinConstant;
import com.weixin.jssdk.JsonToTicket;

public class JSSDKTicket {
	private static String wxticket = null;

	public static void initJsapiTicket() {
		String url = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.ssdk_getJsapiTicketURL),
				Access_token.getAccessToken());
		HttpClientUtil htc = HttpClientUtil.getInstance();
		String rtStr = htc.sendHttpGet(url);
		JsonToTicket ticket = JsonUtil.getObjectByJSON(rtStr, JsonToTicket.class);
		wxticket = ticket.getTicket();
	}
	public static String getWxticket() {
		return wxticket;
	}
}
