package com.exercise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ZipCodeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String countryCode;
	private String postalCode;
	private String placeName;
	private String stateName;
	private String stateCode;
	private String countyName;
	private String countyCode;
	private String communityName;
	private String communityCode;

	private String latitude;
	private String longitude;
	private String accuracy;

	public ZipCodeDetails() {
		super();
	}

	public ZipCodeDetails(String countryCode, String postalCode, String placeName, String stateName, String stateCode,
			String countyName, String countyCode, String communityName, String communityCode, String latitude,
			String longitude, String accuracy) {
		super();
		this.countryCode = countryCode;
		this.postalCode = postalCode;
		this.placeName = placeName;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.countyName = countyName;
		this.countyCode = countyCode;
		this.communityName = communityName;
		this.communityCode = communityCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.accuracy = accuracy;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getPostalCode() {
		return postalCode;
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

	public String getCountyCode() {
		return countyCode;
	}

	public String getCommunityName() {
		return communityName;
	}

	public String getCommunityCode() {
		return communityCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getAccuracy() {
		return accuracy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodeDetails other = (ZipCodeDetails) obj;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		return true;
	}

}
