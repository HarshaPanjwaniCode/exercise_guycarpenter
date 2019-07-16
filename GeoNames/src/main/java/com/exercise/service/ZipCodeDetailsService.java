package com.exercise.service;

import java.io.FileReader;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.entity.ZipCodeDetails;
import com.exercise.exception.StateNotFoundException;
import com.exercise.exception.ZipNotFoundException;
import com.exercise.model.StateDetailsResponse;
import com.exercise.repository.ZipRepository;
import com.opencsv.CSVReader;

@Service
public abstract class ZipCodeDetailsService {

	@Autowired
	protected ZipRepository repository;

	public abstract ZipCodeDetails fetchZipCodeDetails(String zipCode) throws ZipNotFoundException;

	public abstract StateDetailsResponse fetchStateDetails(String stateCode) throws StateNotFoundException;

	@PostConstruct
	public void readZipCodeDetailsFromFile() {
		String fileName = "US.txt";
		ClassLoader classLoader = new ZipCodeDetailsServiceImpl().getClass().getClassLoader();
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(classLoader.getResource(fileName).getFile()), '\t');
			String[] record;
			while ((record = reader.readNext()) != null) {
				ZipCodeDetails zipCodeDetails = new ZipCodeDetails(record[0], record[1], record[2], record[3],
						record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11]);
				repository.saveAndFlush(zipCodeDetails);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
