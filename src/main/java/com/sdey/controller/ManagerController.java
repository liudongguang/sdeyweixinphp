package com.sdey.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.ldg.api.vo.ResultMsg;
import com.sdey.api.po.WxHospital;
import com.sdey.api.po.WxManager;
import com.sdey.api.service.ManagerUserService;
import com.sdey.api.vo.AddHospitalAndUserVo;
import com.sdey.api.vo.PageParam;

@Controller
@RequestMapping(value = "/sdeymanager")
public class ManagerController {
	@Autowired
	private ManagerUserService managerSV;

	/**
	 * 登陆
	 */
	@RequestMapping(value = "/login")
	public String validate(WxManager manager, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		WxManager rtmanager = managerSV.getManagerUserForLogin(manager);
		if (rtmanager == null) {
			request.setAttribute("message", "用户名或密码错误！");
			request.setAttribute("manager", manager);
			return "/houtaimanager/login.jsp";
		}
		request.getSession().setAttribute("loginManager", rtmanager);
		return "redirect:/houtaimanager/index.jsp";
	}

	/**
	 * 退出登陆
	 */
	@RequestMapping(value = "/login_out")
	public String login_out(HttpServletRequest request) throws IOException {
		request.getSession().invalidate();
		return "redirect:/houtaimanager/login.jsp";
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

	/**
	 * 获取医院列表
	 */
	@RequestMapping(value = "/getHospitalList")
	public String getHospitalList(HttpServletRequest request, PageParam pageParam) throws IOException {
		Page<WxHospital> page = managerSV.getHospitalList(pageParam);
		request.setAttribute("page", page.toPageInfo());
		return "/houtaimanager/jigou/disList.jsp";
	}

	/**
	 * 保存医院与医院管理员
	 */
	@RequestMapping(value = "/addHospitalAndSuperManager")
	public @ResponseBody ResultMsg addHospitalAndSuperManager(AddHospitalAndUserVo addvo) throws IOException {
		ResultMsg msg = new ResultMsg();
		int insertC = managerSV.addHospitalAndUser(addvo);
		msg.setData(insertC);
		return msg;
	}

	/**
	 * 获取医院与管理员信息通过机构id
	 */
	@RequestMapping(value = "/getJiGouByID")
	public String getJiGouByID(HttpServletRequest request, Integer id) throws IOException {
		AddHospitalAndUserVo huvo = managerSV.getJiGouByID(id);
		request.setAttribute("huvo", huvo);
		return "/houtaimanager/jigou/addjg.jsp";
	}

	/**
	 * 获取医院与管理员信息通过机构id
	 */
	@RequestMapping(value = "/delJiGouByID")
	public String delJiGouByID(HttpServletRequest request, Integer id) throws IOException {
		int delCount = managerSV.delJiGouByID(id);
		return "/sdeymanager/getHospitalList";
	}

}
