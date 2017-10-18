package com.sdey.impl.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxHospital;

public interface WxHospitalMapper {
	/**
	 * 根据主键删除数据库的记录,wx_hospital
	 * 
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 新写入数据库记录,wx_hospital
	 * 
	 * @param record
	 */
	int insert(WxHospital record);

	/**
	 * 动态字段,写入数据库记录,wx_hospital
	 * 
	 * @param record
	 */
	int insertSelective(WxHospital record);

	/**
	 * 根据指定主键获取一条数据库记录,wx_hospital
	 * 
	 * @param id
	 */
	WxHospital selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_hospital
	 * 
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxHospital record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_hospital
	 * 
	 * @param record
	 */
	int updateByPrimaryKey(WxHospital record);

	int addSimpleHospital(WxHospital hos);

	Page<WxHospital> getHospitalList();

	String getHospitalEWM(Integer hospitalid);

	int saveHospitalEWM(@Param("hospitalid") Integer hospitalid, @Param("getEWMByTicketUrl") String getEWMByTicketUrl);
}