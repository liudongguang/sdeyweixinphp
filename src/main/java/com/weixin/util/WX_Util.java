package com.weixin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ldg.api.util.JsonUtil;
import com.sdey.api.po.WxSucai;
import com.weixin.constant.WeixinConstant;
import com.weixin.vo.ValidateMSG;
import com.weixin.vo.wxhandlermsg.SuCai;

public class WX_Util {
	private static final ConcurrentHashMap<String,WxSucai> menuMap=new ConcurrentHashMap<>();
	
	
	public static ConcurrentHashMap<String, WxSucai> getMenumap() {
		return menuMap;
	}

	public static String validate(ValidateMSG validateMSG) {
		String token = PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_PARAM_TOKEN);
		String signature = validateMSG.getSignature();
		if (signature != null) {
			String[] arrTemp = { token, validateMSG.getTimestamp(), validateMSG.getNonce() };
			Arrays.sort(arrTemp);
			StringBuilder sb = new StringBuilder();
			for (String str : arrTemp) {
				sb.append(str);
			}
			try {
				MessageDigest md = MessageDigest.getInstance(WeixinConstant.SHA1);
				byte[] bytes = md.digest(sb.toString().getBytes());
				StringBuilder sb2 = new StringBuilder();
				for (int i = 0; i < bytes.length; i++) {
					if (((int) bytes[i] & 0xff) < 0x10) {
						sb2.append("0");
					}
					sb2.append(Long.toString((int) bytes[i] & 0xff, 16));
				}
				if (signature.equals(sb2.toString())) {
					return validateMSG.getEchostr();
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * 从request得到报文
	 * 
	 * @param request
	 * @return
	 */
	public static String getStrInputStream(HttpServletRequest request) {
		InputStreamReader reader = null;
		BufferedReader breader = null;
		StringBuilder strb = new StringBuilder();
		try {
			reader = new InputStreamReader(request.getInputStream(), WeixinConstant.WX_UTF8);
			breader = new BufferedReader(reader);
			String str = null;
			while (null != (str = breader.readLine())) {
				strb.append(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != breader) {
				try {
					breader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return strb.toString();
	}

	public static String getXMLCDATA(String reqeustStr, String tagName) {
		boolean needCDATAFlag = true;
		if (WeixinConstant.NOTNEED_CDATA_1.equals(tagName) || WeixinConstant.NOTNEED_CDATA_2.equals(tagName)
				|| WeixinConstant.NOTNEED_CDATA_3.equals(tagName) || WeixinConstant.NOTNEED_CDATA_4.equals(tagName)
				|| WeixinConstant.NOTNEED_CDATA_5.equals(tagName)) {
			needCDATAFlag = false;// 不需要cdata
		}
		// 开始标签
		StringBuilder beginTageName = new StringBuilder("<");
		// 结束标签
		StringBuilder endTagName = new StringBuilder();
		beginTageName.append(tagName);
		if (needCDATAFlag) {
			beginTageName.append("><![CDATA[");
			endTagName.append("]]></");
		} else {
			beginTageName.append(">");
			endTagName.append("</");
		}
		endTagName.append(tagName).append(">");
		int beginIndex = reqeustStr.indexOf(beginTageName.toString()) + beginTageName.length();
		int endIndex = reqeustStr.indexOf(endTagName.toString());
		String rtStr = reqeustStr.substring(beginIndex, endIndex);
		return rtStr;
	}

	// out输出
	public static void print(String source, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		// response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(source);
		out.flush();
		out.close();
	}

	public static String getSuCai() throws JsonProcessingException {
		String url = PropertiesUtil.weixinPropertiesVal("getSuCai");
		HttpClientUtil htc = HttpClientUtil.getInstance();
		SuCai sc = new SuCai();
		sc.setType("image");
		sc.setOffset(0);
		sc.setCount(20);
		String rtStr = htc.sendHttpPostJson(url, JsonUtil.parseToJson(sc));
		System.out.println(rtStr);
		return rtStr;
	}

	public static String getUserInfoByOpenID(String openid) {
		String createMenuBTUrl = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.getUserInfoByOpenId),
				Access_token.getAccessToken(),openid);
		String rsStr = HttpClientUtil.getInstance().sendHttpPost(createMenuBTUrl);
		return rsStr;
	}

	public static void main(String[] args) throws JsonProcessingException {
		getSuCai();
	}
}
