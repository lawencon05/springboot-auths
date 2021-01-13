package com.lawencon.springboot.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lawencon.springboot.model.Users;
import com.lawencon.springboot.service.UserService;

@Service
public class ApiSecurityServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Users userDb = userService.findByUsername(username);
			if (userDb != null) {
				return new User(userDb.getUsername(), userDb.getPwd(), new ArrayList<>());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
