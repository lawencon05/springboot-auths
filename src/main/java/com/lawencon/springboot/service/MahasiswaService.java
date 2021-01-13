package com.lawencon.springboot.service;

import java.util.List;

import com.lawencon.springboot.model.Mahasiswa;

public interface MahasiswaService {

	void insert(Mahasiswa data) throws Exception;

	void update(Mahasiswa data) throws Exception;

	void delete(Long id) throws Exception;

	Mahasiswa getMhsById(Long id) throws Exception;

	Mahasiswa getMhsByNim(String nim) throws Exception;

	Mahasiswa getMhsByNimAndNama(String nim, String nama) throws Exception;

	List<Mahasiswa> getAllMhs() throws Exception;

	List<Mahasiswa> getAllMhsCustom() throws Exception;
}
