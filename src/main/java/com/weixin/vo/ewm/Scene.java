package com.weixin.vo.ewm;

public class Scene {
	private String scene_str;
	private String scene_id;

	public String getScene_id() {
		return scene_id;
	}

	public void setScene_id(String scene_id) {
		this.scene_id = scene_id;
	}

	public String getScene_str() {
		return scene_str;
	}

	public void setScene_str(String scene_str) {
		this.scene_str = scene_str;
	}

	@Override
	public String toString() {
		return "Scene [scene_str=" + scene_str + "]";
	}

}
