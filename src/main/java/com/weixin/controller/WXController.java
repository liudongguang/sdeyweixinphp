package com.weixin.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.sdey.api.po.WxSucai;
import com.sdey.api.service.HospitalService;
import com.sdey.api.service.SuCaiService;
import com.weixin.constant.WeixinConstant;
import com.weixin.handlermsg.HandlerClick;
import com.weixin.util.PropertiesUtil;
import com.weixin.util.WXBizMsgCryptSingleton;
import com.weixin.util.WX_Util;
import com.weixin.vo.ServerSendMSG;
import com.weixin.vo.ValidateMSG;
import com.weixin.vo.event.CancelGZEV;
import com.weixin.vo.event.ClickEV;
import com.weixin.vo.event.WeiGuanZhuEV;
import com.weixin.vo.in.WX_Image;
import com.weixin.vo.in.WX_Link;
import com.weixin.vo.in.WX_Location;
import com.weixin.vo.in.WX_Shortvideo;
import com.weixin.vo.in.WX_Text;
import com.weixin.vo.in.WX_Vidio;
import com.weixin.vo.in.WX_Voice;
import com.weixin.vo.out.WX_OutText;

@Controller
@RequestMapping(value = "/wx")
public class WXController {
	@Autowired
	private HospitalService hospitalSV;
	@Autowired
	private SuCaiService suCaiService;
	/**
	 * 接入验证
	 * 
	 * @param validateMSG
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public void validate(ValidateMSG validateMSG, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println(validateMSG);
		// 验证
		String vstr = WX_Util.validate(validateMSG);
		WX_Util.print(vstr, response);
	}

	/**
	 * 信息处理
	 * 
	 * @param ssdMSG
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws AesException
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public void validate(ServerSendMSG ssdMSG, HttpServletRequest request, HttpServletResponse response)
			throws IOException, AesException {
		String message = WX_Util.getStrInputStream(request);
		if(message.indexOf( WeixinConstant.IN_Encrypt)!=-1){
			String encrypt = WX_Util.getXMLCDATA(message, WeixinConstant.IN_Encrypt);
			WXBizMsgCrypt wmc = WXBizMsgCryptSingleton.getWXBizMsgCryptInstance();
			message = wmc.decrypt(encrypt);// 解密
		}		
		if (StringUtils.isBlank(message)) {
			return;
		}
		// System.out.println(message);
		switch (WX_Util.getXMLCDATA(message, WeixinConstant.IN_COMM_MsgType)) {
		case WeixinConstant.WX_MESSAGETYPE_TEXT:
			// 接受信息
			WX_Text wxtext = new WX_Text(message);
			if ("授权".equals(wxtext.getContent())) {
				String redirectUri = "https://d4393616.ngrok.io/weixin/index.jsp";
				String url = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.sq_getCodeURL),
						PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_PARAM_APPID), redirectUri,
						WeixinConstant.sq_scope_snsapi_userinfo);
				WX_OutText outText = new WX_OutText(wxtext);
				outText.setContent(url);
				WX_Util.print(outText.getReturnStr(), response);
			}
			break;
		case WeixinConstant.WX_MESSAGETYPE_IMAGE:// 图片
			WX_Image image = new WX_Image(message);
			System.out.println(image);
			// WX_OutImage outImage=new WX_OutImage(image);
			// outImage.setMediaId(image.getMediaId());
			// WX_Util.print(outImage.getReturnStr(), response);
			break;
		case WeixinConstant.WX_MESSAGETYPE_VOICE:// 语音
			WX_Voice voice = new WX_Voice(message);
			// 获取声音文件....
			System.out.println(voice);
			break;
		case WeixinConstant.WX_MESSAGETYPE_VIDEO:// 视频
			WX_Vidio vidio = new WX_Vidio(message);
			System.out.println(vidio);
			break;
		case WeixinConstant.WX_MESSAGETYPE_SHORTVIDEO:// 小视频
			WX_Shortvideo shortvidio = new WX_Shortvideo(message);
			System.out.println(shortvidio);
			break;
		case WeixinConstant.WX_MESSAGETYPE_LOCATION:// 地理位置
			WX_Location location = new WX_Location(message);
			System.out.println(location);
			break;
		case WeixinConstant.WX_MESSAGETYPE_LINK:// 链接消息
			WX_Link link = new WX_Link(message);
			System.out.println(link);
			break;
		case WeixinConstant.WX_MESSAGETYPE_EVENT:
			String event = WX_Util.getXMLCDATA(message, WeixinConstant.IN_COMM_Event);
			String eventKey = WX_Util.getXMLCDATA(message, WeixinConstant.IN_COMM_EventKey);
			System.out.println(message + " eventKey:" + eventKey);
			
			switch (event) {
			case WeixinConstant.EVENT_SUBSCRIBE:// 未关注的点击关注
				///
				if(StringUtils.isNotBlank(eventKey)&&eventKey.indexOf("_")!=-1){
					eventKey = eventKey.split("_")[1];// 这里的eventKey前面会加qrscene_
					WeiGuanZhuEV wgzSubscribe = new WeiGuanZhuEV(message);
					System.out.println("未关注的点击关注-----  "+WX_Util.getUserInfoByOpenID(wgzSubscribe.getFromUserName()));
					hospitalSV.wxSubscribe(eventKey,wgzSubscribe.getFromUserName());
				}
				///
				WX_Util.print("", response);
				break;
			case WeixinConstant.EVENT_SCAN:// 扫描关注事件
				WeiGuanZhuEV wgz_scan = new WeiGuanZhuEV(message);
				System.out.println("扫描关注事件-----  "+WX_Util.getUserInfoByOpenID(wgz_scan.getFromUserName()));
				String rs=hospitalSV.wxSubscribe(eventKey,wgz_scan.getFromUserName());
				//WX_Util.print("", response);
				 WX_OutText outText_scan = new WX_OutText(wgz_scan);
//				 outText_scan.setContent("您已经关注！" +
//				 wgz_scan.getFromUserName());
				 outText_scan.setContent("您已成功设置默认科室！您当前的默认科室为：" + rs);
				 
				 WX_Util.print(outText_scan.getReturnStr(), response);
				break;
			case WeixinConstant.EVENT_UNSUBSCRIBE:// 取消关注事件
				CancelGZEV unsub = new CancelGZEV(message);
				System.out.println("取消关注事件-----  "+WX_Util.getUserInfoByOpenID(unsub.getFromUserName()));
				//hospitalSV.wxUnSubscribe(unsub.getFromUserName());
				WX_Util.print("", response);
				break;
			case WeixinConstant.EVENT_CLICK:// 点击事件
				ClickEV clickEV = new ClickEV(message);
				System.out.println("点击事件-----  "+WX_Util.getUserInfoByOpenID(clickEV.getFromUserName()));
				Map<String,WxSucai> map=suCaiService.getMenuMap();
				HandlerClick.handlerClick(clickEV, response,map);
				break;
			default:
				System.out.println(message + "未知EVENT.......");
				WX_Util.print("", response);
				break;
			}
			break;
		default:
			System.out.println(message + " 未知消息类型........");
			WX_Util.print("", response);
			break;
		}

	}
}
