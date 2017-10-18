package com.weixin.vo.menu.type;

import com.weixin.vo.menu.WXButton;

public class ViewMenuBT extends WXButton {
	private String name;
	private String url;

	public ViewMenuBT() {
		super();
		this.setType("view");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
