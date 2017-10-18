package com.sdey.api.vo;

public class GetKeshiManagerListVo {
	private Integer keshiID;
	private String ksName;

	public Integer getKeshiID() {
		return keshiID;
	}

	public void setKeshiID(Integer keshiID) {
		this.keshiID = keshiID;
	}

	public String getKsName() {
		return ksName;
	}

	public void setKsName(String ksName) {
		this.ksName = ksName;
	}

	@Override
	public String toString() {
		return "GetKeshiManagerListVo [keshiID=" + keshiID + ", ksName=" + ksName + "]";
	}

}
