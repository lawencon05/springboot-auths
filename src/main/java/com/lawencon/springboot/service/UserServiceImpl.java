package com.lawencon.springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lawencon.springboot.dao.UserDao;
import com.lawencon.springboot.model.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void insert(Users data) throws Exception {
		data.setPwd(passwordEncoder.encode(data.getPwd()));
		userDao.insert(data);
	}
	
	@Override
	public Users findByUsername(String username) throws Exception{
		return userDao.findByUsername(username);
	}

}
