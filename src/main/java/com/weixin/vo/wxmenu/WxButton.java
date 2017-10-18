package com.weixin.vo.wxmenu;

import java.util.List;

public class WxButton {
	private String name;
	private List<WxSub_button> sub_button;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WxSub_button> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WxSub_button> sub_button) {
		this.sub_button = sub_button;
	}

	@Override
	public String toString() {
		return "WxButton [name=" + name + ", sub_button=" + sub_button + "]";
	}

}
