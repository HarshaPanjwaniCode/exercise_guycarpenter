package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.entity.ZipCodeDetails;

@Repository
public interface ZipRepository extends JpaRepository<ZipCodeDetails, Long> {
	ZipCodeDetails findOneByPostalCode(String postalCode);

	List<ZipCodeDetails> findByStateCode(String stateCode);
}