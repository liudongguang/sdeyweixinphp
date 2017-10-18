package com.sdey.api.vo;

public class AddHospitalAndUserVo {
	private String hospitalName;
	private String managerName;
	private String managerUserName;
	private String userPsd;
	//
	private Integer managerId;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerUserName() {
		return managerUserName;
	}

	public void setManagerUserName(String managerUserName) {
		this.managerUserName = managerUserName;
	}

	public String getUserPsd() {
		return userPsd;
	}

	public void setUserPsd(String userPsd) {
		this.userPsd = userPsd;
	}

	

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "AddHospitalAndUserVo [hospitalName=" + hospitalName + ", managerName=" + managerName
				+ ", managerUserName=" + managerUserName + ", userPsd=" + userPsd + ", managerId=" + managerId + "]";
	}

}
