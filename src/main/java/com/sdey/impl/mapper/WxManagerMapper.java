package com.sdey.impl.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxManager;

public interface WxManagerMapper {
	/**
	 * 根据主键删除数据库的记录,wx_manager
	 * 
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 新写入数据库记录,wx_manager
	 * 
	 * @param record
	 */
	int insert(WxManager record);

	/**
	 * 动态字段,写入数据库记录,wx_manager
	 * 
	 * @param record
	 */
	int insertSelective(WxManager record);

	/**
	 * 根据指定主键获取一条数据库记录,wx_manager
	 * 
	 * @param id
	 */
	WxManager selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_manager
	 * 
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxManager record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_manager
	 * 
	 * @param record
	 */
	int updateByPrimaryKey(WxManager record);

	WxManager selectByHospitalId(Integer id);

	WxManager getManagerUserForLogin(WxManager manager);

	Page<WxManager> getKeshiManagerList(@Param("keshiID") Integer keshiID);

	int deleteByKSID(Integer id);

	int deleteByHospitalID(Integer id);

}