package com.cki.Kairos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cki.Kairos.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	Address findByAddressId(int id);
	
}
