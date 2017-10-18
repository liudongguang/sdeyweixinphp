package com.weixin.vo.ewm;

public class ActionInfo {
	private Scene scene;

	public ActionInfo() {
		this.scene = new Scene();
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	@Override
	public String toString() {
		return "ActionInfo [scene=" + scene + "]";
	}

}
