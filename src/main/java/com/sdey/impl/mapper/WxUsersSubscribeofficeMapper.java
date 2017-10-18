package com.sdey.impl.mapper;

import com.sdey.api.po.WxUsersSubscribeoffice;
import com.sdey.api.vo.Dao_Search_SubParam;
import com.sdey.api.vo.Wxpage_ksjs_gz;

public interface WxUsersSubscribeofficeMapper {
	/**
	 * 根据主键删除数据库的记录,wx_users_subscribeoffice
	 *
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 新写入数据库记录,wx_users_subscribeoffice
	 *
	 * @param record
	 */
	int insert(WxUsersSubscribeoffice record);

	/**
	 * 动态字段,写入数据库记录,wx_users_subscribeoffice
	 *
	 * @param record
	 */
	int insertSelective(WxUsersSubscribeoffice record);

	/**
	 * 根据指定主键获取一条数据库记录,wx_users_subscribeoffice
	 *
	 * @param id
	 */
	WxUsersSubscribeoffice selectByPrimaryKey(Integer id);

	/**
	 * 动态字段,根据主键来更新符合条件的数据库记录,wx_users_subscribeoffice
	 *
	 * @param record
	 */
	int updateByPrimaryKeySelective(WxUsersSubscribeoffice record);

	/**
	 * 根据主键来更新符合条件的数据库记录,wx_users_subscribeoffice
	 *
	 * @param record
	 */
	int updateByPrimaryKey(WxUsersSubscribeoffice record);

	/**
	 * 获取收藏列表中此条收藏
	 * 
	 * @param param
	 * @return
	 */
	WxUsersSubscribeoffice selectByUserIdAndhospitalID_officeID(Dao_Search_SubParam param);

	/**
	 * 取消收藏
	 * 
	 * @param wxuserID
	 */
	int cancelYishouCang(Integer wxuserID);

	/**
	 * 设置收藏
	 * 
	 * @param subObj
	 */
	int updateSubForShouCang(WxUsersSubscribeoffice subObj);

	Wxpage_ksjs_gz getGuanZhuID(String openid);

	Integer getShouchangKSID(String openid);
}