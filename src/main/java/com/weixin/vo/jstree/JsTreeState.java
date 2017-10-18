package com.weixin.vo.jstree;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown
		 = true)
public class JsTreeState {
	private boolean opened;
	private boolean disabled;
	private boolean selected;

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "JsTreeState [opened=" + opened + ", disabled=" + disabled + ", selected=" + selected + "]";
	}

}
