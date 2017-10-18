package com.weixin.vo.wxmenu;

import java.util.List;

public class WxSub_button {
	private String type;
	private String name;
	private String key;
	private List<WxSub_button> sub_button;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public List<WxSub_button> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WxSub_button> sub_button) {
		this.sub_button = sub_button;
	}
	@Override
	public String toString() {
		return "WxSub_button [type=" + type + ", name=" + name + ", key=" + key + ", sub_button=" + sub_button + "]";
	}
	
}
