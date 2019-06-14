package com.cki.kairos.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cki.kairos.profile.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	Address findByAddressId(int id);
	
}
