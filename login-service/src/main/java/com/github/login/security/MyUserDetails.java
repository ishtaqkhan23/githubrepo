package com.github.login.security;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.login.dao.RegitrationDAO;
import com.github.login.model.RegistrationDetails;

@Service
public class MyUserDetails implements UserDetailsService {
	private static Logger log = LoggerFactory.getLogger(MyUserDetails.class);
	@Autowired
	private RegitrationDAO regitrationDAO;

	@Override
	public UserDetails loadUserByUsername(String username) {
		final RegistrationDetails user = regitrationDAO.findByUsername(username);

		if (user == null) {
			try {
				throw new UsernameNotFoundException("User '" + username + "' not found");
			} catch (UsernameNotFoundException e) {
				log.error("username not found", e);
			}

		}
		return org.springframework.security.core.userdetails.User//
				.withUsername(username)//
				.password(null != user ? user.getPassword() : "")//
				.authorities(new ArrayList<>())//
				.accountExpired(false)//
				.accountLocked(false)//
				.credentialsExpired(false)//
				.disabled(false)//
				.build();
	}

}
