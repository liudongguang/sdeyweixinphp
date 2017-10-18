package com.weixin.vo.menu.type;

import java.util.ArrayList;
import java.util.List;

import com.weixin.vo.menu.WXButton;

public class Scancode_waitmsgMenuBT extends WXButton {
	private String name;
	private String key;
	private List<? super WXButton> sub_button = new ArrayList<>();

	public Scancode_waitmsgMenuBT() {
		super();
		this.setType("scancode_waitmsg");
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

	public List<? super WXButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<? super WXButton> sub_button) {
		this.sub_button = sub_button;
	}

	@Override
	public String toString() {
		return "Scancode_waitmsgMenuBT [name=" + name + ", key=" + key + ", sub_button=" + sub_button + "]";
	}

}
