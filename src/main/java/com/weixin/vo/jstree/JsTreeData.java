package com.weixin.vo.jstree;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsTreeData {
	private String id;
	private String text;
	private String icon;
	private List<JsTreeData> children;
	private JsTreeState state = new JsTreeState();
	private JsTreeli_attr li_attr = new JsTreeli_attr();
	private JsTreea_attr a_attr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<JsTreeData> getChildren() {
		return children;
	}

	public void setChildren(List<JsTreeData> children) {
		this.children = children;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public JsTreeState getState() {
		return state;
	}

	public void setState(JsTreeState state) {
		this.state = state;
	}

	public JsTreeli_attr getLi_attr() {
		return li_attr;
	}

	public void setLi_attr(JsTreeli_attr li_attr) {
		this.li_attr = li_attr;
	}

	public JsTreea_attr getA_attr() {
		return a_attr;
	}

	public void setA_attr(JsTreea_attr a_attr) {
		this.a_attr = a_attr;
	}

	@Override
	public String toString() {
		return "JsTreeData [id=" + id + ", text=" + text + ", icon=" + icon + ", children=" + children + ", state="
				+ state + ", li_attr=" + li_attr + ", a_attr=" + a_attr + "]";
	}


}
