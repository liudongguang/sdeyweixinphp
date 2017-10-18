package com.weixin.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.weixin.util.Access_token;

public class ServletListenerForAssToken implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Access_token.init_Access_token();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
