package com.weixin.vo.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<? super WXButton> button = new ArrayList<>();


	


	public List<? super WXButton> getButton() {
		return button;
	}





	public void setButton(List<? super WXButton> button) {
		this.button = button;
	}





	@Override
	public String toString() {
		return "Menu [button=" + button + "]";
	}

}
