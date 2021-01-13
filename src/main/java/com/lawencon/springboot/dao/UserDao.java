package com.lawencon.springboot.dao;

import com.lawencon.springboot.model.Users;

public interface UserDao {

	void insert(Users data) throws Exception;
	
	Users findByUsername(String username) throws Exception;
}
