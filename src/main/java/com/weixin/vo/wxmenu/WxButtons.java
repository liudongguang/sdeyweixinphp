package com.weixin.vo.wxmenu;

import java.util.ArrayList;
import java.util.List;

public class WxButtons {
	private List<WxButton> button=new ArrayList<>();

	public List<WxButton> getButton() {
		return button;
	}

	public void setButton(List<WxButton> button) {
		this.button = button;
	}

	@Override
	public String toString() {
		return "WxButtons [button=" + button + "]";
	}

}
