package com.weixin.vo.wxhandlermsg;

public class SuCai {
	private String type;
	private int offset;
	private int count;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SuCai [type=" + type + ", offset=" + offset + ", count=" + count + "]";
	}

}
