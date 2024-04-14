package com.wspa.vask.archiveservice.springkafkaconsumer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganizationEventDto {
	@JsonProperty("isoTimestamp")
	private String isoTimestamp;
	@JsonProperty("operationTypeNr")
	private String operationTypeNr;
	@JsonProperty("target1")
	private String target1;
	@JsonProperty("target2")
	private String target2;
	@JsonProperty("target3")
	private String target3;
	@JsonProperty("userLogin")
	private String userLogin;
	@JsonProperty("roleId")
	private String roleId;
	@JsonProperty("addInfo")
	private String addInfo;
	@JsonProperty("changedValue")
	private String changedValue;

	@Override
	public String toString() {
		return "OrganizationEventDto{" +
				"isoTimestamp='" + isoTimestamp + '\'' +
				", operationTypeNr='" + operationTypeNr + '\'' +
				", target1='" + target1 + '\'' +
				", target2='" + target2 + '\'' +
				", target3='" + target3 + '\'' +
				", userLogin='" + userLogin + '\'' +
				", roleId='" + roleId + '\'' +
				", addInfo='" + addInfo + '\'' +
				", changedValue='" + changedValue + '\'' +
				'}';
	}

	public String getIsoTimestamp() {
		return isoTimestamp;
	}

	public void setIsoTimestamp(String isoTimestamp) {
		this.isoTimestamp = isoTimestamp;
	}

	public String getOperationTypeNr() {
		return operationTypeNr;
	}

	public void setOperationTypeNr(String operationTypeNr) {
		this.operationTypeNr = operationTypeNr;
	}

	public String getTarget1() {
		return target1;
	}

	public void setTarget1(String target1) {
		this.target1 = target1;
	}

	public String getTarget2() {
		return target2;
	}

	public void setTarget2(String target2) {
		this.target2 = target2;
	}

	public String getTarget3() {
		return target3;
	}

	public void setTarget3(String target3) {
		this.target3 = target3;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}

	public String getChangedValue() {
		return changedValue;
	}

	public void setChangedValue(String changedValue) {
		this.changedValue = changedValue;
	}

}
