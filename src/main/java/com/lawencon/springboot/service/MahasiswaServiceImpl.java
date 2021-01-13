package com.lawencon.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.springboot.dao.MahasiswaDao;
import com.lawencon.springboot.model.Mahasiswa;

@Service
@Transactional
public class MahasiswaServiceImpl implements MahasiswaService {

	@Autowired
	@Qualifier(value = "jpa_method")
	private MahasiswaDao mahasiswaDao;
	
	@Autowired
	private UniversitasService universitasService;

	@Override
	public void insert(Mahasiswa data) throws Exception {
		universitasService.getUnivById(data.getUniversitas().getId()); //validate pk : univ id
		mahasiswaDao.insert(data);
	}

	@Override
	public void update(Mahasiswa data) throws Exception {
		mahasiswaDao.update(data);
	}

	@Override
	public void delete(Long id) throws Exception {
		mahasiswaDao.delete(id);
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		return mahasiswaDao.getMhsById(id);
	}
	
	@Override
	public Mahasiswa getMhsByNim(String nim) throws Exception {
		return mahasiswaDao.getMhsByNim(nim);
	}

	@Override
	public Mahasiswa getMhsByNimAndNama(String nim, String nama) throws Exception {
		return mahasiswaDao.getMhsByNimAndNama(nim, nama);
	}

	@Override
	public List<Mahasiswa> getAllMhs() throws Exception {
		return mahasiswaDao.getAllMhs();
	}
	
	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		return mahasiswaDao.getAllMhsCustom();
	}

}
