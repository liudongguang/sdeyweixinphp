package com.weixin.vo.menu;

public abstract class WXButton {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "WXButton [type=" + type + "]";
	}

}
