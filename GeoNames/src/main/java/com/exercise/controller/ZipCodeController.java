package com.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.entity.ZipCodeDetails;
import com.exercise.exception.StateNotFoundException;
import com.exercise.exception.ZipNotFoundException;
import com.exercise.model.StateDetailsResponse;
import com.exercise.model.ZipCodeDetailsResponse;
import com.exercise.service.ZipCodeDetailsServiceImpl;

@RestController
public class ZipCodeController {

	@Autowired
	ZipCodeDetailsServiceImpl zipCodeDetailsService;

	@RequestMapping(value = "/zip/{zipCodeNo}")
	public ZipCodeDetailsResponse getZipCodeDetails(@PathVariable("zipCodeNo") String zipCodeNo)
			throws ZipNotFoundException {
		ZipCodeDetails zipCodeDetails = zipCodeDetailsService.fetchZipCodeDetails(zipCodeNo);
		ZipCodeDetailsResponse zipCodeDetailsResponse = new ZipCodeDetailsResponse(zipCodeDetails.getPlaceName(),
				zipCodeDetails.getStateName(), zipCodeDetails.getStateCode(), zipCodeDetails.getCountyName());
		return zipCodeDetailsResponse;

	}

	@RequestMapping(value = "/zipcounty/count/{stateCode}")
	public StateDetailsResponse getStateDetails(@PathVariable("stateCode") String stateCode)
			throws StateNotFoundException {
		StateDetailsResponse response;
		response = zipCodeDetailsService.fetchStateDetails(stateCode);
		return response;
	}
}
