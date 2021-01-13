package com.lawencon.springboot.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Mahasiswa;
import com.lawencon.springboot.model.Universitas;
import com.lawencon.springboot.repo.MahasiswaNQRepo;

@Repository(value = "jpa_nq")
public class MahasiswaDaoNQImpl implements MahasiswaDao {

	@Autowired
	private MahasiswaNQRepo mhsRepo;

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
		mhsRepo.delete(id);
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		return mhsRepo.getMhsById(id);
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
		return mhsRepo.getAllMhs();
	}

	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		List<Mahasiswa> listMhs = new ArrayList<>();
		List<Object[]> listObj = mhsRepo.getAllMhsCustom();
		listObj.forEach(objArr -> {
			Mahasiswa mhs = new Mahasiswa();
			mhs.setId(Long.valueOf(objArr[0].toString()));
			mhs.setNim((String) objArr[1]);
			mhs.setNama((String) objArr[2]);

			Universitas univ = new Universitas();
			univ.setId(Long.valueOf(objArr[3].toString()));
			univ.setNama((String) objArr[4]);
			mhs.setUniversitas(univ);

			mhs.setWaktuMasuk(((Date) objArr[5]).toLocalDate());
			listMhs.add(mhs);
		});
		return listMhs;
	}
}
