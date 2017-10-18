package com.weixin.vo.menu.type;

import com.weixin.vo.menu.WXButton;

public class ClickMenuBT extends WXButton {
	private String name;
	private String key;

	public ClickMenuBT() {
		super();
		this.setType("click");
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
