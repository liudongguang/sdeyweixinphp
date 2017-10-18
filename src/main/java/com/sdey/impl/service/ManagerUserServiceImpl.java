package com.sdey.impl.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sdey.api.constant.SysConstant;
import com.sdey.api.po.WxHospital;
import com.sdey.api.po.WxManager;
import com.sdey.api.service.ManagerUserService;
import com.sdey.api.vo.AddHospitalAndUserVo;
import com.sdey.api.vo.PageParam;
import com.sdey.impl.mapper.WxHospitalMapper;
import com.sdey.impl.mapper.WxKeshiMapper;
import com.sdey.impl.mapper.WxManagerMapper;
import com.sdey.impl.mapper.WxNewsMapper;
import com.sdey.impl.mapper.WxYishengMapper;

@Service
public class ManagerUserServiceImpl implements ManagerUserService {
	@Autowired
	private WxHospitalMapper hospitalDao;
	@Autowired
	private WxManagerMapper managerDao;

	@Autowired
	private WxKeshiMapper keshiDao;

	@Autowired
	private WxYishengMapper yishengDao;
	@Autowired
	private WxNewsMapper ksNewsDao;

	/**
	 * 增加医院与医院管理员
	 */
	@Override
	public int addHospitalAndUser(AddHospitalAndUserVo addvo) {
		////////// 修改逻辑
		if (addvo.getManagerId() != null) {
			WxManager manager = new WxManager();
			manager.setId(addvo.getManagerId());
			manager.setName(addvo.getManagerName());
			manager.setUsername(addvo.getManagerUserName());
			manager.setPsd(addvo.getUserPsd());
			return managerDao.updateByPrimaryKeySelective(manager);
		}

		Date now = new Date();
		// 1.增加医院
		WxHospital hos = new WxHospital();
		hos.setName(addvo.getHospitalName());
		hos.setCreatetime(now);
		int hosInsertC = hospitalDao.addSimpleHospital(hos);
		// 2.增加医院管理员
		if (hosInsertC != 0) {
			WxManager manager = new WxManager();
			manager.setHospitalid(hos.getId());
			manager.setQuanxian(SysConstant.QX_HOSPITAL);// 系统管理员权限
			manager.setName(addvo.getManagerName());
			manager.setUsername(addvo.getManagerUserName());
			manager.setPsd(addvo.getUserPsd());
			manager.setCreatetime(now);
			int managerC = managerDao.insertSelective(manager);
			return managerC;
		}
		return 0;
	}

	@Override
	public Page<WxHospital> getHospitalList(PageParam pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return hospitalDao.getHospitalList();
	}

	@Override
	public AddHospitalAndUserVo getJiGouByID(Integer id) {
		WxHospital hospital = hospitalDao.selectByPrimaryKey(id);
		AddHospitalAndUserVo avo = new AddHospitalAndUserVo();
		if (hospital != null) {
			WxManager manager = managerDao.selectByHospitalId(hospital.getId());
			avo.setHospitalName(hospital.getName());
			if (manager != null) {
				avo.setManagerName(manager.getName());
				avo.setManagerUserName(manager.getUsername());
				avo.setUserPsd(manager.getPsd());
				avo.setManagerId(manager.getId());
			}
		}
		return avo;
	}

	@Override
	public WxManager getManagerUserForLogin(WxManager manager) {
		return managerDao.getManagerUserForLogin(manager);
	}

	@Override
	public int delJiGouByID(Integer id) {
		int delCount = hospitalDao.deleteByPrimaryKey(id);
		if (delCount == 1) {
			// 删除 医院信息，医院科室管理员，科室，科室专家，科室新闻
			int i1 = keshiDao.deleteByHospitalID(id);
			int i2 = managerDao.deleteByHospitalID(id);
			int i3 = yishengDao.deleteByHospitalID(id);
			int i4 = ksNewsDao.deleteByHospitalID(id);
		}
		return delCount;
	}

}
