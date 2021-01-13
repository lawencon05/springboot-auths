package com.lawencon.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Users;
import com.lawencon.springboot.repo.UserRepo;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public void insert(Users data) throws Exception {
		userRepo.save(data);
	}
	
	@Override
	public Users findByUsername(String useranme) throws Exception {
		return userRepo.findByUsername(useranme);
	}

}
