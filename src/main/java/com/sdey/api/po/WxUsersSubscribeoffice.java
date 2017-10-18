package com.sdey.api.po;

public class WxUsersSubscribeoffice {
    /**
     * 
     * 表字段 : wx_users_subscribeoffice.id
     */
    private Integer id;

    /**
     * 用户id
     * 表字段 : wx_users_subscribeoffice.userid
     */
    private Integer userid;

    /**
     * 关注的医院id
     * 表字段 : wx_users_subscribeoffice.subhospitalid
     */
    private Integer subhospitalid;

    /**
     * 关注的科室id
     * 表字段 : wx_users_subscribeoffice.subofficeid
     */
    private Integer subofficeid;

    /**
     * 收藏为1   
     * 表字段 : wx_users_subscribeoffice.shoucang
     */
    private Integer shoucang;

    /**
     * 获取  字段:wx_users_subscribeoffice.id
     *
     * @return wx_users_subscribeoffice.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:wx_users_subscribeoffice.id
     *
     * @param id the value for wx_users_subscribeoffice.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户id 字段:wx_users_subscribeoffice.userid
     *
     * @return wx_users_subscribeoffice.userid, 用户id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 用户id 字段:wx_users_subscribeoffice.userid
     *
     * @param userid the value for wx_users_subscribeoffice.userid, 用户id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 关注的医院id 字段:wx_users_subscribeoffice.subhospitalid
     *
     * @return wx_users_subscribeoffice.subhospitalid, 关注的医院id
     */
    public Integer getSubhospitalid() {
        return subhospitalid;
    }

    /**
     * 设置 关注的医院id 字段:wx_users_subscribeoffice.subhospitalid
     *
     * @param subhospitalid the value for wx_users_subscribeoffice.subhospitalid, 关注的医院id
     */
    public void setSubhospitalid(Integer subhospitalid) {
        this.subhospitalid = subhospitalid;
    }

    /**
     * 获取 关注的科室id 字段:wx_users_subscribeoffice.subofficeid
     *
     * @return wx_users_subscribeoffice.subofficeid, 关注的科室id
     */
    public Integer getSubofficeid() {
        return subofficeid;
    }

    /**
     * 设置 关注的科室id 字段:wx_users_subscribeoffice.subofficeid
     *
     * @param subofficeid the value for wx_users_subscribeoffice.subofficeid, 关注的科室id
     */
    public void setSubofficeid(Integer subofficeid) {
        this.subofficeid = subofficeid;
    }

    /**
     * 获取 收藏为1    字段:wx_users_subscribeoffice.shoucang
     *
     * @return wx_users_subscribeoffice.shoucang, 收藏为1   
     */
    public Integer getShoucang() {
        return shoucang;
    }

    /**
     * 设置 收藏为1    字段:wx_users_subscribeoffice.shoucang
     *
     * @param shoucang the value for wx_users_subscribeoffice.shoucang, 收藏为1   
     */
    public void setShoucang(Integer shoucang) {
        this.shoucang = shoucang;
    }
}