package com.sdey.impl.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxManager;
import com.sdey.api.po.WxNews;
import com.sdey.api.vo.KeShi_HospitalManager;

public interface WxNewsMapper {
	/**
	 * 根据主键删除数据库的记录,wx_news
	 *
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 新写入数据库记录,wx_news
	 *
	 * @param record
	 */
	int insert(WxNews record);

	/**
	 * 动态字段,写入数据库记录,wx_news
	 *
	 * @param record
	 */
	int insertSelective(WxNews record);

	/**
	 * 根据指定主键获取一条数据库记录,wx_news
	 *
	 * @param id
	 */
	WxNews selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_news
	 *
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxNews record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_news
	 *
	 * @param record
	 */
	int updateByPrimaryKey(WxNews record);

	Page<WxNews> getKsNewsList(WxManager wxman);

	int deleteByKSID(Integer id);

	int deleteByHospitalID(Integer id);

	Page<KeShi_HospitalManager> getKsNewsListForHospitalManager(WxManager wxman);

	List<WxNews> getNewsListByksid(Integer officeid);

	Page<WxNews> getKsNewsListByKSID(Integer keshiID);

}