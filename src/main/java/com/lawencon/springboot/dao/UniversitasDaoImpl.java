package com.lawencon.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Universitas;
import com.lawencon.springboot.repo.UniversitasRepo;

/*
 * @author lawencon05
 */

@Repository
public class UniversitasDaoImpl implements UniversitasDao{
	
	@Autowired
	private UniversitasRepo universitasRepo;

	@Override
	public Universitas getUnivById(Long id) throws Exception {
		return universitasRepo.getOne(id);
	}

}
