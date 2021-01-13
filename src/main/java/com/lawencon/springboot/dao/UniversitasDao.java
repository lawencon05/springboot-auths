package com.lawencon.springboot.dao;

import com.lawencon.springboot.model.Universitas;

/*
 * @author lawencon05
 */

public interface UniversitasDao {
	Universitas getUnivById(Long id) throws Exception;
}
