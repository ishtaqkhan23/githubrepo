package com.github.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.login.model.RegistrationDetails;

@Repository
public interface RegitrationDAO extends JpaRepository<RegistrationDetails, Integer> {

	RegistrationDetails findByUsername(String username);

}
