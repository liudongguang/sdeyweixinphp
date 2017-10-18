package com.weixin.vo.menu.type;

import com.weixin.vo.menu.WXButton;

public class Location_selectMenuBT extends WXButton {
	private String name;
	private String key;

	public Location_selectMenuBT() {
		super();
		this.setType("location_select");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
}
