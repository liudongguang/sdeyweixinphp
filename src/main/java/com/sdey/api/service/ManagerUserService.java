package com.sdey.api.service;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxHospital;
import com.sdey.api.po.WxManager;
import com.sdey.api.po.WxYisheng;
import com.sdey.api.vo.AddHospitalAndUserVo;
import com.sdey.api.vo.PageParam;

public interface ManagerUserService {
	int addHospitalAndUser(AddHospitalAndUserVo addvo);

	Page<WxHospital> getHospitalList(PageParam pageParam);

	AddHospitalAndUserVo getJiGouByID(Integer id);

	WxManager getManagerUserForLogin(WxManager manager);

	/**
	 * 删除医院及其关联信息
	 * 
	 * @param id
	 * @return
	 */
	int delJiGouByID(Integer id);

}
