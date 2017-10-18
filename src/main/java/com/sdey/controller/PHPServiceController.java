package com.sdey.controller;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ldg.api.util.JsonUtil;
import com.ldg.api.vo.ResultMsg;
import com.sdey.api.constant.SysConstant;
import com.sdey.api.service.PhpWXService;
import com.weixin.constant.WeixinConstant;
import com.weixin.util.Access_token;
import com.weixin.util.HttpClientUtil;
import com.weixin.util.PropertiesUtil;
import com.weixin.vo.ewm.ActionInfo;
import com.weixin.vo.ewm.GetTicketParam;
import com.weixin.vo.ewm.RsTicket;

@Controller
@RequestMapping(value = "/wxwebservice")
public class PHPServiceController {
	@Autowired
	private PhpWXService phpSV;

	/**
	 * 获取科室二维码PHP
	 * 
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/getOfficeQR")
	public @ResponseBody ResultMsg getOfficeQR(HttpServletRequest request, HttpServletResponse response,
			String hospitalid, String officeid) throws JsonProcessingException {
		ResultMsg msg = new ResultMsg();
		String erweimaURL = phpSV.getKSEWM(hospitalid, officeid);
		if (erweimaURL != null) {
			msg.setData(erweimaURL);
		} else {
			//// 获取二维码
			String getTicketUrl = MessageFormat.format(
					PropertiesUtil.weixinPropertiesVal(WeixinConstant.ewm_getTicketURL), Access_token.getAccessToken());
			GetTicketParam gtp = new GetTicketParam();
			gtp.setAction_name(WeixinConstant.ewm_QR_LIMIT_STR_SCENE);
			ActionInfo ai = new ActionInfo();
			StringBuilder scene_str = new StringBuilder();
			scene_str.append(hospitalid).append("-").append(officeid);
			ai.getScene().setScene_str(scene_str.toString());
			gtp.setAction_info(ai);
			String ticketRs = HttpClientUtil.getInstance().sendHttpPostJson(getTicketUrl, JsonUtil.parseToJson(gtp));
			RsTicket rt = JsonUtil.getObjectByJSON(ticketRs, RsTicket.class);
			// 根据ticket获取二维码
			String getEWMByTicketUrl = MessageFormat
					.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.ewm_getEWMByTicket), rt.getTicket());
			int insertc = phpSV.saveKSEWM(hospitalid, officeid, getEWMByTicketUrl);
			msg.setData(getEWMByTicketUrl);
		}
		return msg;
	}

	/**
	 * 获取医院二维码PHP
	 * 
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/getHospitalQR")
	public @ResponseBody ResultMsg getHospitalQR(HttpServletRequest request, HttpServletResponse response,
			String hospitalid) throws JsonProcessingException {
		ResultMsg msg = new ResultMsg();
		String erweimaURL = phpSV.getHospitalEWM(hospitalid);
		if (erweimaURL != null) {
			msg.setData(erweimaURL);
		} else {
			//// 获取二维码
			String getTicketUrl = MessageFormat.format(
					PropertiesUtil.weixinPropertiesVal(WeixinConstant.ewm_getTicketURL), Access_token.getAccessToken());
			GetTicketParam gtp = new GetTicketParam();
			gtp.setAction_name(WeixinConstant.ewm_QR_LIMIT_STR_SCENE);
			ActionInfo ai = new ActionInfo();
			StringBuilder scene_str = new StringBuilder();
			scene_str.append(SysConstant.WXEWM_HOSPITAL).append(hospitalid);
			ai.getScene().setScene_str(scene_str.toString());
			gtp.setAction_info(ai);
			String ticketRs = HttpClientUtil.getInstance().sendHttpPostJson(getTicketUrl, JsonUtil.parseToJson(gtp));
			RsTicket rt = JsonUtil.getObjectByJSON(ticketRs, RsTicket.class);
			// 根据ticket获取二维码
			String getEWMByTicketUrl = MessageFormat
					.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.ewm_getEWMByTicket), rt.getTicket());
			int insertc = phpSV.saveHospitalEWM(hospitalid, getEWMByTicketUrl);
			msg.setData(getEWMByTicketUrl);
		}
		return msg;
	}
}
