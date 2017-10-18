package com.sdey.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.Page;
import com.ldg.api.util.JsonUtil;
import com.ldg.api.vo.ResultMsg;
import com.sdey.api.constant.SysConstant;
import com.sdey.api.po.WxHospital;
import com.sdey.api.po.WxKeshi;
import com.sdey.api.po.WxManager;
import com.sdey.api.po.WxNews;
import com.sdey.api.po.WxYisheng;
import com.sdey.api.service.HospitalService;
import com.sdey.api.util.PinyinTool;
import com.sdey.api.util.RequestFileUtil;
import com.sdey.api.vo.GetKeshiManagerListVo;
import com.sdey.api.vo.KeShi_HospitalManager;
import com.sdey.api.vo.PageParam;
import com.sdey.api.vo.Yisheng_HospitalManger;
import com.weixin.constant.WeixinConstant;
import com.weixin.util.Access_token;
import com.weixin.util.HttpClientUtil;
import com.weixin.util.PropertiesUtil;
import com.weixin.vo.ewm.ActionInfo;
import com.weixin.vo.ewm.GetTicketParam;
import com.weixin.vo.ewm.RsTicket;

@Controller
@RequestMapping(value = "/hospitalmanager")
public class HospitalController {
	@Autowired
	private HospitalService hospitalSv;

	/**
	 * 获取医院列表
	 */
	@RequestMapping(value = "/getKeshiList")
	public String getKeshiList(HttpServletRequest request, PageParam pageParam) throws IOException {
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		Page<WxKeshi> page = hospitalSv.getKeshiList(pageParam, wxman);
		request.setAttribute("page", page.toPageInfo());
		return "/houtaimanager/keshi/disList.jsp";
	}

	/**
	 * 获取这个医院所有的科室
	 * 
	 * @param request
	 * @param pageParam
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getKeshiListNoPage")
	public @ResponseBody ResultMsg getKeshiListNoPage(HttpServletRequest request, PageParam pageParam)
			throws IOException {
		ResultMsg msg = new ResultMsg();
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		Page<WxKeshi> page = hospitalSv.getKeshiList(null, wxman);
		msg.setData(page.toPageInfo());
		return msg;
	}

	/**
	 * 保存科室
	 */
	@RequestMapping(value = "/addKSInfo")
	public @ResponseBody ResultMsg addKSInfo(WxKeshi keshi, HttpServletRequest request) throws IOException {
		ResultMsg msg = new ResultMsg();
		List<MultipartFile> files = RequestFileUtil.getUploadFile(request);
		String fileName = RequestFileUtil.saveToComputer(files, request, "ksphone");
		keshi.setPhoto(fileName);
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		int insertC = 0;
		if (keshi.getId() == null) {
			keshi.setCzyid(wxman.getId());
			keshi.setHospitalid(wxman.getHospitalid());
			keshi.setCreatetime(new Date());
			keshi.setPinyin(PinyinTool.getPinYin(keshi.getName()));
			insertC = hospitalSv.addHospitalKS(keshi);
		} else {
			insertC = hospitalSv.updateHospitalKS(keshi);
		}
		msg.setData(insertC);
		return msg;
	}

	/**
	 * 获取科室信息通过id
	 */
	@RequestMapping(value = "/getKeshiByID")
	public String getKeshiByID(HttpServletRequest request, Integer id, Integer type) throws IOException {
		WxKeshi obj = hospitalSv.getKeshiByID(id);
		request.setAttribute("obj", obj);
		// 有类型的时候表示进入的是科室简介页面
		if (type != null) {
			return "/houtaimanager/keshi/ksjs.jsp";
		}
		return "/houtaimanager/keshi/addks.jsp";
	}

	/**
	 * 删除科室及其关联信息
	 */
	@RequestMapping(value = "/delKeshiByID")
	public String delKeshiByID(HttpServletRequest request, Integer id) throws IOException {
		int delCount = hospitalSv.delKeshiAndThisManagerByID(id);
		request.setAttribute("obj", delCount);
		return "/hospitalmanager/getKeshiList";
	}

	/**
	 * 获取科室管理员列表
	 */
	@RequestMapping(value = "/getKeshiManagerList")
	public String getKeshiManagerList(HttpServletRequest request, PageParam pageParam, GetKeshiManagerListVo glv)
			throws IOException {
		Page<WxManager> page = hospitalSv.getKeshiManagerList(pageParam, glv.getKeshiID());
		request.setAttribute("page", page.toPageInfo());
		return "/houtaimanager/keshi/ksmanagerdisList.jsp";
	}

	/**
	 * 保存科室管理员
	 */
	@RequestMapping(value = "/addKSInfoManager")
	public @ResponseBody ResultMsg addKSInfoManager(WxManager keshiManager, HttpServletRequest request)
			throws IOException {
		ResultMsg msg = new ResultMsg();
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		keshiManager.setHospitalid(wxman.getHospitalid());
		keshiManager.setCreatetime(new Date());
		keshiManager.setQuanxian(SysConstant.QX_KESHI);
		int insertC = 0;
		if (keshiManager.getId() != null) {
			insertC = hospitalSv.updateKSInfoManager(keshiManager);
		} else {
			insertC = hospitalSv.addKSInfoManager(keshiManager);
		}
		msg.setData(insertC);
		return msg;
	}

	/**
	 * 获取科室管理员信息
	 */
	@RequestMapping(value = "/getKSManagerByID")
	public String getKSManagerByID(HttpServletRequest request, Integer id) throws IOException {
		WxManager obj = hospitalSv.getKSManagerByID(id);
		request.setAttribute("obj", obj);
		return "/houtaimanager/keshi/addksnanager.jsp";
	}

	/**
	 * 删除科室管理员信息
	 */
	@RequestMapping(value = "/delKeshiManagerByID")
	public String delKeshiManagerByID(HttpServletRequest request, Integer id, Integer ksID) throws IOException {
		int delCount = hospitalSv.delKeshiManagerByID(id);
		request.setAttribute("obj", delCount);
		return "/hospitalmanager/getKeshiManagerList?keshiID=" + ksID;
	}

	// --------------------------------------------------------------
	/**
	 * 获取医生列表
	 */
	@RequestMapping(value = "/getDoctorList")
	public String getDoctorList(HttpServletRequest request, PageParam pageParam) throws IOException {
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		Page<WxYisheng> page = hospitalSv.getDoctorList(pageParam, wxman);
		request.setAttribute("page", page.toPageInfo());
		return "/houtaimanager/yisheng/disYSList.jsp";
	}

	/**
	 * 保存医生
	 */
	@RequestMapping(value = "/addDoctor")
	public @ResponseBody ResultMsg addDoctor(WxYisheng ys, HttpServletRequest request) throws IOException {
		ResultMsg msg = new ResultMsg();
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		if (wxman.getQuanxian() == SysConstant.QX_KESHI) {// 使用管理员所在科室的id
			ys.setSsksid(wxman.getKsofficeid());
		}
		List<MultipartFile> files = RequestFileUtil.getUploadFile(request);
		String fileName = RequestFileUtil.saveToComputer(files, request, "ysHeadimg");
		ys.setHeadimg(fileName);
		int insertC = 0;
		if (ys.getId() == null) {
			ys.setCzyid(wxman.getId());
			ys.setHospitalid(wxman.getHospitalid());
			ys.setCzyid(wxman.getId());
			ys.setHospitalid(wxman.getHospitalid());
			ys.setCreatetime(new Date());
			ys.setPinyin(PinyinTool.getPinYin(ys.getName()));
			insertC = hospitalSv.addDoctor(ys);
		} else {
			insertC = hospitalSv.updateDoctor(ys);
		}
		msg.setData(insertC);
		return msg;
	}

	/**
	 * 获取单个医生
	 */
	@RequestMapping(value = "/getDoctorByID")
	public String getDoctorByID(HttpServletRequest request, Integer id) throws IOException {
		WxYisheng obj = hospitalSv.getDoctorByIDByID(id);
		request.setAttribute("obj", obj);
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		//// 医院管理员跳转
		if (wxman.getQuanxian() == SysConstant.QX_HOSPITAL) {
			return "/houtaimanager/hospitalmanager/yisheng/addys.jsp";
		} else if (wxman.getQuanxian() == SysConstant.QX_KESHI) { // 科室管理员跳转页面
			return "/houtaimanager/yisheng/addys.jsp";
		}
		return "/houtaimanager/yisheng/addys.jsp";
	}

	/**
	 * 删除单个医生
	 */
	@RequestMapping(value = "/delDoctorByID")
	public String delDoctorByID(HttpServletRequest request, Integer id) throws IOException {
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		int delCount = hospitalSv.delDoctorByIDByID(id);
		request.setAttribute("obj", delCount);
		//// 医院管理员跳转
		if (wxman.getQuanxian() == SysConstant.QX_HOSPITAL) {
			return "/hospitalmanager/getDoctorListForHospitalManager";
		} else if (wxman.getQuanxian() == SysConstant.QX_KESHI) { // 科室管理员跳转页面
			return "/hospitalmanager/getDoctorList";
		}
		return "/hospitalmanager/getDoctorList";
	}

	// -------------------------------------------
	/**
	 * 获取科室新闻列表
	 */
	@RequestMapping(value = "/getKsNewsList")
	public String getKsNewsList(HttpServletRequest request, PageParam pageParam) throws IOException {
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		Page<WxNews> page = hospitalSv.getKsNewsList(pageParam, wxman);
		request.setAttribute("page", page.toPageInfo());
		return "/houtaimanager/ksnews/disList.jsp";
	}

	/**
	 * 增加科室新闻
	 * 
	 * @param news
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addKsNews")
	public @ResponseBody ResultMsg addKsNews(WxNews news, HttpServletRequest request) throws IOException {
		ResultMsg msg = new ResultMsg();
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		if (wxman.getQuanxian() == SysConstant.QX_KESHI) {// 使用管理员所在科室的id
			news.setKsid(wxman.getKsofficeid());
		}
		int insertC = 0;
		if (news.getId() == null) {
			news.setCzyid(wxman.getId());
			news.setHospitalid(wxman.getHospitalid());
			news.setCzyid(wxman.getId());
			news.setHospitalid(wxman.getHospitalid());
			news.setCreatetime(new Date());
			insertC = hospitalSv.addKsNews(news);
		} else {
			insertC = hospitalSv.updateKsNews(news);
		}
		msg.setData(insertC);
		return msg;
	}

	/**
	 * 获取单条科室新闻
	 */
	@RequestMapping(value = "/getKSNewsByID")
	public String getKSNewsByID(HttpServletRequest request, Integer id) throws IOException {
		WxNews obj = hospitalSv.getKSNewsByID(id);
		request.setAttribute("obj", obj);
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		if (wxman.getQuanxian() == SysConstant.QX_HOSPITAL) {
			return "/houtaimanager/hospitalmanager/ksnews/add.jsp";
		}
		return "/houtaimanager/ksnews/add.jsp";
	}

	/**
	 * 删除单条新闻
	 */
	@RequestMapping(value = "/delKSNewsByID")
	public String delKSNewsByID(HttpServletRequest request, Integer id) throws IOException {
		int delCount = hospitalSv.delKSNewsByID(id);
		request.setAttribute("obj", delCount);
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		if (wxman.getQuanxian() == SysConstant.QX_HOSPITAL) {
			return "/hospitalmanager/getKsNewsListForHospitalManager";
		}
		return "/hospitalmanager/getKsNewsList";
	}

	//////
	/**
	 * 获取医生列表----医院管理员
	 */
	@RequestMapping(value = "/getDoctorListForHospitalManager")
	public String getDoctorListForHospitalManager(HttpServletRequest request, PageParam pageParam) throws IOException {
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		Page<Yisheng_HospitalManger> page = hospitalSv.getDoctorListForHospitalManager(pageParam, wxman);
		request.setAttribute("page", page.toPageInfo());
		return "/houtaimanager/hospitalmanager/yisheng/disYSList.jsp";
	}

	/**
	 * 获取科室新闻列表
	 */
	@RequestMapping(value = "/getKsNewsListForHospitalManager")
	public String getKsNewsListForHospitalManager(HttpServletRequest request, PageParam pageParam) throws IOException {
		Object manager = request.getSession().getAttribute(SysConstant.LOGINMANAGER);
		WxManager wxman = (WxManager) manager;
		Page<KeShi_HospitalManager> page = hospitalSv.getKsNewsListForHospitalManager(pageParam, wxman);
		request.setAttribute("page", page.toPageInfo());
		return "/houtaimanager/hospitalmanager/ksnews/disList.jsp";
	}

	/**
	 * 获取科室二维码
	 * 
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/keshierweima")
	public @ResponseBody ResultMsg keshierweima(HttpServletRequest request, HttpServletResponse response,
			WxManager wxman) throws JsonProcessingException {
		ResultMsg msg = new ResultMsg();
		Integer hospitalid = wxman.getHospitalid();
		Integer officeid = wxman.getKsofficeid();
		String erweimaURL = hospitalSv.getKSEWM(hospitalid, officeid);
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
			int insertc = hospitalSv.saveKSEWM(wxman.getHospitalid(), wxman.getKsofficeid(), getEWMByTicketUrl);
			msg.setData(getEWMByTicketUrl);
		}
		return msg;
	}

	/**
	 * 获取医院二维码
	 * 
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/hospitalerweima")
	public @ResponseBody ResultMsg hospitalerweima(HttpServletRequest request, HttpServletResponse response,
			WxManager wxman) throws JsonProcessingException {
		ResultMsg msg = new ResultMsg();
		Integer hospitalid = wxman.getHospitalid();
		String erweimaURL = hospitalSv.getHospitalEWM(hospitalid);
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
			int insertc = hospitalSv.saveHospitalEWM(wxman.getHospitalid(), getEWMByTicketUrl);
			msg.setData(getEWMByTicketUrl);
		}
		return msg;
	}
}
