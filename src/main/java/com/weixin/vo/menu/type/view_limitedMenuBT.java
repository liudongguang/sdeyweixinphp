package com.weixin.vo.menu.type;

import com.weixin.vo.menu.WXButton;

public class view_limitedMenuBT extends WXButton {
	private String name;
	private String media_id;

	public view_limitedMenuBT() {
		super();
		this.setType("view_limited");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

}
