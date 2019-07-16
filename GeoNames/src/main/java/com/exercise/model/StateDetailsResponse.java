package com.exercise.model;

public class StateDetailsResponse {

	private String stateName;
	private String stateCode;
	private int numberOfCounties;
	private int numberOfZipCodes;

	public StateDetailsResponse(String stateName, String stateCode, int numberOfCounties, int numberOfZipCodes) {
		super();
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.numberOfCounties = numberOfCounties;
		this.numberOfZipCodes = numberOfZipCodes;
	}

	public String getStateName() {
		return stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public int getNumberOfCounties() {
		return numberOfCounties;
	}

	public int getNumberOfZipCodes() {
		return numberOfZipCodes;
	}

}
