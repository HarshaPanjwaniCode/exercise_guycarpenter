package com.exercise.model;

public class ZipCodeDetailsResponse {
	
	private String placeName;
	private String stateName;
	private String stateCode;
	private String countyName;
	
	public ZipCodeDetailsResponse(String placeName, String stateName, String stateCode, String countyName) {
		super();
		this.placeName = placeName;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.countyName = countyName;
	}
	
	public String getPlaceName() {
		return placeName;
	}
	public String getStateName() {
		return stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public String getCountyName() {
		return countyName;
	}
	
		
	
}
