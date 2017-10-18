package com.weixin.util;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

import com.ldg.api.util.JsonUtil;
import com.weixin.constant.WeixinConstant;
import com.weixin.vo.AsscessToken;

public class Access_token {
	private static String accessToken = null;

	public static void init_Access_token() {
		String url = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.GETACCESS_TOKENURL),
				PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_PARAM_APPID),
				PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_PARAM_SCERET));
		HttpClientUtil htc = HttpClientUtil.getInstance();
		String rtStr = htc.sendHttpGet(url);
		if (StringUtils.isNotBlank(rtStr)) {
			AsscessToken ass = JsonUtil.getObjectByJSON(rtStr, AsscessToken.class);
			accessToken = ass.getAccess_token();
			// jssdk使用
			JSSDKTicket.initJsapiTicket();
		}
	}

	public static String getAccessToken() {
		return accessToken;
	}

}
