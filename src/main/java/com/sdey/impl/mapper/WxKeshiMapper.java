package com.sdey.impl.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxHospital;
import com.sdey.api.po.WxKeshi;
import com.sdey.api.po.WxManager;

public interface WxKeshiMapper {
	/**
	 * 新写入数据库记录,wx_keshi
	 *
	 * @param record
	 */
	int insert(WxKeshi record);

	/**
	 * 动态字段,写入数据库记录,wx_keshi
	 *
	 * @param record
	 */
	int insertSelective(WxKeshi record);

	int deleteByPrimaryKey(Integer id);

	/**
	 * 根据指定主键获取一条数据库记录,wx_keshi
	 *
	 * @param id
	 */
	WxKeshi selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_keshi
	 *
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxKeshi record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_keshi
	 *
	 * @param record
	 */
	int updateByPrimaryKey(WxKeshi record);

	Page<WxKeshi> getKeshiList(WxManager wxman);

	int deleteByHospitalID(Integer id);

	String getKSEWM(@Param("hospitalid") Integer hospitalid, @Param("ksofficeid") Integer ksofficeid);

	int saveKSEWM(@Param("hospitalid") Integer hospitalid, @Param("ksofficeid") Integer ksofficeid,
			@Param("getEWMByTicketUrl") String getEWMByTicketUrl);
}