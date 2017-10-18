package com.weixin.handlermsg;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.sdey.api.po.WxSucai;
import com.weixin.constant.WeixinConstant;
import com.weixin.util.PropertiesUtil;
import com.weixin.util.WX_Util;
import com.weixin.vo.event.ClickEV;
import com.weixin.vo.out.WX_OutNews;
import com.weixin.vo.out.WX_OutNews_item;

public class HandlerClick {
	public static void handlerClick(ClickEV clickEV, HttpServletResponse response, Map<String, WxSucai> map)
			throws IOException {
		WX_OutNews out = null;
		String server = PropertiesUtil.weixinPropertiesVal(WeixinConstant.SERVER);
		StringBuilder imgurl = new StringBuilder(server);
		String wxUserId = clickEV.getFromUserName();
		WxSucai sucai = map.get(clickEV.getEventKey());
		if (sucai != null) {
			out = new WX_OutNews(clickEV);
			List<WX_OutNews_item> items = out.getItems();
			WX_OutNews_item item = new WX_OutNews_item();
			item.setTitle(sucai.getTitle());
			item.setDescription(sucai.getJianjie());
			StringBuilder url = new StringBuilder(sucai.getLinkurl());
			url.append("?weixinid=").append(wxUserId);
			item.setUrl(url.toString());
			
			item.setPicUrl(
					imgurl.append(sucai.getImgpath()).append("?t=").append(System.currentTimeMillis()).toString());
			items.add(item);			
			WX_Util.print(out.getReturnStr(), response);
		}
	}
}
