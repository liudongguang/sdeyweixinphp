package com.sdey.api.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxKeshi;
import com.sdey.api.po.WxManager;
import com.sdey.api.po.WxNews;
import com.sdey.api.po.WxYisheng;
import com.sdey.api.vo.KeShi_HospitalManager;
import com.sdey.api.vo.PageParam;
import com.sdey.api.vo.Wx_ysxq;
import com.sdey.api.vo.Wxpage_ksjs_gz;
import com.sdey.api.vo.Yisheng_HospitalManger;

public interface HospitalService {
	/**
	 * 科室列表
	 * 
	 * @param pageParam
	 * @param wxman
	 * @return
	 */
	Page<WxKeshi> getKeshiList(PageParam pageParam, WxManager wxman);

	/**
	 * 增加科室信息
	 * 
	 * @param keshi
	 * @return
	 */
	int addHospitalKS(WxKeshi keshi);

	/**
	 * 获取科室管理员
	 * 
	 * @param pageParam
	 * @param wxman
	 * @return
	 */
	Page<WxManager> getKeshiManagerList(PageParam pageParam, Integer keshiID);

	/**
	 * 添加科室管理员
	 * 
	 * @param keshiManager
	 * @return
	 */
	int addKSInfoManager(WxManager keshiManager);

	/**
	 * 获取管理员通过id
	 * 
	 * @param id
	 * @return
	 */
	WxManager getKSManagerByID(Integer id);

	/**
	 * 修改用户
	 * 
	 * @param keshiManager
	 * @return
	 */
	int updateKSInfoManager(WxManager keshiManager);

	/**
	 * 获取科室信息通过id
	 * 
	 * @param id
	 * @return
	 */
	WxKeshi getKeshiByID(Integer id);

	/**
	 * 修改科室信息
	 * 
	 * @param keshi
	 * @return
	 */
	int updateHospitalKS(WxKeshi keshi);

	/**
	 * 获取医生列表
	 * 
	 * @param pageParam
	 * @param wxman
	 * @return
	 */
	Page<WxYisheng> getDoctorList(PageParam pageParam, WxManager wxman);

	/**
	 * 增加医生
	 * 
	 * @param ys
	 * @return
	 */
	int addDoctor(WxYisheng ys);

	/**
	 * 修改医生
	 * 
	 * @param ys
	 * @return
	 */
	int updateDoctor(WxYisheng ys);

	/**
	 * 获取医生信息根据id
	 * 
	 * @param id
	 * @return
	 */
	WxYisheng getDoctorByIDByID(Integer id);

	/**
	 * 删除医生
	 * 
	 * @param id
	 * @return
	 */
	int delDoctorByIDByID(Integer id);

	/**
	 * 获取科室新闻列表
	 * 
	 * @param pageParam
	 * @param wxman
	 * @return
	 */
	Page<WxNews> getKsNewsList(PageParam pageParam, WxManager wxman);

	Page<WxNews> getKsNewsList(PageParam pageParam, Integer keshiID);

	/**
	 * 增加科室新闻信息
	 * 
	 * @param news
	 * @return
	 */
	int addKsNews(WxNews news);

	/**
	 * 修改科室新闻
	 * 
	 * @param news
	 * @return
	 */
	int updateKsNews(WxNews news);

	/**
	 * 根据id获取科室新闻
	 * 
	 * @param id
	 * @return
	 */
	WxNews getKSNewsByID(Integer id);

	/**
	 * 删除科室新闻
	 * 
	 * @param id
	 * @return
	 */
	int delKSNewsByID(Integer id);

	/**
	 * 删除科室及其管理员
	 * 
	 * @param id
	 * @return
	 */
	int delKeshiAndThisManagerByID(Integer id);

	/**
	 * 删除管理员
	 * 
	 * @param id
	 * @return
	 */
	int delKeshiManagerByID(Integer id);

	/**
	 * 获取医生信息，包含医生所在科室
	 * 
	 * @param pageParam
	 * @param wxman
	 * @return
	 */
	Page<Yisheng_HospitalManger> getDoctorListForHospitalManager(PageParam pageParam, WxManager wxman);

	Page<KeShi_HospitalManager> getKsNewsListForHospitalManager(PageParam pageParam, WxManager wxman);

	/**
	 * 获取二维码
	 * 
	 * @param hospitalid
	 * @param ksofficeid
	 * @return
	 */
	String getKSEWM(Integer hospitalid, Integer ksofficeid);

	/**
	 * 保存二维码
	 * 
	 * @param hospitalid
	 * @param ksofficeid
	 * @param getEWMByTicketUrl
	 */
	int saveKSEWM(Integer hospitalid, Integer ksofficeid, String getEWMByTicketUrl);

	/**
	 * 关注事件
	 * 
	 * @param eventKey
	 *            二维码参数
	 * @param fromUserName
	 *            用户id
	 * @return
	 */
	String wxSubscribe(String eventKey, String fromUserName);

	/**
	 * 取消关注
	 * 
	 * @param fromUserName
	 */
	int wxUnSubscribe(String fromUserName);

	/**
	 * 获取关注的科室
	 * 
	 * @param openid
	 * @return
	 */
	Wxpage_ksjs_gz getGuanZhuID(String openid);

	/**
	 * 根据医院id获取二维码
	 * 
	 * @param hospitalid
	 * @return
	 */
	String getHospitalEWM(Integer hospitalid);

	/**
	 * 保存二院二维码
	 * 
	 * @param hospitalid
	 * @param getEWMByTicketUrl
	 * @return
	 */
	int saveHospitalEWM(Integer hospitalid, String getEWMByTicketUrl);

	/**
	 * 获取收藏的医院
	 * 
	 * @param openid
	 * @return
	 */
	Integer getShouchangHospitalID(String openid);

	/**
	 * 通过科室id获取医生列表
	 * 
	 * @param officeid
	 * @return
	 */
	List<WxYisheng> getYSListByksid(Integer officeid);

	/**
	 * 微信页面医生详情
	 * 
	 * @param ysid
	 * @return
	 */
	Wx_ysxq selectysxqByYSID(Integer ysid);

	/**
	 * 获取新闻列表通过科室id
	 * 
	 * @param officeid
	 * @return
	 */
	List<WxNews> getNewsListByksid(Integer officeid);

	/**
	 * 根据微信id获取科室所在医院的id
	 * 
	 * @param openid
	 * @return
	 */
	Integer getShouchangKSID(String openid);

}
