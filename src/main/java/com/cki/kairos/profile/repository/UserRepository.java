package com.cki.kairos.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cki.kairos.profile.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(int id);

}
