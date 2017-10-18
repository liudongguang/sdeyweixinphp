package com.weixin.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

import com.sdey.api.constant.SysConstant;

public class PropertiesUtil {
	private static Properties weixinProperties = new Properties();
	static {
		ClassPathResource cr = new ClassPathResource("weixin.properties");
		try {
			weixinProperties.load(cr.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String weixinPropertiesVal(String key) {
		return weixinProperties.getProperty(key);
	}

	public static String sysForPHPPropertiesVal(String key) {
		StringBuilder sbd = new StringBuilder(weixinProperties.getProperty(SysConstant.phpserver));
		sbd.append(weixinProperties.getProperty(key));
		return sbd.toString();
	}

	public static void main(String[] args) {
		System.out.println(PropertiesUtil.weixinPropertiesVal("token"));
	}
}
