package com.weixin.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.Page;
import com.ldg.api.util.JsonUtil;
import com.sdey.api.po.WxSucai;
import com.sdey.api.service.SuCaiService;
import com.sdey.api.util.RequestFileUtil;
import com.sdey.api.vo.PageParam;
import com.weixin.constant.WeixinConstant;
import com.weixin.util.Access_token;
import com.weixin.util.HttpClientUtil;
import com.weixin.util.PropertiesUtil;
import com.weixin.util.WX_Util;
import com.weixin.vo.jstree.JsTree;
import com.weixin.vo.jstree.JsTreeData;
import com.weixin.vo.menu.Menu;
import com.weixin.vo.menu.MenuSubBt;
import com.weixin.vo.menu.type.ClickMenuBT;
import com.weixin.vo.menu.type.Location_selectMenuBT;
import com.weixin.vo.menu.type.Media_idMenuBT;
import com.weixin.vo.menu.type.Pic_photo_or_albumMenuBT;
import com.weixin.vo.menu.type.Pic_sysphotoMenuBT;
import com.weixin.vo.menu.type.Scancode_pushMenuBT;
import com.weixin.vo.menu.type.Scancode_waitmsgMenuBT;
import com.weixin.vo.menu.type.ViewMenuBT;
import com.weixin.vo.menu.type.pic_weixinMenuBT;
import com.weixin.vo.menu.type.view_limitedMenuBT;
import com.weixin.vo.wx.ReturnMSG;
import com.weixin.vo.wxmenu.WxButton;
import com.weixin.vo.wxmenu.WxButtons;
import com.weixin.vo.wxmenu.WxMenu;
import com.weixin.vo.wxmenu.WxSub_button;

@Controller
@RequestMapping(value = "/weixinConfig")
public class WXConfigController {
	@Autowired
	private SuCaiService suCaiService;

	@RequestMapping(value = "/testMap")
	public String testMap(HttpServletRequest request, HttpServletResponse response, Integer id, String cdid)
			throws IOException {
		Map<String,WxSucai> map=suCaiService.getMenuMap();
		System.out.println(map);
		return "/weixinConfig/getSuCaiList";
	}
	@RequestMapping(value = "/guanlianSCByID")
	public String guanlianSCByID(HttpServletRequest request, HttpServletResponse response, Integer id, String cdid)
			throws IOException {
		int updateCount = suCaiService.guanlianSCByID(id, cdid);
		WX_Util.getMenumap().clear();
		return "/weixinConfig/getSuCaiList";
	}

	@RequestMapping(value = "/delSCByID")
	public String delSCByID(HttpServletRequest request, HttpServletResponse response, Integer id, String imgpath)
			throws IOException {
		RequestFileUtil.delFile(request, imgpath);
		int i = suCaiService.delSCByID(id);
		return "/weixinConfig/getSuCaiList";
	}

	@RequestMapping(value = "/uploadSuCai")
	public String uploadSuCai(HttpServletRequest request, HttpServletResponse response, WxSucai sucai)
			throws IOException {
		suCaiService.saveSuCai(request,sucai);
		return "/weixinConfig/getSuCaiList";
	}

	/**
	 * 查询素材列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getSuCaiList")
	public String getSuCaiList(HttpServletRequest request, HttpServletResponse response, PageParam pageParam)
			throws IOException {
		Page<WxSucai> page = suCaiService.getSuCaiList(pageParam);
		request.setAttribute("page", page.toPageInfo());
		return "/houtaimanager/wxmenu/sucaiList.jsp";
	}

	/**
	 * 保存的微信按钮的信息
	 * 
	 * @param request
	 * @param response
	 * @param saveData
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/saveMenuData")
	public ReturnMSG saveMenuData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<JsTreeData> saveData) throws IOException {
		Menu mu = new Menu();
		saveData.forEach(item -> {
			List<JsTreeData> zhuMenu = item.getChildren();
			zhuMenu.forEach(zhuItem -> {
				String zhuName = zhuItem.getText();
				MenuSubBt zhuBT = new MenuSubBt();
				zhuBT.setName(zhuName);
				mu.getButton().add(zhuBT);// 添加主菜单
				//////////
				List<JsTreeData> ziMenu = zhuItem.getChildren();
				ziMenu.forEach(ziItem -> {
					String ziName = ziItem.getText();
					ClickMenuBT subBT = new ClickMenuBT();
					subBT.setName(ziName);
					subBT.setKey(ziName);
					zhuBT.getSub_button().add(subBT);
				});
			});
		});
		String createMenuBTUrl = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.createMenuBT),
				Access_token.getAccessToken());
		System.out.println( JsonUtil.parseToJson(mu));
		String rsStr = HttpClientUtil.getInstance().sendHttpPostJson(createMenuBTUrl, JsonUtil.parseToJson(mu));
		ReturnMSG msg = JsonUtil.getObjectByJSON(rsStr, ReturnMSG.class);
		return msg;
	}

	/**
	 * 跳转页面
	 * 
	 * @param pageUrl
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/jumpPage")
	public String jumpPage(String pageUrl) throws IOException {
		return pageUrl;
	}

	@RequestMapping(value = "/createCaiDanList")
	public String createCaiDanList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String createMenuBTUrl = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.createMenuBT),
				Access_token.getAccessToken());
		String rsStr = HttpClientUtil.getInstance().sendHttpPostJson(createMenuBTUrl, JsonUtil.parseToJson(getMenu3()));
		System.out.println(rsStr);
		return "";
	}

	/**
	 * 获取微信菜单数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/getCaiDanList")
	public List<JsTree> getCaiDanList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String getMenuBTUrl = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.getMunuBT),
				Access_token.getAccessToken());
		String rsStr = HttpClientUtil.getInstance().sendHttpGet(getMenuBTUrl);
		System.out.println(rsStr+"----------------------");
		WxMenu menu = JsonUtil.getObjectByJSON(rsStr, WxMenu.class);
		System.out.println(menu+"+++++++++++++++++++");
		return getMenu(menu);
	}

	private static List<JsTree> getMenu(WxMenu menu) {
		List<JsTree> list = new ArrayList<>();
		JsTree jsRoot = new JsTree();
		jsRoot.setId("xxx");
		jsRoot.setParent("#");
		jsRoot.setText("微信菜单维护");
		jsRoot.getLi_attr().setLevel(1);
		jsRoot.getState().setOpened(true);
		list.add(jsRoot);
		/////////////////////////////
		WxButtons button = menu.getMenu();
		List<WxButton> bts = button.getButton();
		bts.stream().forEach(item -> {
			String name = item.getName();
			JsTree zhuBT = new JsTree();
			zhuBT.setId(name);
			zhuBT.setParent("xxx");
			zhuBT.setText(name);
			zhuBT.getLi_attr().setLevel(jsRoot.getLi_attr().getLevel() + 1);
			zhuBT.getState().setOpened(true);
			list.add(zhuBT);
			List<WxSub_button> subBts = item.getSub_button();
			subBts.forEach(subitem -> {
				String ziname = subitem.getName();
				JsTree ziBT = new JsTree();
				ziBT.setId(ziname);
				ziBT.setParent(zhuBT.getId());
				ziBT.setText(ziname);
				ziBT.getLi_attr().setLevel(zhuBT.getLi_attr().getLevel() + 1);
				list.add(ziBT);
			});
		});
		return list;
	}

	private static Menu getMenu3() {
		Menu mu = new Menu();
		/////
		MenuSubBt musub = new MenuSubBt();
		musub.setName("就诊信息");
		ClickMenuBT cl1 = new ClickMenuBT();
		cl1.setName("科室介绍");
		cl1.setKey("ksjs");
		ClickMenuBT cl2 = new ClickMenuBT();
		cl2.setName("专家介绍");
		cl2.setKey("zjjs");
		ClickMenuBT cl3 = new ClickMenuBT();
		cl3.setName("新闻动态");
		cl3.setKey("xwdt");
		musub.getSub_button().add(cl1);
		musub.getSub_button().add(cl2);
		musub.getSub_button().add(cl3);
		mu.getButton().add(musub);
		///
		/////
		MenuSubBt musub2 = new MenuSubBt();
		musub2.setName("就医指南");
		ClickMenuBT cl21 = new ClickMenuBT();
		cl21.setName("预约流程");
		cl21.setKey("yylc");
		ClickMenuBT cl22 = new ClickMenuBT();
		cl22.setName("就医流程");
		cl22.setKey("jzlc");
		ClickMenuBT cl23 = new ClickMenuBT();
		cl23.setName("科室分布");
		cl23.setKey("ksfb");
		ClickMenuBT cl24 = new ClickMenuBT();
		cl24.setName("医保政策");
		cl24.setKey("ybzc");
		ClickMenuBT cl25 = new ClickMenuBT();
		cl25.setName("地址查询");
		cl25.setKey("dzcx");
		musub2.getSub_button().add(cl21);
		musub2.getSub_button().add(cl22);
		musub2.getSub_button().add(cl23);
		// musub2.getSub_button().add(cl24);
		musub2.getSub_button().add(cl25);
		mu.getButton().add(musub2);
		///

		/////
		MenuSubBt musub3 = new MenuSubBt();
		musub3.setName("更多");
		ClickMenuBT cl31 = new ClickMenuBT();
		cl31.setName("我的关注");
		cl31.setKey("wdgz");
		ClickMenuBT cl32 = new ClickMenuBT();
		cl32.setName("官方微博");
		cl32.setKey("gfwb");
		ClickMenuBT cl33 = new ClickMenuBT();
		cl33.setName("招聘信息");
		cl33.setKey("zpxx");
		ClickMenuBT cl34 = new ClickMenuBT();
		cl34.setName("微官网");
		cl34.setKey("sdeywgw");

		ClickMenuBT cl35 = new ClickMenuBT();
		cl35.setName("测试");
		cl35.setKey("ceshi");

		musub3.getSub_button().add(cl31);
		musub3.getSub_button().add(cl32);
		musub3.getSub_button().add(cl33);
		musub3.getSub_button().add(cl34);
		// musub3.getSub_button().add(cl35);
		mu.getButton().add(musub3);
		///
		return mu;
	}

	private static Menu getMenu() {
		Menu mu = new Menu();
		ClickMenuBT cl1 = new ClickMenuBT();
		cl1.setName("今日歌曲");
		cl1.setKey("V1001_TODAY_MUSIC");
		mu.getButton().add(cl1);
		/////
		MenuSubBt musub = new MenuSubBt();
		musub.setName("菜单");
		ViewMenuBT subbt1 = new ViewMenuBT();
		subbt1.setName("搜索");
		subbt1.setUrl("http://www.soso.com/");
		ViewMenuBT subbt2 = new ViewMenuBT();
		subbt2.setName("视频");
		subbt2.setUrl("http://v.qq.com/");
		ClickMenuBT subbt3 = new ClickMenuBT();
		subbt3.setName("赞一下我们");
		subbt3.setKey("V1001_GOOD");
		musub.getSub_button().add(subbt1);
		musub.getSub_button().add(subbt2);
		musub.getSub_button().add(subbt3);
		///
		mu.getButton().add(musub);
		return mu;
	}

	private static Menu getMenu2() {
		Menu mu = new Menu();
		/////
		MenuSubBt musub = new MenuSubBt();
		musub.setName("扫码");
		Scancode_waitmsgMenuBT subbt1 = new Scancode_waitmsgMenuBT();
		subbt1.setName("扫码带提示");
		subbt1.setKey("rselfmenu_0_0");
		Scancode_pushMenuBT subbt2 = new Scancode_pushMenuBT();
		subbt2.setName("扫码推事件");
		subbt2.setKey("rselfmenu_0_1");
		musub.getSub_button().add(subbt1);
		musub.getSub_button().add(subbt2);
		mu.getButton().add(musub);
		///
		///
		MenuSubBt musub2 = new MenuSubBt();
		musub2.setName("发图");
		Pic_sysphotoMenuBT pic1 = new Pic_sysphotoMenuBT();
		pic1.setName("系统拍照发图");
		pic1.setKey("rselfmenu_1_0");
		Pic_photo_or_albumMenuBT pic2 = new Pic_photo_or_albumMenuBT();
		pic2.setName("拍照或者相册发图");
		pic2.setKey("rselfmenu_1_1");
		pic_weixinMenuBT pic3 = new pic_weixinMenuBT();
		pic3.setName("微信相册发图");
		pic3.setKey("rselfmenu_1_2");
		musub2.getSub_button().add(pic1);
		musub2.getSub_button().add(pic2);
		musub2.getSub_button().add(pic3);
		mu.getButton().add(musub2);
		///
		Location_selectMenuBT loc = new Location_selectMenuBT();
		loc.setName("发送位置");
		loc.setKey("rselfmenu_2_0");
		mu.getButton().add(loc);
		////
		Media_idMenuBT med = new Media_idMenuBT();
		med.setName("图片");
		med.setMedia_id("MEDIA_ID1");
		// mu.getButton().add(med);
		////
		view_limitedMenuBT vie = new view_limitedMenuBT();
		vie.setName("图文消息");
		vie.setMedia_id("MEDIA_ID2");
		// mu.getButton().add(vie);
		return mu;
	}

	public static void main(String[] args) throws JsonProcessingException {
		System.out.println(JsonUtil.parseToJson(getMenu()));
		System.out.println(JsonUtil.parseToJson(getMenu2()));
	}
}
