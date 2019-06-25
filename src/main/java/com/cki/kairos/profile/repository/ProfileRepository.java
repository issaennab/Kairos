package com.cki.kairos.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cki.kairos.profile.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	Profile findByProfileId(int id);

}
