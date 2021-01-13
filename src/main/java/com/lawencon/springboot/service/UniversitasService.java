package com.lawencon.springboot.service;

import com.lawencon.springboot.model.Universitas;

/*
 * @author lawencon05
 */

public interface UniversitasService {
	Universitas getUnivById(Long id) throws Exception;
}
