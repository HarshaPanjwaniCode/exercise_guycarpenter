package com.exercise.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exercise.entity.ZipCodeDetails;
import com.exercise.exception.StateNotFoundException;
import com.exercise.exception.ZipNotFoundException;
import com.exercise.model.StateDetailsResponse;

@Service
public class ZipCodeDetailsServiceImpl extends ZipCodeDetailsService {

	@Override
	public ZipCodeDetails fetchZipCodeDetails(String zipCode) throws ZipNotFoundException {
		ZipCodeDetails zipCodeDetails = repository.findOneByPostalCode(zipCode);
		if (zipCodeDetails == null) {
			throw new ZipNotFoundException(zipCode + " not found");
		}

		return zipCodeDetails;

	}

	@Override
	public StateDetailsResponse fetchStateDetails(String stateCode) throws StateNotFoundException {
		List<ZipCodeDetails> zipCodeDetails = repository.findByStateCode(stateCode);

		if (zipCodeDetails == null || zipCodeDetails.size() == 0) {
			throw new StateNotFoundException(stateCode + " not found");
		}

		Optional<String> stateNameOptional = zipCodeDetails.stream().findFirst().map(z -> z.getStateName());
		String stateName = stateNameOptional.get();
		Set<String> counties = new HashSet<>();
		Set<String> zipCodes = new HashSet<>();
		zipCodeDetails.forEach(z -> {
			counties.add(z.getCountyCode());
			zipCodes.add(z.getPostalCode());
		});
		StateDetailsResponse response = new StateDetailsResponse(stateName, stateCode, counties.size(),
				zipCodes.size());
		return response;
	}

}
