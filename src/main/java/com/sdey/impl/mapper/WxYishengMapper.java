package com.sdey.impl.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxManager;
import com.sdey.api.po.WxYisheng;
import com.sdey.api.vo.Wx_ysxq;
import com.sdey.api.vo.Yisheng_HospitalManger;

public interface WxYishengMapper {
	/**
	 * 根据主键删除数据库的记录,wx_yisheng
	 * 
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 新写入数据库记录,wx_yisheng
	 * 
	 * @param record
	 */
	int insert(WxYisheng record);

	/**
	 * 动态字段,写入数据库记录,wx_yisheng
	 * 
	 * @param record
	 */
	int insertSelective(WxYisheng record);

	/**
	 * 根据指定主键获取一条数据库记录,wx_yisheng
	 * 
	 * @param id
	 */
	WxYisheng selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_yisheng
	 * 
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxYisheng record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_yisheng
	 * 
	 * @param record
	 */
	int updateByPrimaryKey(WxYisheng record);

	/**
	 * 医生列表
	 * 
	 * @return
	 */
	Page<WxYisheng> getDoctorList(WxManager wxman);

	int deleteByKSID(Integer id);

	int deleteByHospitalID(Integer id);

	Page<Yisheng_HospitalManger> getDoctorListForHospitalManager(WxManager wxman);

	List<WxYisheng> getYSListByksid(Integer officeid);

	Wx_ysxq selectysxqByYSID(Integer ysid);

	
}