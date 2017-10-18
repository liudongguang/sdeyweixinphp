package com.sdey.api.po;

public class WxUsersSubscribehospital {
    /**
     * 
     * 表字段 : wx_users_subscribehospital.id
     */
    private Integer id;

    /**
     * 用户id
     * 表字段 : wx_users_subscribehospital.userid
     */
    private Integer userid;

    /**
     * 收藏医院id
     * 表字段 : wx_users_subscribehospital.subscribehospitalid
     */
    private Integer subscribehospitalid;

    /**
     * 收藏状态1收藏    2不收藏
     * 表字段 : wx_users_subscribehospital.shoucang
     */
    private Integer shoucang;

    /**
     * 获取  字段:wx_users_subscribehospital.id
     *
     * @return wx_users_subscribehospital.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:wx_users_subscribehospital.id
     *
     * @param id the value for wx_users_subscribehospital.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户id 字段:wx_users_subscribehospital.userid
     *
     * @return wx_users_subscribehospital.userid, 用户id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 用户id 字段:wx_users_subscribehospital.userid
     *
     * @param userid the value for wx_users_subscribehospital.userid, 用户id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 收藏医院id 字段:wx_users_subscribehospital.subscribehospitalid
     *
     * @return wx_users_subscribehospital.subscribehospitalid, 收藏医院id
     */
    public Integer getSubscribehospitalid() {
        return subscribehospitalid;
    }

    /**
     * 设置 收藏医院id 字段:wx_users_subscribehospital.subscribehospitalid
     *
     * @param subscribehospitalid the value for wx_users_subscribehospital.subscribehospitalid, 收藏医院id
     */
    public void setSubscribehospitalid(Integer subscribehospitalid) {
        this.subscribehospitalid = subscribehospitalid;
    }

    /**
     * 获取 收藏状态1收藏    2不收藏 字段:wx_users_subscribehospital.shoucang
     *
     * @return wx_users_subscribehospital.shoucang, 收藏状态1收藏    2不收藏
     */
    public Integer getShoucang() {
        return shoucang;
    }

    /**
     * 设置 收藏状态1收藏    2不收藏 字段:wx_users_subscribehospital.shoucang
     *
     * @param shoucang the value for wx_users_subscribehospital.shoucang, 收藏状态1收藏    2不收藏
     */
    public void setShoucang(Integer shoucang) {
        this.shoucang = shoucang;
    }

	@Override
	public String toString() {
		return "WxUsersSubscribehospital [id=" + id + ", userid=" + userid + ", subscribehospitalid="
				+ subscribehospitalid + ", shoucang=" + shoucang + "]";
	}
    
}