package com.weixin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldg.api.util.JsonUtil;
import com.ldg.api.vo.ResultMsg;
import com.weixin.constant.WeixinConstant;
import com.weixin.util.Access_token;
import com.weixin.util.HttpClientUtil;
import com.weixin.util.PropertiesUtil;
import com.weixin.vo.SQ_AccessVO;
import com.weixin.vo.SQ_UserInfo;

/**
 * 微信网页授权
 * 
 * 1、引导用户进入授权页面同意授权，获取code
 * 
 * 2、通过code换取网页授权access_token（与基础支持中的access_token不同）
 * 
 * 3、如果需要，开发者可以刷新网页授权access_token，避免过期
 * 
 * 4、通过网页授权access_token和openid获取用户基本信息（支持UnionID机制）
 * 
 * @author liudo
 *
 */
@Controller
@RequestMapping(value = "/wxsq")
public class WXSQController {
	/**
	 * 获取授权连接
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/jumpPageForOAuth")
	public String jumpPageForOAuth(String page) throws UnsupportedEncodingException {
		StringBuilder redirectUri = new StringBuilder(PropertiesUtil.weixinPropertiesVal(WeixinConstant.SERVER));
		redirectUri.append(page);
		String appid = PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_PARAM_APPID);
		String state = "abc";
		String url = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.sq_getCodeURL), appid,
				URLEncoder.encode(redirectUri.toString(), "utf-8"), WeixinConstant.sq_scope_snsapi_userinfo, state);
		return "redirect:" + url;
	}

	
	/**
	 * 身份认证
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getUserInfo")
	public @ResponseBody ResultMsg getUserInfo(String code,HttpServletRequest request) {
		ResultMsg msg = new ResultMsg();
		if (StringUtils.isBlank(code)) {
			msg.setErrorCode(500);
			msg.setErrorMsg("无code信息！");
			return msg;
		}
		String url = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.sq_getAccessTokenByCodeURL),
				PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_PARAM_APPID),
				PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_PARAM_SCERET), code);
		String rs = HttpClientUtil.getInstance().sendHttpGet(url);
		SQ_AccessVO sv = JsonUtil.getObjectByJSON(rs, SQ_AccessVO.class);// 2.获取到了授权码
		String userid = sv.getOpenid();
		if (userid != null) {
			String getUserUrl = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.sq_getUserInfo),
					sv.getAccess_token(), sv.getOpenid());
			String userRs = HttpClientUtil.getInstance().sendHttpGet(getUserUrl);
			SQ_UserInfo user = JsonUtil.getObjectByJSON(userRs, SQ_UserInfo.class);
			request.getSession().setAttribute("wxuser", user);
			System.out.println(user);
			msg.setData(user);
			return msg;
		}
		return msg;
	}
}
