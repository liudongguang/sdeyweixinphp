package com.sdey.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.ldg.api.vo.ResultMsg;
import com.sdey.api.po.WxKeshi;
import com.sdey.api.po.WxManager;
import com.sdey.api.po.WxNews;
import com.sdey.api.po.WxYisheng;
import com.sdey.api.service.HospitalService;
import com.sdey.api.vo.PageParam;
import com.sdey.api.vo.Wx_ysxq;
import com.sdey.api.vo.Wxpage_ksjs_gz;
import com.weixin.vo.SQ_UserInfo;

@Controller
@RequestMapping(value = "/wxpage")
public class WxPageController {
	@Autowired
	private HospitalService hospitalSv;

	/**
	 * 根据id返回科室详情
	 * 
	 * @param request
	 * @param ksid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getksjsbyID")
	public String getksjsbyID(HttpServletRequest request, Integer ksid) throws IOException {
		WxKeshi obj = hospitalSv.getKeshiByID(ksid);
		request.setAttribute("obj", obj);
		return "/weixinqianduan/ksjs_content.jsp";
	}

	@RequestMapping(value = "/ksjs")
	public String ksjs(HttpServletRequest request) throws IOException {
		SQ_UserInfo user = (SQ_UserInfo) request.getSession().getAttribute("wxuser");
		String openid = user.getOpenid();
		Wxpage_ksjs_gz ksjsgz = hospitalSv.getGuanZhuID(openid);// 获取关注的科室id
		String page = "/weixinqianduan/ksjs_content.jsp";
		if (ksjsgz != null) {
			WxKeshi obj = hospitalSv.getKeshiByID(ksjsgz.getOfficeid());
			request.setAttribute("obj", obj);
		} else {
			// 获取收藏的医院
			Integer hosID = hospitalSv.getShouchangHospitalID(openid);
			// 获取科室列表
			WxManager wxman = new WxManager();
			wxman.setHospitalid(hosID);
			Page<WxKeshi> rspage = hospitalSv.getKeshiList(null, wxman);
			request.setAttribute("obj", pinyinksMap(rspage));
			page = "/weixinqianduan/ksjs_hosList.jsp";
		}
		return page;
	}

	private Map<String, List<WxKeshi>> pinyinksMap(Page<WxKeshi> rspage) {
		rspage.sort(new Comparator<WxKeshi>() {
			@Override
			public int compare(WxKeshi o1, WxKeshi o2) {
				String s1 = o1.getPinyin();
				String s2 = o2.getPinyin();
				if (StringUtils.isNotBlank(s1) && StringUtils.isNotBlank(s2)) {
					char c1 = s1.charAt(0);
					char c2 = s2.charAt(0);
					o1.setPinyin(String.valueOf(c1));
					o2.setPinyin(String.valueOf(c2));
					int i1 = c1;
					int i2 = c2;
					return i1 - i2;
				}
				return 0;
			}
		});

		Map<String, List<WxKeshi>> rsMap = new LinkedHashMap<>();
		for (WxKeshi ks : rspage.getResult()) {
			String pyzm = ks.getPinyin().substring(0,1).toUpperCase();
			ks.setPinyin(pyzm);
			List<WxKeshi> list = rsMap.get(pyzm);
			if (list == null) {
				list = new ArrayList<>();
				rsMap.put(pyzm, list);
				list.add(ks);
			} else {
				list.add(ks);
			}
		}
		return rsMap;
	}

	/**
	 * 专家介绍------------------------------------------------------------------------------
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/zjjs")
	public String zjjs(HttpServletRequest request) throws IOException {
		SQ_UserInfo user = (SQ_UserInfo) request.getSession().getAttribute("wxuser");
		String openid = user.getOpenid();
		// String openid = "oQFQlwqkl6oBO7kiqKWTEYQT8ktQ";
		Wxpage_ksjs_gz ksjsgz = hospitalSv.getGuanZhuID(openid);// 获取关注的科室id
		String page = "/weixinqianduan/zjjs_ysList.jsp";
		if (ksjsgz != null) {
			List<WxYisheng> ysList = hospitalSv.getYSListByksid(ksjsgz.getOfficeid());
			WxKeshi ks = hospitalSv.getKeshiByID(ksjsgz.getOfficeid());
			request.setAttribute("ksName", ks.getName());
			request.setAttribute("obj", pinyinysMap(ysList));
		} else {
			// 获取收藏的医院
			Integer hosID = hospitalSv.getShouchangHospitalID(openid);
			// 获取科室列表
			WxManager wxman = new WxManager();
			wxman.setHospitalid(hosID);
			Page<WxKeshi> rspage = hospitalSv.getKeshiList(null, wxman);
			request.setAttribute("obj", pinyinksMap(rspage));
			page = "/weixinqianduan/zjjs_ksList.jsp";
		}
		return page;
	}

	private Map<String, List<WxYisheng>> pinyinysMap(List<WxYisheng> ysList) {
		ysList.sort(new Comparator<WxYisheng>() {
			@Override
			public int compare(WxYisheng o1, WxYisheng o2) {
				String s1 = o1.getPinyin();
				String s2 = o2.getPinyin();
				if (StringUtils.isNotBlank(s1) && StringUtils.isNotBlank(s2)) {
					char c1 = s1.charAt(0);
					char c2 = s2.charAt(0);
					o1.setPinyin(String.valueOf(c1));
					o2.setPinyin(String.valueOf(c2));
					int i1 = c1;
					int i2 = c2;
					return i1 - i2;
				}
				return 0;
			}
		});
		Map<String, List<WxYisheng>> rsMap = new LinkedHashMap<>();
		for (WxYisheng ks : ysList) {
			String pyzm = ks.getPinyin().substring(0,1).toUpperCase();
			List<WxYisheng> list = rsMap.get(pyzm);
			if (list == null) {
				list = new ArrayList<>();
				rsMap.put(pyzm, list);
				list.add(ks);
			} else {
				list.add(ks);
			}
		}
		return rsMap;
	}

	/**
	 * 根据id返回科室中的医生列表
	 * 
	 * @param request
	 * @param ksid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getysListbyKSID")
	public String getysListbyKSID(HttpServletRequest request, Integer ksid, String ksName) throws IOException {
		List<WxYisheng> ysList = hospitalSv.getYSListByksid(ksid);
		request.setAttribute("ksName", ksName);
		request.setAttribute("obj", pinyinysMap(ysList));
		return "/weixinqianduan/zjjs_ysList.jsp";
	}

	/**
	 * 获取医生详情
	 * 
	 * @param request
	 * @param ysid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getysxqbyYSID")
	public String getysxqbyYSID(HttpServletRequest request, Integer ysid) throws IOException {
		Wx_ysxq ysxq = hospitalSv.selectysxqByYSID(ysid);
		request.setAttribute("obj", ysxq);
		return "/weixinqianduan/zjjs_content.jsp";
	}

	/**
	 * 科室列表为医生支持
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/zjjsKSList")
	public String zjjsKSList(HttpServletRequest request) throws IOException {
		SQ_UserInfo user = (SQ_UserInfo) request.getSession().getAttribute("wxuser");
		String openid = user.getOpenid();
		// 获取收藏科室关联的医院id
		Integer hosID = hospitalSv.getShouchangKSID(openid);
		// 获取科室列表
		WxManager wxman = new WxManager();
		wxman.setHospitalid(hosID);
		Page<WxKeshi> rspage = hospitalSv.getKeshiList(null, wxman);
		System.out.println(rspage);
		request.setAttribute("obj", pinyinksMap(rspage));
		return "/weixinqianduan/zjjs_ksList.jsp";
	}

	// 新闻动态----------------------------------------------------------------------
	@RequestMapping(value = "/xwdt")
	public String xwdt(HttpServletRequest request, PageParam pageParam) throws IOException {
		SQ_UserInfo user = (SQ_UserInfo) request.getSession().getAttribute("wxuser");
		String openid = user.getOpenid();
		// System.out.println("xwdt "+openid);
		//String openid = "oQFQlwqkl6oBO7kiqKWTEYQT8ktQ";
		Wxpage_ksjs_gz ksjsgz = hospitalSv.getGuanZhuID(openid);// 获取关注的科室id
		String page = "/weixinqianduan/xwdt_newsList.jsp";
		if (ksjsgz != null) {
			Page<WxNews> newsList = hospitalSv.getKsNewsList(pageParam, ksjsgz.getOfficeid());
			// WxKeshi ks = hospitalSv.getKeshiByID(ksjsgz.getOfficeid());
			// request.setAttribute("ksName", ks.getName());
			request.setAttribute("obj", newsList.toPageInfo());
			request.setAttribute("ksid", ksjsgz.getOfficeid());
		} else {
			// 获取收藏的医院
			Integer hosID = hospitalSv.getShouchangHospitalID(openid);
			// 获取科室列表
			WxManager wxman = new WxManager();
			wxman.setHospitalid(hosID);
			Page<WxKeshi> rspage = hospitalSv.getKeshiList(null, wxman);
			request.setAttribute("obj", pinyinksMap(rspage));
			page = "/weixinqianduan/xwdt_ksList.jsp";
		}
		return page;
	}

	@ResponseBody
	@RequestMapping(value = "/getXwdtPageData")
	public ResultMsg getXwdtPageData(HttpServletRequest request, PageParam pageParam, Integer ksofficeid)
			throws IOException {
		ResultMsg msg = new ResultMsg();
		Page<WxNews> pageDate = hospitalSv.getKsNewsList(pageParam, ksofficeid);
		msg.setData(pageDate.toPageInfo());
		return msg;
	}

	/**
	 * 根据xwdtid获取新闻详细信息
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getXwdtByID")
	public String getXwdtByID(HttpServletRequest request, Integer id) throws IOException {
		WxNews news = hospitalSv.getKSNewsByID(id);
		request.setAttribute("obj", news);
		return "/weixinqianduan/xwdt_content.jsp";
	}

	/**
	 * 获取科室下的新闻列表
	 * 
	 * @param request
	 * @param ksid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getXwdtListbyKSID")
	public String getXwdtListbyKSID(HttpServletRequest request, Integer ksid) throws IOException {
		List<WxNews> newsList = hospitalSv.getNewsListByksid(ksid);
		request.setAttribute("obj", newsList);
		return "/weixinqianduan/xwdt_newsList.jsp";
	}

}
