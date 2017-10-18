package com.sdey.impl.service;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ldg.api.util.JsonUtil;
import com.sdey.api.constant.SysConstant;
import com.sdey.api.po.WxKeshi;
import com.sdey.api.po.WxManager;
import com.sdey.api.po.WxNews;
import com.sdey.api.po.WxUsers;
import com.sdey.api.po.WxUsersSubscribehospital;
import com.sdey.api.po.WxUsersSubscribeoffice;
import com.sdey.api.po.WxYisheng;
import com.sdey.api.service.HospitalService;
import com.sdey.api.vo.Dao_Search_SubParam;
import com.sdey.api.vo.KeShi_HospitalManager;
import com.sdey.api.vo.PHP_saomars;
import com.sdey.api.vo.PageParam;
import com.sdey.api.vo.Wx_ysxq;
import com.sdey.api.vo.Wxpage_ksjs_gz;
import com.sdey.api.vo.Yisheng_HospitalManger;
import com.sdey.impl.mapper.WxHospitalMapper;
import com.sdey.impl.mapper.WxKeshiMapper;
import com.sdey.impl.mapper.WxManagerMapper;
import com.sdey.impl.mapper.WxNewsMapper;
import com.sdey.impl.mapper.WxUsersMapper;
import com.sdey.impl.mapper.WxUsersSubscribehospitalMapper;
import com.sdey.impl.mapper.WxUsersSubscribeofficeMapper;
import com.sdey.impl.mapper.WxYishengMapper;
import com.weixin.constant.WeixinConstant;
import com.weixin.util.HttpClientUtil;
import com.weixin.util.PropertiesUtil;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private WxKeshiMapper keshiDao;
	@Autowired
	private WxManagerMapper managerDao;
	@Autowired
	private WxYishengMapper yishengDao;
	@Autowired
	private WxNewsMapper ksNewsDao;

	@Autowired
	private WxUsersMapper wxUserDao;
	@Autowired
	private WxUsersSubscribeofficeMapper wxUserSubOfficeDao;

	@Autowired
	private WxHospitalMapper hospitalDao;

	@Autowired
	private WxUsersSubscribehospitalMapper wxUserSubHospitalDao;

	@Override
	public Page<WxKeshi> getKeshiList(PageParam pageParam, WxManager wxman) {
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		} else {
			PageHelper.startPage(0, 0, false);
		}
		return keshiDao.getKeshiList(wxman);
	}

	@Override
	public int addHospitalKS(WxKeshi keshi) {
		return keshiDao.insertSelective(keshi);
	}

	@Override
	public Page<WxManager> getKeshiManagerList(PageParam pageParam, Integer keshiID) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return managerDao.getKeshiManagerList(keshiID);
	}

	@Override
	public int addKSInfoManager(WxManager keshiManager) {
		return managerDao.insertSelective(keshiManager);
	}

	@Override
	public WxManager getKSManagerByID(Integer id) {
		return managerDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateKSInfoManager(WxManager keshiManager) {
		return managerDao.updateByPrimaryKeySelective(keshiManager);
	}

	@Override
	public WxKeshi getKeshiByID(Integer id) {
		return keshiDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateHospitalKS(WxKeshi keshi) {
		return keshiDao.updateByPrimaryKeySelective(keshi);
	}

	@Override
	public Page<WxYisheng> getDoctorList(PageParam pageParam, WxManager wxman) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return yishengDao.getDoctorList(wxman);
	}

	@Override
	public Page<Yisheng_HospitalManger> getDoctorListForHospitalManager(PageParam pageParam, WxManager wxman) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return yishengDao.getDoctorListForHospitalManager(wxman);
	}

	@Override
	public int addDoctor(WxYisheng ys) {
		return yishengDao.insertSelective(ys);
	}

	@Override
	public int updateDoctor(WxYisheng ys) {
		return yishengDao.updateByPrimaryKeySelective(ys);
	}

	@Override
	public WxYisheng getDoctorByIDByID(Integer id) {
		return yishengDao.selectByPrimaryKey(id);
	}

	@Override
	public int delDoctorByIDByID(Integer id) {
		return yishengDao.deleteByPrimaryKey(id);
	}

	@Override
	public Page<WxNews> getKsNewsList(PageParam pageParam, WxManager wxman) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return ksNewsDao.getKsNewsList(wxman);
	}

	@Override
	public int addKsNews(WxNews news) {
		return ksNewsDao.insertSelective(news);
	}

	@Override
	public int updateKsNews(WxNews news) {
		return ksNewsDao.updateByPrimaryKeySelective(news);
	}

	@Override
	public WxNews getKSNewsByID(Integer id) {
		return ksNewsDao.selectByPrimaryKey(id);
	}

	@Override
	public int delKSNewsByID(Integer id) {
		return ksNewsDao.deleteByPrimaryKey(id);
	}

	@Override
	public int delKeshiAndThisManagerByID(Integer id) {
		// 删除 科室, 医院科室管理员，科室专家，科室新闻
		int delKSCount = keshiDao.deleteByPrimaryKey(id);
		if (delKSCount != 0) {
			int i1 = managerDao.deleteByKSID(id);
			int i2 = yishengDao.deleteByKSID(id);
			int i3 = ksNewsDao.deleteByKSID(id);
		}
		return delKSCount;
	}

	@Override
	public int delKeshiManagerByID(Integer id) {
		return managerDao.deleteByPrimaryKey(id);
	}

	@Override
	public Page<KeShi_HospitalManager> getKsNewsListForHospitalManager(PageParam pageParam, WxManager wxman) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return ksNewsDao.getKsNewsListForHospitalManager(wxman);
	}

	@Override
	public String getKSEWM(Integer hospitalid, Integer ksofficeid) {
		return keshiDao.getKSEWM(hospitalid, ksofficeid);
	}

	@Override
	public int saveKSEWM(Integer hospitalid, Integer ksofficeid, String getEWMByTicketUrl) {
		return keshiDao.saveKSEWM(hospitalid, ksofficeid, getEWMByTicketUrl);
	}

	@Override
	public String wxSubscribe(String eventKey, String fromUserName) {
		// 1.1扫描医院二维码逻辑
		if (eventKey.indexOf(SysConstant.WXEWM_HOSPITAL) != -1) {
			return "0";
		}
		// 2.增加关注科室列表，并且设置为收藏
		String[] spStr = eventKey.split("-");
		String hospitalID = spStr[0];
		String officeID = spStr[1];
		String phpsaomaURL = MessageFormat.format(PropertiesUtil.sysForPHPPropertiesVal(SysConstant.phpsaoma), officeID,
				fromUserName);
		String rs = HttpClientUtil.getInstance().sendHttpPostMobile(phpsaomaURL);
		System.out.println("扫描二维码：php返回结果......rs" + rs.substring(rs.indexOf("{")));
		PHP_saomars rsobj=JsonUtil.getObjectByJSON( rs.substring(rs.indexOf("{")), PHP_saomars.class);
		System.out.println("扫描二维码：php返回结果......rsobj" + rsobj);
		return rsobj.getName();
	}

	@Override
	public int wxUnSubscribe(String fromUserName) {
		return wxUserDao.updateWXUserToUnSub(fromUserName);
	}

	@Override
	public Wxpage_ksjs_gz getGuanZhuID(String openid) {
		return wxUserSubOfficeDao.getGuanZhuID(openid);
	}

	@Override
	public String getHospitalEWM(Integer hospitalid) {
		return hospitalDao.getHospitalEWM(hospitalid);
	}

	@Override
	public int saveHospitalEWM(Integer hospitalid, String getEWMByTicketUrl) {
		return hospitalDao.saveHospitalEWM(hospitalid, getEWMByTicketUrl);
	}

	@Override
	public Integer getShouchangHospitalID(String openid) {
		return wxUserSubHospitalDao.getShouchangHospitalID(openid);
	}

	@Override
	public List<WxYisheng> getYSListByksid(Integer officeid) {
		return yishengDao.getYSListByksid(officeid);
	}

	@Override
	public Wx_ysxq selectysxqByYSID(Integer ysid) {
		return yishengDao.selectysxqByYSID(ysid);
	}

	@Override
	public List<WxNews> getNewsListByksid(Integer officeid) {
		return ksNewsDao.getNewsListByksid(officeid);
	}

	@Override
	public Page<WxNews> getKsNewsList(PageParam pageParam, Integer keshiID) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return ksNewsDao.getKsNewsListByKSID(keshiID);
	}

	@Override
	public Integer getShouchangKSID(String openid) {
		return wxUserSubOfficeDao.getShouchangKSID(openid);
	}
   public static void main(String[] args) {
	   String ss="{\"name\":\"\u7532\u72b6\u817a\u5916\u79d1\",\"info\":\"sucess\"}";
	   PHP_saomars rsobj=JsonUtil.getObjectByJSON(ss, PHP_saomars.class);
	   System.out.println(rsobj);
	   System.out.println("aab{ddd".substring("aab{ddd".indexOf("{")));
}
}
