package com.weixin.vo.jstree;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown
		 = true)
public class JsTreeli_attr {
	private int level;
	private String id;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "JsTreeli_attr [level=" + level + ", id=" + id + "]";
	}
	
}
