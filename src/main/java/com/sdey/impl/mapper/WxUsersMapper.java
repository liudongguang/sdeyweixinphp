package com.sdey.impl.mapper;

import com.sdey.api.po.WxUsers;

public interface WxUsersMapper {
	/**
	 * 根据主键删除数据库的记录,wx_users
	 *
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 新写入数据库记录,wx_users
	 *
	 * @param record
	 */
	int insert(WxUsers record);

	/**
	 * 动态字段,写入数据库记录,wx_users
	 *
	 * @param record
	 */
	int insertSelective(WxUsers record);

	/**
	 * 根据指定主键获取一条数据库记录,wx_users
	 *
	 * @param id
	 */
	WxUsers selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_users
	 *
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxUsers record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_users
	 *
	 * @param record
	 */
	int updateByPrimaryKey(WxUsers record);

	/**
	 * 根据微信openid获取用户信息
	 * 
	 * @param fromUserName
	 * @return
	 */
	WxUsers selectByWXOpenID(String fromUserName);

	/**
	 * 保存用户 并返回id
	 * 
	 * @param wxuser
	 * @return
	 */
	int saveWXUser(WxUsers wxuser);

	/**
	 * 修改成为关注状态
	 * 
	 * @param wxuser
	 * @return
	 */
	int updateWXUserToSub(WxUsers wxuser);

	/**
	 * 
	 * @param fromUserName
	 * @return
	 */
	int updateWXUserToUnSub(String fromUserName);
}