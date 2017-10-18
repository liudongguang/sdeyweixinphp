package com.weixin.vo.wxmenu;

public class WxMenu {
	private WxButtons menu=new WxButtons();

	public WxButtons getMenu() {
		return menu;
	}

	public void setMenu(WxButtons menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "WxMenu [menu=" + menu + "]";
	}

}
