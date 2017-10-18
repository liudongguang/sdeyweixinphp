package com.sdey.impl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxSucai;

public interface WxSucaiMapper {

	/**
	 * 根据主键删除数据库的记录,wx_sucai
	 * 
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 新写入数据库记录,wx_sucai
	 * 
	 * @param record
	 */
	int insert(WxSucai record);

	/**
	 * 动态字段,写入数据库记录,wx_sucai
	 * 
	 * @param record
	 */
	int insertSelective(WxSucai record);

	/**
	 * 根据指定主键获取一条数据库记录,wx_sucai
	 * 
	 * @param id
	 */
	WxSucai selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_sucai
	 * 
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxSucai record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_sucai
	 * 
	 * @param record
	 */
	int updateByPrimaryKey(WxSucai record);

	Page<WxSucai> getSuCaiList();

	int guanlianSCByID(@Param("id") Integer id, @Param("cdid") String cdid);

	void clearGuanLian(String cdid);

	List<WxSucai> getAllCaidan();
}