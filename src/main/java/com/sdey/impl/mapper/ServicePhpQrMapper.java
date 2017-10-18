package com.sdey.impl.mapper;

import com.sdey.api.po.ServicePhpQr;

public interface ServicePhpQrMapper {
  

	/**
     *  根据主键删除数据库的记录,service_php_qr
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,service_php_qr
     *
     * @param record
     */
    int insert(ServicePhpQr record);

    /**
     *  动态字段,写入数据库记录,service_php_qr
     *
     * @param record
     */
    int insertSelective(ServicePhpQr record);

    /**
     *  根据指定主键获取一条数据库记录,service_php_qr
     *
     * @param id
     */
    ServicePhpQr selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,service_php_qr
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ServicePhpQr record);

    /**
     *  根据主键来更新符合条件的数据库记录,service_php_qr
     *
     * @param record
     */
    int updateByPrimaryKey(ServicePhpQr record);

	String getKSEWM(ServicePhpQr sp);

	String getHospitalEWM(String hospitalid);
}