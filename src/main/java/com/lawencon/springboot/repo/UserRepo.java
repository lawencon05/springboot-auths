package com.lawencon.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

	Users findByUsername(String username) throws Exception;
}
