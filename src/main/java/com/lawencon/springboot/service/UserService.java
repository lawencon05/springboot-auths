package com.lawencon.springboot.service;

import com.lawencon.springboot.model.Users;

public interface UserService {

	void insert(Users data) throws Exception;
	
	Users findByUsername(String username) throws Exception;
}
