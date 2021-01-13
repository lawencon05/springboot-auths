package com.lawencon.springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.springboot.dao.UniversitasDao;
import com.lawencon.springboot.model.Universitas;

/*
 * @author lawencon05
 */
@Service
@Transactional
public class UniversitasServiceImpl implements UniversitasService {

	@Autowired
	private UniversitasDao universitasDao;
	
	@Override
	public Universitas getUnivById(Long id) throws Exception {
		return universitasDao.getUnivById(id);
	}

}
