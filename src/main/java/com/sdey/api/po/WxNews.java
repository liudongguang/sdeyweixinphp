package com.sdey.api.po;

import java.util.Date;

public class WxNews {
    /**
     * 
     * 表字段 : wx_news.id
     */
    private Integer id;

    /**
     * 标题
     * 表字段 : wx_news.title
     */
    private String title;

    /**
     * 内容
     * 表字段 : wx_news.content
     */
    private String content;

    /**
     * 医院id
     * 表字段 : wx_news.hospitalid
     */
    private Integer hospitalid;

    /**
     * 科室id
     * 表字段 : wx_news.ksid
     */
    private Integer ksid;

    /**
     * 创建时间
     * 表字段 : wx_news.createtime
     */
    private Date createtime;

    /**
     * 操作员id
     * 表字段 : wx_news.czyid
     */
    private Integer czyid;

    /**
     * 获取  字段:wx_news.id
     *
     * @return wx_news.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:wx_news.id
     *
     * @param id the value for wx_news.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 标题 字段:wx_news.title
     *
     * @return wx_news.title, 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 标题 字段:wx_news.title
     *
     * @param title the value for wx_news.title, 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 内容 字段:wx_news.content
     *
     * @return wx_news.content, 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 内容 字段:wx_news.content
     *
     * @param content the value for wx_news.content, 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取 医院id 字段:wx_news.hospitalid
     *
     * @return wx_news.hospitalid, 医院id
     */
    public Integer getHospitalid() {
        return hospitalid;
    }

    /**
     * 设置 医院id 字段:wx_news.hospitalid
     *
     * @param hospitalid the value for wx_news.hospitalid, 医院id
     */
    public void setHospitalid(Integer hospitalid) {
        this.hospitalid = hospitalid;
    }

    /**
     * 获取 科室id 字段:wx_news.ksid
     *
     * @return wx_news.ksid, 科室id
     */
    public Integer getKsid() {
        return ksid;
    }

    /**
     * 设置 科室id 字段:wx_news.ksid
     *
     * @param ksid the value for wx_news.ksid, 科室id
     */
    public void setKsid(Integer ksid) {
        this.ksid = ksid;
    }

    /**
     * 获取 创建时间 字段:wx_news.createtime
     *
     * @return wx_news.createtime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:wx_news.createtime
     *
     * @param createtime the value for wx_news.createtime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 操作员id 字段:wx_news.czyid
     *
     * @return wx_news.czyid, 操作员id
     */
    public Integer getCzyid() {
        return czyid;
    }

    /**
     * 设置 操作员id 字段:wx_news.czyid
     *
     * @param czyid the value for wx_news.czyid, 操作员id
     */
    public void setCzyid(Integer czyid) {
        this.czyid = czyid;
    }
}