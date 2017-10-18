package com.weixin.vo.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuSubBt extends WXButton {
	private String name;
	private List<? super WXButton> sub_button = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<? super WXButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<? super WXButton> sub_button) {
		this.sub_button = sub_button;
	}

}
