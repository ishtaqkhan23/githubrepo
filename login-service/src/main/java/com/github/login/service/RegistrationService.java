package com.github.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.login.dao.RegitrationDAO;
import com.github.login.model.RegistrationDetails;

@Service
public class RegistrationService {

	@Autowired
	RegitrationDAO regitrationDAO;
	
	public void saveDetails(RegistrationDetails registrationDetails) {
		regitrationDAO.save(registrationDetails);
	}
}
