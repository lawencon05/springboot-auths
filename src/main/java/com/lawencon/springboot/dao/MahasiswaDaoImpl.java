package com.lawencon.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Mahasiswa;
import com.lawencon.springboot.repo.MahasiswaRepo;

@Repository(value = "jpa_method")
public class MahasiswaDaoImpl implements MahasiswaDao {

	@Autowired
	private MahasiswaRepo mhsRepo;

	@Override
	public void insert(Mahasiswa data) throws Exception {
		mhsRepo.save(data);
	}

	@Override
	public void update(Mahasiswa data) throws Exception {
		mhsRepo.save(data);
	}

	@Override
	public void delete(Long id) throws Exception {
		mhsRepo.deleteById(id);
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		return mhsRepo.findById(id).get();
	}
	
	@Override
	public Mahasiswa getMhsByNim(String nim) throws Exception {
		return mhsRepo.findByNim(nim);
	}

	@Override
	public Mahasiswa getMhsByNimAndNama(String nim, String nama) throws Exception {
		return mhsRepo.findByNimAndNama(nim, nama);
	}

	@Override
	public List<Mahasiswa> getAllMhs() throws Exception {
		return mhsRepo.findAll();
	}
	
	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		return mhsRepo.findAll();
	}
}
