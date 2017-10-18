package com.sdey.impl.mapper;

import com.sdey.api.po.WxUsersSubscribehospital;
import com.sdey.api.vo.Dao_Search_SubParam;

public interface WxUsersSubscribehospitalMapper {
	/**
	 * 根据主键删除数据库的记录,wx_users_subscribehospital
	 *
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 新写入数据库记录,wx_users_subscribehospital
	 *
	 * @param record
	 */
	int insert(WxUsersSubscribehospital record);

	/**
	 * 动态字段,写入数据库记录,wx_users_subscribehospital
	 *
	 * @param record
	 */
	int insertSelective(WxUsersSubscribehospital record);

	/**
	 * 根据指定主键获取一条数据库记录,wx_users_subscribehospital
	 *
	 * @param id
	 */
	WxUsersSubscribehospital selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_users_subscribehospital
	 *
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxUsersSubscribehospital record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_users_subscribehospital
	 *
	 * @param record
	 */
	int updateByPrimaryKey(WxUsersSubscribehospital record);

	/**
	 * 获取收藏的医院
	 * 
	 * @param param
	 * @return
	 */
	WxUsersSubscribehospital selectSubHospitalByUserIdAndHospitalId(Dao_Search_SubParam param);

	/**
	 * 取消收藏
	 * 
	 * @param wxuserID
	 */
	void cancelYishouCang(Integer wxuserID);

	void updateSubForShouCang(WxUsersSubscribehospital subObj);

	Integer getShouchangHospitalID(String openid);
}