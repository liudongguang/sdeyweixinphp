package com.weixin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.Main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldg.api.vo.ResultMsg;
import com.weixin.constant.WeixinConstant;
import com.weixin.jssdk.Sign;
import com.weixin.util.Access_token;
import com.weixin.util.HttpClientUtil;
import com.weixin.util.JSSDKTicket;
import com.weixin.util.PropertiesUtil;
import com.weixin.vo.ResponseStream;

@Controller
@RequestMapping(value = "/jssdk")
public class WXJSSDKController {
	@RequestMapping(value = "/getJsapiTicket")
	public @ResponseBody Map<String, String> getJsapiTicket(String url) throws IOException {
		String ticket = JSSDKTicket.getWxticket();
		Map<String, String> ret = Sign.sign(ticket, url);
		ret.put("appId", PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_PARAM_APPID));
		return ret;
	}

	/**
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getLuYinByServerId")
	public @ResponseBody ResultMsg getLuYinByServerId(String serverId,HttpServletRequest request) throws IOException {
		ResultMsg rs = new ResultMsg();
		String getDMTUrl = PropertiesUtil.weixinPropertiesVal(WeixinConstant.file_getDuoMeiTiURL);
		String acctoken = Access_token.getAccessToken();
		getDMTUrl = MessageFormat.format(getDMTUrl, acctoken, serverId);
		ResponseStream responseStream = HttpClientUtil.getInstance().sendHttpGetForInputStream(getDMTUrl);
		switch (responseStream.getContentType()) {
		case WeixinConstant.MEDIA_TYPE_audio_amr:
			String serverRealPath=request.getServletContext().getRealPath("luyin");
			File severFileMdr=new File(serverRealPath);
			if(!severFileMdr.exists()){
				severFileMdr.mkdirs();
			}
			StringBuilder saveFile=new StringBuilder(serverRealPath);
			StringBuilder fileName=new StringBuilder(UUID.randomUUID().toString());
			fileName.append(".amr");
			saveFile.append("/").append(fileName);
			 InputStream ins=responseStream.getIn();
			 File file=new File(saveFile.toString());
			 FileOutputStream fos=new FileOutputStream(file);
			 IOUtils.copy(ins, fos);
			 IOUtils.closeQuietly(fos);
			 rs.setData(fileName.toString());
			break;
		default:
			break;
		}
		return rs;
	}
	public static void main(String[] args) throws Exception {
		 File file=new File("d:/省立医院.PNG");
		 FileInputStream ins=new FileInputStream(file);
		 System.out.println(ins.available());
		 File file2=new File("d:/d.png");
		 if(!file2.exists()){
			 file2.createNewFile();
		 }
		 FileOutputStream fos=new FileOutputStream(file2);
		 IOUtils.copy(ins, fos);
		 IOUtils.closeQuietly(ins);
		 IOUtils.closeQuietly(fos);
	}
}
