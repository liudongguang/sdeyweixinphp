package com.weixin.controller;

import java.text.MessageFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ldg.api.util.JsonUtil;
import com.weixin.constant.WeixinConstant;
import com.weixin.util.Access_token;
import com.weixin.util.HttpClientUtil;
import com.weixin.util.PropertiesUtil;
import com.weixin.vo.ewm.ActionInfo;
import com.weixin.vo.ewm.GetTicketParam;
import com.weixin.vo.ewm.RsTicket;

/**
 * 二维码获取 |||| 帐号管理-----》生成带参数的二维码
 *
 */
@Controller
@RequestMapping(value = "/wxewm")
public class WXEWMController {
	/**
	 * QR_LIMIT_SCENE与scene_id对应 ----scene_id为数字
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/getTicket")
	public @ResponseBody String getTicket() throws JsonProcessingException {
		String getTicketUrl = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.ewm_getTicketURL),
				Access_token.getAccessToken());
		GetTicketParam gtp = new GetTicketParam();
		gtp.setAction_name(WeixinConstant.ewm_QR_LIMIT_SCENE);
		ActionInfo ai = new ActionInfo();
		// ai.getScene().setScene_str("123");
		gtp.setAction_info(ai);
		String ticketRs = HttpClientUtil.getInstance().sendHttpPostJson(getTicketUrl, JsonUtil.parseToJson(gtp));
		RsTicket rt = JsonUtil.getObjectByJSON(ticketRs, RsTicket.class);

		// 根据ticket获取二维码
		String getEWMByTicketUrl = MessageFormat
				.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.ewm_getEWMByTicket), rt.getTicket());
		return getEWMByTicketUrl;
	}

	/**
	 * QR_LIMIT_STR_SCENE与scene_str对应 ----scene_str为字符串
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/getTicket2")
	public @ResponseBody String getTicket2() throws JsonProcessingException {
		String getTicketUrl = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.ewm_getTicketURL),
				Access_token.getAccessToken());
		GetTicketParam gtp = new GetTicketParam();
		gtp.setAction_name(WeixinConstant.ewm_QR_LIMIT_STR_SCENE);
		ActionInfo ai = new ActionInfo();
		ai.getScene().setScene_str("abc");
		gtp.setAction_info(ai);
		String ticketRs = HttpClientUtil.getInstance().sendHttpPostJson(getTicketUrl, JsonUtil.parseToJson(gtp));
		RsTicket rt = JsonUtil.getObjectByJSON(ticketRs, RsTicket.class);

		// 根据ticket获取二维码
		String getEWMByTicketUrl = MessageFormat
				.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.ewm_getEWMByTicket), rt.getTicket());
		return getEWMByTicketUrl;
	}
}
