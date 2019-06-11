package com.cki.Kairos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cki.Kairos.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(int id);

}
