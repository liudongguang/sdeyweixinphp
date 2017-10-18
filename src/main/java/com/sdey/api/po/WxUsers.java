package com.sdey.api.po;

import java.util.Date;

public class WxUsers {
    /**
     * 
     * 表字段 : wx_users.id
     */
    private Integer id;

    /**
     * 微信服务号的openid
     * 表字段 : wx_users.openid
     */
    private String openid;

    /**
     * 创建时间
     * 表字段 : wx_users.createtime
     */
    private Date createtime;

    /**
     * 关注状态   1关注 2不关注
     * 表字段 : wx_users.subscribe
     */
    private Integer subscribe;

    /**
     * 获取  字段:wx_users.id
     *
     * @return wx_users.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:wx_users.id
     *
     * @param id the value for wx_users.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 微信服务号的openid 字段:wx_users.openid
     *
     * @return wx_users.openid, 微信服务号的openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置 微信服务号的openid 字段:wx_users.openid
     *
     * @param openid the value for wx_users.openid, 微信服务号的openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 获取 创建时间 字段:wx_users.createtime
     *
     * @return wx_users.createtime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:wx_users.createtime
     *
     * @param createtime the value for wx_users.createtime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 关注状态   1关注 2不关注 字段:wx_users.subscribe
     *
     * @return wx_users.subscribe, 关注状态   1关注 2不关注
     */
    public Integer getSubscribe() {
        return subscribe;
    }

    /**
     * 设置 关注状态   1关注 2不关注 字段:wx_users.subscribe
     *
     * @param subscribe the value for wx_users.subscribe, 关注状态   1关注 2不关注
     */
    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

	@Override
	public String toString() {
		return "WxUsers [id=" + id + ", openid=" + openid + ", createtime=" + createtime + ", subscribe=" + subscribe
				+ "]";
	}
    
}